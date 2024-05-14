package model;

//nota do tabuleiro '0' para água, '1' para tiro, 'E' para encouraçado, 'C' para cruzador,
// 'D' para destroyer, 'S' para submarino, 'H' para hidroavião, 'A' para acerto

class Tabuleiro {
	char[][] tabuleiro;

	// Construtor para inicializar o tabuleiro
	Tabuleiro() {
		this.tabuleiro = new char[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				this.tabuleiro[i][j] = '0';
			}
		}
	}

	// Construtor para inicializar o tabuleiro a partir de uma matriz salva
	Tabuleiro(char[][] arquivoCarregado) {
		this.tabuleiro = new char[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				this.tabuleiro[i][j] = arquivoCarregado[i][j];
			}
		}
	}

	void inserirCouracado(Couracado couracado) {
		if (couracado.orientacao == 90) {
			this.tabuleiro[couracado.linhaInicial][couracado.colunaInicial] = 'E';
			this.tabuleiro[couracado.linhaInicial + 1][couracado.colunaInicial] = 'E';
			this.tabuleiro[couracado.linhaInicial + 2][couracado.colunaInicial] = 'E';
			this.tabuleiro[couracado.linhaInicial + 3][couracado.colunaInicial] = 'E';
			this.tabuleiro[couracado.linhaInicial + 4][couracado.colunaInicial] = 'E';
		} else {
			this.tabuleiro[couracado.linhaInicial][couracado.colunaInicial] = 'E';
			this.tabuleiro[couracado.linhaInicial][couracado.colunaInicial + 1] = 'E';
			this.tabuleiro[couracado.linhaInicial][couracado.colunaInicial + 2] = 'E';
			this.tabuleiro[couracado.linhaInicial][couracado.colunaInicial + 3] = 'E';
			this.tabuleiro[couracado.linhaInicial][couracado.colunaInicial + 4] = 'E';
		}
	}

	void inserirCruzador(Cruzador cruzador) {
		if (cruzador.orientacao == 90) {
			this.tabuleiro[cruzador.linhaInicial][cruzador.colunaInicial] = 'C';
			this.tabuleiro[cruzador.linhaInicial + 1][cruzador.colunaInicial] = 'C';
			this.tabuleiro[cruzador.linhaInicial + 2][cruzador.colunaInicial] = 'C';
			this.tabuleiro[cruzador.linhaInicial + 3][cruzador.colunaInicial] = 'C';
		} else {
			this.tabuleiro[cruzador.linhaInicial][cruzador.colunaInicial] = 'C';
			this.tabuleiro[cruzador.linhaInicial][cruzador.colunaInicial + 1] = 'C';
			this.tabuleiro[cruzador.linhaInicial][cruzador.colunaInicial + 2] = 'C';
			this.tabuleiro[cruzador.linhaInicial][cruzador.colunaInicial + 3] = 'C';
		}
	}

	void inserirDestroyer(Destroyer destroyer) {
		if (destroyer.orientacao == 90) {
			this.tabuleiro[destroyer.linhaInicial][destroyer.colunaInicial] = 'D';
			this.tabuleiro[destroyer.linhaInicial + 1][destroyer.colunaInicial] = 'D';
		} else {
			this.tabuleiro[destroyer.linhaInicial][destroyer.colunaInicial] = 'D';
			this.tabuleiro[destroyer.linhaInicial][destroyer.colunaInicial + 1] = 'D';
		}
	}

	void inserirSubmarino(Submarino submarino) {
		this.tabuleiro[submarino.linhaInicial][submarino.colunaInicial] = 'S';
	}

	void inserirHidroaviao(Hidroaviao hidroaviao) {
		if (hidroaviao.orientacao == 0 || hidroaviao.orientacao == 360) {
			this.tabuleiro[hidroaviao.linhaInicial][hidroaviao.colunaInicial] = 'H';
			this.tabuleiro[hidroaviao.linhaInicial + 1][hidroaviao.colunaInicial + 1] = 'H';
			this.tabuleiro[hidroaviao.linhaInicial + 1][hidroaviao.colunaInicial - 1] = 'H';
		}
		if (hidroaviao.orientacao == 90) {
			this.tabuleiro[hidroaviao.linhaInicial][hidroaviao.colunaInicial] = 'H';
			this.tabuleiro[hidroaviao.linhaInicial + 1][hidroaviao.colunaInicial + 1] = 'H';
			this.tabuleiro[hidroaviao.linhaInicial - 1][hidroaviao.colunaInicial + 1] = 'H';
		}
		if (hidroaviao.orientacao == 180) {
			this.tabuleiro[hidroaviao.linhaInicial][hidroaviao.colunaInicial] = 'H';
			this.tabuleiro[hidroaviao.linhaInicial - 1][hidroaviao.colunaInicial + 1] = 'H';
			this.tabuleiro[hidroaviao.linhaInicial - 1][hidroaviao.colunaInicial - 1] = 'H';
		} else {
			this.tabuleiro[hidroaviao.linhaInicial][hidroaviao.colunaInicial] = 'H';
			this.tabuleiro[hidroaviao.linhaInicial - 1][hidroaviao.colunaInicial - 1] = 'H';
			this.tabuleiro[hidroaviao.linhaInicial + 1][hidroaviao.colunaInicial - 1] = 'H';
		}
	}

	// Método para exibir o tabuleiro no console
	void exibirTabuleiro() {
		System.out.println("  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
		for (int i = 0; i < 15; i++) {
			System.out.print((char) ('A' + i) + " ");
			for (int j = 0; j < 15; j++) {
				System.out.print(this.tabuleiro[i][j] + " ");
			}
			System.out.println();
		}
	}

	// Métodos para obter e definir o estado de uma posição no tabuleiro
	char getPosicao(int linha, int coluna) {
		return this.tabuleiro[linha][coluna];
	}

	void setPosicao(int linha, int coluna, char valor) {
		this.tabuleiro[linha][coluna] = valor;
	}

	// Método para verificar se uma posição no tabuleiro está dentro dos limites
	boolean posicaoValida(int linha, int coluna) {
		return linha >= 0 && linha < 15 && coluna >= 0 && coluna < 15;
	}

}
