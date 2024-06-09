package control;

import model.AccessModel;
import model.ObservadorConfiguraTabuleiro;

class Jogo {
	AccessModel accessModel;

	Jogo() {
		this.accessModel = new AccessModel();
	}

	void criaJogadores(String nomeJogador1, String nomeJogador2) {
		accessModel.criaJogadores(nomeJogador1, nomeJogador2);
	}
	
	public void adicionaObservador(ObservadorConfiguraTabuleiro observador) {
		this.accessModel.adicionaObservador(observador);
		return;
	}
	
	public void removeObservador(ObservadorConfiguraTabuleiro observador) {
		this.accessModel.removeObservador(observador);
		return;
	}
	
	char[][] salvaTabuleiroAtaque(char[][] tabuleiro, String nomeJogador, char tipoDeArma, int linha, int coluna) {
		char[][] novoTabuleiro = null;
		switch(tipoDeArma) {
		case 'C':
			novoTabuleiro = this.accessModel.couracadoNoTabuleiro(tabuleiro, linha, coluna);
			break;
		case 'c':
			novoTabuleiro = this.accessModel.cruzadorNoTabuleiro(tabuleiro, linha, coluna);
			break;
		case 'd':
			novoTabuleiro = this.accessModel.destroyerNoTabuleiro(tabuleiro, linha, coluna);
			break;
		case 'h':
			novoTabuleiro = this.accessModel.hidroaviaoNoTabuleiro(tabuleiro,linha, coluna);
			break;
		case 's':
			novoTabuleiro = this.accessModel.submarinoNoTabuleiro(tabuleiro, linha, coluna);
			break;
		}
		accessModel.salvaTabuleiroAtaque(novoTabuleiro, nomeJogador);
		return novoTabuleiro;
	}
		
	void criaTabuleiroDeDefesa(String nomeJogador){
		char[][] tabuleiro = new char[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				tabuleiro[i][j] = '0';
			}
		}
		accessModel.criaTabuleiroDefesa(tabuleiro, nomeJogador);
		return;
	}
	
	char[][] pegaTabuleiroDeAtaque(String nomeJogador){
		return accessModel.pegaTabuleiroAtaque(nomeJogador);
	}
	
	char[][] pegaTabuleiroDefesa(String nomeJogador){
		return accessModel.pegaTabuleiroDefesa(nomeJogador);
	}
}
