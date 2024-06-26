package model;

import java.util.ArrayList;
import java.util.List;

class Couracado {
	int linhaInicial;
	int colunaInicial;
	List<QuadradoDeTabuleiro> coordenadas = new ArrayList<>();
	Boolean afundou;

	Couracado(int linhaInicial, int colunaInicial) {
		this.linhaInicial = linhaInicial;
		this.colunaInicial = colunaInicial;
		this.afundou = false;
	}
	
	Couracado(){}

	boolean casasAdajacentes(char[][] matriz, int linhaInicial, int colunaInicial, int orientacao) {
		if (orientacao == 90) {
			for (int i = linhaInicial - 1; i <= linhaInicial + 5; i++) {
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
				for (int j = colunaInicial - 1; j <= colunaInicial + 5; j++) {
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
			return linhaInicial + 4 < 15 && casasAdajacentes(matriz, linhaInicial, colunaInicial, orientacao);
		} else {
			return colunaInicial + 4 <= 15 && casasAdajacentes(matriz, linhaInicial, colunaInicial, orientacao);
		}
	}
}
