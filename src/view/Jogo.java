package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

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
                    if(jogadores.size() == 3) {
						nomeJogador1 = jogadores.get(2);
						nomeJogador2 = jogadores.get(1);
					}
					else {
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
        PainelDeJogo painelJogador1 = new PainelDeJogo(tabuleiroAtaque1, tabuleiroDefesa1, nomeJogador1);
        painelJogador1.setVisible(true);
        painelJogador1.setFocusable(true);
        painelJogador1.requestFocus();
        
        painelJogador1.botao.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		painelJogador1.dispose();
        		
        		char[][] tabuleiroAtaque2 = control.tabuleiroAtaque(nomeJogador2);
				char[][] tabuleiroDefesa2 = control.tabuleiroDefesa(nomeJogador2);
	            PainelDeJogo painelJogador2 = new PainelDeJogo(tabuleiroAtaque2, tabuleiroDefesa2, nomeJogador2);
	            painelJogador2.setVisible(true);
	            painelJogador2.setFocusable(true);
	            painelJogador2.requestFocus();
        		
	            painelJogador2.botao.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						painelJogador2.dispose();
					}
				});
        	}
            
//            PainelDeJogo painelJogador2 = new PainelDeJogo(nomeJogador2);
//
//            painelJogador1.addNavigationListener(event -> {
//                frame.remove(painelJogador1);
//                frame.add(painelJogador2);
//                frame.revalidate();
//                frame.repaint();
//            });
//
//            painelJogador2.addNavigationListener(event -> {
//                frame.remove(painelJogador2);
//                frame.add(painelJogador1);
//                frame.revalidate();
//                frame.repaint();
//            });
//
//            frame.add(painelJogador1);
//            frame.setVisible(true);
        });
	}
}
