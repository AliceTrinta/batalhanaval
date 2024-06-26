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
		this.dados.jogador1.setTabuleiroPrincipal(tabuleiroAtaque2, tabuleiroDefesa1);
		this.dados.jogador2.setTabuleiroAtaque(tabuleiroAtaque2);
		this.dados.jogador2.setTabuleiroDefesa(tabuleiroDefesa2);
		this.dados.jogador1.setTabuleiroPrincipal(tabuleiroAtaque1, tabuleiroDefesa2);
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
		Boolean posicaoCorreta = this.couracacado.posicaoValida(matriz, linha, coluna, 0);
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		if (tabuleiro.couracadoQtd == 0) {
			return novaMatriz;
		}
		Couracado c = new Couracado(linha, coluna);
		for (int i = 0; i < 5; i++) {
			novaMatriz[linha][coluna + i] = 'C';
			if (orientacao == 90) {
				c.coordenadas.add(new QuadradoDeTabuleiro(linha + i, coluna));
			} else {
				c.coordenadas.add(new QuadradoDeTabuleiro(linha, coluna + i));
			}
		}
		tabuleiro.couracadoQtd--;
		tabuleiro.couracado = c;
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.couracadoNoTabuleiro(linha, coluna, posicaoCorreta);
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		return novaMatriz;
	}

	public char[][] cruzadorNoTabuleiro(char[][] matriz, int linha, int coluna, int orientacao, String nomeJogador) {
		Boolean posicaoCorreta = this.cruzador.posicaoValida(matriz, linha, coluna, 0);
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		if (tabuleiro.cruzadorQtd == 0) {
			return novaMatriz;
		}
		Cruzador c = new Cruzador(linha, coluna);
		for (int i = 0; i < 4; i++) {
			novaMatriz[linha][coluna + i] = 'c';
			if (orientacao == 90) {
				c.coordenadas.add(new QuadradoDeTabuleiro(linha + i, coluna));
			} else {
				c.coordenadas.add(new QuadradoDeTabuleiro(linha, coluna + i));
			}
		}
		this.dados.cruzadorNoTabuleiro(linha, coluna, posicaoCorreta);
		tabuleiro.cruzadorQtd--;
		tabuleiro.cruzadores.add(c);
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		return novaMatriz;
	}

	public char[][] destroyerNoTabuleiro(char[][] matriz, int linha, int coluna, int orientacao, String nomeJogador) {
		Boolean posicaoCorreta = this.destroyer.posicaoValida(matriz, linha, coluna, 0);
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		if (tabuleiro.destroyerQtd == 0) {
			return novaMatriz;
		}
		Destroyer d = new Destroyer(linha, coluna);
		for (int i = 0; i < 2; i++) {
			novaMatriz[linha][coluna + i] = 'd';
			if (orientacao == 90) {
				d.coordenadas.add(new QuadradoDeTabuleiro(linha + i, coluna));
			} else {
				d.coordenadas.add(new QuadradoDeTabuleiro(linha, coluna + i));
			}
		}
		this.dados.destroyerNoTabuleiro(linha, coluna, posicaoCorreta);
		tabuleiro.destroyers.add(d);
		tabuleiro.destroyerQtd--;
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		return novaMatriz;
	}

	public char[][] hidroaviaoNoTabuleiro(char[][] matriz, int linha, int coluna, int orientacao, String nomeJogador) {
		Boolean posicaoCorreta = this.hidroaviao.posicaoValida(matriz, linha, coluna, 0);
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		if (tabuleiro.hidroaviaoQtd == 0) {
			return novaMatriz;
		}
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
			novaMatriz[linha + 1][coluna + 1] = 'h';
			novaMatriz[linha + 1][coluna - 1] = 'h';
			h.coordenadas.add(new QuadradoDeTabuleiro(linha, coluna));
			h.coordenadas.add(new QuadradoDeTabuleiro(linha + 1, coluna + 1));
			h.coordenadas.add(new QuadradoDeTabuleiro(linha + 1, coluna - 1));
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
		tabuleiro.hidroaviaoQtd--;
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.hidroaviaoNoTabuleiro(linha, coluna, posicaoCorreta);
		return novaMatriz;
	}

	public char[][] submarinoNoTabuleiro(char[][] matriz, int linha, int coluna, String nomeJogador) {
		Boolean posicaoCorreta = this.submarino.posicaoValida(matriz, linha, coluna, 0);
		char[][] novaMatriz = matriz;
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeJogador);
		if (tabuleiro.submarinoQtd == 0) {
			return novaMatriz;
		}
		novaMatriz[linha][coluna] = 's';
		Submarino s = new Submarino(linha, coluna);
		s.coordenadas.x = linha;
		s.coordenadas.y = coluna;
		tabuleiro.submarinos.add(s);
		tabuleiro.submarinoQtd--;
		this.dados.setTabuleiroPrincipal(tabuleiro, nomeJogador);
		this.dados.submarinoNoTabuleiro(linha, coluna, posicaoCorreta);
		return novaMatriz;
	}

	public boolean verificaSeAfundou(int linha, int coluna, char tipoDeArma, String nomeAtacado) {
		Tabuleiro tabuleiro = this.dados.getTabuleiroPrincipal(nomeAtacado);
		boolean result = false;
		switch (tipoDeArma) {
		case 'C':
			for (QuadradoDeTabuleiro q : tabuleiro.couracado.coordenadas) {
				if(q.x == linha && q.y == coluna) {
					q.cor = "ROSA";
					int index = tabuleiro.couracado.coordenadas.indexOf(q);
					tabuleiro.couracado.coordenadas.set(index, q);
				}
			}
			result = tabuleiro.couracado.coordenadas.stream().anyMatch(p -> p.cor.equals("BRANCO"));
			if(result == false) {
				for (QuadradoDeTabuleiro q : tabuleiro.couracado.coordenadas) {
					pintarQuadrado(q.x, q.y, "VERMELHO");
					q.cor = "VERMELHO";
					int index = tabuleiro.couracado.coordenadas.indexOf(q);
					tabuleiro.couracado.coordenadas.set(index, q);
				}
			}
			break;
		case 'c':
			for (Cruzador c : tabuleiro.cruzadores) {
	            if (c.coordenadas.stream().anyMatch(p -> p.x == linha && p.y == coluna)) {
	            	int indexMacro = tabuleiro.cruzadores.indexOf(c);
	            	for (QuadradoDeTabuleiro q : c.coordenadas) {
    					if(q.x == linha && q.y == coluna) {
    						q.cor = "ROSA";
    						int index = c.coordenadas.indexOf(q);
							tabuleiro.cruzadores.get(indexMacro).coordenadas.set(index, q);
    					}
    				}
	            	result = c.coordenadas.stream().anyMatch(p -> p.cor.equals("BRANCO"));
	            	if(result == false) {
	            		for (QuadradoDeTabuleiro q : c.coordenadas) {
							pintarQuadrado(q.x, q.y, "VERMELHO");
							q.cor = "VERMELHO";
							int index = c.coordenadas.indexOf(q);
							tabuleiro.cruzadores.get(indexMacro).coordenadas.set(index, q);
						}
	    			}
	            }
	        }
			break;
		case 'd':
			for (Destroyer d : tabuleiro.destroyers) {
	            if (d.coordenadas.stream().anyMatch(p -> p.x == linha && p.y == coluna)) {
	            	int indexMacro = tabuleiro.destroyers.indexOf(d);
	            	for (QuadradoDeTabuleiro q : d.coordenadas) {
    					if(q.x == linha && q.y == coluna) {
    						q.cor = "ROSA";
    						int index = d.coordenadas.indexOf(q);
							tabuleiro.destroyers.get(indexMacro).coordenadas.set(index, q);
    					}
    				}
	            	result = d.coordenadas.stream().anyMatch(p -> p.cor.equals("BRANCO"));
	            	if(result == false) {
	            		for (QuadradoDeTabuleiro q : d.coordenadas) {
							pintarQuadrado(q.x, q.y, "VERMELHO");
							q.cor = "VERMELHO";
							int index = d.coordenadas.indexOf(q);
							tabuleiro.destroyers.get(indexMacro).coordenadas.set(index, q);
						}
	    			}
	            }
	        }
			break;
		case 'h':
			for (Hidroaviao h : tabuleiro.hidroavioes) {
	            if (h.coordenadas.stream().anyMatch(p -> p.x == linha && p.y == coluna)) {
	            	int indexMacro = tabuleiro.hidroavioes.indexOf(h);
	            	for (QuadradoDeTabuleiro q : h.coordenadas) {
    					if(q.x == linha && q.y == coluna) {
    						q.cor = "ROSA";
    						int index = h.coordenadas.indexOf(q);
							tabuleiro.hidroavioes.get(indexMacro).coordenadas.set(index, q);
    					}
    				}
	            	result = h.coordenadas.stream().anyMatch(p -> p.cor.equals("BRANCO"));
	            	if(result == false) {
	            		for (QuadradoDeTabuleiro q : h.coordenadas) {
							pintarQuadrado(q.x, q.y, "VERMELHO");
							q.cor = "VERMELHO";
							int index = h.coordenadas.indexOf(q);
							tabuleiro.hidroavioes.get(indexMacro).coordenadas.set(index, q);
						}
	    			}
	            }
	        }
			break;
		case 's':
			for (Submarino s : tabuleiro.submarinos) {
	            if (s.coordenadas.x == linha && s.coordenadas.y == coluna) {
	            	s.coordenadas.cor = "ROSA";
	            	result = s.coordenadas.cor.equals("BRANCO");
	            	if(result == false) {
	            		pintarQuadrado(s.coordenadas.x, s.coordenadas.y, "VERMELHO");
	            		s.coordenadas.cor = "VERMELHO";
	            		int index = tabuleiro.submarinos.indexOf(s);
						tabuleiro.submarinos.set(index, s);
	    			}
	            }
	        }
			break;
		default:
			break;
		}
		return !result;
	}
	
	public void pintarQuadrado(int linha, int coluna, String cor) {
		this.dados.pintarQuadrado(linha, coluna, cor);
	}

}
