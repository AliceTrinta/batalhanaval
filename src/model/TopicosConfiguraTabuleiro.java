package model;

import java.util.ArrayList;
import java.util.List;

public class TopicosConfiguraTabuleiro {
	List<ObservadorConfiguraTabuleiro> observadores = new ArrayList<>();
	
	public List<ObservadorConfiguraTabuleiro> getObservadores(){
		return this.observadores;
	}
	
	public void setObservadores(List<ObservadorConfiguraTabuleiro> observadores){
		this.observadores = observadores;
	}

	public void addObservador(ObservadorConfiguraTabuleiro observador) {
		observadores.add(observador);
	}

	public void removeObservador(ObservadorConfiguraTabuleiro observador) {
		observadores.remove(observador);
	}
	
	public void couracadoNoTabuleiro(int linhaInicial, int colunaInicial, int orientacao, Boolean posicaoCorreta) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.couracadoNoTabuleiro(linhaInicial, colunaInicial, orientacao, posicaoCorreta);
		}
	}
	
	public void cruzadorNoTabuleiro(int linhaInicial, int colunaInicial, int orientacao, Boolean posicaoCorreta) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.cruzadorNoTabuleiro(linhaInicial, colunaInicial, orientacao, posicaoCorreta);
		}
	}
	
	public void destroyerNoTabuleiro(int linhaInicial, int colunaInicial, int orientacao, Boolean posicaoCorreta) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.destroyerNoTabuleiro(linhaInicial, colunaInicial, orientacao, posicaoCorreta);
		}
	}
	
	public void hidroaviaoNoTabuleiro(int linhaInicial, int colunaInicial, int orientacao, Boolean posicaoCorreta) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.hidroaviaoNoTabuleiro(linhaInicial, colunaInicial, orientacao, posicaoCorreta);
		}
	}
	
	public void submarinoNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.submarinoNoTabuleiro(linhaInicial, colunaInicial, posicaoCorreta);
		}
	}
	
	public void pintarQuadrado(int linha, int coluna, String cor) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.pintarQuadrado(linha, coluna, cor);
		}
	}
	
	public void anunciaVencedor() {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.anunciaVencedor();
		}
	}
	
	public void removeCouracadoDoTabuleiro(int linhaInicial, int colunaInicial, int orientacao) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.removeCouracadoDoTabuleiro(linhaInicial, colunaInicial, orientacao);
		}
	}
	
	public void removeCruzadorDoTabuleiro(int linhaInicial, int colunaInicial, int orientacao) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.removeCruzadorDoTabuleiro(linhaInicial, colunaInicial, orientacao);
		}
	}
	
	public void removeDestroyerDoTabuleiro(int linhaInicial, int colunaInicial, int orientacao) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.removeDestroyerDoTabuleiro(linhaInicial, colunaInicial, orientacao);
		}
	}
	
	public void removeHidroaviaoDoTabuleiro(int linhaInicial, int colunaInicial, int orientacao) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.removeHidroaviaoDoTabuleiro(linhaInicial, colunaInicial, orientacao);
		}
	}
	
	public void removeSubmarinoDoTabuleiro(int linhaInicial, int colunaInicial) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.removeSubmarinoDoTabuleiro(linhaInicial, colunaInicial);
		}
	}
}
