package control;

import model.AccessModel;

class Jogo {
	AccessModel accessModel;

	Jogo() {
		this.accessModel = new AccessModel();
	}

	void criaJogadores(String nomeJogador1, String nomeJogador2) {
		accessModel.criaJogadores(nomeJogador1, nomeJogador2);
	}
	
	void salvaTabuleiroAtaque(char[][] tabuleiro, String nomeJogador) {
		accessModel.salvaTabuleiroAtaque(tabuleiro, nomeJogador);
	}
	
	char[][] pegaTabuleiroDeAtaque(String nomeJogador){
		return accessModel.pegaTabuleiroAtaque(nomeJogador);
	}
}
