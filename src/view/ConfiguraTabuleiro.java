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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import control.AccessControl;

class ConfiguraTabuleiro extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;
	AccessControl control;
	String nomeJogador;
	Couracado couracado;
	Cruzador cruzador;
	Destroyer destroyer;
	Hidroaviao hidroaviao;
	Submarino submarino;
	Integer quantidadeCouracado;
	Integer quantidadeCruzador;
	Integer quantidadeDestroyer;
	Integer quantidadeHidroaviao;
	Integer quantidadeSubmarino;
	Tabuleiro tabuleiro;
	JPanel painelDeArmas;
	JPanel painelDoTabuleiro;
	Component componenteAtual;
	String armaSelecionada;
	JButton botao;

	ConfiguraTabuleiro(String nomeJogador) {
		super("Batalha Naval - Insercao De Armas");
		this.control = new AccessControl();
		this.nomeJogador = nomeJogador;
		this.couracado = new Couracado();
		this.cruzador = new Cruzador();
		this.destroyer = new Destroyer();
		this.hidroaviao = new Hidroaviao();
		this.submarino = new Submarino();
		this.tabuleiro = new Tabuleiro(15, 15);
		this.armaSelecionada = null;
		this.quantidadeCouracado = 1;
		this.quantidadeCruzador = 2;
		this.quantidadeDestroyer = 3;
		this.quantidadeHidroaviao = 5;
		this.quantidadeSubmarino = 4;
		iniciaPosicionamentoDeArmas();
	}

	void iniciaPosicionamentoDeArmas() {
		setSize(1600, 1000);
		addKeyListener(this);

		JPanel painelEsquerda = new JPanel(new GridLayout(5, 1));
		painelEsquerda.add(this.hidroaviao);
		painelEsquerda.add(this.submarino);
		painelEsquerda.add(this.destroyer);
		painelEsquerda.add(this.cruzador);
		painelEsquerda.add(this.couracado);

		JPanel painelDireita = new JPanel(new BorderLayout());
		painelDireita.add(this.tabuleiro, BorderLayout.CENTER);

		JPanel painelCentral = new JPanel(new GridLayout(1, 2));
		painelCentral.add(painelEsquerda);
		painelCentral.add(painelDireita);

		JPanel painelInferior = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 0, 50, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		JLabel label = new JLabel(nomeJogador + ", selecione uma arma na lista");
		painelInferior.add(label, gbc);

		gbc.gridy = 1;
		this.botao = new JButton("Tabuleiro Pronto");
		this.botao.setPreferredSize(new Dimension(200, 50));
		painelInferior.add(this.botao, gbc);

		this.painelDeArmas = painelEsquerda;
		this.painelDoTabuleiro = painelDireita;

		this.getContentPane().add(painelCentral, BorderLayout.CENTER);
		this.getContentPane().add(painelInferior, BorderLayout.SOUTH);

		this.tabuleiro.addMouseListener(new MouseAdapter() {
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
		this.componenteAtual = null;

		if (source == painelDeArmas) {
			Point convertedPoint = SwingUtilities.convertPoint(painelDeArmas, clickPoint, painelDeArmas);
			componenteAtual = painelDeArmas.getComponentAt(convertedPoint);
		} else if (source == this.tabuleiro) {
			Point convertedPoint = SwingUtilities.convertPoint(this.tabuleiro, clickPoint, this.tabuleiro);
			componenteAtual = this.tabuleiro.getComponentAt(convertedPoint);
		}

		Point pontoRelativo = SwingUtilities.convertPoint(e.getComponent(), clickPoint, componenteAtual);

		if (componenteAtual != null) {
			if (button == MouseEvent.BUTTON1) {
				if (this.couracado.getClass() == this.componenteAtual.getClass() && this.armaSelecionada == null
						&& this.quantidadeCouracado > 0) {
					this.armaSelecionada = "Couracado";
					this.couracado.selecionaNavio(this.componenteAtual.getGraphics());
					return;
				} else if (this.cruzador.getClass() == this.componenteAtual.getClass()
						&& this.armaSelecionada == null && this.quantidadeCruzador > 0) {
					Integer numeroDoCruzador = this.cruzador.confirmaObjeto(pontoRelativo);
					if (numeroDoCruzador != null) {
						switch (numeroDoCruzador) {
						case 1:
							this.armaSelecionada = "c1";
							this.cruzador.selecionaNavio(this.componenteAtual.getGraphics(), 1);
							break;
						case 2:
							this.armaSelecionada = "c2";
							this.cruzador.selecionaNavio(this.componenteAtual.getGraphics(), 2);
							break;
						default:
							break;
						}
					}
					return;
				} else if (this.destroyer.getClass() == this.componenteAtual.getClass()
						&& this.armaSelecionada == null && this.quantidadeDestroyer > 0) {
					Integer numeroDoDestroyer = this.destroyer.confirmaObjeto(pontoRelativo);
					switch (numeroDoDestroyer) {
					case 1:
						this.armaSelecionada = "d1";
						this.destroyer.selecionaNavio(this.componenteAtual.getGraphics(), 1);
						break;
					case 2:
						this.armaSelecionada = "d2";
						this.destroyer.selecionaNavio(this.componenteAtual.getGraphics(), 2);
						break;
					case 3:
						this.armaSelecionada = "d3";
						this.destroyer.selecionaNavio(this.componenteAtual.getGraphics(), 3);
						break;
					default:
						break;
					}
					return;
				} else if (this.hidroaviao.getClass() == this.componenteAtual.getClass()
						&& this.armaSelecionada == null && this.quantidadeHidroaviao > 0) {
					Integer numeroDoHidroaviao = this.hidroaviao.confirmaObjeto(pontoRelativo);
					switch (numeroDoHidroaviao) {
					case 1:
						this.armaSelecionada = "h1";
						this.hidroaviao.selecionaNavio(this.componenteAtual.getGraphics(), 1);
						break;
					case 2:
						this.armaSelecionada = "h2";
						this.hidroaviao.selecionaNavio(this.componenteAtual.getGraphics(), 2);
						break;
					case 3:
						this.armaSelecionada = "h3";
						this.hidroaviao.selecionaNavio(this.componenteAtual.getGraphics(), 3);
						break;
					case 4:
						this.armaSelecionada = "h4";
						this.hidroaviao.selecionaNavio(this.componenteAtual.getGraphics(), 4);
						break;
					case 5:
						this.armaSelecionada = "h5";
						this.hidroaviao.selecionaNavio(this.componenteAtual.getGraphics(), 5);
						break;
					default:
						break;
					}
					return;
				} else if (this.submarino.getClass() == this.componenteAtual.getClass() && this.armaSelecionada == null
						&& this.quantidadeSubmarino > 0) {
					Integer numeroDoSubmarino = this.submarino.confirmaObjeto(pontoRelativo);
					switch (numeroDoSubmarino) {
					case 1:
						this.armaSelecionada = "s1";
						this.submarino.selecionaNavio(this.componenteAtual.getGraphics(), 1);
						break;
					case 2:
						this.armaSelecionada = "s2";
						this.submarino.selecionaNavio(this.componenteAtual.getGraphics(), 2);
						break;
					case 3:
						this.armaSelecionada = "s3";
						this.submarino.selecionaNavio(this.componenteAtual.getGraphics(), 3);
						break;
					case 4:
						this.armaSelecionada = "s4";
						this.submarino.selecionaNavio(this.componenteAtual.getGraphics(), 4);
						break;
					default:
						break;
					}
					return;
				} else if (this.tabuleiro.getClass() == this.componenteAtual.getClass()) {
					//TODO Nao permitir insercao de arma fora dos limites
					QuadradoDeTabuleiro quadrado = this.tabuleiro.confirmaObjeto(clickPoint);
					if (quadrado != null && this.armaSelecionada != null) {
						if (this.armaSelecionada == "Couracado" && this.quantidadeCouracado > 0) {
							this.tabuleiro.couracadoNoTabuleiro(this.componenteAtual.getGraphics(), pontoRelativo,
									quadrado);
							this.quantidadeCouracado--;
							this.couracado.removeNavio(this.couracado.getGraphics());
						} else if (this.armaSelecionada == "c1"
								|| this.armaSelecionada == "c2" && this.quantidadeCruzador > 0) {
							this.tabuleiro.cruzadorNoTabuleiro(this.componenteAtual.getGraphics(), pontoRelativo,
									quadrado);
							this.quantidadeCruzador--;
							this.cruzador.removeNavio(this.cruzador.getGraphics(), this.armaSelecionada);
						} else if (this.armaSelecionada == "d1" || this.armaSelecionada == "d2"
								|| this.armaSelecionada == "d3" && this.quantidadeDestroyer > 0) {
							this.tabuleiro.destroyerNoTabuleiro(this.componenteAtual.getGraphics(), pontoRelativo,
									quadrado);
							this.quantidadeDestroyer--;
							this.destroyer.removeNavio(this.destroyer.getGraphics(), this.armaSelecionada);
						} else if (this.armaSelecionada == "h1" || this.armaSelecionada == "h2"
								|| this.armaSelecionada == "h3" || this.armaSelecionada == "h4"
								|| this.armaSelecionada == "h5" && this.quantidadeHidroaviao > 0) {
							this.tabuleiro.hidroaviaoNoTabuleiro(this.componenteAtual.getGraphics(), pontoRelativo,
									quadrado);
							this.quantidadeHidroaviao--;
							this.hidroaviao.removeNavio(this.hidroaviao.getGraphics(), this.armaSelecionada);
						} else if (this.armaSelecionada == "s1" || this.armaSelecionada == "s2"
								|| this.armaSelecionada == "s3" || this.armaSelecionada == "s4"
								|| this.armaSelecionada == "s5" && this.quantidadeSubmarino > 0) {
							this.tabuleiro.submarinoNoTabuleiro(this.componenteAtual.getGraphics(), pontoRelativo,
									quadrado);
							this.quantidadeSubmarino--;
							this.submarino.removeNavio(this.submarino.getGraphics(), this.armaSelecionada);
						}
						control.salvarMudancasNoTabuleiro(this.tabuleiro.atualizaMatriz(), this.nomeJogador);
						this.armaSelecionada = null;
						return;
					} else if (quadrado != null) {
						switch (quadrado.cor) {
						case "CINZA":
							this.armaSelecionada = "Couracado";
							// TODO: MOVER arma
							break;
						case "ROSA":
							this.armaSelecionada = "Cruzador";
							// TODO: MOVER arma
							break;
						case "VERDE":
							this.armaSelecionada = "Destroyer";
							// TODO: MOVER arma
							break;
						case "AZUL":
							this.armaSelecionada = "Submarino";
							// TODO: MOVER arma
							break;
						case "VERMELHO":
							this.armaSelecionada = "Hidroaviao";
							// TODO: MOVER arma
							break;
						default:
							break;
						}
					}
				}
			}
			// TODO Rotacionar armas e atualizar tabuleiro
//			else if (button == MouseEvent.BUTTON3) {
//				if (armaSelecionada != null) {
//					switch (tipoArmaSelecionada) {
//					case "Couracado":
//						System.out.println("Couracado selecionado!");
//						break;
//					case "Cruzador":
//						System.out.println("Cruzador selecionado!");
//						break;
//					case "Destroyer":
//						System.out.println("Destroyer selecionado!");
//						break;
//					case "Hidroaviao":
//						System.out.println("Hidroaviao selecionado!");
//						break;
//					case "Submarino":
//						System.out.println("Submarino selecionado!");
//						break;
//					default:
//						System.out.println("Arma desconhecida!");
//						break;
//					}
//				}
//			}
			return;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE && this.armaSelecionada != null) {
			if (this.armaSelecionada == "Couracado") {
				this.couracado.deselecionaNavio(this.componenteAtual.getGraphics());
			} else if (this.armaSelecionada == "c1" || this.armaSelecionada == "c2") {
				this.cruzador.deselecionaNavio(this.componenteAtual.getGraphics(), this.armaSelecionada);
			} else if (this.armaSelecionada == "d1" || this.armaSelecionada == "d2" || this.armaSelecionada == "d3") {
				this.destroyer.deselecionaNavio(this.componenteAtual.getGraphics(), this.armaSelecionada);
			} else if (this.armaSelecionada == "h1" || this.armaSelecionada == "h2" || this.armaSelecionada == "h3"
					|| this.armaSelecionada == "h4" || this.armaSelecionada == "h5") {
				this.hidroaviao.deselecionaNavio(this.componenteAtual.getGraphics(), this.armaSelecionada);
			} else if (this.armaSelecionada == "s1" || this.armaSelecionada == "s2" || this.armaSelecionada == "s3"
					|| this.armaSelecionada == "s4" || this.armaSelecionada == "s5") {
				this.submarino.deselecionaNavio(this.componenteAtual.getGraphics(), this.armaSelecionada);
			}
		}
		this.armaSelecionada = null;
		return;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
