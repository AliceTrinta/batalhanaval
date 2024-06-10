package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class ConfiguraJogadores extends JFrame {
	private static final long serialVersionUID = 1L;
	JTextField nomeJogador1;
	JTextField nomeJogador2;
	JButton comecarButton;

	ConfiguraJogadores() {
		setTitle("Jogadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLayout(new GridLayout(3, 2));

		nomeJogador1 = new JTextField("Jogador 1");
		nomeJogador2 = new JTextField("Jogador 2");

		JLabel jogador1Label = new JLabel("Jogador 1:");
		JLabel jogador2Label = new JLabel("Jogador 2:");

		comecarButton = new JButton("Começar");

		add(jogador1Label);
		add(nomeJogador1);
		add(jogador2Label);
		add(nomeJogador2);
		add(comecarButton);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	String getNomeJogador1() {
		return nomeJogador1.getText();
	}

	String getNomeJogador2() {
		return nomeJogador2.getText();
	}
}