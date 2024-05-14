package model;

class Submarino extends Arma {
	final int tamanho = 1;
	int orientacao;

	Submarino(int linhaInicial, int colunaInicial, int orientacao) {
		this.linhaInicial = linhaInicial;
		this.colunaInicial = colunaInicial;
		this.orientacao = orientacao;
	}

	boolean casasAdajacentes(Tabuleiro tabuleiro) {
		for (int i = this.linhaInicial - 1; i <= this.colunaInicial + 1; i++) {
			for (int j = this.colunaInicial - 1; j <= this.colunaInicial + 1; j++) {
				if (i >= 0 && i < 15 && j >= 0 && j < 15) {
					if (tabuleiro.tabuleiro[i][j] != '0') {
						return false;
					}
				}
			}
		}
		return true;
	}

	boolean posicaoValida(Tabuleiro tabuleiro) {
		return this.linhaInicial >= 0 && this.linhaInicial < 15 && this.colunaInicial >= 0 && this.colunaInicial < 15
				&& casasAdajacentes(tabuleiro);
	}
}
