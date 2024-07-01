package model;

import java.util.ArrayList;
import java.util.Iterator;

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

	public void inicializaTabuleiroPrincipal(String nomeJogador, char[][] tabuleiroAtaque, char[][] tabuleiroDefesa,
			int couracadosRestantes, int cruzadoresRestantes, int hidroavioesRestantes, int submarinosRestantes,
			int destroyersRestantes) {
		if (this.dados.jogador1.getNome().equals(nomeJogador)) {
			this.dados.jogador1.setTabuleiroPrincipal(tabuleiroAtaque, tabuleiroDefesa, couracadosRestantes,
					cruzadoresRestantes, hidroavioesRestantes, submarinosRestantes, destroyersRestantes);
		} else if (this.dados.jogador2.getNome().equals(nomeJogador)) {
			this.dados.jogador2.setTabuleiroPrincipal(tabuleiroAtaque, tabuleiroDefesa, couracadosRestantes,
					cruzadoresRestantes, hidroavioesRestantes, submarinosRestantes, destroyersRestantes);
		}
		return;
	}

	public void inicializaComDadosDeArquivo(String nomeJogador1, String nomeJogador2, char[][] tabuleiroAtaque1,
			char[][] tabuleiroDefesa1, String couracadosRestantes1, String cruzadoresRestantes1,
			String hidroavioesRestantes1, String submarinosRestantes1, String destroyersRestantes1,
			char[][] tabuleiroAtaque2, char[][] tabuleiroDefesa2, String couracadosRestantes2,
			String cruzadoresRestantes2, String hidroavioesRestantes2, String submarinosRestantes2,
			String destroyersRestantes2) {

		int couracados1 = Integer.parseInt(couracadosRestantes1);
		int cruzadores1 = Integer.parseInt(cruzadoresRestantes1);
		;
		int hidroavioes1 = Integer.parseInt(hidroavioesRestantes1);
		;
		int submarinos1 = Integer.parseInt(submarinosRestantes1);
		;
		int destroyers1 = Integer.parseInt(destroyersRestantes1);
		;
		int couracados2 = Integer.parseInt(couracadosRestantes2);
		;
		int cruzadores2 = Integer.parseInt(cruzadoresRestantes2);
		;
		int hidroavioes2 = Integer.parseInt(hidroavioesRestantes2);
		;
		int submarinos2 = Integer.parseInt(submarinosRestantes2);
		;
		int destroyers2 = Integer.parseInt(destroyersRestantes2);
		;

		this.dados.jogador1.setNome(nomeJogador1);
		this.dados.jogador2.setNome(nomeJogador2);
		this.dados.jogador1.setTabuleiroAtaque(tabuleiroAtaque1);
		this.dados.jogador1.setTabuleiroDefesa(tabuleiroDefesa1);
		this.dados.jogador1.setTabuleiroPrincipal(tabuleiroAtaque2, tabuleiroDefesa1, couracados1, cruzadores1,
				hidroavioes1, submarinos1, destroyers1);
		this.dados.jogador2.setTabuleiroAtaque(tabuleiroAtaque2);
		this.dados.jogador2.setTabuleiroDefesa(tabuleiroDefesa2);
		this.dados.jogador2.setTabuleiroPrincipal(tabuleiroAtaque1, tabuleiroDefesa2, couracados2, cruzadores2,
				hidroavioes2, submarinos2, destroyers2);
		return;
	}

	public Integer pegaNaviosRestantes(String nomeJogador, char navio) {
		Tabuleiro tabuleiro = new Tabuleiro();
		if (this.dados.jogador1.getNome().equals(nomeJogador)) {
			tabuleiro = this.dados.jogador1.tabuleiroPrincipal;
		} else if (this.dados.jogador2.getNome().equals(nomeJogador)) {
			tabuleiro = this.dados.jogador2.tabuleiroPrincipal;
		}
		switch (navio) {
		case 'C':
			return tabuleiro.couracadoQtd;
		case 'c':
			return tabuleiro.cruzadorQtd;
		case 'd':
			return tabuleiro.destroyerQtd;
		case 's':
			return tabuleiro.submarinoQtd;
		case 'h':
			return tabuleiro.hidroaviaoQtd;
		}
		return null;
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

	public char[][] salvaTabuleiroDefesa(char[][] tabuleiro, String nomeJogador) {
		if (this.dados.jogador1.getNome().equals(nomeJogador)) {
			this.dados.jogador1.setTabuleiroDefesa(tabuleiro);
			return this.dados.jogador1.getTabuleiroDefesa();
		} else if (this.dados.jogador2.getNome().equals(nomeJogador)) {
			this.dados.jogador2.setTabuleiroDefesa(tabuleiro);
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

	public char[][] couracadoNoTabuleiro(char[][] matriz, int linha, int coluna, int orientacao, String nomeJogador) {
		Boolean posicaoCorreta = this.couracacado.posicaoValida(matriz, linha, coluna, orientacao);
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		Couracado c = new Couracado(linha, coluna);
		for (int i = 0; i < 5; i++) {
			if (orientacao == 90) {
				novaMatriz[linha + i][coluna] = 'C';
				c.coordenadas.add(new QuadradoDeTabuleiro(linha + i, coluna));
			} else {
				novaMatriz[linha][coluna + i] = 'C';
				c.coordenadas.add(new QuadradoDeTabuleiro(linha, coluna + i));
			}
		}
		tabuleiro.couracado = c;
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.couracadoNoTabuleiro(linha, coluna, orientacao, posicaoCorreta);
		return novaMatriz;
	}

	public char[][] removeCouracadoDoTabuleiro(char[][] matriz, int linha, int coluna, int orientacao,
			String nomeJogador) {
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		for (int i = 0; i < 5; i++) {
			if (orientacao == 90) {
				novaMatriz[linha + i][coluna] = '0';
			} else {
				novaMatriz[linha][coluna + i] = '0';
			}
		}
		tabuleiro.couracado = null;
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.removeCouracadoDoTabuleiro(linha, coluna, orientacao);
		return novaMatriz;
	}

	public char[][] cruzadorNoTabuleiro(char[][] matriz, int linha, int coluna, int orientacao, String nomeJogador) {
		Boolean posicaoCorreta = this.cruzador.posicaoValida(matriz, linha, coluna, orientacao);
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		Cruzador c = new Cruzador(linha, coluna);
		for (int i = 0; i < 4; i++) {
			if (orientacao == 90) {
				novaMatriz[linha + i][coluna] = 'c';
				c.coordenadas.add(new QuadradoDeTabuleiro(linha + i, coluna));
			} else {
				novaMatriz[linha][coluna + i] = 'c';
				c.coordenadas.add(new QuadradoDeTabuleiro(linha, coluna + i));
			}
		}
		tabuleiro.cruzadores.add(c);
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.cruzadorNoTabuleiro(linha, coluna, orientacao, posicaoCorreta);
		return novaMatriz;
	}

	public char[][] removeCruzadorDoTabuleiro(char[][] matriz, int linha, int coluna, int orientacao,
			String nomeJogador) {
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		Iterator<Cruzador> iterator = tabuleiro.cruzadores.iterator();
		while (iterator.hasNext()) {
			Cruzador cruzador = iterator.next();
			if (cruzador.linhaInicial == linha && cruzador.colunaInicial == coluna) {
				iterator.remove();
			}
		}
		for (int i = 0; i < 4; i++) {
			if (orientacao == 90) {
				novaMatriz[linha + i][coluna] = '0';
			} else {
				novaMatriz[linha][coluna + i] = '0';
			}
		}
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.removeCruzadorDoTabuleiro(linha, coluna, orientacao);
		return novaMatriz;
	}

	public char[][] destroyerNoTabuleiro(char[][] matriz, int linha, int coluna, int orientacao, String nomeJogador) {
		Boolean posicaoCorreta = this.destroyer.posicaoValida(matriz, linha, coluna, orientacao);
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		Destroyer d = new Destroyer(linha, coluna);
		for (int i = 0; i < 2; i++) {
			if (orientacao == 90) {
				novaMatriz[linha + i][coluna] = 'd';
				d.coordenadas.add(new QuadradoDeTabuleiro(linha + i, coluna));
			} else {
				novaMatriz[linha][coluna + i] = 'd';
				d.coordenadas.add(new QuadradoDeTabuleiro(linha, coluna + i));
			}
		}
		tabuleiro.destroyers.add(d);
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.destroyerNoTabuleiro(linha, coluna, orientacao, posicaoCorreta);
		return novaMatriz;
	}

	public char[][] removeDestroyerDoTabuleiro(char[][] matriz, int linha, int coluna, int orientacao,
			String nomeJogador) {
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		Iterator<Destroyer> iterator = tabuleiro.destroyers.iterator();
		while (iterator.hasNext()) {
			Destroyer destroyer = iterator.next();
			if (destroyer.linhaInicial == linha && destroyer.colunaInicial == coluna) {
				iterator.remove();
			}
		}
		for (int i = 0; i < 2; i++) {
			if (orientacao == 90) {
				novaMatriz[linha + i][coluna] = '0';
			} else {
				novaMatriz[linha][coluna + i] = '0';
			}
		}
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.removeDestroyerDoTabuleiro(linha, coluna, orientacao);
		return novaMatriz;
	}

	public char[][] hidroaviaoNoTabuleiro(char[][] matriz, int linha, int coluna, int orientacao, String nomeJogador) {
		Boolean posicaoCorreta = this.hidroaviao.posicaoValida(matriz, linha, coluna, orientacao);
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);

		Hidroaviao h = new Hidroaviao(linha, coluna);
		if (orientacao == 90) {
			novaMatriz[linha][coluna] = 'h';
			novaMatriz[linha - 1][coluna - 1] = 'h';
			novaMatriz[linha + 1][coluna - 1] = 'h';
			h.coordenadas.add(new QuadradoDeTabuleiro(linha, coluna));
			h.coordenadas.add(new QuadradoDeTabuleiro(linha - 1, coluna - 1));
			h.coordenadas.add(new QuadradoDeTabuleiro(linha + 1, coluna - 1));

		} else if (orientacao == 180) {
			novaMatriz[linha][coluna] = 'h';
			novaMatriz[linha - 1][coluna - 1] = 'h';
			novaMatriz[linha - 1][coluna + 1] = 'h';
			h.coordenadas.add(new QuadradoDeTabuleiro(linha, coluna));
			h.coordenadas.add(new QuadradoDeTabuleiro(linha - 1, coluna - 1));
			h.coordenadas.add(new QuadradoDeTabuleiro(linha - 1, coluna + 1));
		} else if (orientacao == 270) {
			novaMatriz[linha][coluna] = 'h';
			novaMatriz[linha - 1][coluna + 1] = 'h';
			novaMatriz[linha + 1][coluna + 1] = 'h';
			h.coordenadas.add(new QuadradoDeTabuleiro(linha, coluna));
			h.coordenadas.add(new QuadradoDeTabuleiro(linha - 1, coluna + 1));
			h.coordenadas.add(new QuadradoDeTabuleiro(linha + 1, coluna + 1));
		} else {
			novaMatriz[linha][coluna] = 'h';
			novaMatriz[linha + 1][coluna - 1] = 'h';
			novaMatriz[linha + 1][coluna + 1] = 'h';
			h.coordenadas.add(new QuadradoDeTabuleiro(linha, coluna));
			h.coordenadas.add(new QuadradoDeTabuleiro(linha + 1, coluna - 1));
			h.coordenadas.add(new QuadradoDeTabuleiro(linha + 1, coluna + 1));
		}

		tabuleiro.hidroavioes.add(h);
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.hidroaviaoNoTabuleiro(linha, coluna, orientacao, posicaoCorreta);
		return novaMatriz;
	}

	public char[][] removeHidroaviaoDoTabuleiro(char[][] matriz, int linha, int coluna, int orientacao,
			String nomeJogador) {
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		Iterator<Hidroaviao> iterator = tabuleiro.hidroavioes.iterator();
		while (iterator.hasNext()) {
			Hidroaviao h = iterator.next();
			if (h.linhaInicial == linha && h.colunaInicial == coluna) {
				iterator.remove();
			}
		}
		if (orientacao == 90) {
			novaMatriz[linha][coluna] = '0';
			novaMatriz[linha - 1][coluna - 1] = '0';
			novaMatriz[linha + 1][coluna - 1] = '0';

		} else if (orientacao == 180) {
			novaMatriz[linha][coluna] = '0';
			novaMatriz[linha - 1][coluna - 1] = '0';
			novaMatriz[linha - 1][coluna + 1] = '0';
		} else if (orientacao == 270) {
			novaMatriz[linha][coluna] = '0';
			novaMatriz[linha - 1][coluna + 1] = '0';
			novaMatriz[linha + 1][coluna + 1] = '0';
		} else {
			novaMatriz[linha][coluna] = '0';
			novaMatriz[linha + 1][coluna - 1] = '0';
			novaMatriz[linha + 1][coluna + 1] = '0';
		}
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.removeHidroaviaoDoTabuleiro(linha, coluna, orientacao);
		return novaMatriz;
	}

	public char[][] submarinoNoTabuleiro(char[][] matriz, int linha, int coluna, String nomeJogador) {
		Boolean posicaoCorreta = this.submarino.posicaoValida(matriz, linha, coluna, 0);
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);

		novaMatriz[linha][coluna] = 's';
		Submarino s = new Submarino(linha, coluna);
		s.coordenadas.x = linha;
		s.coordenadas.y = coluna;
		tabuleiro.submarinos.add(s);
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.submarinoNoTabuleiro(linha, coluna, posicaoCorreta);
		return novaMatriz;
	}

	public char[][] removeSubmarinoDoTabuleiro(char[][] matriz, int linha, int coluna, String nomeJogador) {
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);

		novaMatriz[linha][coluna] = '0';
		Iterator<Submarino> iterator = tabuleiro.submarinos.iterator();
		while (iterator.hasNext()) {
			Submarino s = iterator.next();
			if (s.linhaInicial == linha && s.colunaInicial == coluna) {
				iterator.remove();
			}
		}
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.removeSubmarinoDoTabuleiro(linha, coluna);
		return novaMatriz;
	}

	public boolean verificaSeAfundou(int linha, int coluna, char tipoDeArma, String nomeAtacante) {
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeAtacante);
		boolean result = false;
		switch (tipoDeArma) {
		case 'C':
			for (QuadradoDeTabuleiro q : tabuleiro.couracado.coordenadas) {
				if (q.x == linha && q.y == coluna) {
					q.cor = "ROSA";
					int index = tabuleiro.couracado.coordenadas.indexOf(q);
					tabuleiro.couracado.coordenadas.set(index, q);
				}
			}
			result = tabuleiro.couracado.coordenadas.stream().anyMatch(p -> p.cor.equals("BRANCO"));
			if (result == false) {
				for (QuadradoDeTabuleiro q : tabuleiro.couracado.coordenadas) {
					pintarQuadrado(q.x, q.y, "VERMELHO");
					q.cor = "VERMELHO";
					int index = tabuleiro.couracado.coordenadas.indexOf(q);
					tabuleiro.couracado.coordenadas.set(index, q);
				}
				tabuleiro.couracadoQtd--;
			}
			break;
		case 'c':
			for (Cruzador c : tabuleiro.cruzadores) {
				if (c.coordenadas.stream().anyMatch(p -> p.x == linha && p.y == coluna)) {
					int indexMacro = tabuleiro.cruzadores.indexOf(c);
					for (QuadradoDeTabuleiro q : c.coordenadas) {
						if (q.x == linha && q.y == coluna) {
							q.cor = "ROSA";
							int index = c.coordenadas.indexOf(q);
							tabuleiro.cruzadores.get(indexMacro).coordenadas.set(index, q);
						}
					}
					result = c.coordenadas.stream().anyMatch(p -> p.cor.equals("BRANCO"));
					if (result == false) {
						for (QuadradoDeTabuleiro q : c.coordenadas) {
							pintarQuadrado(q.x, q.y, "VERMELHO");
							q.cor = "VERMELHO";
							int index = c.coordenadas.indexOf(q);
							tabuleiro.cruzadores.get(indexMacro).coordenadas.set(index, q);
						}
						tabuleiro.cruzadorQtd--;
					}
				}
			}
			break;
		case 'd':
			for (Destroyer d : tabuleiro.destroyers) {
				if (d.coordenadas.stream().anyMatch(p -> p.x == linha && p.y == coluna)) {
					int indexMacro = tabuleiro.destroyers.indexOf(d);
					for (QuadradoDeTabuleiro q : d.coordenadas) {
						if (q.x == linha && q.y == coluna) {
							q.cor = "ROSA";
							int index = d.coordenadas.indexOf(q);
							tabuleiro.destroyers.get(indexMacro).coordenadas.set(index, q);
						}
					}
					result = d.coordenadas.stream().anyMatch(p -> p.cor.equals("BRANCO"));
					if (result == false) {
						for (QuadradoDeTabuleiro q : d.coordenadas) {
							pintarQuadrado(q.x, q.y, "VERMELHO");
							q.cor = "VERMELHO";
							int index = d.coordenadas.indexOf(q);
							tabuleiro.destroyers.get(indexMacro).coordenadas.set(index, q);
						}
						tabuleiro.destroyerQtd--;
					}
				}
			}
			break;
		case 'h':
			for (Hidroaviao h : tabuleiro.hidroavioes) {
				if (h.coordenadas.stream().anyMatch(p -> p.x == linha && p.y == coluna)) {
					int indexMacro = tabuleiro.hidroavioes.indexOf(h);
					for (QuadradoDeTabuleiro q : h.coordenadas) {
						if (q.x == linha && q.y == coluna) {
							q.cor = "ROSA";
							int index = h.coordenadas.indexOf(q);
							tabuleiro.hidroavioes.get(indexMacro).coordenadas.set(index, q);
						}
					}
					result = h.coordenadas.stream().anyMatch(p -> p.cor.equals("BRANCO"));
					if (result == false) {
						for (QuadradoDeTabuleiro q : h.coordenadas) {
							pintarQuadrado(q.x, q.y, "VERMELHO");
							q.cor = "VERMELHO";
							int index = h.coordenadas.indexOf(q);
							tabuleiro.hidroavioes.get(indexMacro).coordenadas.set(index, q);
						}
						tabuleiro.hidroaviaoQtd--;
					}
				}
			}
			break;
		case 's':
			for (Submarino s : tabuleiro.submarinos) {
				if (s.coordenadas.x == linha && s.coordenadas.y == coluna) {
					s.coordenadas.cor = "ROSA";
					result = s.coordenadas.cor.equals("BRANCO");
					if (result == false) {
						pintarQuadrado(s.coordenadas.x, s.coordenadas.y, "VERMELHO");
						s.coordenadas.cor = "VERMELHO";
						int index = tabuleiro.submarinos.indexOf(s);
						tabuleiro.submarinos.set(index, s);
						tabuleiro.submarinoQtd--;
					}
				}
			}
			break;
		default:
			break;
		}
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeAtacante);
		return !result;
	}

	public boolean verificaSeTodosAfundaram(String nomeAtacante) {
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeAtacante);
		if (tabuleiro.couracadoQtd == 0 && tabuleiro.cruzadorQtd == 0 && tabuleiro.destroyerQtd == 0
				&& tabuleiro.hidroaviaoQtd == 0 && tabuleiro.submarinoQtd == 0) {
			return true;
		}
		return false;
	}

	public void anunciaVencedor() {
		this.dados.anunciaVencedor();
	}

	public void pintarQuadrado(int linha, int coluna, String cor) {
		this.dados.pintarQuadrado(linha, coluna, cor);
	}

	public ArrayList<Integer> pegaLinhaInicialDoCouracado(String nomeJogador) {
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(tabuleiro.couracado.linhaInicial);
		result.add(tabuleiro.couracado.colunaInicial);
		return result;
	}

	public ArrayList<Integer> pegaLinhaInicialDoCruzador(int linha, int coluna, String nomeJogador) {
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (Cruzador c : tabuleiro.cruzadores) {
			int indexMacro = tabuleiro.cruzadores.indexOf(c);
			for (QuadradoDeTabuleiro q : c.coordenadas) {
				if (q.x == linha && q.y == coluna) {
					result.add(tabuleiro.cruzadores.get(indexMacro).linhaInicial);
					result.add(tabuleiro.cruzadores.get(indexMacro).colunaInicial);
					return result;
				}
			}
		}
		return result;
	}

	public ArrayList<Integer> pegaLinhaInicialDoDestroyer(int linha, int coluna, String nomeJogador) {
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (Destroyer d : tabuleiro.destroyers) {
			int indexMacro = tabuleiro.destroyers.indexOf(d);
			for (QuadradoDeTabuleiro q : d.coordenadas) {
				if (q.x == linha && q.y == coluna) {
					result.add(tabuleiro.destroyers.get(indexMacro).linhaInicial);
					result.add(tabuleiro.destroyers.get(indexMacro).colunaInicial);
					return result;
				}
			}
		}
		return result;
	}

	public ArrayList<Integer> pegaLinhaInicialDoHidroaviao(int linha, int coluna, String nomeJogador) {
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (Hidroaviao h : tabuleiro.hidroavioes) {
			int indexMacro = tabuleiro.hidroavioes.indexOf(h);
			for (QuadradoDeTabuleiro q : h.coordenadas) {
				if (q.x == linha && q.y == coluna) {
					result.add(tabuleiro.hidroavioes.get(indexMacro).linhaInicial);
					result.add(tabuleiro.hidroavioes.get(indexMacro).colunaInicial);
					return result;
				}
			}
		}
		return result;
	}

	public ArrayList<Integer> pegaLinhaInicialDoSubmarino(int linha, int coluna, String nomeJogador) {
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (Submarino s : tabuleiro.submarinos) {
			int indexMacro = tabuleiro.submarinos.indexOf(s);
			if (s.coordenadas.x == linha && s.coordenadas.y == coluna) {
				result.add(tabuleiro.submarinos.get(indexMacro).linhaInicial);
				result.add(tabuleiro.submarinos.get(indexMacro).colunaInicial);
				return result;
			}
		}
		return result;
	}

	public Integer pegaOrientacaoDoCouracado(String nomeJogador) {
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		if (tabuleiro.couracado.coordenadas.get(1).y == tabuleiro.couracado.colunaInicial) {
			return 90;
		}
		return 0;
	}

	public Integer pegaOrientacaoDoCruzador(int linha, int coluna, String nomeJogador) {
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);

		for (Cruzador c : tabuleiro.cruzadores) {
			for (QuadradoDeTabuleiro q : c.coordenadas) {
				if (q.x == linha && q.y == coluna) {
					if (c.colunaInicial == c.coordenadas.get(1).y) {
						return 90;
					}
					return 0;
				}
			}
		}
		return null;
	}

	public Integer pegaOrientacaoDoDestroyer(int linha, int coluna, String nomeJogador) {
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		for (Destroyer d : tabuleiro.destroyers) {
			for (QuadradoDeTabuleiro q : d.coordenadas) {
				if (q.x == linha && q.y == coluna) {
					if (d.colunaInicial == d.coordenadas.get(1).y) {
						return 90;
					}
					return 0;
				}
			}
		}
		return null;
	}

	public Integer pegaOrientacaoDoHidroaviao(int linha, int coluna, char[][] matriz) {
		char[][] tabuleiroAtaque = matriz;
		int i = linha;
		int j = coluna;
		if (tabuleiroAtaque[i + 1][j - 1] == 'h' && tabuleiroAtaque[i + 1][j + 1] == 'h') {
			return 0;
		} else if (tabuleiroAtaque[i + 1][j - 1] == 'h' && tabuleiroAtaque[i - 1][j - 1] == 'h') {
			return 90;
		} else if (tabuleiroAtaque[i - 1][j - 1] == 'h' && tabuleiroAtaque[i - 1][j + 1] == 'h') {
			return 180;
		} else if (tabuleiroAtaque[i - 1][j + 1] == 'h' && tabuleiroAtaque[i + 1][j + 1] == 'h') {
			return 270;
		}
		return null;
	}
}
