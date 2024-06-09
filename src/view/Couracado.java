package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

class Couracado extends JPanel{
	private static final long serialVersionUID = 1L;
	int tamanho = 5;
	double ladoQuadrado;
	QuadradoDeTabuleiro[][] couracado;
	
	Couracado(){
		this.couracado = inicializarCouracado();
		this.ladoQuadrado = couracado[0][0].lado;
	}
	
	QuadradoDeTabuleiro[][] inicializarCouracado() {
		QuadradoDeTabuleiro[][] couracado = new QuadradoDeTabuleiro[1][this.tamanho];
		for (int j = 0; j < 5; j++) {
			couracado[0][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		}
		return couracado;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.lightGray);
		
		for (int coluna = 0; coluna < tamanho; coluna++) {
			double x = 50 + coluna * this.ladoQuadrado;
			this.couracado[0][coluna] = new QuadradoDeTabuleiro(0, coluna, x, 100);
			g2d.draw(this.couracado[0][coluna].quadrado);
			g2d.fill(this.couracado[0][coluna].quadrado);
		}
	}
	
	void selecionaNavio(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (int coluna = 0; coluna < this.tamanho; coluna++) {
			g2d.setColor(Color.BLACK);
			g2d.draw(this.couracado[0][coluna].quadrado);
		}
		return;
	}
	
	void deselecionaNavio(Graphics g) {
		repaint();
		return;
	}
	
	void removeNavio(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (int coluna = 0; coluna < this.tamanho; coluna++) {
			g2d.setColor(Color.WHITE);
			g2d.draw(this.couracado[0][coluna].quadrado);
			g2d.fill(this.couracado[0][coluna].quadrado);
		}
		return;
	}
}
