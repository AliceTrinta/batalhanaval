package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class PainelDeJogo extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	int linhas;
	int colunas;
	double larguraRetangulo = 40.0;
	double alturaRetangulo = 40.0;
	int espacamentoTabuleiro = 60;
	TabuleiroDeJogo tabuleiroDeAtaque;
	TabuleiroDeJogo tabuleiroDeDefesa;

	PainelDeJogo(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.tabuleiroDeAtaque = new TabuleiroDeJogo(linhas, colunas);
		this.tabuleiroDeDefesa = new TabuleiroDeJogo(linhas, colunas);
		addMouseListener(this);
	}

	private void handleMouseClick(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		Graphics2D g2d = (Graphics2D) getGraphics();

		QuadradoDeTabuleiro[][] tabuleiro = getTabuleiroAtual(x, y);

		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				QuadradoDeTabuleiro quadrado = tabuleiro[linha][coluna];
				if (quadrado.quadrado.contains(x, y)) {
					quadrado.setSelecionado(true);
					quadrado.pintar(g2d);
					return;
				}
			}
		}
	}

	QuadradoDeTabuleiro[][] getTabuleiroAtual(double x, double y) {
		double inicioLinhaTabuleiroAtaque = this.tabuleiroDeAtaque.tabuleiro[0][0].posicaoLinhaInicial;
		double inicioColunaTabuleiroAtaque = this.tabuleiroDeAtaque.tabuleiro[0][0].posicaoColunaInicial;
		double inicioLinhaTabuleiroDefesa = this.tabuleiroDeDefesa.tabuleiro[0][0].posicaoLinhaInicial;
		double inicioColunaTabuleiroDefesa = this.tabuleiroDeDefesa.tabuleiro[0][0].posicaoColunaInicial;

		if (x >= inicioLinhaTabuleiroAtaque && x <= larguraRetangulo * linhas + inicioLinhaTabuleiroAtaque) {
			if (y >= inicioColunaTabuleiroAtaque && y <= alturaRetangulo * colunas + inicioColunaTabuleiroAtaque) {
				return tabuleiroDeAtaque.tabuleiro;
			}
		}

		if (x >= inicioLinhaTabuleiroDefesa && x <= larguraRetangulo * linhas + inicioLinhaTabuleiroDefesa) {
			if (y >= inicioColunaTabuleiroDefesa && y <= alturaRetangulo * colunas + inicioColunaTabuleiroDefesa) {
				return tabuleiroDeDefesa.tabuleiro;
			}
		}
		return new QuadradoDeTabuleiro[0][0];
	}

	@Override
	protected void paintComponent(Graphics g) {
		System.out.print("Entrou");
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.BLACK);

		double larguraTabuleiro = colunas * larguraRetangulo;
		double alturaTabuleiro = linhas * alturaRetangulo;

		int larguraPainel = getWidth();
		int alturaPainel = getHeight();
		double larguraTotal = 2 * larguraTabuleiro + espacamentoTabuleiro;
		double inicioX = (larguraPainel - larguraTotal) / 2;
		double inicioY = (alturaPainel - alturaTabuleiro) / 2;

		this.tabuleiroDeAtaque.desenharTabuleiro(g2d, inicioX, inicioY);

		this.tabuleiroDeDefesa.desenharTabuleiro(g2d, inicioX + larguraTabuleiro + espacamentoTabuleiro, inicioY);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		handleMouseClick(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}