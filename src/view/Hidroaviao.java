package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;

class Hidroaviao extends JPanel {
	private static final long serialVersionUID = 1L;
	int tamanho = 3;
	QuadradoDeTabuleiro[][] h1;
	QuadradoDeTabuleiro[][] h2;
	QuadradoDeTabuleiro[][] h3;
	QuadradoDeTabuleiro[][] h4;
	QuadradoDeTabuleiro[][] h5;
	double ladoQuadrado;

	Hidroaviao() {
		inicializaHidroavioes();
		this.ladoQuadrado = h1[1][0].lado;
	}

	void inicializaHidroavioes() {
		this.h1 = new QuadradoDeTabuleiro[2][3];
		this.h2 = new QuadradoDeTabuleiro[2][3];
		this.h3 = new QuadradoDeTabuleiro[2][3];
		this.h4 = new QuadradoDeTabuleiro[2][3];
		this.h5 = new QuadradoDeTabuleiro[2][3];

		this.h1[1][0] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.h1[0][1] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.h1[1][2] = new QuadradoDeTabuleiro(0, 0, 0, 0);

		this.h2[1][0] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.h2[0][1] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.h2[1][2] = new QuadradoDeTabuleiro(0, 0, 0, 0);

		this.h3[1][0] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.h3[0][1] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.h3[1][2] = new QuadradoDeTabuleiro(0, 0, 0, 0);

		this.h4[1][0] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.h4[0][1] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.h4[1][2] = new QuadradoDeTabuleiro(0, 0, 0, 0);

		this.h5[1][0] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.h5[0][1] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.h5[1][2] = new QuadradoDeTabuleiro(0, 0, 0, 0);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.ORANGE);

		this.h1[1][0] = new QuadradoDeTabuleiro(0, 0, 50, 50);
		this.h1[0][1] = new QuadradoDeTabuleiro(0, 0, 50 - this.ladoQuadrado, 50 + this.ladoQuadrado);
		this.h1[1][2] = new QuadradoDeTabuleiro(0, 0, 50 + this.ladoQuadrado, 50 + this.ladoQuadrado);
		g2d.draw(this.h1[1][0].quadrado);
		g2d.fill(this.h1[1][0].quadrado);
		g2d.draw(this.h1[0][1].quadrado);
		g2d.fill(this.h1[0][1].quadrado);
		g2d.draw(this.h1[1][2].quadrado);
		g2d.fill(this.h1[1][2].quadrado);

