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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import control.AccessControl;
import model.ObservadorConfiguraTabuleiro;

class ConfiguraTabuleiro extends JFrame implements KeyListener, ObservadorConfiguraTabuleiro {
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
	Boolean posicaoFinal = false;
	Integer orientacaoDaArmaAtual = 0;
	Integer linhaAnterior = 0;
	Integer colunaAnterior = 0;
	Boolean reposicao = false;

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
				} else if (this.cruzador.getClass() == this.componenteAtual.getClass() && this.armaSelecionada == null
						&& this.quantidadeCruzador > 0) {
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
				} else if (this.destroyer.getClass() == this.componenteAtual.getClass() && this.armaSelecionada == null
						&& this.quantidadeDestroyer > 0) {
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
				} else if (this.hidroaviao.getClass() == this.componenteAtual.getClass() && this.armaSelecionada == null
						&& this.quantidadeHidroaviao > 0) {
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
					QuadradoDeTabuleiro quadrado = this.tabuleiro.confirmaObjeto(clickPoint);
					if (quadrado != null && this.armaSelecionada != null) {
						if (this.armaSelecionada == "Couracado") {
							if (this.posicaoFinal) {
								this.tabuleiro.matriz = control.removeArmaDoTabuleiro(this.tabuleiro.matriz,
										this.nomeJogador, 'C', this.linhaAnterior, this.colunaAnterior,
										this.orientacaoDaArmaAtual);
							}
							this.tabuleiro.matriz = control.salvarMudancasNoTabuleiro(this.tabuleiro.matriz,
									this.nomeJogador, 'C', (int) quadrado.linhaInicial, (int) quadrado.colunaInicial,
									this.orientacaoDaArmaAtual);
							this.linhaAnterior = (int) quadrado.linhaInicial;
							this.colunaAnterior = (int) quadrado.colunaInicial;
							this.orientacaoDaArmaAtual = 0;
						} else if (this.armaSelecionada == "c1" || this.armaSelecionada == "c2") {
							if (this.posicaoFinal) {
								this.tabuleiro.matriz = control.removeArmaDoTabuleiro(this.tabuleiro.matriz,
										this.nomeJogador, 'c', this.linhaAnterior, this.colunaAnterior,
										this.orientacaoDaArmaAtual);
							}
							this.tabuleiro.matriz = control.salvarMudancasNoTabuleiro(this.tabuleiro.matriz,
									this.nomeJogador, 'c', (int) quadrado.linhaInicial, (int) quadrado.colunaInicial,
									this.orientacaoDaArmaAtual);
							this.linhaAnterior = (int) quadrado.linhaInicial;
							this.colunaAnterior = (int) quadrado.colunaInicial;
							this.orientacaoDaArmaAtual = 0;
						} else if (this.armaSelecionada == "d1" || this.armaSelecionada == "d2"
								|| this.armaSelecionada == "d3") {
							if (this.posicaoFinal) {
								this.tabuleiro.matriz = control.removeArmaDoTabuleiro(this.tabuleiro.matriz,
										this.nomeJogador, 'd', this.linhaAnterior, this.colunaAnterior,
										this.orientacaoDaArmaAtual);
							}
							this.tabuleiro.matriz = control.salvarMudancasNoTabuleiro(this.tabuleiro.matriz,
									this.nomeJogador, 'd', (int) quadrado.linhaInicial, (int) quadrado.colunaInicial,
									this.orientacaoDaArmaAtual);
							this.linhaAnterior = (int) quadrado.linhaInicial;
							this.colunaAnterior = (int) quadrado.colunaInicial;
							this.orientacaoDaArmaAtual = 0;
						} else if (this.armaSelecionada == "h1" || this.armaSelecionada == "h2"
								|| this.armaSelecionada == "h3" || this.armaSelecionada == "h4"
								|| this.armaSelecionada == "h5") {
							if (this.posicaoFinal) {
								this.tabuleiro.matriz = control.removeArmaDoTabuleiro(this.tabuleiro.matriz,
										this.nomeJogador, 'h', this.linhaAnterior, this.colunaAnterior,
										this.orientacaoDaArmaAtual);
							}
							this.tabuleiro.matriz = control.salvarMudancasNoTabuleiro(this.tabuleiro.matriz,
									this.nomeJogador, 'h', (int) quadrado.linhaInicial, (int) quadrado.colunaInicial,
									this.orientacaoDaArmaAtual);
							this.linhaAnterior = (int) quadrado.linhaInicial;
							this.colunaAnterior = (int) quadrado.colunaInicial;
							this.orientacaoDaArmaAtual = 0;
						} else if (this.armaSelecionada == "s1" || this.armaSelecionada == "s2"
								|| this.armaSelecionada == "s3" || this.armaSelecionada == "s4"
								|| this.armaSelecionada == "s5") {
							if (this.posicaoFinal) {
								this.tabuleiro.matriz = control.removeArmaDoTabuleiro(this.tabuleiro.matriz,
										this.nomeJogador, 's', this.linhaAnterior, this.colunaAnterior,
										this.orientacaoDaArmaAtual);
							}
							this.tabuleiro.matriz = control.salvarMudancasNoTabuleiro(this.tabuleiro.matriz,
									this.nomeJogador, 's', (int) quadrado.linhaInicial, (int) quadrado.colunaInicial,
									this.orientacaoDaArmaAtual);
							this.linhaAnterior = (int) quadrado.linhaInicial;
							this.colunaAnterior = (int) quadrado.colunaInicial;
							this.orientacaoDaArmaAtual = 0;
						}
						return;
					} else if (quadrado != null) {
						ArrayList<Integer> coordenadas = new ArrayList<Integer>();
						switch (quadrado.cor) {
						case "CINZA":
							coordenadas = this.control.pegarCoordenadaDeNavio((int) quadrado.linhaInicial,
									(int) quadrado.colunaInicial, this.nomeJogador, 'C');
							this.orientacaoDaArmaAtual = this.control.pegaOrientacao(coordenadas.get(0),
									coordenadas.get(1), this.nomeJogador, 'C', this.tabuleiro.matriz);
							this.tabuleiro.selecionaCouracado(this.componenteAtual.getGraphics(), coordenadas.get(0),
									coordenadas.get(1), this.orientacaoDaArmaAtual, false);
							this.armaSelecionada = "Couracado";
							this.quantidadeCouracado++;
							break;
						case "ROSA":
							coordenadas = this.control.pegarCoordenadaDeNavio((int) quadrado.linhaInicial,
									(int) quadrado.colunaInicial, this.nomeJogador, 'c');
							this.orientacaoDaArmaAtual = this.control.pegaOrientacao(coordenadas.get(0),
									coordenadas.get(1), this.nomeJogador, 'c', this.tabuleiro.matriz);
							this.tabuleiro.selecionaCruzador(this.componenteAtual.getGraphics(), coordenadas.get(0),
									coordenadas.get(1), this.orientacaoDaArmaAtual, false);
							this.armaSelecionada = "c1";
							this.quantidadeCruzador++;
							break;
						case "VERDE":
							coordenadas = this.control.pegarCoordenadaDeNavio((int) quadrado.linhaInicial,
									(int) quadrado.colunaInicial, this.nomeJogador, 'd');
							this.orientacaoDaArmaAtual = this.control.pegaOrientacao(coordenadas.get(0),
									coordenadas.get(1), this.nomeJogador, 'd', this.tabuleiro.matriz);
							this.tabuleiro.selecionaDestroyer(this.componenteAtual.getGraphics(), coordenadas.get(0),
									coordenadas.get(1), this.orientacaoDaArmaAtual, false);
							this.armaSelecionada = "d1";
							this.quantidadeDestroyer++;
							break;
						case "AZUL":
							coordenadas = this.control.pegarCoordenadaDeNavio((int) quadrado.linhaInicial,
									(int) quadrado.colunaInicial, this.nomeJogador, 's');
							this.orientacaoDaArmaAtual = 0;
							this.tabuleiro.selecionaSubmarino(this.componenteAtual.getGraphics(), coordenadas.get(0),
									coordenadas.get(1), false);
							this.armaSelecionada = "s1";
							this.quantidadeSubmarino++;
							break;
						case "LARANJA":
							coordenadas = this.control.pegarCoordenadaDeNavio((int) quadrado.linhaInicial,
									(int) quadrado.colunaInicial, this.nomeJogador, 'h');
							this.orientacaoDaArmaAtual = this.control.pegaOrientacao(coordenadas.get(0),
									coordenadas.get(1), this.nomeJogador, 'h', this.tabuleiro.matriz);
							this.tabuleiro.selecionaHidroaviao(this.componenteAtual.getGraphics(), coordenadas.get(0),
									coordenadas.get(1), this.orientacaoDaArmaAtual, false);
							this.armaSelecionada = "h1";
							this.quantidadeHidroaviao++;
							break;
						default:
							break;
						}
						this.linhaAnterior = coordenadas.get(0);
						this.colunaAnterior = coordenadas.get(1);
						this.posicaoFinal = true;
						this.reposicao = true;
					}
				}
			}
			else if (button == MouseEvent.BUTTON3 && this.tabuleiro.getClass() == this.componenteAtual.getClass()) {
				if (this.posicaoFinal) {
					if (this.armaSelecionada == "Couracado") {
						this.tabuleiro.matriz = control.removeArmaDoTabuleiro(this.tabuleiro.matriz, this.nomeJogador,
								'C', this.linhaAnterior, this.colunaAnterior, this.orientacaoDaArmaAtual);
						if (this.orientacaoDaArmaAtual == 0) {
							this.orientacaoDaArmaAtual = 90;
						} else {
							this.orientacaoDaArmaAtual = 0;
						}
						this.tabuleiro.matriz = control.salvarMudancasNoTabuleiro(this.tabuleiro.matriz,
								this.nomeJogador, 'C', (int) this.linhaAnterior, (int) this.colunaAnterior,
								this.orientacaoDaArmaAtual);
					} else if (this.armaSelecionada == "c1" || this.armaSelecionada == "c2") {
						this.tabuleiro.matriz = control.removeArmaDoTabuleiro(this.tabuleiro.matriz, this.nomeJogador,
								'c', this.linhaAnterior, this.colunaAnterior, this.orientacaoDaArmaAtual);
						if (this.orientacaoDaArmaAtual == 0) {
							this.orientacaoDaArmaAtual = 90;
						} else {
							this.orientacaoDaArmaAtual = 0;
						}
						this.tabuleiro.matriz = control.salvarMudancasNoTabuleiro(this.tabuleiro.matriz,
								this.nomeJogador, 'c', (int) this.linhaAnterior, (int) this.colunaAnterior,
								this.orientacaoDaArmaAtual);
					} else if (this.armaSelecionada == "d1" || this.armaSelecionada == "d2"
							|| this.armaSelecionada == "d3") {
						this.tabuleiro.matriz = control.removeArmaDoTabuleiro(this.tabuleiro.matriz, this.nomeJogador,
								'd', this.linhaAnterior, this.colunaAnterior, this.orientacaoDaArmaAtual);
						if (this.orientacaoDaArmaAtual == 0) {
							this.orientacaoDaArmaAtual = 90;
						} else {
							this.orientacaoDaArmaAtual = 0;
						}
						this.tabuleiro.matriz = control.salvarMudancasNoTabuleiro(this.tabuleiro.matriz,
								this.nomeJogador, 'd', (int) this.linhaAnterior, (int) this.colunaAnterior,
								this.orientacaoDaArmaAtual);
					} else if (this.armaSelecionada == "h1" || this.armaSelecionada == "h2"
							|| this.armaSelecionada == "h3" || this.armaSelecionada == "h4"
							|| this.armaSelecionada == "h5") {
						this.tabuleiro.matriz = control.removeArmaDoTabuleiro(this.tabuleiro.matriz, this.nomeJogador,
								'h', this.linhaAnterior, this.colunaAnterior, this.orientacaoDaArmaAtual);
						switch(this.orientacaoDaArmaAtual) {
						case 0:
							this.orientacaoDaArmaAtual = 90;
							break;
						case 90:
							this.orientacaoDaArmaAtual = 180;
							break;
						case 180:
							this.orientacaoDaArmaAtual = 270;
							break;
						case 270:
							this.orientacaoDaArmaAtual = 0;
							break;
						}
						this.tabuleiro.matriz = control.salvarMudancasNoTabuleiro(this.tabuleiro.matriz,
								this.nomeJogador, 'h', (int) this.linhaAnterior, (int) this.colunaAnterior,
								this.orientacaoDaArmaAtual);
					}
				}
			}
			return;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE && this.armaSelecionada != null && !this.posicaoFinal
				&& !this.reposicao) {
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
		} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE && this.armaSelecionada != null && this.posicaoFinal
				&& !this.reposicao) {
			if (this.armaSelecionada == "Couracado") {
				this.couracado.removeNavio(this.couracado.getGraphics());
			} else if (this.armaSelecionada == "c1" || this.armaSelecionada == "c2") {
				this.cruzador.removeNavio(this.cruzador.getGraphics(), this.armaSelecionada);
			} else if (this.armaSelecionada == "d1" || this.armaSelecionada == "d2" || this.armaSelecionada == "d3") {
				this.destroyer.removeNavio(this.destroyer.getGraphics(), this.armaSelecionada);
			} else if (this.armaSelecionada == "h1" || this.armaSelecionada == "h2" || this.armaSelecionada == "h3"
					|| this.armaSelecionada == "h4" || this.armaSelecionada == "h5") {
				this.hidroaviao.removeNavio(this.hidroaviao.getGraphics(), this.armaSelecionada);
			} else if (this.armaSelecionada == "s1" || this.armaSelecionada == "s2" || this.armaSelecionada == "s3"
					|| this.armaSelecionada == "s4" || this.armaSelecionada == "s5") {
				this.submarino.removeNavio(this.submarino.getGraphics(), this.armaSelecionada);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE && this.armaSelecionada != null && this.posicaoFinal
				&& this.reposicao) {
			if (this.armaSelecionada == "Couracado") {
				this.quantidadeCouracado--;
				this.tabuleiro.selecionaCouracado(this.componenteAtual.getGraphics(), this.linhaAnterior,
						this.colunaAnterior, this.orientacaoDaArmaAtual, true);
			} else if (this.armaSelecionada == "c1" || this.armaSelecionada == "c2") {
				this.quantidadeCruzador--;
				this.tabuleiro.selecionaCruzador(this.componenteAtual.getGraphics(), this.linhaAnterior,
						this.colunaAnterior, this.orientacaoDaArmaAtual, true);
			} else if (this.armaSelecionada == "d1" || this.armaSelecionada == "d2" || this.armaSelecionada == "d3") {
				this.quantidadeDestroyer--;
				this.tabuleiro.selecionaDestroyer(this.componenteAtual.getGraphics(), this.linhaAnterior,
						this.colunaAnterior, this.orientacaoDaArmaAtual, true);
			} else if (this.armaSelecionada == "h1" || this.armaSelecionada == "h2" || this.armaSelecionada == "h3"
					|| this.armaSelecionada == "h4" || this.armaSelecionada == "h5") {
				this.quantidadeHidroaviao--;
				this.tabuleiro.selecionaHidroaviao(this.componenteAtual.getGraphics(), this.linhaAnterior,
						this.colunaAnterior, this.orientacaoDaArmaAtual, true);
			} else if (this.armaSelecionada == "s1" || this.armaSelecionada == "s2" || this.armaSelecionada == "s3"
					|| this.armaSelecionada == "s4" || this.armaSelecionada == "s5") {
				this.quantidadeSubmarino--;
				this.tabuleiro.selecionaSubmarino(this.componenteAtual.getGraphics(), this.linhaAnterior,
						this.colunaAnterior, true);
			}
		}
		this.armaSelecionada = null;
		this.linhaAnterior = 0;
		this.colunaAnterior = 0;
		this.orientacaoDaArmaAtual = 0;
		this.posicaoFinal = false;
		this.reposicao = false;
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

	@Override
	public void couracadoNoTabuleiro(int linhaInicial, int colunaInicial, int orientacao, Boolean posicaoCorreta) {
		this.tabuleiro.couracadoNoTabuleiro(this.componenteAtual.getGraphics(), linhaInicial, colunaInicial, orientacao,
				posicaoCorreta);
		this.quantidadeCouracado--;
		this.posicaoFinal = true;
	}

	@Override
	public void cruzadorNoTabuleiro(int linhaInicial, int colunaInicial, int orientacao, Boolean posicaoCorreta) {
		this.tabuleiro.cruzadorNoTabuleiro(this.componenteAtual.getGraphics(), linhaInicial, colunaInicial, orientacao,
				posicaoCorreta);
		this.quantidadeCruzador--;
		this.posicaoFinal = true;
	}

	@Override
	public void destroyerNoTabuleiro(int linhaInicial, int colunaInicial, int orientacao, Boolean posicaoCorreta) {
		this.tabuleiro.destroyerNoTabuleiro(this.componenteAtual.getGraphics(), linhaInicial, colunaInicial, orientacao,
				posicaoCorreta);
		this.quantidadeDestroyer--;
		this.posicaoFinal = true;
	}

	@Override
	public void hidroaviaoNoTabuleiro(int linhaInicial, int colunaInicial, int orientacao, Boolean posicaoCorreta) {
		this.tabuleiro.hidroaviaoNoTabuleiro(this.componenteAtual.getGraphics(), linhaInicial, colunaInicial,
				orientacao, posicaoCorreta);
		this.quantidadeHidroaviao--;
		this.posicaoFinal = true;
	}

	@Override
	public void submarinoNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		this.tabuleiro.submarinoNoTabuleiro(this.componenteAtual.getGraphics(), linhaInicial, colunaInicial,
				posicaoCorreta);
		this.quantidadeSubmarino--;
		this.submarino.removeNavio(this.submarino.getGraphics(), this.armaSelecionada);
		this.posicaoFinal = true;
	}

	@Override
	public void removeCouracadoDoTabuleiro(int linhaInicial, int colunaInicial, int orientacao) {
		this.tabuleiro.removeCouracadoDoTabuleiro(this.componenteAtual.getGraphics(), linhaInicial, colunaInicial,
				orientacao);
		this.quantidadeCouracado++;
	}

	@Override
	public void removeCruzadorDoTabuleiro(int linhaInicial, int colunaInicial, int orientacao) {
		this.tabuleiro.removeCruzadorDoTabuleiro(this.componenteAtual.getGraphics(), linhaInicial, colunaInicial,
				orientacao);
		this.quantidadeCruzador++;

	}

	@Override
	public void removeDestroyerDoTabuleiro(int linhaInicial, int colunaInicial, int orientacao) {
		this.tabuleiro.removeDestroyerDoTabuleiro(this.componenteAtual.getGraphics(), linhaInicial, colunaInicial,
				orientacao);
		this.quantidadeDestroyer++;

	}

	@Override
	public void removeHidroaviaoDoTabuleiro(int linhaInicial, int colunaInicial, int orientacao) {
		this.tabuleiro.removeHidroaviaoDoTabuleiro(this.componenteAtual.getGraphics(), linhaInicial, colunaInicial,
				orientacao);
		this.quantidadeHidroaviao++;

	}

	@Override
	public void removeSubmarinoDoTabuleiro(int linhaInicial, int colunaInicial) {
		this.tabuleiro.removeSubmarinoDoTabuleiro(this.componenteAtual.getGraphics(), linhaInicial, colunaInicial);
		this.quantidadeSubmarino++;

	}

	@Override
	public void pintarQuadrado(int linha, int coluna, String cor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void anunciaVencedor() {
		// TODO Auto-generated method stub

	}

}
