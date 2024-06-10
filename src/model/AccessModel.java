package model;

public class AccessModel {
	DadosDeJogo dados;
	Couracado couracacado;
	Cruzador cruzador;
	Destroyer destroyer;
	Submarino submarino;
	Hidroaviao hidroaviao;

	public AccessModel() {
		this.dados = DadosDeJogo.getInstance();
		this.couracacado = new Couracado();
		this.cruzador = new Cruzador();
		this.destroyer = new Destroyer();
		this.submarino = new Submarino();
		this.hidroaviao = new Hidroaviao();
	}

	public void criaJogadores(String nomeJogador1, String nomeJogador2) {
		this.dados.jogador1.setNome(nomeJogador1);
		this.dados.jogador2.setNome(nomeJogador2);
		return;
	}

	public void inicializaComDadosDeArquivo(String nomeJogador1, String nomeJogador2, char[][] tabuleiroAtaque1,
			char[][] tabuleiroDefesa1, char[][] tabuleiroAtaque2, char[][] tabuleiroDefesa2) {
		this.dados.jogador1.setNome(nomeJogador1);
		this.dados.jogador2.setNome(nomeJogador2);
		this.dados.jogador1.setTabuleiroAtaque(tabuleiroAtaque1);
		this.dados.jogador1.setTabuleiroDefesa(tabuleiroDefesa1);
		this.dados.jogador2.setTabuleiroAtaque(tabuleiroAtaque2);
		this.dados.jogador2.setTabuleiroDefesa(tabuleiroDefesa2);
		return;
	}

	public void adicionaObservador(ObservadorConfiguraTabuleiro observador) {
		this.dados.addObservador(observador);
		return;
	}

	public void removeObservador(ObservadorConfiguraTabuleiro observador) {
		this.dados.removeObservador(observador);
		return;
	}

	public void salvaTabuleiroAtaque(char[][] tabuleiro, String nomeJogador) {
		if (this.dados.jogador1.getNome().equals(nomeJogador)) {
			this.dados.jogador1.setTabuleiroAtaque(tabuleiro);
		} else if (this.dados.jogador2.getNome().equals(nomeJogador)) {
			this.dados.jogador2.setTabuleiroAtaque(tabuleiro);
		}
		return;
	}

	public void criaTabuleiroDefesa(char[][] tabuleiro, String nomeJogador) {
		if (this.dados.jogador1.getNome().equals(nomeJogador)) {
			this.dados.jogador1.setTabuleiroDefesa(tabuleiro);
		} else if (this.dados.jogador2.getNome().equals(nomeJogador)) {
			this.dados.jogador2.setTabuleiroDefesa(tabuleiro);
		}
		return;
	}

	public char[][] pegaTabuleiroAtaque(String nomeJogador) {
		if (this.dados.jogador1.getNome().equals(nomeJogador)) {
			return this.dados.jogador1.getTabuleiroAtaque();
		} else if (this.dados.jogador2.getNome().equals(nomeJogador)) {
			return this.dados.jogador2.getTabuleiroAtaque();
		}
		return null;
	}

	public char[][] pegaTabuleiroDefesa(String nomeJogador) {
		if (this.dados.jogador1.getNome().equals(nomeJogador)) {
			return this.dados.jogador1.getTabuleiroDefesa();
		} else if (this.dados.jogador2.getNome().equals(nomeJogador)) {
			return this.dados.jogador2.getTabuleiroDefesa();
		}
		return null;
	}

	public String pegaNomeJogador1() {
		return this.dados.jogador1.getNome();
	}

	public String pegaNomeJogador2() {
		return this.dados.jogador2.getNome();
	}

	public char[][] couracadoNoTabuleiro(char[][] matriz, int linha, int coluna) {
		Boolean posicaoCorreta = this.couracacado.posicaoValida(matriz, linha, coluna, 0);
		char[][] novaMatriz = matriz;
		for (int i = 0; i < 5; i++) {
			novaMatriz[linha][coluna + i] = 'C';
		}
		this.dados.couracadoNoTabuleiro(linha, coluna, posicaoCorreta);
		return novaMatriz;
	}

	public char[][] cruzadorNoTabuleiro(char[][] matriz, int linha, int coluna) {
		Boolean posicaoCorreta = this.cruzador.posicaoValida(matriz, linha, coluna, 0);
		this.dados.cruzadorNoTabuleiro(linha, coluna, posicaoCorreta);
		char[][] novaMatriz = matriz;
		for (int i = 0; i < 4; i++) {
			novaMatriz[linha][coluna + i] = 'c';
		}
		return novaMatriz;
	}

	public char[][] destroyerNoTabuleiro(char[][] matriz, int linha, int coluna) {
		Boolean posicaoCorreta = this.destroyer.posicaoValida(matriz, linha, coluna, 0);
		this.dados.destroyerNoTabuleiro(linha, coluna, posicaoCorreta);
		char[][] novaMatriz = matriz;
		for (int i = 0; i < 2; i++) {
			novaMatriz[linha][coluna + i] = 'd';
		}
		return novaMatriz;
	}

	public char[][] hidroaviaoNoTabuleiro(char[][] matriz, int linha, int coluna) {
		Boolean posicaoCorreta = this.hidroaviao.posicaoValida(matriz, linha, coluna, 0);
		this.dados.hidroaviaoNoTabuleiro(linha, coluna, posicaoCorreta);
		char[][] novaMatriz = matriz;
		novaMatriz[linha][coluna] = 'h';
		novaMatriz[linha + 1][coluna - 1] = 'h';
		novaMatriz[linha + 1][coluna + 1] = 'h';
		return novaMatriz;
	}

	public char[][] submarinoNoTabuleiro(char[][] matriz, int linha, int coluna) {
		Boolean posicaoCorreta = this.submarino.posicaoValida(matriz, linha, coluna, 0);
		this.dados.submarinoNoTabuleiro(linha, coluna, posicaoCorreta);
		char[][] novaMatriz = matriz;
		novaMatriz[linha][coluna] = 's';
		return novaMatriz;
	}
}
