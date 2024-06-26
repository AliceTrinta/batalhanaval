package model;

import java.util.ArrayList;
import java.util.List;

class Tabuleiro {
	char[][] matriz;
	Couracado couracado;
	int couracadoQtd = 1;
	int cruzadorQtd = 2;
	int destroyerQtd = 3;
	int submarinoQtd = 4;
	int hidroaviaoQtd = 5;
	List<Cruzador> cruzadores = new ArrayList<>();
	List<Destroyer> destroyers = new ArrayList<>();
	List<Submarino> submarinos = new ArrayList<>();
	List<Hidroaviao> hidroavioes = new ArrayList<>();

	Tabuleiro() {
	}

	void inicializaDePartidaAnterior(char[][] tabuleiroAtaque, char[][] tabuleiroDefesa) {
		for (int i = 0; i < tabuleiroAtaque.length; i++) {
			for (int j = 0; j < tabuleiroAtaque[i].length; j++) {
				switch (tabuleiroAtaque[i][j]) {
				case 'C':
					if (this.couracado != null) {
						if (tabuleiroAtaque[i + 1][j] == 'C') {
							adicionarCouracado(i, j, 90);
						} else {
							adicionarCouracado(i, j, 0);
						}
					}
					break;
				case 'c':
					if (tabuleiroAtaque[i + 1][j] == 'c') {
						adicionarCruzador(i, j, 90);
						tabuleiroAtaque[i][j] = '0';
						tabuleiroAtaque[i + 1][j] = '0';
						tabuleiroAtaque[i + 2][j] = '0';
						tabuleiroAtaque[i + 3][j] = '0';
					} else {
						adicionarCruzador(i, j, 0);
						j = j + 4;
					}
					break;
				case 'd':
					if (tabuleiroAtaque[i + 1][j] == 'd') {
						adicionarDestroyer(i, j, 90);
						tabuleiroAtaque[i][j] = '0';
						tabuleiroAtaque[i + 1][j] = '0';
						tabuleiroAtaque[i + 2][j] = '0';
					} else {
						adicionarDestroyer(i, j, 0);
						j = j + 3;
					}
					break;
				case 's':
					adicionarSubmarino(i, j);
					break;
				case 'h':
					if(tabuleiroAtaque[i + 1][j - 1] == 'h' && tabuleiroAtaque[i + 1][j + 1] == 'h') {
						adicionarHidroaviao(i, j, 0);
					}
				    else if (tabuleiroAtaque[i + 1][j - 1] == 'h' && tabuleiroAtaque[i - 1][j - 1] == 'h') {
						adicionarHidroaviao(i, j, 90);
					} else if (tabuleiroAtaque[i + 1][j + 1] == 'h' && tabuleiroAtaque[i + 1][j - 1] == 'h') {
						adicionarHidroaviao(i, j, 180);
					} else if (tabuleiroAtaque[i - 1][j + 1] == 'h' && tabuleiroAtaque[i + 1][j + 1] == 'h') {
						adicionarHidroaviao(i, j, 270);
					}
					break;
				}
			}
		}

		for (int i = 0; i < tabuleiroDefesa.length; i++) {
			for (int j = 0; j < tabuleiroDefesa[i].length; j++) {
				String cor = null;
				if (tabuleiroDefesa[i][j] == 'V') {
					cor = "VERMELHO";
				} else if (tabuleiroDefesa[i][j] == 'A') {
					cor = "ROSA";
				}

				if (cor != null) {
					for(Submarino s : this.submarinos) {
						if (s.coordenadas.x == i && s.coordenadas.y == j) {
							s.coordenadas.cor = "ROSA";
							int index = this.submarinos.indexOf(s);
							this.submarinos.set(index, s);
						}
					}
					
					if(this.couracado != null) {
						for (QuadradoDeTabuleiro q : this.couracado.coordenadas) {
							if (q.x == i && q.y == j) {
								q.cor = "ROSA";
								int index = this.couracado.coordenadas.indexOf(q);
								this.couracado.coordenadas.set(index, q);
							}
						}
					}

					for (Cruzador c : this.cruzadores) {
						int indexMacro = this.cruzadores.indexOf(c);
						for (QuadradoDeTabuleiro q : c.coordenadas) {
							if (q.x == i && q.y == j) {
								q.cor = cor;
								int index = c.coordenadas.indexOf(q);
								this.cruzadores.get(indexMacro).coordenadas.set(index, q);
							}
						}
					}

					for (Destroyer d : this.destroyers) {
						int indexMacro = this.destroyers.indexOf(d);
						for (QuadradoDeTabuleiro q : d.coordenadas) {
							if (q.x == i && q.y == j) {
								q.cor = cor;
								int index = d.coordenadas.indexOf(q);
								this.destroyers.get(indexMacro).coordenadas.set(index, q);
							}
						}
					}
					
					for (Hidroaviao h : this.hidroavioes) {
						int indexMacro = this.hidroavioes.indexOf(h);
						for (QuadradoDeTabuleiro q : h.coordenadas) {
							if (q.x == i && q.y == j) {
								q.cor = cor;
								int index = h.coordenadas.indexOf(q);
								this.hidroavioes.get(indexMacro).coordenadas.set(index, q);
							}
						}
					}
				}
			}
		}
	}

