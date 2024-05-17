package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Destroyer extends JPanel{
	private static final long serialVersionUID = 1L;
	int tamanho = 2;
	QuadradoDeTabuleiro[][] destroyer1;
	QuadradoDeTabuleiro[][] destroyer2;
	QuadradoDeTabuleiro[][] destroyer3;
	double alturaQuadrado;
	double larguraQuadrado;

	Destroyer() {
		this.destroyer1 = new QuadradoDeTabuleiro[1][tamanho];
		this.destroyer2 = new QuadradoDeTabuleiro[1][tamanho];
		this.destroyer3 = new QuadradoDeTabuleiro[1][tamanho];
		inicializarDestroyer();
		this.alturaQuadrado = destroyer1[0][0].altura;
		this.larguraQuadrado = destroyer1[0][0].largura;
	}

	void inicializarDestroyer() {
		for (int j = 0; j < tamanho; j++) {
			this.destroyer1[0][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
			this.destroyer2[0][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
			this.destroyer3[0][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.green);
		
		desenharDestroyer(g2d, 50, 100, this.destroyer1);
		
		desenharDestroyer(g2d, larguraQuadrado*4+50, 100, this.destroyer2);
		
		desenharDestroyer(g2d, larguraQuadrado*4+(larguraQuadrado*4+50), 100, this.destroyer3);
	}
	
	void desenharDestroyer(Graphics2D g2d, double inicioX, double inicioY, QuadradoDeTabuleiro[][] destroyer) {
		for (int coluna = 0; coluna < tamanho; coluna++) {
			double x = inicioX + coluna * larguraQuadrado;
			double y = inicioY;
			QuadradoDeTabuleiro quadrado = new QuadradoDeTabuleiro(0, coluna, x, y);
			destroyer[0][coluna] = quadrado;
			g2d.draw(quadrado.quadrado);
			g2d.fill(quadrado.quadrado);
		}
	}
	
	Integer confirmaObjeto(Point point){
		for (int coluna = 0; coluna < tamanho; coluna++) {
			if(this.destroyer1[0][coluna].quadrado.contains(point)){
				return 1;
			}
			if(this.destroyer2[0][coluna].quadrado.contains(point)){
				return 2;
			}
			if(this.destroyer3[0][coluna].quadrado.contains(point)){
				return 3;
			}
		}
		return null;
	}
	
	void pintarNavio(Graphics g, int navio) {
		Graphics2D g2d = (Graphics2D) g;
		if(navio == 1) {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.setColor(Color.BLACK);
				g2d.draw(destroyer1[0][coluna].quadrado);
			}
		}
		else if(navio == 2) {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.setColor(Color.BLACK);
				g2d.draw(destroyer2[0][coluna].quadrado);
			}
		}
		else if(navio == 3) {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.setColor(Color.BLACK);
				g2d.draw(destroyer3[0][coluna].quadrado);
			}
		}
		return;
	}
}
