package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

class QuadradoDeTabuleiro {
	Rectangle2D.Double quadrado;
	String color = "BRANCO";
	double linhaInicial;
	double colunaInicial;
	double posicaoLinhaInicial;
	double posicaoColunaInicial;
	double altura = 35.0;
	double largura = 35.0;
	
	boolean selecionado = false;

	QuadradoDeTabuleiro(double linhaInicial, double colunaInicial, double posicaoLinhaInicial,
			double posicaoColunaInicial) {
		this.linhaInicial = linhaInicial;
		this.colunaInicial = colunaInicial;
		this.posicaoLinhaInicial = posicaoLinhaInicial;
		this.posicaoColunaInicial = posicaoColunaInicial;
		this.quadrado = new Rectangle2D.Double(posicaoLinhaInicial, posicaoColunaInicial, altura, largura);
	}

	void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

	boolean getSelecionado() {
		return selecionado;
	}

	public void pintar(Graphics2D g2d) {
        g2d.fill(this.quadrado);
        g2d.setColor(Color.BLACK);
        g2d.draw(this.quadrado);
    }
}
