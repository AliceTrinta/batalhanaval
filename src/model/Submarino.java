package model;

class Submarino {
	int linhaInicial;
	int colunaInicial;
	Boolean afundou;
	QuadradoDeTabuleiro coordenadas = new QuadradoDeTabuleiro(0,0);

	Submarino(int linhaInicial, int colunaInicial) {
		this.linhaInicial = linhaInicial;
		this.colunaInicial = colunaInicial;
		this.afundou = false;
	}
	
	Submarino(){}

	boolean casasAdajacentes(char[][] matriz, int linhaInicial, int colunaInicial, int orientacao) {
		for (int i = linhaInicial - 1; i <= colunaInicial + 1; i++) {
			for (int j = colunaInicial - 1; j <= colunaInicial + 1; j++) {
				if (i >= 0 && i < 15 && j >= 0 && j < 15) {
					if (matriz[i][j] != '0') {
						return false;
					}
				}
			}
		}
		return true;
	}

	boolean posicaoValida(char[][] matriz, int linhaInicial, int colunaInicial, int orientacao) {
		return linhaInicial >= 0 && linhaInicial < 15 && colunaInicial >= 0 && colunaInicial < 15
				&& casasAdajacentes(matriz, linhaInicial, colunaInicial, orientacao);
	}
}
