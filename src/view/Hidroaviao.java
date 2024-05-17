package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Hidroaviao extends JPanel {
	private static final long serialVersionUID = 1L;
	int tamanho = 3;
	QuadradoDeTabuleiro[][] h1;
	QuadradoDeTabuleiro[][] h2;
	QuadradoDeTabuleiro[][] h3;
	QuadradoDeTabuleiro[][] h4;
	QuadradoDeTabuleiro[][] h5;
	double alturaQuadrado;
	double larguraQuadrado;

	Hidroaviao() {
		this.h1 = new QuadradoDeTabuleiro[2][3];
		this.h2 = new QuadradoDeTabuleiro[2][3];
		this.h3 = new QuadradoDeTabuleiro[2][3];
		this.h4 = new QuadradoDeTabuleiro[2][3];
		this.h5 = new QuadradoDeTabuleiro[2][3];
		inicializarHidroaviao();
		this.alturaQuadrado = h1[1][0].altura;
		this.larguraQuadrado = h1[1][0].largura;
	}

	void inicializarHidroaviao() {
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

		g2d.setColor(Color.red);

		desenharHidroaviao(g2d, 50, 50, this.h1);

		desenharHidroaviao(g2d, larguraQuadrado * 4 + 50, 50, this.h2);

		desenharHidroaviao(g2d, larguraQuadrado * 8 + 50, 50, this.h3);

		desenharHidroaviao(g2d, larguraQuadrado * 12 + 50, 50, this.h4);

		desenharHidroaviao(g2d, larguraQuadrado * 16 + 50, 50, this.h5);
	}

	void desenharHidroaviao(Graphics2D g2d, double inicioX, double inicioY, QuadradoDeTabuleiro[][] hidroaviao) {
		double x = inicioX;
		double y = inicioY;
		QuadradoDeTabuleiro quadrado1 = new QuadradoDeTabuleiro(0, 0, x, y);
		QuadradoDeTabuleiro quadrado2 = new QuadradoDeTabuleiro(0, 0, x - alturaQuadrado, y + larguraQuadrado);
		QuadradoDeTabuleiro quadrado3 = new QuadradoDeTabuleiro(0, 0, x + alturaQuadrado, y + larguraQuadrado);
		hidroaviao[1][0] = quadrado1;
		hidroaviao[0][1] = quadrado2;
		hidroaviao[1][2] = quadrado3;
		g2d.draw(quadrado1.quadrado);
		g2d.fill(quadrado1.quadrado);
		g2d.draw(quadrado2.quadrado);
		g2d.fill(quadrado2.quadrado);
		g2d.draw(quadrado3.quadrado);
		g2d.fill(quadrado3.quadrado);
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
	
	void pintarNavio(Graphics g, int navio) {
		Graphics2D g2d = (Graphics2D) g;
		if(navio == 1) {
			g2d.setColor(Color.BLACK);
			g2d.draw(h1[1][0].quadrado);
			g2d.draw(h1[0][1].quadrado);
			g2d.draw(h1[1][2].quadrado);
		}
		else if(navio == 2) {
			g2d.setColor(Color.BLACK);
			g2d.draw(h2[1][0].quadrado);
			g2d.draw(h2[0][1].quadrado);
			g2d.draw(h2[1][2].quadrado);
		}
		else if(navio == 2) {
			g2d.setColor(Color.BLACK);
			g2d.draw(h3[1][0].quadrado);
			g2d.draw(h3[0][1].quadrado);
			g2d.draw(h3[1][2].quadrado);
		}
		else if(navio == 2) {
			g2d.setColor(Color.BLACK);
			g2d.draw(h4[1][0].quadrado);
			g2d.draw(h4[0][1].quadrado);
			g2d.draw(h4[1][2].quadrado);
		}
		else if(navio == 2) {
			g2d.setColor(Color.BLACK);
			g2d.draw(h5[1][0].quadrado);
			g2d.draw(h5[0][1].quadrado);
			g2d.draw(h5[1][2].quadrado);
		}
		return;
	}

}
