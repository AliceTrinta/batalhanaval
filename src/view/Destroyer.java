package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;

class Destroyer extends JPanel{
	private static final long serialVersionUID = 1L;
	int tamanho = 2;
	QuadradoDeTabuleiro[][] d1;
	QuadradoDeTabuleiro[][] d2;
	QuadradoDeTabuleiro[][] d3;
	double ladoQuadrado;
	
	Destroyer(){
		inicializaDestroyers();
		this.ladoQuadrado = d1[0][0].lado;
	}
	
	void inicializaDestroyers() {
		this.d1 = new QuadradoDeTabuleiro[1][tamanho];
		this.d2 = new QuadradoDeTabuleiro[1][tamanho];
		this.d3 = new QuadradoDeTabuleiro[1][tamanho];
		for (int j = 0; j < tamanho; j++) {
			this.d1[0][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
			this.d2[0][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
			this.d3[0][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.green);

		for (int coluna = 0; coluna < tamanho; coluna++) {
			double x = 50 + coluna * ladoQuadrado;
			this.d1[0][coluna] = new QuadradoDeTabuleiro(0, coluna, x, 100);
			g2d.draw(this.d1[0][coluna].quadrado);
			g2d.fill(this.d1[0][coluna].quadrado);
		}
		
		for (int coluna = 0; coluna < tamanho; coluna++) {
			double x = this.ladoQuadrado*4+50 + coluna * ladoQuadrado;
			this.d2[0][coluna] = new QuadradoDeTabuleiro(0, coluna, x, 100);
			g2d.draw(this.d2[0][coluna].quadrado);
			g2d.fill(this.d2[0][coluna].quadrado);
		}
		
		for (int coluna = 0; coluna < tamanho; coluna++) {
			double x = ladoQuadrado*4+(ladoQuadrado*4+50) + coluna * ladoQuadrado;
			this.d3[0][coluna] = new QuadradoDeTabuleiro(0, coluna, x, 100);
			g2d.draw(this.d3[0][coluna].quadrado);
			g2d.fill(this.d3[0][coluna].quadrado);
		}
	}
	
	Integer confirmaObjeto(Point point){
		for (int coluna = 0; coluna < tamanho; coluna++) {
			if(this.d1[0][coluna].quadrado.contains(point)){
				return 1;
			}
			if(this.d2[0][coluna].quadrado.contains(point)){
				return 2;
			}
			if(this.d3[0][coluna].quadrado.contains(point)){
				return 3;
			}
		}
		return null;
	}
	
	void selecionaNavio(Graphics g, int navio) {
		Graphics2D g2d = (Graphics2D) g;
		if(navio == 1) {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.setColor(Color.BLACK);
				g2d.draw(this.d1[0][coluna].quadrado);
			}
		}
		else if(navio == 2) {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.setColor(Color.BLACK);
				g2d.draw(this.d2[0][coluna].quadrado);
			}
		}
		else if(navio == 3) {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.setColor(Color.BLACK);
				g2d.draw(this.d3[0][coluna].quadrado);
			}
		}
		return;
	}
	
	void deselecionaNavio(Graphics g, String navio) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.green);
		if(navio == "d1") {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.draw(this.d1[0][coluna].quadrado);
				g2d.fill(this.d1[0][coluna].quadrado);
			}
		} else if(navio == "d2") {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.draw(this.d2[0][coluna].quadrado);
				g2d.fill(this.d2[0][coluna].quadrado);
			}
		} else if(navio == "d3") {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.draw(this.d3[0][coluna].quadrado);
				g2d.fill(this.d3[0][coluna].quadrado);
			}
		}
		return;
	}
	
	void removeNavio(Graphics g, String navio) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		if(navio == "d1") {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.draw(this.d1[0][coluna].quadrado);
				g2d.fill(this.d1[0][coluna].quadrado);
			}
		} else if(navio == "d2") {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.draw(this.d2[0][coluna].quadrado);
				g2d.fill(this.d2[0][coluna].quadrado);
			}
		} else if(navio == "d3") {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.draw(this.d3[0][coluna].quadrado);
				g2d.fill(this.d3[0][coluna].quadrado);
			}
		}
		return;
	}
}
