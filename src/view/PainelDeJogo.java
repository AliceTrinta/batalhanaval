package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import control.AccessControl;
import model.ObservadorConfiguraTabuleiro;

class PainelDeJogo extends JPanel implements MouseListener, ObservadorConfiguraTabuleiro {
	private static final long serialVersionUID = 1L;
	AccessControl control;
	String nomeJogador;
	Tabuleiro tabuleiroAtaque;
	Tabuleiro tabuleiroDefesa;
	JPanel painelTabuleiroDefesa;
	Component componenteAtual;
	List<NavigationListener> listeners = new ArrayList<>();
	JButton botao;
	Boolean acao;
	Boolean atual;

	PainelDeJogo(char[][] tabuleiroAtaque, char[][] tabuleiroDefesa, String nomeJogador) {
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
		this.painelTabuleiroDefesa = painelDireita;

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

		this.add(painelCentral, BorderLayout.CENTER);
		this.add(painelInferior, BorderLayout.SOUTH);

		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireNavigationEvent();
			}
		});

	}

	void fireNavigationEvent() {
		NavigationEvent event = new NavigationEvent(null, null, 0); // Panel number not needed for switch
		for (NavigationListener listener : listeners) {
			listener.navigate(event);
		}
	}

	void addNavigationListener(NavigationListener listener) {
		listeners.add(listener);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		handleMouseClick(e);

	}

	void handleMouseClick(MouseEvent e) {
		System.out.print("Entrou");
		Point clickPoint = e.getPoint();
		Component source = e.getComponent().getComponentAt(clickPoint).getComponentAt(clickPoint);
		this.componenteAtual = null;

		if (source == painelTabuleiroDefesa) {
			Point convertedPoint = SwingUtilities.convertPoint(e.getComponent().getComponentAt(clickPoint), clickPoint,
					painelTabuleiroDefesa);
			componenteAtual = painelTabuleiroDefesa.getComponentAt(convertedPoint);

			QuadradoDeTabuleiro quadrado = this.tabuleiroDefesa.confirmaObjeto(convertedPoint);
			if (quadrado != null) {
				control.realizaAtaque((int) quadrado.linhaInicial, (int) quadrado.colunaInicial, this.nomeJogador);
				return;
			}
		}
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

	@Override
	public void pintarQuadrado(int linha, int coluna, String cor) {
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		if (cor == "ROSA") {
			g2d.setColor(Color.PINK);
			g2d.fill(this.tabuleiroDefesa.tabuleiro[linha][coluna].quadrado);
		} else if (cor == "AZUL") {
			g2d.setColor(Color.CYAN);
			g2d.fill(this.tabuleiroDefesa.tabuleiro[linha][coluna].quadrado);
		} else if (cor == "VERMELHO") {
			g2d.setColor(Color.RED);
			g2d.fill(this.tabuleiroDefesa.tabuleiro[linha][coluna].quadrado);
		}
	}

	@Override
	public void couracadoNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cruzadorNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroyerNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hidroaviaoNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void submarinoNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		// TODO Auto-generated method stub

	}
}
