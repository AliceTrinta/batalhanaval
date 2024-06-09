package model;

public interface ObservadorConfiguraTabuleiro {
//	void deselecionarCouracado();
//	void deselecionarCruzador();
//	void deselecionarDestroyer();
//	void deselecionarHidroaviao();
//	void deselecionarSubmarino();
	void couracadoNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta);
	void cruzadorNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta);
	void destroyerNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta);
	void hidroaviaoNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta);
	void submarinoNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta);
}
