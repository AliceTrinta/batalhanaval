package control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.ObservadorConfiguraTabuleiro;

public class AccessControl {

	Jogo jogo;
	Ataque ataque;

	public AccessControl() {
		this.jogo = new Jogo();
		this.ataque = new Ataque();
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

	public char[][] salvarMudancasNoTabuleiro(char[][] tabuleiro, String nomeJogador, char tipoArma, int linha, int coluna, int orientacao) {
		return jogo.salvaTabuleiroAtaque(tabuleiro, nomeJogador, tipoArma, linha, coluna, orientacao);
	}
	
	public char[][] removeArmaDoTabuleiro(char[][] tabuleiro, String nomeJogador, char tipoArma, int linha, int coluna, int orientacao) {
		return jogo.removeArmaDoTabuleiroDeAtaque(tabuleiro, nomeJogador, tipoArma, linha, coluna, orientacao);
	}
	
	public char[][] salvaTabuleiroDefesa(char[][] tabuleiro, String nomeJogador){
		return jogo.salvaTabuleiroDefesa(tabuleiro, nomeJogador);
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
	
	public void realizaAtaque(int linha, int coluna, String nomeAtacante) {
		ataque.realizaAtaque(linha, coluna, nomeAtacante);
	}
	
	public ArrayList<Integer> pegarCoordenadaDeNavio(int linha, int coluna, String nomeJogador, char tipoDeArma){
		return jogo.pegaCoordenadaDeNavio(linha, coluna, nomeJogador, tipoDeArma);
	}
	
	public Integer pegaOrientacao(int linha, int coluna, String nomeJogador, char tipoDeArma, char[][] matriz){
		return jogo.pegaOrientacao(linha, coluna, nomeJogador, tipoDeArma, matriz);
	}
	
	public void inicializaTabuleiroPrincipal(String nomeJogador, char[][] tabuleiroAtaque, char[][] tabuleiroDefesa,
			int couracadosRestantes, int cruzadoresRestantes, int hidroavioesRestantes, int submarinosRestantes,
			int destroyersRestantes) {
		jogo.inicializaTabuleiroPrincipal(
				nomeJogador, tabuleiroAtaque, tabuleiroDefesa, couracadosRestantes, cruzadoresRestantes, hidroavioesRestantes, submarinosRestantes, destroyersRestantes);
	}
}