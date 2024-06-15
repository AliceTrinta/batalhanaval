package model;

class Jogador {
	String nome;
	char[][] tabuleiroAtaque;
	char[][] tabuleiroDefesa;
	Tabuleiro tabuleiroPrincipal;

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
		this.tabuleiroPrincipal = new Tabuleiro(tabuleiroAtaque);
	}
	
	char[][] getTabuleiroDefesa() {
		return this.tabuleiroDefesa;
	}

	void setTabuleiroDefesa(char[][] tabuleiro) {
		this.tabuleiroDefesa = tabuleiro;
	}
}
