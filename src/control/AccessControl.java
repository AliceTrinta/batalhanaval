package control;

import java.io.File;
import java.util.List;

import model.ObservadorConfiguraTabuleiro;

public class AccessControl {

	Jogo jogo;

	public AccessControl() {
		this.jogo = new Jogo();
	}

	public void criaJogadores(String nomeJogador1, String nomeJogador2) {
		jogo.criaJogadores(nomeJogador1, nomeJogador2);
		return;
	}
	
	public void salvarPartida(File file, String turno) {
		jogo.salvarPartida(file, turno);
		return;
	}
	
	public List<String> carregaPartida(File file){
		return jogo.carregaPartida(file);
	}
	
	public void adicionaObserver(ObservadorConfiguraTabuleiro observador) {
		jogo.adicionaObservador(observador);
		return;
	}
	
	public void removeObserver(ObservadorConfiguraTabuleiro observador) {
		jogo.removeObservador(observador);
		return;
	}

	public char[][] salvarMudancasNoTabuleiro(char[][] tabuleiro, String nomeJogador, char tipoArma, int linha, int coluna) {
		return jogo.salvaTabuleiroAtaque(tabuleiro, nomeJogador, tipoArma, linha, coluna);
	}
	
	public void criaTabuleiroDeDefesa(String nomeJogador) {
		jogo.criaTabuleiroDeDefesa(nomeJogador);
		return;
	}
	
	public char[][] tabuleiroAtaque(String nomeJogador) {
		return jogo.pegaTabuleiroDeAtaque(nomeJogador);
	}
	
	public char[][] tabuleiroDefesa(String nomeJogador) {
		return jogo.pegaTabuleiroDefesa(nomeJogador);
	}
}