package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class TabuleiroDeJogo extends JPanel{
	private static final long serialVersionUID = 1L;
	QuadradoDeTabuleiro[][] tabuleiro;
	int linhas;
	int colunas;
	double alturaQuadrado;
	double larguraQuadrado;
	
	TabuleiroDeJogo(int linhas, int colunas){
		this.linhas = linhas;
		this.colunas = colunas;
		this.tabuleiro = new QuadradoDeTabuleiro[linhas][colunas];
		inicializarTabuleiro();
		this.alturaQuadrado = tabuleiro[0][0].altura;
		this.larguraQuadrado = tabuleiro[0][0].largura;
	}
	
	void inicializarTabuleiro() {
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				this.tabuleiro[i][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
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
		for (int linha = 0; linha < linhas; linha++) {
			double y = inicioY + linha * alturaQuadrado + alturaQuadrado / 2;
			g2d.drawString(Integer.toString(linha + 1), (float) (inicioX - 20), (float) y);
		}

		for (int coluna = 0; coluna < colunas; coluna++) {
			double x = inicioX + coluna * larguraQuadrado + larguraQuadrado / 2;
			g2d.drawString(Character.toString((char) ('A' + coluna)), (float) x, (float) (inicioY - 10));
		}

		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				double x = inicioX + coluna * larguraQuadrado;
				double y = inicioY + linha * alturaQuadrado;
				QuadradoDeTabuleiro quadrado = new QuadradoDeTabuleiro(linha, coluna, x, y);
				this.tabuleiro[linha][coluna] = quadrado;
				g2d.draw(quadrado.quadrado);
			}
		}
	}
}
