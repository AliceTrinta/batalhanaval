package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TelaDeSelecao extends JFrame implements MouseListener, KeyListener {
	private static final long serialVersionUID = 1L;
	TabuleiroDeJogo tabuleiro;
	Couracado couracado;
	Cruzador cruzador;
	Destroyer destroyer;
	Hidroaviao hidroaviao;
	Submarino submarino;
	QuadradoDeTabuleiro[][] armaSelecionada;
	String tipoArmaSelecionada;
	JPanel painelDeArmas;
	Component componenteAtual;
	JPanel painelDoTabuleiro;

	TelaDeSelecao() {
		super("Batalha Naval - Insercao De Armas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1600, 1000);
		addMouseListener(this);
		ewaddKeyListener(this);
		this.couracado = new Couracado();
		this.cruzador = new Cruzador();
		this.destroyer = new Destroyer();
		this.submarino = new Submarino();
		this.hidroaviao = new Hidroaviao();
		this.armaSelecionada = null;
		this.tipoArmaSelecionada = null;
		TabuleiroDeJogo tabuleiro = new TabuleiroDeJogo(15, 15);

		JPanel painelEsquerda = new JPanel(new GridLayout(5, 1));
		painelEsquerda.add(hidroaviao);
		painelEsquerda.add(submarino);
		painelEsquerda.add(destroyer);
		painelEsquerda.add(cruzador);
		painelEsquerda.add(couracado);

		JPanel painelDireita = new JPanel(new BorderLayout());
		painelDireita.add(tabuleiro, BorderLayout.CENTER);

		JPanel painelCentral = new JPanel(new GridLayout(1, 2));
		painelCentral.add(painelEsquerda);
		painelCentral.add(painelDireita);

		JPanel painelInferior = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 0, 50, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		JLabel label = new JLabel("Mensagem Centralizada");
		painelInferior.add(label, gbc);

		gbc.gridy = 1;
		JButton botao = new JButton("Tabuleiro Pronto");
		botao.setPreferredSize(new Dimension(200, 50));
		painelInferior.add(botao, gbc);

		this.painelDeArmas = painelEsquerda;
		this.painelDoTabuleiro = painelDireita;

		getContentPane().add(painelCentral, BorderLayout.CENTER);
		getContentPane().add(painelInferior, BorderLayout.SOUTH);
		getContentPane().requestFocusInWindow();
	}

	private void handleMouseClick(MouseEvent e) {
		System.out.println("entrou");
		Point clickPoint = e.getPoint();
		int button = e.getButton();
		Component component = this.painelDeArmas.getComponentAt(clickPoint);

		if (button == MouseEvent.BUTTON1 && this.armaSelecionada == null) {
			if (this.couracado.getClass() == component.getClass()) {
				this.couracado.pintarNavio(component.getGraphics());
				this.armaSelecionada = this.couracado.couracado;
				this.tipoArmaSelecionada = "Couracado";
				this.componenteAtual = component;
				return;
			} else if (this.cruzador.getClass() == component.getClass()) {
				Point pontoRelativo = SwingUtilities.convertPoint(e.getComponent(), clickPoint, component);
				Integer numeroDoCruzador = this.cruzador.confirmaObjeto(pontoRelativo);
				if (numeroDoCruzador != null) {
					switch (numeroDoCruzador) {
					case 1:
						this.cruzador.pintarNavio(component.getGraphics(), 1);
						this.armaSelecionada = this.cruzador.cruzador1;
						this.tipoArmaSelecionada = "Cruzador";
						break;
					case 2:
						this.cruzador.pintarNavio(component.getGraphics(), 2);
						this.armaSelecionada = this.cruzador.cruzador2;
						this.tipoArmaSelecionada = "Cruzador";
						break;
					default:
						break;
					}
				}
				this.componenteAtual = component;
				return;
			} else if (this.destroyer.getClass() == component.getClass()) {
				Point pontoRelativo = SwingUtilities.convertPoint(e.getComponent(), clickPoint, component);
				Integer numeroDoDestroyer = this.destroyer.confirmaObjeto(pontoRelativo);
				switch (numeroDoDestroyer) {
				case 1:
					this.destroyer.pintarNavio(component.getGraphics(), 1);
					this.armaSelecionada = this.destroyer.destroyer1;
					this.tipoArmaSelecionada = "Destroyer";
					break;
				case 2:
					this.destroyer.pintarNavio(component.getGraphics(), 2);
					this.armaSelecionada = this.destroyer.destroyer2;
					this.tipoArmaSelecionada = "Destroyer";
					break;
				case 3:
					this.destroyer.pintarNavio(component.getGraphics(), 3);
					this.armaSelecionada = this.destroyer.destroyer3;
					this.tipoArmaSelecionada = "Destroyer";
					break;
				default:
					break;
				}
				this.componenteAtual = component;
				return;
			} else if (this.hidroaviao.getClass() == component.getClass()) {
				Point pontoRelativo = SwingUtilities.convertPoint(e.getComponent(), clickPoint, component);
				Integer numeroDoHidroaviao = this.hidroaviao.confirmaObjeto(pontoRelativo);
				switch (numeroDoHidroaviao) {
				case 1:
					this.hidroaviao.pintarNavio(component.getGraphics(), 1);
					this.armaSelecionada = this.hidroaviao.h1;
					this.tipoArmaSelecionada = "Hidroaviao";
					break;
				case 2:
					this.hidroaviao.pintarNavio(component.getGraphics(), 2);
					this.armaSelecionada = this.hidroaviao.h2;
					this.tipoArmaSelecionada = "Hidroaviao";
					break;
				case 3:
					this.hidroaviao.pintarNavio(component.getGraphics(), 3);
					this.armaSelecionada = this.hidroaviao.h3;
					this.tipoArmaSelecionada = "Hidroaviao";
					break;
				case 4:
					this.hidroaviao.pintarNavio(component.getGraphics(), 4);
					this.armaSelecionada = this.hidroaviao.h4;
					this.tipoArmaSelecionada = "Hidroaviao";
					break;
				case 5:
					this.hidroaviao.pintarNavio(component.getGraphics(), 5);
					this.armaSelecionada = this.hidroaviao.h5;
					this.tipoArmaSelecionada = "Hidroaviao";
					break;
				default:
					break;
				}
				this.componenteAtual = component;
				return;
			} else if (this.submarino.getClass() == component.getClass()) {
				Point pontoRelativo = SwingUtilities.convertPoint(e.getComponent(), clickPoint, component);
				Integer numeroDoSubmarino = this.submarino.confirmaObjeto(pontoRelativo);
				switch (numeroDoSubmarino) {
				case 1:
					this.submarino.pintarNavio(component.getGraphics(), 1);
					this.armaSelecionada = this.submarino.sub1;
					this.tipoArmaSelecionada = "Submarino";
					break;
				case 2:
					this.submarino.pintarNavio(component.getGraphics(), 2);
					this.armaSelecionada = this.submarino.sub2;
					this.tipoArmaSelecionada = "Submarino";
					break;
				case 3:
					this.submarino.pintarNavio(component.getGraphics(), 3);
					this.armaSelecionada = this.submarino.sub3;
					this.tipoArmaSelecionada = "Submarino";
					break;
				case 4:
					this.submarino.pintarNavio(component.getGraphics(), 4);
					this.armaSelecionada = this.submarino.sub4;
					this.tipoArmaSelecionada = "Submarino";
					break;
				default:
					break;
				}
				this.componenteAtual = component;
				return;
			} else if (this.tabuleiro.getClass() == component.getClass()) {
				QuadradoDeTabuleiro tabuleiro = this.tabuleiro.confirmaObjeto(clickPoint);
				if (tabuleiro != null && armaSelecionada != null) {
					// Coloca arma no tabuleiro
					return;
				}
				return;
			}
			return;
		} else if (button == MouseEvent.BUTTON3) {
			if (armaSelecionada != null) {
				switch (tipoArmaSelecionada) {
				case "Couracado":
					System.out.println("Couracado selecionado!");
					break;
				case "Cruzador":
					System.out.println("Cruzador selecionado!");
					break;
				case "Destroyer":
					System.out.println("Destroyer selecionado!");
					break;
				case "Hidroaviao":
					System.out.println("Hidroaviao selecionado!");
					break;
				case "Submarino":
					System.out.println("Submarino selecionado!");
					break;
				default:
					System.out.println("Arma desconhecida!");
					break;
				}
			}
			return;
		}
		return;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		handleMouseClick(e);

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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("entrou evento");
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("entrou esc");
			if (this.tipoArmaSelecionada != null) {
				switch (tipoArmaSelecionada) {
				case "Couracado":
					this.couracado.deselecionarNavio(this.componenteAtual.getGraphics());
					break;
				case "Cruzador":
					this.cruzador.deselecionarNavio(this.componenteAtual.getGraphics());
					break;
				case "Destroyer":
					this.destroyer.deselecionarNavio(this.componenteAtual.getGraphics());
					break;
				case "Hidroaviao":
					this.hidroaviao.deselecionarNavio(this.componenteAtual.getGraphics());
					break;
				case "Submarino":
					this.submarino.deselecionarNavio(this.componenteAtual.getGraphics());
					break;
				default:
					break;
				}
			}
			this.tipoArmaSelecionada = null;
			return;
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
