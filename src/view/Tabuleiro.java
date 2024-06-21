package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;

class Tabuleiro extends JPanel {
	private static final long serialVersionUID = 1L;
	QuadradoDeTabuleiro[][] tabuleiro;
	char[][] matriz;
	int linhas;
	int colunas;
	double ladoQuadrado;

	Tabuleiro(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.tabuleiro = new QuadradoDeTabuleiro[linhas][colunas];
		this.matriz = new char[linhas][colunas];
		inicializarTabuleiro();
		this.ladoQuadrado = tabuleiro[0][0].lado;
	}

	Tabuleiro(char[][] matriz) {
		this.matriz = matriz;
		this.linhas = 15;
		this.colunas = 15;
		this.tabuleiro = new QuadradoDeTabuleiro[linhas][colunas];
		inicializaTabuleiroComMatriz();
		this.ladoQuadrado = tabuleiro[0][0].lado;
	}

	void inicializarTabuleiro() {
		for (int i = 0; i < this.linhas; i++) {
			for (int j = 0; j < this.colunas; j++) {
				this.tabuleiro[i][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
			}
		}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				this.matriz[i][j] = '0';
			}
		}
	}

	void inicializaTabuleiroComMatriz() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				this.tabuleiro[i][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
				if (this.matriz[i][j] == 'C') {
					this.tabuleiro[i][j].cor = "CINZA";
				} else if (this.matriz[i][j] == 'c') {
					this.tabuleiro[i][j].cor = "ROSA";
				} else if (this.matriz[i][j] == 'd') {
					this.tabuleiro[i][j].cor = "VERDE";
				} else if (this.matriz[i][j] == 's') {
					this.tabuleiro[i][j].cor = "AZUL";
				} else if (this.matriz[i][j] == 'h') {
					this.tabuleiro[i][j].cor = "LARANJA";
				} else if (this.matriz[i][j] == 'A') {
					this.tabuleiro[i][j].cor = "ROSA";
				} else if (this.matriz[i][j] == 'a') {
					this.tabuleiro[i][j].cor = "AZUL";
				} else if (this.matriz[i][j] == 'V') {
					this.tabuleiro[i][j].cor = "VERMELHO";
				}
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.BLACK);

		desenharTabuleiro(g2d, 100, 200);
	}

	void desenharTabuleiro(Graphics2D g2d, double inicioX, double inicioY) {
		for (int linha = 0; linha < this.linhas; linha++) {
			double y = inicioY + linha * this.ladoQuadrado + this.ladoQuadrado / 2;
			g2d.drawString(Integer.toString(linha + 1), (float) (inicioX - 20), (float) y);
		}

		for (int coluna = 0; coluna < this.colunas; coluna++) {
			double x = inicioX + coluna * this.ladoQuadrado + this.ladoQuadrado / 2;
			g2d.drawString(Character.toString((char) ('A' + coluna)), (float) x, (float) (inicioY - 10));
		}

		for (int linha = 0; linha < this.linhas; linha++) {
			for (int coluna = 0; coluna < this.colunas; coluna++) {
				double x = inicioX + coluna * this.ladoQuadrado;
				double y = inicioY + linha * this.ladoQuadrado;
				if (this.tabuleiro[linha][coluna].cor != "BRANCO") {
					this.tabuleiro[linha][coluna] = new QuadradoDeTabuleiro(linha, coluna, x, y,
							this.tabuleiro[linha][coluna].cor);
					if (this.tabuleiro[linha][coluna].cor == "CINZA") {
						g2d.setColor(Color.LIGHT_GRAY);
						g2d.fill(this.tabuleiro[linha][coluna].quadrado);
					} else if (this.tabuleiro[linha][coluna].cor == "ROSA") {
						g2d.setColor(Color.PINK);
						g2d.fill(this.tabuleiro[linha][coluna].quadrado);
					} else if (this.tabuleiro[linha][coluna].cor == "VERDE") {
						g2d.setColor(Color.GREEN);
						g2d.fill(this.tabuleiro[linha][coluna].quadrado);
					} else if (this.tabuleiro[linha][coluna].cor == "AZUL") {
						g2d.setColor(Color.BLUE);
						g2d.fill(this.tabuleiro[linha][coluna].quadrado);
					} else if (this.tabuleiro[linha][coluna].cor == "LARANJA") {
						g2d.setColor(Color.ORANGE);
						g2d.fill(this.tabuleiro[linha][coluna].quadrado);
					} else if (this.tabuleiro[linha][coluna].cor == "VERMELHO") {
						g2d.setColor(Color.RED);
						g2d.fill(this.tabuleiro[linha][coluna].quadrado);
					}
				} else {
					this.tabuleiro[linha][coluna] = new QuadradoDeTabuleiro(linha, coluna, x, y);
					g2d.setColor(Color.BLACK);
					g2d.draw(this.tabuleiro[linha][coluna].quadrado);

				}
			}
		}
	}

	QuadradoDeTabuleiro confirmaObjeto(Point point) {
		for (int i = 0; i < this.linhas; i++) {
			for (int j = 0; j < this.colunas; j++) {
				if (this.tabuleiro[i][j].quadrado.contains(point)) {
					return this.tabuleiro[i][j];
				}
			}
		}
		return null;
	}

	void couracadoNoTabuleiro(Graphics g, int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		int tamanho = 5;
		Graphics2D g2d = (Graphics2D) g;
		if (posicaoCorreta) {
			g2d.setColor(Color.LIGHT_GRAY);
		} else {
			g2d.setColor(Color.RED);
		}
		for (int i = 0; i < tamanho; i++) {
			g2d.fill(this.tabuleiro[linhaInicial][i + colunaInicial].quadrado);
			this.tabuleiro[linhaInicial][i + colunaInicial].cor = "CINZA";
		}
		return;
	}

	void cruzadorNoTabuleiro(Graphics g, int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		int tamanho = 4;
		Graphics2D g2d = (Graphics2D) g;
		if (posicaoCorreta) {
			g2d.setColor(Color.PINK);
		} else {
			g2d.setColor(Color.RED);
		}
		for (int i = 0; i < tamanho; i++) {
			g2d.fill(this.tabuleiro[linhaInicial][i + colunaInicial].quadrado);
			this.tabuleiro[linhaInicial][i + colunaInicial].cor = "ROSA";
		}
		return;
	}

	void destroyerNoTabuleiro(Graphics g, int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		int tamanho = 2;
		Graphics2D g2d = (Graphics2D) g;
		if (posicaoCorreta) {
			g2d.setColor(Color.GREEN);
		} else {
			g2d.setColor(Color.RED);
		}
		for (int i = 0; i < tamanho; i++) {
			g2d.fill(this.tabuleiro[linhaInicial][i + colunaInicial].quadrado);
			this.tabuleiro[linhaInicial][i + colunaInicial].cor = "VERDE";
		}
		return;
	}

	void submarinoNoTabuleiro(Graphics g, int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		Graphics2D g2d = (Graphics2D) g;
		if (posicaoCorreta) {
			g2d.setColor(Color.BLUE);
		} else {
			g2d.setColor(Color.RED);
		}
		g2d.fill(this.tabuleiro[linhaInicial][colunaInicial].quadrado);
		this.tabuleiro[linhaInicial][colunaInicial].cor = "AZUL";
		return;
	}

	void hidroaviaoNoTabuleiro(Graphics g, int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		Graphics2D g2d = (Graphics2D) g;
		if (posicaoCorreta) {
			g2d.setColor(Color.ORANGE);
		} else {
			g2d.setColor(Color.RED);
		}
		g2d.fill(this.tabuleiro[linhaInicial][colunaInicial].quadrado);
		g2d.fill(this.tabuleiro[linhaInicial + 1][colunaInicial - 1].quadrado);
		g2d.fill(this.tabuleiro[linhaInicial + 1][colunaInicial + 1].quadrado);
		this.tabuleiro[linhaInicial][colunaInicial].cor = "LARANJA";
		this.tabuleiro[linhaInicial + 1][colunaInicial - 1].cor = "LARANJA";
		this.tabuleiro[linhaInicial + 1][colunaInicial + 1].cor = "LARANJA";
	}

	char[][] insereAtualizaMatriz(QuadradoDeTabuleiro quadradoInicial, char tipoDeArma) {
		int linha = (int) quadradoInicial.linhaInicial;
		int coluna = (int) quadradoInicial.colunaInicial;
		switch (tipoDeArma) {
		case 'C':
			for (int i = 0; i < 5; i++) {
				this.matriz[linha][coluna + i] = 'C';
			}
			break;
		case 'c':
			for (int i = 0; i < 4; i++) {
				this.matriz[linha][coluna + i] = 'c';
			}
			break;
		case 'd':
			for (int i = 0; i < 2; i++) {
				this.matriz[linha][coluna + i] = 'd';
			}
			break;
		case 'h':
			this.matriz[linha][coluna] = 'h';
			this.matriz[linha + 1][coluna - 1] = 'h';
			this.matriz[linha + 1][coluna + 1] = 'h';
			break;
		case 's':
			this.matriz[linha][coluna] = 's';
			break;
		case 'A':
			this.matriz[linha][coluna] = 'A';
			break;
		case 'a':
			this.matriz[linha][coluna] = 'a';
			break;
		}
		return this.matriz;
	}
}
