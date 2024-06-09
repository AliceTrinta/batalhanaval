package model;

class DadosDeJogo extends TopicosConfiguraTabuleiro{
	private static DadosDeJogo instance;
	Jogador jogador1;
	Jogador jogador2;
	
	DadosDeJogo() {
		jogador1 = new Jogador();
		jogador2 = new Jogador();
	}

	static DadosDeJogo getInstance() {
		if (instance == null) {
			instance = new DadosDeJogo();
		}
		return instance;
	}

	Jogador getJogador1() {
		return this.jogador1;
	}

	void setJogador1(Jogador jogador) {
		this.jogador1 = jogador;
	}

	Jogador getJogador2() {
		return this.jogador2;
	}

	void setJogador2(Jogador jogador) {
		this.jogador2 = jogador;
	}
	
	char[][] getTabuleiroAtaque1() {
		return this.jogador1.tabuleiroAtaque;
	}

	void setTabuleiroAtaque1(char[][] tabuleiro) {
		this.jogador1.tabuleiroAtaque = tabuleiro;
	}
	
	char[][] getTabuleiroDefesa1() {
		return this.jogador1.tabuleiroDefesa;
	}

	void setTabuleiroDefesa1(char[][] tabuleiro) {
		this.jogador1.tabuleiroDefesa = tabuleiro;
	}
	
	char[][] getTabuleiroAtaque2() {
		return this.jogador2.tabuleiroAtaque;
	}

	void setTabuleiroAtaque2(char[][] tabuleiro) {
		this.jogador2.tabuleiroAtaque = tabuleiro;
	}
	
	char[][] getTabuleiroDefesa2() {
		return this.jogador2.tabuleiroDefesa;
	}

	void setTabuleiroDefesa2(char[][] tabuleiro) {
		this.jogador2.tabuleiroDefesa = tabuleiro;
	}
}
