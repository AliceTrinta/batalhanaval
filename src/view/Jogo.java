package view;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import control.AccessControl;

class Jogo {
	AccessControl control;
	String nomeJogador1;
	String nomeJogador2;

	Jogo() {
		this.control = new AccessControl();
		nomeJogador1 = null;
		nomeJogador2 = null;
	}

	void telaInicial() {
		TelaInicial tela1 = new TelaInicial();
		tela1.setVisible(true);
		tela1.novoJogo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tela1.dispose();
				iniciar();
			}
		});
		tela1.carregarJogo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int option = fileChooser.showOpenDialog(tela1);

				if (option == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					List<String> jogadores = new ArrayList<>();
					tela1.dispose();
					jogadores = control.carregaPartida(file);
					if (jogadores.size() == 3) {
						nomeJogador1 = jogadores.get(2);
						if (nomeJogador1.equals(jogadores.get(0))) {
							nomeJogador2 = jogadores.get(1);
						} else {
							nomeJogador2 = jogadores.get(0);
						}
					} else {
						nomeJogador1 = jogadores.get(0);
						nomeJogador2 = jogadores.get(1);
					}
					comecarAtaques();
				}
			}
		});
	}

	void iniciar() {
		ConfiguraJogadores tela1 = new ConfiguraJogadores();
		tela1.setVisible(true);

		tela1.comecarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nomeJogador1 = tela1.getNomeJogador1();
				nomeJogador2 = tela1.getNomeJogador2();

				control.criaJogadores(nomeJogador1, nomeJogador2);

				tela1.dispose();

				ConfiguraTabuleiro tela2 = new ConfiguraTabuleiro(nomeJogador1);
				control.adicionaObserver(tela2);

				tela2.setVisible(true);
				tela2.setFocusable(true);
				tela2.requestFocus();

				tela2.botao.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						tela2.dispose();
						ConfiguraTabuleiro tela3 = new ConfiguraTabuleiro(nomeJogador2);
						control.removeObserver(tela2);
						control.adicionaObserver(tela3);
						tela3.setVisible(true);
						tela3.setFocusable(true);
						tela3.requestFocus();
						tela3.botao.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								tela3.dispose();
								control.removeObserver(tela3);
								control.criaTabuleiroDeDefesa(nomeJogador1);
								control.criaTabuleiroDeDefesa(nomeJogador2);
								comecarAtaques();

							}
						});
					}
				});
			}
		});
	}

	void comecarAtaques() {
		char[][] tabuleiroAtaque1 = control.tabuleiroAtaque(nomeJogador1);
		char[][] tabuleiroDefesa1 = control.tabuleiroDefesa(nomeJogador1);

		char[][] tabuleiroAtaque2 = control.tabuleiroAtaque(nomeJogador2);
		char[][] tabuleiroDefesa2 = control.tabuleiroDefesa(nomeJogador2);

		JFrame frame = new JFrame("Batalha Naval");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1600, 1000);

		PainelDeJogo painelJogador1 = new PainelDeJogo(tabuleiroAtaque1, tabuleiroDefesa1, nomeJogador1);
		PainelDeJogo painelJogador2 = new PainelDeJogo(tabuleiroAtaque2, tabuleiroDefesa2, nomeJogador2);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Sair da Partida");
		JMenuItem itemSalvarSair = new JMenuItem("Salvar e sair");
		itemSalvarSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int option = fileChooser.showSaveDialog(frame);

				if (option == JFileChooser.APPROVE_OPTION) {

					String jogadorNoTurno = null;
					if (painelJogador1.atual) {
						jogadorNoTurno = nomeJogador1;
					} else {
						jogadorNoTurno = nomeJogador2;
					}
					File file = fileChooser.getSelectedFile();
					control.salvarPartida(file, jogadorNoTurno);
					System.exit(0);
				}
			}
		});
		menu.add(itemSalvarSair);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		painelJogador1.botaoReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Component source = (Component) e.getSource();
                Window window = SwingUtilities.getWindowAncestor(source);
                window.dispose();
            	frame.dispose();
            	new Jogo().telaInicial();
            }
        });

		painelJogador1.addNavigationListener(event -> {
			frame.remove(painelJogador1);
			frame.add(painelJogador2);
			frame.revalidate();
			frame.repaint();
			control.removeObserver(painelJogador1);
			control.adicionaObserver(painelJogador2);
			painelJogador1.atual = false;
			painelJogador2.atual = true;
		});

		painelJogador2.addNavigationListener(event -> {
			frame.remove(painelJogador2);
			frame.add(painelJogador1);
			frame.revalidate();
			frame.repaint();
			control.removeObserver(painelJogador2);
			control.adicionaObserver(painelJogador1);
			painelJogador1.atual = true;
			painelJogador2.atual = false;
		});

		frame.add(painelJogador1);
		frame.setVisible(true);
		control.adicionaObserver(painelJogador1);
	}
}