		this.h2[1][0] = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 4 + 50, 50);
		this.h2[0][1] = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 4 + 50 - this.ladoQuadrado,
				50 + this.ladoQuadrado);
		this.h2[1][2] = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 4 + 50 + this.ladoQuadrado,
				50 + this.ladoQuadrado);
		g2d.draw(this.h2[1][0].quadrado);
		g2d.fill(this.h2[1][0].quadrado);
		g2d.draw(this.h2[0][1].quadrado);
		g2d.fill(this.h2[0][1].quadrado);
		g2d.draw(this.h2[1][2].quadrado);
		g2d.fill(this.h2[1][2].quadrado);

		this.h3[1][0] = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 8 + 50, 50);
		this.h3[0][1] = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 8 + 50 - this.ladoQuadrado,
				50 + this.ladoQuadrado);
		this.h3[1][2] = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 8 + 50 + this.ladoQuadrado,
				50 + this.ladoQuadrado);
		g2d.draw(this.h3[1][0].quadrado);
		g2d.fill(this.h3[1][0].quadrado);
		g2d.draw(this.h3[0][1].quadrado);
		g2d.fill(this.h3[0][1].quadrado);
		g2d.draw(this.h3[1][2].quadrado);
		g2d.fill(this.h3[1][2].quadrado);

		this.h4[1][0] = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 12 + 50, 50);
		this.h4[0][1] = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 12 + 50 - this.ladoQuadrado,
				50 + this.ladoQuadrado);
		this.h4[1][2] = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 12 + 50 + this.ladoQuadrado,
				50 + this.ladoQuadrado);
		g2d.draw(this.h4[1][0].quadrado);
		g2d.fill(this.h4[1][0].quadrado);
		g2d.draw(this.h4[0][1].quadrado);
		g2d.fill(this.h4[0][1].quadrado);
		g2d.draw(this.h4[1][2].quadrado);
		g2d.fill(this.h4[1][2].quadrado);

		this.h5[1][0] = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 16 + 50, 50);
		this.h5[0][1] = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 16 + 50 - this.ladoQuadrado,
				50 + this.ladoQuadrado);
		this.h5[1][2] = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 16 + 50 + this.ladoQuadrado,
				50 + this.ladoQuadrado);
		g2d.draw(this.h5[1][0].quadrado);
		g2d.fill(this.h5[1][0].quadrado);
		g2d.draw(this.h5[0][1].quadrado);
		g2d.fill(this.h5[0][1].quadrado);
		g2d.draw(this.h5[1][2].quadrado);
		g2d.fill(this.h5[1][2].quadrado);
	}
	
	Integer confirmaObjeto(Point point) {
		if (this.h1[1][0].quadrado.contains(point) || this.h1[0][1].quadrado.contains(point)
				|| this.h1[1][2].quadrado.contains(point)) {
			return 1;
		}
		if (this.h2[1][0].quadrado.contains(point) || this.h2[0][1].quadrado.contains(point)
				|| this.h2[1][2].quadrado.contains(point)) {
			return 2;
		}
		if (this.h3[1][0].quadrado.contains(point) || this.h3[0][1].quadrado.contains(point)
				|| this.h3[1][2].quadrado.contains(point)) {
			return 3;
		}
		if (this.h4[1][0].quadrado.contains(point) || this.h4[0][1].quadrado.contains(point)
				|| this.h4[1][2].quadrado.contains(point)) {
			return 4;
		}
		if (this.h5[1][0].quadrado.contains(point) || this.h5[0][1].quadrado.contains(point)
				|| this.h5[1][2].quadrado.contains(point)) {
			return 5;
		}
		return null;
	}
	
	void selecionaNavio(Graphics g, int navio) {
		Graphics2D g2d = (Graphics2D) g;
		if(navio == 1) {
			g2d.setColor(Color.BLACK);
			g2d.draw(this.h1[1][0].quadrado);
			g2d.draw(this.h1[0][1].quadrado);
			g2d.draw(this.h1[1][2].quadrado);
		}
		else if(navio == 2) {
			g2d.setColor(Color.BLACK);
			g2d.draw(this.h2[1][0].quadrado);
			g2d.draw(this.h2[0][1].quadrado);
			g2d.draw(this.h2[1][2].quadrado);
		}
		else if(navio == 3) {
			g2d.setColor(Color.BLACK);
			g2d.draw(this.h3[1][0].quadrado);
			g2d.draw(this.h3[0][1].quadrado);
			g2d.draw(this.h3[1][2].quadrado);
		}
		else if(navio == 4) {
			g2d.setColor(Color.BLACK);
			g2d.draw(this.h4[1][0].quadrado);
			g2d.draw(this.h4[0][1].quadrado);
			g2d.draw(this.h4[1][2].quadrado);
		}
		else if(navio == 5) {
			g2d.setColor(Color.BLACK);
			g2d.draw(this.h5[1][0].quadrado);
			g2d.draw(this.h5[0][1].quadrado);
			g2d.draw(this.h5[1][2].quadrado);
		}
		return;
	}
	
	void deselecionaNavio(Graphics g, String navio) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.ORANGE);
		if(navio == "h1") {
			g2d.draw(this.h1[1][0].quadrado);
			g2d.draw(this.h1[0][1].quadrado);
			g2d.draw(this.h1[1][2].quadrado);
			g2d.fill(this.h1[1][0].quadrado);
			g2d.fill(this.h1[0][1].quadrado);
			g2d.fill(this.h1[1][2].quadrado);
		}
		else if(navio == "h2") {
			g2d.draw(this.h2[1][0].quadrado);
			g2d.draw(this.h2[0][1].quadrado);
			g2d.draw(this.h2[1][2].quadrado);
			g2d.fill(this.h2[1][0].quadrado);
			g2d.fill(this.h2[0][1].quadrado);
			g2d.fill(this.h2[1][2].quadrado);
		}
		else if(navio == "h3") {
			g2d.draw(this.h3[1][0].quadrado);
			g2d.draw(this.h3[0][1].quadrado);
			g2d.draw(this.h3[1][2].quadrado);
			g2d.fill(this.h3[1][0].quadrado);
			g2d.fill(this.h3[0][1].quadrado);
			g2d.fill(this.h3[1][2].quadrado);
		}
		else if(navio == "h4") {
			g2d.setColor(Color.BLACK);
			g2d.draw(this.h4[1][0].quadrado);
			g2d.draw(this.h4[0][1].quadrado);
			g2d.draw(this.h4[1][2].quadrado);
			g2d.fill(this.h4[1][0].quadrado);
			g2d.fill(this.h4[0][1].quadrado);
			g2d.fill(this.h4[1][2].quadrado);
		}
		else if(navio == "h5") {
			g2d.draw(this.h5[1][0].quadrado);
			g2d.draw(this.h5[0][1].quadrado);
			g2d.draw(this.h5[1][2].quadrado);
			g2d.fill(this.h5[1][0].quadrado);
			g2d.fill(this.h5[0][1].quadrado);
			g2d.fill(this.h5[1][2].quadrado);
		}
		return;
	}
	
	void removeNavio(Graphics g, String navio) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		if(navio == "h1") {
			g2d.draw(this.h1[1][0].quadrado);
			g2d.draw(this.h1[0][1].quadrado);
			g2d.draw(this.h1[1][2].quadrado);
			g2d.fill(this.h1[1][0].quadrado);
			g2d.fill(this.h1[0][1].quadrado);
			g2d.fill(this.h1[1][2].quadrado);
		}
		else if(navio == "h2") {
			g2d.draw(this.h2[1][0].quadrado);
			g2d.draw(this.h2[0][1].quadrado);
			g2d.draw(this.h2[1][2].quadrado);
			g2d.fill(this.h2[1][0].quadrado);
			g2d.fill(this.h2[0][1].quadrado);
			g2d.fill(this.h2[1][2].quadrado);
		}
		else if(navio == "h3") {
			g2d.draw(this.h3[1][0].quadrado);
			g2d.draw(this.h3[0][1].quadrado);
			g2d.draw(this.h3[1][2].quadrado);
			g2d.fill(this.h3[1][0].quadrado);
			g2d.fill(this.h3[0][1].quadrado);
			g2d.fill(this.h3[1][2].quadrado);
		}
		else if(navio == "h4") {
			g2d.draw(this.h4[1][0].quadrado);
			g2d.draw(this.h4[0][1].quadrado);
			g2d.draw(this.h4[1][2].quadrado);
			g2d.fill(this.h4[1][0].quadrado);
			g2d.fill(this.h4[0][1].quadrado);
			g2d.fill(this.h4[1][2].quadrado);
		}
		else if(navio == "h5") {
			g2d.draw(this.h5[1][0].quadrado);
			g2d.draw(this.h5[0][1].quadrado);
			g2d.draw(this.h5[1][2].quadrado);
			g2d.fill(this.h5[1][0].quadrado);
			g2d.fill(this.h5[0][1].quadrado);
			g2d.fill(this.h5[1][2].quadrado);
		}
		return;
	}
}
