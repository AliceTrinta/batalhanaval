package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Couracado extends JPanel{
	private static final long serialVersionUID = 1L;
	int tamanho = 5;
	QuadradoDeTabuleiro[][] couracado;
	double alturaQuadrado;
	double larguraQuadrado;
	
	Couracado(){
		this.couracado = new QuadradoDeTabuleiro[1][tamanho];
		inicializarCouracado();
		this.alturaQuadrado = couracado[0][0].altura;
		this.larguraQuadrado = couracado[0][0].largura;
	}
	
	void inicializarCouracado() {
		for (int j = 0; j < tamanho; j++) {
			this.couracado[0][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.lightGray);
		
		desenharCouracado(g2d, 50, 100);
	}
	
	void desenharCouracado(Graphics2D g2d, double inicioX, double inicioY) {
		for (int coluna = 0; coluna < tamanho; coluna++) {
			double x = inicioX + coluna * larguraQuadrado;
			double y = inicioY;
			QuadradoDeTabuleiro quadrado = new QuadradoDeTabuleiro(0, coluna, x, y);
			this.couracado[0][coluna] = quadrado;
			g2d.draw(quadrado.quadrado);
			g2d.fill(quadrado.quadrado);
		}
	}
}
