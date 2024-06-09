package model;

public class AccessModel {
	DadosDeJogo dados;

	public AccessModel() {
		this.dados = DadosDeJogo.getInstance();
	}

	public void criaJogadores(String nomeJogador1, String nomeJogador2) {
		dados.jogador1.setNome(nomeJogador1);
		dados.jogador2.setNome(nomeJogador2);
		return;
	}

	public void salvaTabuleiroAtaque(char[][] tabuleiro, String nomeJogador) {
		if (dados.jogador1.getNome() == nomeJogador) {
			dados.jogador1.setTabuleiroAtaque(tabuleiro);
		} else if (dados.jogador2.getNome() == nomeJogador) {
			dados.jogador2.setTabuleiroAtaque(tabuleiro);
		}
		return;
	}
	
	public char[][] pegaTabuleiroAtaque(String nomeJogador) {
		if (dados.jogador1.getNome() == nomeJogador) {
			return dados.jogador1.getTabuleiroAtaque();
		} else if (dados.jogador2.getNome() == nomeJogador) {
			return dados.jogador1.getTabuleiroAtaque();
		}
		return null;
	}
}
