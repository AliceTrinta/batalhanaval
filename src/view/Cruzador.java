package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;

class Cruzador extends JPanel {
	private static final long serialVersionUID = 1L;
	int tamanho = 4;
	double ladoQuadrado;
	QuadradoDeTabuleiro[][] c1;
	QuadradoDeTabuleiro[][] c2;
	
	Cruzador(){
		inicializarCruzadores();
		this.ladoQuadrado = c1[0][0].lado;
	}
	
	void inicializarCruzadores() {
		this.c1 = new QuadradoDeTabuleiro[1][this.tamanho];
		this.c2 =  new QuadradoDeTabuleiro[1][this.tamanho];
		for (int j = 0; j < tamanho; j++) {
			this.c1[0][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
			this.c2[0][j] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.pink);

		for (int coluna = 0; coluna < tamanho; coluna++) {
			double x = 50 + coluna * ladoQuadrado;
			this.c1[0][coluna] = new QuadradoDeTabuleiro(0, coluna, x, 100);
			g2d.draw(this.c1[0][coluna].quadrado);
			g2d.fill(this.c1[0][coluna].quadrado);
		}
		
		for (int coluna = 0; coluna < tamanho; coluna++) {
			double x = ladoQuadrado*5+50 + coluna * ladoQuadrado;
			this.c2[0][coluna] = new QuadradoDeTabuleiro(0, coluna, x, 100);
			g2d.draw(this.c2[0][coluna].quadrado);
			g2d.fill(this.c2[0][coluna].quadrado);
		}
	}
	
	Integer confirmaObjeto(Point point){
		for (int coluna = 0; coluna < tamanho; coluna++) {
			if(this.c1[0][coluna].quadrado.contains(point)){
				return 1;
			}
			if(this.c2[0][coluna].quadrado.contains(point)){
				return 2;
			}
		}
		return null;
	}
	
	void selecionaNavio(Graphics g, int navio) {
		Graphics2D g2d = (Graphics2D) g;
		if(navio == 1) {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.setColor(Color.BLACK);
				g2d.draw(this.c1[0][coluna].quadrado);
			}
		}
		else if(navio == 2) {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.setColor(Color.BLACK);
				g2d.draw(this.c2[0][coluna].quadrado);
			}
		}
		return;
	}
	
	void deselecionaNavio(Graphics g, String navio) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.pink);
		if(navio == "c1") {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.draw(this.c1[0][coluna].quadrado);
				g2d.fill(this.c1[0][coluna].quadrado);
			}
		} else if(navio == "c2") {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.draw(this.c2[0][coluna].quadrado);
				g2d.fill(this.c2[0][coluna].quadrado);
			}
		}
		return;
	}
	
	void removeNavio(Graphics g, String navio) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		if(navio == "c1") {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.draw(this.c1[0][coluna].quadrado);
				g2d.fill(this.c1[0][coluna].quadrado);
			}
		} else if(navio == "c2") {
			for (int coluna = 0; coluna < this.tamanho; coluna++) {
				g2d.draw(this.c2[0][coluna].quadrado);
				g2d.fill(this.c2[0][coluna].quadrado);
			}
		}
		return;
	}

}
