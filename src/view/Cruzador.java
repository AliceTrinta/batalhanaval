package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Cruzador extends JPanel{
	private static final long serialVersionUID = 1L;
	int tamanho = 4;
	QuadradoDeTabuleiro[][] cruzador1;
	QuadradoDeTabuleiro[][] cruzador2;
	double alturaQuadrado;
	double larguraQuadrado;
	
	Cruzador(){
		this.cruzador1 = new QuadradoDeTabuleiro[1][tamanho];
		this.cruzador2 = new QuadradoDeTabuleiro[1][tamanho];
		inicializarCruzador();
		this.alturaQuadrado = cruzador1[0][0].altura;
		this.larguraQuadrado = cruzador1[0][0].largura;
	}
	
	void inicializarCruzador() {
		for (int j = 0; j < tamanho; j++) {
			this.cruzador1[0][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
			this.cruzador2[0][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.pink);
		
		desenharCouracado(g2d, 50, 100, this.cruzador1);
		
		desenharCouracado(g2d, larguraQuadrado*5+50, 100, this.cruzador2);
	}
	
	void desenharCouracado(Graphics2D g2d, double inicioX, double inicioY, QuadradoDeTabuleiro[][] cruzador) {
		for (int coluna = 0; coluna < tamanho; coluna++) {
			double x = inicioX + coluna * larguraQuadrado;
			double y = inicioY;
			QuadradoDeTabuleiro quadrado = new QuadradoDeTabuleiro(0, coluna, x, y);
			cruzador[0][coluna] = quadrado;
			g2d.draw(quadrado.quadrado);
			g2d.fill(quadrado.quadrado);
		}
	}
}
