package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;


class Submarino extends JPanel {
	private static final long serialVersionUID = 1L;
	int tamanho = 1;
	QuadradoDeTabuleiro s1;
	QuadradoDeTabuleiro s2;
	QuadradoDeTabuleiro s3;
	QuadradoDeTabuleiro s4;
	double ladoQuadrado;
	
	Submarino(){
		inicializaSubmarinos();
		this.ladoQuadrado = s1.lado;
	}
	
	void inicializaSubmarinos(){
		this.s1 = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.s2 = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.s3 = new QuadradoDeTabuleiro(0, 0, 0, 0);
		this.s4 = new QuadradoDeTabuleiro(0, 0, 0, 0);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.blue);

		this.s1 = new QuadradoDeTabuleiro(0, 0, 50, 100);
		g2d.draw(this.s1.quadrado);
		g2d.fill(this.s1.quadrado);

		this.s2 = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 2 + 50, 100);
		g2d.draw(this.s2.quadrado);
		g2d.fill(this.s2.quadrado);
		
		this.s3 = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 4 + 50, 100);
		g2d.draw(this.s3.quadrado);
		g2d.fill(this.s3.quadrado);
		
		this.s4 = new QuadradoDeTabuleiro(0, 0, this.ladoQuadrado * 6 + 50, 100);
		g2d.draw(this.s4.quadrado);
		g2d.fill(this.s4.quadrado);
	}
	
	Integer confirmaObjeto(Point point){
		if(this.s1.quadrado.contains(point)){
			return 1;
		}
		if(this.s2.quadrado.contains(point)){
			return 2;
		}
		if(this.s3.quadrado.contains(point)){
			return 3;
		}
		if(this.s4.quadrado.contains(point)){
			return 4;
		}
		return null;
	}
	
	public void selecionaNavio(Graphics g, int navio) {
		Graphics2D g2d = (Graphics2D) g;
		if(navio == 1) {
			g2d.setColor(Color.BLACK);
			g2d.draw(this.s1.quadrado);
		}
		else if(navio == 2) {
			g2d.setColor(Color.BLACK);
			g2d.draw(this.s2.quadrado);
		}
		else if(navio == 3) {
			g2d.setColor(Color.BLACK);
			g2d.draw(this.s3.quadrado);
		}
		else if(navio == 4) {
			g2d.setColor(Color.BLACK);
			g2d.draw(this.s4.quadrado);
		}
		return;
	}
	
	public void deselecionaNavio(Graphics g, String navio) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);
		if(navio == "s1") {
			g2d.draw(this.s1.quadrado);
			g2d.fill(this.s1.quadrado);
		}
		else if(navio == "s2") {
			g2d.draw(this.s2.quadrado);
			g2d.fill(this.s2.quadrado);
		}
		else if(navio == "s3") {
			g2d.draw(this.s3.quadrado);
			g2d.fill(this.s3.quadrado);
		}
		else if(navio == "s4") {
			g2d.draw(this.s4.quadrado);
			g2d.fill(this.s4.quadrado);
		}
		return;
	}
	
	void removeNavio(Graphics g, String navio) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		if(navio == "s1") {
			g2d.draw(this.s1.quadrado);
			g2d.fill(this.s1.quadrado);
		}
		else if(navio == "s2") {
			g2d.draw(this.s2.quadrado);
			g2d.fill(this.s2.quadrado);
		}
		else if(navio == "s3") {
			g2d.draw(this.s3.quadrado);
			g2d.fill(this.s3.quadrado);
		}
		else if(navio == "s4") {
			g2d.draw(this.s4.quadrado);
			g2d.fill(this.s4.quadrado);
		}
		return;
	}
}
