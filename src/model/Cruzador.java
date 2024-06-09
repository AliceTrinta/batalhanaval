package model;

class Cruzador {

	Cruzador() {
	}

	boolean casasAdajacentes(char[][] matriz, int linhaInicial, int colunaInicial, int orientacao) {
		if (orientacao == 90) {
			for (int i = linhaInicial - 1; i <= linhaInicial + 4; i++) {
				for (int j = colunaInicial - 1; j <= colunaInicial + 1; j++) {
					if (i >= 0 && i < 15 && j >= 0 && j < 15) {
						if (matriz[i][j] != '0') {
							return false;
						}
					}
				}
			}
		} else {
			for (int i = linhaInicial - 1; i <= linhaInicial + 1; i++) {
				for (int j = colunaInicial - 1; j <= colunaInicial + 4; j++) {
					if (i >= 0 && i < 15 && j >= 0 && j < 15) {
						if (matriz[i][j] != '0') {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	boolean posicaoValida(char[][] matriz, int linhaInicial, int colunaInicial, int orientacao) {
		if (orientacao == 90) {
			return linhaInicial + 3 < 15 && casasAdajacentes(matriz, linhaInicial, colunaInicial, orientacao);
		} else {
			return colunaInicial + 3 <= 15 && casasAdajacentes(matriz, linhaInicial, colunaInicial, orientacao);
		}
	}
}
