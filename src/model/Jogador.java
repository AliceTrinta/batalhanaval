package model;

class Jogador {
	String nome;
	char[][] tabuleiroAtaque;
	char[][] tabuleiroDefesa;
	Tabuleiro tabuleiroPrincipal = new Tabuleiro();

	Jogador() {
	}

	String getNome() {
		return this.nome;
	}

	void setNome(String nome) {
		this.nome = nome;
	}

	char[][] getTabuleiroAtaque() {
		return this.tabuleiroAtaque;
	}

	void setTabuleiroAtaque(char[][] tabuleiro) {
		this.tabuleiroAtaque = tabuleiro;
	}

	char[][] getTabuleiroDefesa() {
		return this.tabuleiroDefesa;
	}

	void setTabuleiroDefesa(char[][] tabuleiro) {
		this.tabuleiroDefesa = tabuleiro;
	}

	void setTabuleiroPrincipal(char[][] tabuleiroAtaque, char[][] tabuleiroDefesa, int couracadosRestantes,
			int cruzadoresRestantes, int hidroavioesRestantes, int submarinosRestantes, int destroyersRestantes) {
		this.tabuleiroPrincipal.inicializaDePartidaAnterior(tabuleiroAtaque, tabuleiroDefesa, couracadosRestantes,
				cruzadoresRestantes, hidroavioesRestantes, submarinosRestantes, destroyersRestantes);
	}
}
