package model;

import java.util.ArrayList;
import java.util.List;

class Hidroaviao {
	int linhaInicial;
	int colunaInicial;
	Boolean afundou;
	List<QuadradoDeTabuleiro> coordenadas = new ArrayList<>();

	Hidroaviao(int linhaInicial, int colunaInicial) {
		this.linhaInicial = linhaInicial;
		this.colunaInicial = colunaInicial;
		this.afundou = false;
	}

	Hidroaviao(){}
	
	boolean casasAdajacentes(char[][] matriz, int linhaInicial, int colunaInicial, int orientacao) {
		if (orientacao == 0 || orientacao == 360 || orientacao == 180) {
			for (int i = linhaInicial - 1; i <= linhaInicial + 2; i++) {
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
				for (int j = colunaInicial - 1; j <= colunaInicial + 2; j++) {
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
		if (orientacao == 0 || orientacao == 360) {
			return linhaInicial >= 0 && linhaInicial + 2 < 15 && colunaInicial - 1 >= 0 && colunaInicial + 1 < 15
					&& casasAdajacentes(matriz, linhaInicial, colunaInicial, orientacao);
		} else if (orientacao == 90) {
			return linhaInicial - 1 >= 0 && linhaInicial + 1 < 15 && colunaInicial >= 0 && colunaInicial + 2 < 15
					&& casasAdajacentes(matriz, linhaInicial, colunaInicial, orientacao);
		} else if (orientacao == 180) {
			return linhaInicial - 1 >= 0 && linhaInicial + 2 < 15 && colunaInicial - 1 >= 0 && colunaInicial + 1 < 15
					&& casasAdajacentes(matriz, linhaInicial, colunaInicial, orientacao);
		} else {
			return linhaInicial - 1 >= 0 && linhaInicial + 1 < 15 && colunaInicial - 1 >= 0 && colunaInicial + 2 < 15
					&& casasAdajacentes(matriz, linhaInicial, colunaInicial, orientacao);
		}
	}
}
