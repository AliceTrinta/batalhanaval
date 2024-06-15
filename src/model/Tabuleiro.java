package model;

public class Tabuleiro {
	char[][] matriz;
	Couracado couracado;
	Cruzador[] cruzadores;
	Destroyer[] destroyers;
	Submarino[] submarinos;
	Hidroaviao[] hidroavioes;

	Tabuleiro(char[][] matriz) {
		this.matriz = matriz;
		this.couracado = null;
		this.cruzadores = new Cruzador[2];
		this.destroyers = new Destroyer[3];
		this.submarinos = new Submarino[4];
		this.hidroavioes = new Hidroaviao[5];

		inicializarEmbarcacoes();
	}

	void inicializarEmbarcacoes() {
		int cruzadorIndex = 0;
		int destroyerIndex = 0;
		int submarinoIndex = 0;
		int hidroaviaoIndex = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				switch (matriz[i][j]) {
				case 'C':
					if (couracado == null) {
						couracado = new Couracado(i, j);
					}
					break;
				case 'c':
					if (cruzadorIndex < 2) {
						cruzadores[cruzadorIndex++] = new Cruzador(i, j);
					}
					break;
				case 'd':
					if (destroyerIndex < 3) {
						destroyers[destroyerIndex++] = new Destroyer(i, j);
					}
					break;
				case 's':
					if (submarinoIndex < 4) {
						submarinos[submarinoIndex++] = new Submarino(i, j);
					}
					break;
				case 'h':
					if (hidroaviaoIndex < 5) {
						if (matriz[i + 1][j + 1] == 'h' && matriz[i + 1][j - 1] == 'h') {
							hidroavioes[hidroaviaoIndex++] = new Hidroaviao(i, j);
						}
					}
					break;
				}
			}
		}
	}

//	Boolean verificarCouracadoAfundou(int linha, int coluna) {
//		int linhaInicial = this.couracado.linhaInicial;
//		int colunaInicial = this.couracado.colunaInicial;
//		int posicaoRestante = this.couracado.posicaoRestante();
//		if (linha == linhaInicial && colunaInicial == coluna) {
//			
//		} else if (linhaInicial < linha) {
//
//		} else if (colunaInicial < coluna) {
//
//		}
//		if(posicaoRestante == 0) {
//			return true;
//		}
//	}
//	
//	Boolean verificaCruzadorAfundou(int linha, int coluna) {
//		
//		if (linha == linhaInicial && colunaInicial == coluna) {
//			
//		} else if (linhaInicial < linha) {
//
//		} else if (colunaInicial < coluna) {
//
//		}
//		if(posicaoRestante == 0) {
//			return true;
//		}
//	}
}
