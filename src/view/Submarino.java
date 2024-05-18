package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Submarino extends JPanel {
	private static final long serialVersionUID = 1L;
	int tamanho = 1;
	int quantidade = 4;
	QuadradoDeTabuleiro[][] sub1;
	QuadradoDeTabuleiro[][] sub2;
	QuadradoDeTabuleiro[][] sub3;
	QuadradoDeTabuleiro[][] sub4;
	double alturaQuadrado;
	double larguraQuadrado;

	Submarino() {
		this.sub1 = new QuadradoDeTabuleiro[1][1];
		this.sub2 = new QuadradoDeTabuleiro[1][1];
		this.sub3 = new QuadradoDeTabuleiro[1][1];
		this.sub4 = new QuadradoDeTabuleiro[1][1];
		inicializarSubmarino();
		this.alturaQuadrado = sub1[0][0].altura;
		this.larguraQuadrado = sub1[0][0].largura;
	}

	void inicializarSubmarino() {
		this.sub1[0][0] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.sub2[0][0] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.sub3[0][0] = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.sub4[0][0] = new QuadradoDeTabuleiro(0, 0, 0, 0);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.blue);

		desenharSubmarino(g2d, 50, 100, this.sub1);

		desenharSubmarino(g2d, larguraQuadrado * 2 + 50, 100, this.sub2);

		desenharSubmarino(g2d, larguraQuadrado * 4 + 50, 100, this.sub3);
		
		desenharSubmarino(g2d, larguraQuadrado * 6 + 50, 100, this.sub4);
	}

	void desenharSubmarino(Graphics2D g2d, double inicioX, double inicioY, QuadradoDeTabuleiro[][] submarino) {
		double x = inicioX;
		double y = inicioY;
		QuadradoDeTabuleiro quadrado = new QuadradoDeTabuleiro(0, 0, x, y);
		submarino[0][0] = quadrado;
		g2d.draw(quadrado.quadrado);
		g2d.fill(quadrado.quadrado);
	}
	
	Integer confirmaObjeto(Point point){
		if(this.sub1[0][0].quadrado.contains(point)){
			return 1;
		}
		if(this.sub2[0][0].quadrado.contains(point)){
			return 2;
		}
		if(this.sub1[0][0].quadrado.contains(point)){
			return 3;
		}
		if(this.sub2[0][0].quadrado.contains(point)){
			return 4;
		}
		return null;
	}
	
	void pintarNavio(Graphics g, int navio) {
		Graphics2D g2d = (Graphics2D) g;
		if(navio == 1) {
			g2d.setColor(Color.BLACK);
			g2d.draw(sub1[0][0].quadrado);
		}
		else if(navio == 2) {
			g2d.setColor(Color.BLACK);
			g2d.draw(sub2[0][0].quadrado);
		}
		else if(navio == 3) {
			g2d.setColor(Color.BLACK);
			g2d.draw(sub3[0][0].quadrado);
		}
		else if(navio == 4) {
			g2d.setColor(Color.BLACK);
			g2d.draw(sub4[0][0].quadrado);
		}
		return;
	}
	
	void deselecionarNavio(Graphics g) {
		repaint();
		return;
	}
}
