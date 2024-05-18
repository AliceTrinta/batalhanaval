package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TelaDeSelecao extends JFrame implements KeyListener {
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
		addKeyListener(this);
		this.couracado = new Couracado();
		this.cruzador = new Cruzador();
		this.destroyer = new Destroyer();
		this.submarino = new Submarino();
		this.hidroaviao = new Hidroaviao();
		this.armaSelecionada = null;
		this.tipoArmaSelecionada = null;
		this.tabuleiro = new TabuleiroDeJogo(15, 15);

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
		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						dispose();
					}
				});
			}
		});
		botao.setPreferredSize(new Dimension(200, 50));
		painelInferior.add(botao, gbc);

		this.painelDeArmas = painelEsquerda;
		this.painelDoTabuleiro = painelDireita;

		getContentPane().add(painelCentral, BorderLayout.CENTER);
		getContentPane().add(painelInferior, BorderLayout.SOUTH);

		tabuleiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleMouseClick(e);
			}
		});

		painelDeArmas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleMouseClick(e);
			}
		});
	}

	private void handleMouseClick(MouseEvent e) {
		Point clickPoint = e.getPoint();
		Component source = e.getComponent();
		int button = e.getButton();
		Component component = null;

		if (source == painelDeArmas) {
			Point convertedPoint = SwingUtilities.convertPoint(painelDeArmas, clickPoint, painelDeArmas);
			component = painelDeArmas.getComponentAt(convertedPoint);
		} else if (source == tabuleiro) {
			Point convertedPoint = SwingUtilities.convertPoint(tabuleiro, clickPoint, tabuleiro);
			component = tabuleiro.getComponentAt(convertedPoint);
		}

		if (component != null) {
			if (button == MouseEvent.BUTTON1) {
				if (couracado.getClass() == component.getClass() && armaSelecionada == null) {
					couracado.pintarNavio(component.getGraphics());
					armaSelecionada = couracado.couracado;
					tipoArmaSelecionada = "Couracado";
					componenteAtual = component;
					return;
				} else if (cruzador.getClass() == component.getClass()) {
					Point pontoRelativo = SwingUtilities.convertPoint(e.getComponent(), clickPoint, component);
					Integer numeroDoCruzador = cruzador.confirmaObjeto(pontoRelativo);
					if (numeroDoCruzador != null) {
						switch (numeroDoCruzador) {
						case 1:
							cruzador.pintarNavio(component.getGraphics(), 1);
							armaSelecionada = cruzador.cruzador1;
							tipoArmaSelecionada = "Cruzador";
							break;
						case 2:
							cruzador.pintarNavio(component.getGraphics(), 2);
							armaSelecionada = cruzador.cruzador2;
							tipoArmaSelecionada = "Cruzador";
							break;
						default:
							break;
						}
					}
					componenteAtual = component;
					return;
				} else if (destroyer.getClass() == component.getClass() && armaSelecionada == null) {
					Point pontoRelativo = SwingUtilities.convertPoint(e.getComponent(), clickPoint, component);
					Integer numeroDoDestroyer = destroyer.confirmaObjeto(pontoRelativo);
					switch (numeroDoDestroyer) {
					case 1:
						destroyer.pintarNavio(component.getGraphics(), 1);
						armaSelecionada = destroyer.destroyer1;
						tipoArmaSelecionada = "Destroyer";
						break;
					case 2:
						destroyer.pintarNavio(component.getGraphics(), 2);
						armaSelecionada = destroyer.destroyer2;
						tipoArmaSelecionada = "Destroyer";
						break;
					case 3:
						destroyer.pintarNavio(component.getGraphics(), 3);
						armaSelecionada = destroyer.destroyer3;
						tipoArmaSelecionada = "Destroyer";
						break;
					default:
						break;
					}
					componenteAtual = component;
					return;
				} else if (hidroaviao.getClass() == component.getClass() && armaSelecionada == null) {
					Point pontoRelativo = SwingUtilities.convertPoint(e.getComponent(), clickPoint, component);
					Integer numeroDoHidroaviao = hidroaviao.confirmaObjeto(pontoRelativo);
					switch (numeroDoHidroaviao) {
					case 1:
						hidroaviao.pintarNavio(component.getGraphics(), 1);
						armaSelecionada = hidroaviao.h1;
						tipoArmaSelecionada = "Hidroaviao";
						break;
					case 2:
						hidroaviao.pintarNavio(component.getGraphics(), 2);
						armaSelecionada = hidroaviao.h2;
						tipoArmaSelecionada = "Hidroaviao";
						break;
					case 3:
						hidroaviao.pintarNavio(component.getGraphics(), 3);
						armaSelecionada = hidroaviao.h3;
						tipoArmaSelecionada = "Hidroaviao";
						break;
					case 4:
						hidroaviao.pintarNavio(component.getGraphics(), 4);
						armaSelecionada = hidroaviao.h4;
						tipoArmaSelecionada = "Hidroaviao";
						break;
					case 5:
						hidroaviao.pintarNavio(component.getGraphics(), 5);
						armaSelecionada = hidroaviao.h5;
						tipoArmaSelecionada = "Hidroaviao";
						break;
					default:
						break;
					}
					componenteAtual = component;
					return;
				} else if (submarino.getClass() == component.getClass() && armaSelecionada == null) {
					Point pontoRelativo = SwingUtilities.convertPoint(e.getComponent(), clickPoint, component);
					Integer numeroDoSubmarino = submarino.confirmaObjeto(pontoRelativo);
					switch (numeroDoSubmarino) {
					case 1:
						submarino.pintarNavio(component.getGraphics(), 1);
						armaSelecionada = submarino.sub1;
						tipoArmaSelecionada = "Submarino";
						break;
					case 2:
						submarino.pintarNavio(component.getGraphics(), 2);
						armaSelecionada = submarino.sub2;
						tipoArmaSelecionada = "Submarino";
						break;
					case 3:
						submarino.pintarNavio(component.getGraphics(), 3);
						armaSelecionada = submarino.sub3;
						tipoArmaSelecionada = "Submarino";
						break;
					case 4:
						submarino.pintarNavio(component.getGraphics(), 4);
						armaSelecionada = submarino.sub4;
						tipoArmaSelecionada = "Submarino";
						break;
					default:
						break;
					}
					componenteAtual = component;
					return;
				} else if (tabuleiro.getClass() == component.getClass()) {
					QuadradoDeTabuleiro quadrado = this.tabuleiro.confirmaObjeto(clickPoint);
					Point pontoRelativo = SwingUtilities.convertPoint(e.getComponent(), clickPoint, component);
					if (quadrado != null && armaSelecionada != null) {
						switch (tipoArmaSelecionada) {
						case "Couracado":
							if (this.couracado.quantidade > 0) {
								this.tabuleiro.desenhaCouracado(component.getGraphics(), pontoRelativo, quadrado);
								this.couracado.quantidade = 0;
								this.couracado.deselecionarNavio(this.componenteAtual.getGraphics());
							}
							this.armaSelecionada = null;
							break;
						case "Cruzador":
							if (this.cruzador.quantidade > 0) {
								this.tabuleiro.desenhaCruzador(component.getGraphics(), pontoRelativo, quadrado);
								this.cruzador.quantidade--;
								this.cruzador.deselecionarNavio(this.componenteAtual.getGraphics());
							}
							this.armaSelecionada = null;
							break;
						case "Destroyer":
							if (this.destroyer.quantidade > 0) {
								this.tabuleiro.desenhaDestroyer(component.getGraphics(), pontoRelativo, quadrado);
								this.destroyer.quantidade--;
								this.destroyer.deselecionarNavio(this.componenteAtual.getGraphics());
							}
							this.armaSelecionada = null;
							break;
						case "Hidroaviao":
							if (this.hidroaviao.quantidade > 0) {
								this.tabuleiro.desenhaHidroaviao(component.getGraphics(), pontoRelativo, quadrado);
								this.hidroaviao.quantidade--;
								this.hidroaviao.deselecionarNavio(this.componenteAtual.getGraphics());
							}
							this.armaSelecionada = null;
							break;
						case "Submarino":
							if (this.submarino.quantidade > 0) {
								this.tabuleiro.desenhaSubmarino(component.getGraphics(), pontoRelativo, quadrado);
								this.submarino.quantidade--;
								this.submarino.deselecionarNavio(this.componenteAtual.getGraphics());
							}
							this.armaSelecionada = null;
							break;
						default:
							System.out.println("Arma desconhecida!");
							break;
						}
						return;
					} else if (quadrado != null) {
						switch (quadrado.color) {
						case "CINZA":
							this.tipoArmaSelecionada = "Couracado";
							this.armaSelecionada = this.couracado.couracado;
							break;
						case "ROSA":
							this.tipoArmaSelecionada = "Cruzador";
							this.armaSelecionada = this.cruzador.cruzador1;
							break;
						case "VERDE":
							this.tipoArmaSelecionada = "Destroyer";
							this.armaSelecionada = this.destroyer.destroyer1;
							break;
						case "AZUL":
							this.tipoArmaSelecionada = "Submarino";
							this.armaSelecionada = this.submarino.sub1;
							break;
						case "VERMELHO":
							this.tipoArmaSelecionada = "Hidroaviao";
							this.armaSelecionada = this.hidroaviao.h1;
							break;
						default:
							break;
						}
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
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (this.tipoArmaSelecionada != null) {
				switch (tipoArmaSelecionada) {
				case "Couracado":
					this.couracado.deselecionarNavio(this.componenteAtual.getGraphics());
					this.tipoArmaSelecionada = null;
					this.armaSelecionada = null;
					break;
				case "Cruzador":
					this.cruzador.deselecionarNavio(this.componenteAtual.getGraphics());
					this.tipoArmaSelecionada = null;
					this.armaSelecionada = null;
					break;
				case "Destroyer":
					this.destroyer.deselecionarNavio(this.componenteAtual.getGraphics());
					this.tipoArmaSelecionada = null;
					this.armaSelecionada = null;
					break;
				case "Hidroaviao":
					this.hidroaviao.deselecionarNavio(this.componenteAtual.getGraphics());
					this.tipoArmaSelecionada = null;
					this.armaSelecionada = null;
					break;
				case "Submarino":
					this.submarino.deselecionarNavio(this.componenteAtual.getGraphics());
					this.tipoArmaSelecionada = null;
					this.armaSelecionada = null;
					break;
				default:
					break;
				}
			}
			return;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
