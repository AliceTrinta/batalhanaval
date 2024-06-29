package model;

public interface ObservadorConfiguraTabuleiro {
	void anunciaVencedor();
	void pintarQuadrado(int linha, int coluna, String cor);
	void couracadoNoTabuleiro(int linhaInicial, int colunaInicial, int orientacao, Boolean posicaoCorreta);
	void cruzadorNoTabuleiro(int linhaInicial, int colunaInicial, int orientacao, Boolean posicaoCorreta);
	void destroyerNoTabuleiro(int linhaInicial, int colunaInicial, int orientacao, Boolean posicaoCorreta);
	void hidroaviaoNoTabuleiro(int linhaInicial, int colunaInicial, int orientacao, Boolean posicaoCorreta);
	void submarinoNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta);
	void removeCouracadoDoTabuleiro(int linhaInicial, int colunaInicial, int orientacao);
	void removeCruzadorDoTabuleiro(int linhaInicial, int colunaInicial, int orientacao);
	void removeDestroyerDoTabuleiro(int linhaInicial, int colunaInicial, int orientacao);
	void removeHidroaviaoDoTabuleiro(int linhaInicial, int colunaInicial, int orientacao);
	void removeSubmarinoDoTabuleiro(int linhaInicial, int colunaInicial);
}