	void adicionarCouracado(int i, int j, int orientacao) {
		if (orientacao == 90) {
			this.couracado = new Couracado(i, j);
			for (int k = 0; k < 5; k++) {
				this.couracado.coordenadas.add(new QuadradoDeTabuleiro(i + k, j));
			}
		} else {
			for (int k = 0; k < 5; k++) {
				this.couracado.coordenadas.add(new QuadradoDeTabuleiro(i, j + k));
			}
		}
	}

	void adicionarCruzador(int i, int j, int orientacao) {
		Cruzador c = new Cruzador(i, j);
		if (orientacao == 90) {
			for (int k = 0; k < 4; k++) {
				c.coordenadas.add(new QuadradoDeTabuleiro(i + k, j));
			}
		} else {
			for (int k = 0; k < 4; k++) {
				c.coordenadas.add(new QuadradoDeTabuleiro(i, j + k));
			}
		}
		this.cruzadores.add(c);
	}

	void adicionarDestroyer(int i, int j, int orientacao) {
		Destroyer d = new Destroyer(i, j);
		if (orientacao == 90) {
			for (int k = 0; k < 2; k++) {
				d.coordenadas.add(new QuadradoDeTabuleiro(i + k, j));
			}
		} else {
			for (int k = 0; k < 2; k++) {
				d.coordenadas.add(new QuadradoDeTabuleiro(i, j + k));
			}
		}
		this.destroyers.add(d);
	}

	void adicionarHidroaviao(int i, int j, int orientacao) {
		Hidroaviao h = new Hidroaviao(i, j);
		if (orientacao == 90) {
			h.coordenadas.add(new QuadradoDeTabuleiro(i, j));
			h.coordenadas.add(new QuadradoDeTabuleiro(i - 1, j - 1));
			h.coordenadas.add(new QuadradoDeTabuleiro(i + 1, j - 1));
		} else if (orientacao == 180) {
			h.coordenadas.add(new QuadradoDeTabuleiro(i, j));
			h.coordenadas.add(new QuadradoDeTabuleiro(i + 1, j + 1));
			h.coordenadas.add(new QuadradoDeTabuleiro(i + 1, j - 1));
		} else if (orientacao == 270) {
			h.coordenadas.add(new QuadradoDeTabuleiro(i, j));
			h.coordenadas.add(new QuadradoDeTabuleiro(i - 1, j + 1));
			h.coordenadas.add(new QuadradoDeTabuleiro(i + 1, j + 1));
		} else {
			h.coordenadas.add(new QuadradoDeTabuleiro(i, j));
			h.coordenadas.add(new QuadradoDeTabuleiro(i + 1, j - 1));
			h.coordenadas.add(new QuadradoDeTabuleiro(i + 1, j + 1));
		}
		this.hidroavioes.add(h);
	}

	void adicionarSubmarino(int i, int j) {
		Submarino s = new Submarino(i, j);
		s.coordenadas.x = i;
		s.coordenadas.y = j;
		this.submarinos.add(s);
	}
}
