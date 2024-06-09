package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	void iniciar() {
		ConfiguraJogadores tela1 = new ConfiguraJogadores();
		tela1.setVisible(true);

		tela1.getComecarButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nomeJogador1 = tela1.getNomeJogador1();
				nomeJogador2 = tela1.getNomeJogador2();
				
				control.criaJogadores(nomeJogador1, nomeJogador2);

				tela1.dispose();

				ConfiguraTabuleiro tela2 = new ConfiguraTabuleiro(nomeJogador1);

				tela2.setVisible(true);
				tela2.setFocusable(true);
				tela2.requestFocus();

				tela2.botao.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						tela2.dispose();
						ConfiguraTabuleiro tela3 = new ConfiguraTabuleiro(nomeJogador2);
						tela3.setVisible(true);
						tela3.setFocusable(true);
						tela3.requestFocus();
						tela3.botao.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								tela3.dispose();
								comecarAtaques(nomeJogador1, nomeJogador2);
							}
						});
					}
				});
			}
		});
	}
	
	void comecarAtaques(String nomeJogador1, String nomeJogador2) {
		SwingUtilities.invokeLater(() -> {
			char[][] tabuleiroAtaque = control.tabuleiroAtaque(nomeJogador1);
            PainelDeJogo painelJogador1 = new PainelDeJogo(tabuleiroAtaque, nomeJogador1);
            painelJogador1.setVisible(true);
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
