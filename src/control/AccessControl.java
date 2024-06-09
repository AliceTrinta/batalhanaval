package control;

public class AccessControl {

	Jogo jogo;

	public AccessControl() {
		this.jogo = new Jogo();
	}

	public void criaJogadores(String nomeJogador1, String nomeJogador2) {
		jogo.criaJogadores(nomeJogador1, nomeJogador2);
		return;
	}

	public void salvarMudancasNoTabuleiro(char[][] tabuleiro, String nomeJogador) {
		jogo.salvaTabuleiroAtaque(tabuleiro, nomeJogador);
		return;
	}
	
	public char[][] tabuleiroAtaque(String nomeJogador) {
		return jogo.pegaTabuleiroDeAtaque(nomeJogador);
	}
}
