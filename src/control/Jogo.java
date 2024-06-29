package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	public void salvarPartida(File file, String turno) {
		String nomeJogador1 = accessModel.pegaNomeJogador1();
		String nomeJogador2 = accessModel.pegaNomeJogador2();
		char[][] tabuleiroAtaque1 = accessModel.pegaTabuleiroAtaque(nomeJogador1);
		char[][] tabuleiroDefesa1 = accessModel.pegaTabuleiroDefesa(nomeJogador1);
		char[][] tabuleiroAtaque2 = accessModel.pegaTabuleiroAtaque(nomeJogador2);
		char[][] tabuleiroDefesa2 = accessModel.pegaTabuleiroDefesa(nomeJogador2);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(nomeJogador1);
			writer.newLine();
			escreverTabuleiro(writer, tabuleiroAtaque1);
			writer.newLine();
			escreverTabuleiro(writer, tabuleiroDefesa1);
			writer.newLine();
			writer.write(nomeJogador2);
			writer.newLine();
			escreverTabuleiro(writer, tabuleiroAtaque2);
			writer.newLine();
			escreverTabuleiro(writer, tabuleiroDefesa2);
			writer.newLine();
			writer.write(turno);
		} catch (IOException e) {

		}
		return;
	}

	void escreverTabuleiro(BufferedWriter writer, char[][] tabuleiro) throws IOException {
		for (char[] linha : tabuleiro) {
			for (char celula : linha) {
				writer.write(celula + " ");
			}
			writer.newLine();
		}
	}

	public List<String> carregaPartida(File file) {
		List<String> nomesJogadores = new ArrayList<>();
		String nomeJogador1 = null;
		String nomeJogador2 = null;
		char[][] tabuleiroAtaque1 = new char[15][15];
		char[][] tabuleiroDefesa1 = new char[15][15];
		char[][] tabuleiroAtaque2 = new char[15][15];
		char[][] tabuleiroDefesa2 = new char[15][15];
		String turno;

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			nomeJogador1 = reader.readLine();
			nomesJogadores.add(nomeJogador1);
			lerTabuleiro(reader, tabuleiroAtaque1);
			reader.readLine();
			lerTabuleiro(reader, tabuleiroDefesa1);
			reader.readLine();

			nomeJogador2 = reader.readLine();
			nomesJogadores.add(nomeJogador2);
			lerTabuleiro(reader, tabuleiroAtaque2);
			reader.readLine();
			lerTabuleiro(reader, tabuleiroDefesa2);
			reader.readLine();
			turno = reader.readLine();
			nomesJogadores.add(turno);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.accessModel.inicializaComDadosDeArquivo(nomeJogador1, nomeJogador2, tabuleiroAtaque1, tabuleiroDefesa1,
				tabuleiroAtaque2, tabuleiroDefesa2);
		return nomesJogadores;
	}

	void lerTabuleiro(BufferedReader reader, char[][] tabuleiro) throws IOException {
		for (int i = 0; i < 15; i++) {
			String linha = reader.readLine();
			String[] cells = linha.split(" ");
			for (int j = 0; j < cells.length; j++) {
				tabuleiro[i][j] = cells[j].charAt(0);
			}
		}
	}

	public void adicionaObservador(ObservadorConfiguraTabuleiro observador) {
		this.accessModel.adicionaObservador(observador);
		return;
	}

	public void removeObservador(ObservadorConfiguraTabuleiro observador) {
		this.accessModel.removeObservador(observador);
		return;
	}

	char[][] salvaTabuleiroAtaque(char[][] tabuleiro, String nomeJogador, char tipoDeArma, int linha, int coluna, int orientacao) {
		char[][] novoTabuleiro = null;
		switch (tipoDeArma) {
		case 'C':
			novoTabuleiro = this.accessModel.couracadoNoTabuleiro(tabuleiro, linha, coluna, orientacao, nomeJogador);
			break;
		case 'c':
			novoTabuleiro = this.accessModel.cruzadorNoTabuleiro(tabuleiro, linha, coluna, orientacao, nomeJogador);
			break;
		case 'd':
			novoTabuleiro = this.accessModel.destroyerNoTabuleiro(tabuleiro, linha, coluna, orientacao, nomeJogador);
			break;
		case 'h':
			novoTabuleiro = this.accessModel.hidroaviaoNoTabuleiro(tabuleiro, linha, coluna, orientacao, nomeJogador);
			break;
		case 's':
			novoTabuleiro = this.accessModel.submarinoNoTabuleiro(tabuleiro, linha, coluna, nomeJogador);
			break;
		}
		accessModel.salvaTabuleiroAtaque(novoTabuleiro, nomeJogador);
		return novoTabuleiro;
	}
	
	char[][] removeArmaDoTabuleiroDeAtaque(char[][] tabuleiro, String nomeJogador, char tipoDeArma, int linha, int coluna, int orientacao) {
		char[][] novoTabuleiro = null;
		switch (tipoDeArma) {
		case 'C':
			novoTabuleiro = this.accessModel.removeCouracadoDoTabuleiro(tabuleiro, linha, coluna, orientacao, nomeJogador);
			break;
		case 'c':
			novoTabuleiro = this.accessModel.removeCruzadorDoTabuleiro(tabuleiro, linha, coluna, orientacao, nomeJogador);
			break;
		case 'd':
			novoTabuleiro = this.accessModel.removeDestroyerDoTabuleiro(tabuleiro, linha, coluna, orientacao, nomeJogador);
			break;
		case 'h':
			novoTabuleiro = this.accessModel.removeHidroaviaoDoTabuleiro(tabuleiro, linha, coluna, orientacao, nomeJogador);
			break;
		case 's':
			novoTabuleiro = this.accessModel.removeSubmarinoDoTabuleiro(tabuleiro, linha, coluna, nomeJogador);
			break;
		}
		accessModel.salvaTabuleiroAtaque(novoTabuleiro, nomeJogador);
		return novoTabuleiro;
	}
	
	char[][] salvaTabuleiroDefesa(char[][] tabuleiro, String nomeJogador) {
		return accessModel.salvaTabuleiroDefesa(tabuleiro, nomeJogador);
	}

	void criaTabuleiroDeDefesa(String nomeJogador) {
		char[][] tabuleiro = new char[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				tabuleiro[i][j] = '0';
			}
		}
		accessModel.criaTabuleiroDefesa(tabuleiro, nomeJogador);
		return;
	}

	char[][] pegaTabuleiroDeAtaque(String nomeJogador) {
		return accessModel.pegaTabuleiroAtaque(nomeJogador);
	}

	char[][] pegaTabuleiroDefesa(String nomeJogador) {
		return accessModel.pegaTabuleiroDefesa(nomeJogador);
	}
	
	ArrayList<Integer> pegaCoordenadaDeNavio(int linha, int coluna, String nomeJogador, char tipoDeArma) {
		switch (tipoDeArma) {
		case 'C':
			return this.accessModel.pegaLinhaInicialDoCouracado(nomeJogador);
		case 'c':
			return this.accessModel.pegaLinhaInicialDoCruzador(linha, coluna, nomeJogador);
		case 'd':
			return this.accessModel.pegaLinhaInicialDoDestroyer(linha, coluna, nomeJogador);
		case 'h':
			return this.accessModel.pegaLinhaInicialDoHidroaviao(linha, coluna, nomeJogador);
		case 's':
			return this.accessModel.pegaLinhaInicialDoSubmarino(linha, coluna, nomeJogador);
		}
		return null;
	}
	
	Integer pegaOrientacao(int linha, int coluna, String nomeJogador, char tipoDeArma, char[][] matriz) {
		switch (tipoDeArma) {
		case 'C':
			return this.accessModel.pegaOrientacaoDoCouracado(nomeJogador);
		case 'c':
			return this.accessModel.pegaOrientacaoDoCruzador(linha, coluna, nomeJogador);
		case 'd':
			return this.accessModel.pegaOrientacaoDoDestroyer(linha, coluna, nomeJogador);
		case 'h':
			return this.accessModel.pegaOrientacaoDoHidroaviao(linha, coluna, matriz);	
		}
		return null;
	}
}
