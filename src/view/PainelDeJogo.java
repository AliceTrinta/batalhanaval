package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.AccessControl;

class PainelDeJogo extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;
	AccessControl control;
	String nomeJogador;
	Tabuleiro tabuleiroAtaque;
	Tabuleiro tabuleiroDefesa;
	JButton botao;
	Boolean acao;
	
	PainelDeJogo(char [][] tabuleiroAtaque, char [][] tabuleiroDefesa, String nomeJogador){
		super("Batalha Naval");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 1000);
		addMouseListener(this);
		setLayout(new BorderLayout());
		this.control = new AccessControl();
		this.nomeJogador = nomeJogador;
		this.tabuleiroAtaque = new Tabuleiro(tabuleiroAtaque);
		this.tabuleiroDefesa = new Tabuleiro(tabuleiroDefesa);
        this.botao = new JButton("Terminar turno");
        
        JPanel painelEsquerda = new JPanel(new BorderLayout());
        painelEsquerda.add(this.tabuleiroAtaque, BorderLayout.CENTER);
		
		JPanel painelDireita = new JPanel(new BorderLayout());
		painelDireita.add(this.tabuleiroDefesa, BorderLayout.CENTER);

		JPanel painelCentral = new JPanel(new GridLayout(1, 2));
		painelCentral.add(painelEsquerda);
		painelCentral.add(painelDireita);
		
		JPanel painelInferior = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 0, 50, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		JLabel label = new JLabel(nomeJogador + ", realize sua jogada!");
		painelInferior.add(label, gbc);

		gbc.gridy = 1;
		this.botao = new JButton("Terminar turno");
		this.botao.setPreferredSize(new Dimension(200, 50));
		painelInferior.add(this.botao, gbc);

		this.getContentPane().add(painelCentral, BorderLayout.CENTER);
		this.getContentPane().add(painelInferior, BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Sair da Partida");
        JMenuItem itemSalvarSair = new JMenuItem("Salvar e sair");
        itemSalvarSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               salvarPartidaESair();
            }
        });
        menu.add(itemSalvarSair);
        menuBar.add(menu);
        setJMenuBar(menuBar);
		
		botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (acao == false) {
                    // Do not allow switching if no new square has been selected
                    JOptionPane.showMessageDialog(null, "Realize uma acao para trocar de turno!");
                    return;
                }
//                selectedSquare = null;
//                newSquareSelected = false;  // Reset the flag after switching
//                fireNavigationEvent();
            }
        });
		
	}
	
	void salvarPartidaESair() {
		JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            control.salvarPartida(file, this.nomeJogador);
            System.exit(0);
        }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
