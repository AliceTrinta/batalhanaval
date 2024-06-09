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

//	public void deselecionarCouracado() {
//		for (ObservadorConfiguraTabuleiro observador : observadores) {
//			observador.deselecionarCouracado();
//		}
//	}
//	
//	public void deselecionarCruzador() {
//		for (ObservadorConfiguraTabuleiro observador : observadores) {
//			observador.deselecionarCruzador();
//		}
//	}
//	
//	public void deselecionarDestroyer() {
//		for (ObservadorConfiguraTabuleiro observador : observadores) {
//			observador.deselecionarDestroyer();
//		}
//	}
//	
//	public void deselecionarHidroaviao() {
//		for (ObservadorConfiguraTabuleiro observador : observadores) {
//			observador.deselecionarHidroaviao();
//		}
//	}
//	
//	public void deselecionarSubmarino() {
//		for (ObservadorConfiguraTabuleiro observador : observadores) {
//			observador.deselecionarSubmarino();
//		}
//	}
	
	public void couracadoNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.couracadoNoTabuleiro(linhaInicial, colunaInicial, posicaoCorreta);
		}
	}
	
	public void cruzadorNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.cruzadorNoTabuleiro(linhaInicial, colunaInicial, posicaoCorreta);
		}
	}
	
	public void destroyerNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.destroyerNoTabuleiro(linhaInicial, colunaInicial, posicaoCorreta);
		}
	}
	
	public void hidroaviaoNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.hidroaviaoNoTabuleiro(linhaInicial, colunaInicial, posicaoCorreta);
		}
	}
	
	public void submarinoNoTabuleiro(int linhaInicial, int colunaInicial, Boolean posicaoCorreta) {
		for (ObservadorConfiguraTabuleiro observador : observadores) {
			observador.submarinoNoTabuleiro(linhaInicial, colunaInicial, posicaoCorreta);
		}
	}
}
