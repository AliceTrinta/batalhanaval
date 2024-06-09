package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

class QuadradoDeTabuleiro {
	Rectangle2D.Double quadrado;
	String cor;
	double linhaInicial;
	double colunaInicial;
	double posicaoLinhaInicial;
	double posicaoColunaInicial;
	double lado = 35.0;
	boolean selecionado = false;

	QuadradoDeTabuleiro(double linhaInicial, double colunaInicial, double posicaoLinhaInicial,
			double posicaoColunaInicial) {
		this.cor = "BRANCO";
		this.linhaInicial = linhaInicial;
		this.colunaInicial = colunaInicial;
		this.posicaoLinhaInicial = posicaoLinhaInicial;
		this.posicaoColunaInicial = posicaoColunaInicial;
		this.quadrado = new Rectangle2D.Double(posicaoLinhaInicial, posicaoColunaInicial, lado, lado);
	}
	
	QuadradoDeTabuleiro(double linhaInicial, double colunaInicial, double posicaoLinhaInicial,
			double posicaoColunaInicial, String cor) {
		this.cor = cor;
		this.linhaInicial = linhaInicial;
		this.colunaInicial = colunaInicial;
		this.posicaoLinhaInicial = posicaoLinhaInicial;
		this.posicaoColunaInicial = posicaoColunaInicial;
		this.quadrado = new Rectangle2D.Double(posicaoLinhaInicial, posicaoColunaInicial, lado, lado);
	}

	void pintar(Graphics2D g2d) {
		g2d.fill(this.quadrado);
		g2d.setColor(Color.BLACK);
		g2d.draw(this.quadrado);
	}
}
