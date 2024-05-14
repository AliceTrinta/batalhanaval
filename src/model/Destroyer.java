package model;

class Destroyer extends Arma {
	final int tamanho = 2;
	int orientacao;

	Destroyer(int linhaInicial, int colunaInicial, int orientacao) {
		this.linhaInicial = linhaInicial;
		this.colunaInicial = colunaInicial;
		this.orientacao = orientacao;
	}

	boolean casasAdajacentes(Tabuleiro tabuleiro) {
		if (orientacao == 90) {
			for (int i = this.linhaInicial - 1; i <= this.linhaInicial + 2; i++) {
				for (int j = this.colunaInicial - 1; j <= this.colunaInicial + 1; j++) {
					if (i >= 0 && i < 15 && j >= 0 && j < 15) {
						if (tabuleiro.tabuleiro[i][j] != '0') {
							return false;
						}
					}
				}
			}
		} else {
			for (int i = this.linhaInicial - 1; i <= this.linhaInicial + 1; i++) {
				for (int j = this.colunaInicial - 1; j <= this.colunaInicial + 2; j++) {
					if (i >= 0 && i < 15 && j >= 0 && j < 15) {
						if (tabuleiro.tabuleiro[i][j] != '0') {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	boolean posicaoValida(Tabuleiro tabuleiro) {
		if (orientacao == 90) {
			return this.linhaInicial >= 0 && this.colunaInicial >= 0 && this.colunaInicial < 15
					&& this.linhaInicial + 1 < 15 && casasAdajacentes(tabuleiro);
		} else {
			return this.linhaInicial >= 0 && this.linhaInicial < 15 && this.colunaInicial >= 0
					&& this.colunaInicial < 15 && this.colunaInicial + 1 <= 15 && casasAdajacentes(tabuleiro);
		}
	}
}