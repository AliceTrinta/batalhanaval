package model;

public class AccessModel {
	private static AccessModel ModelAccesser = null;

	private AccessModel() {
	}

	public static AccessModel getAcessModel() {
		if (ModelAccesser == null)
			ModelAccesser = new AccessModel();
		return ModelAccesser;
	}

	public boolean InserirArma(String TipoArma, Player player, int linhaInicial, int colunaInicial, int orientacao) {
		Tabuleiro tabuleiro = player.getTabuleiro_proprio();
		if (tabuleiro.qtdHidroavioes <= 0 || tabuleiro.qtdDestroyers <= 0 || tabuleiro.qtdCruzadores <= 0
				|| tabuleiro.qtdSubmarinos <= 0 || tabuleiro.qtdEncouracado <= 0) {
			System.out.println("Não foi possível inserir arma, quantidade de armas excedida");
			return false;
		}

		if (TipoArma.equals("Encouracado")) {
			Couracado couracado = new Couracado(linhaInicial, colunaInicial, orientacao);
			if (tabuleiro.posicaoValida(couracado.linhaInicial, couracado.colunaInicial, couracado.orientacao,
					couracado) == false) {
				System.out.println("Não foi possível inserir arma, posição inválida");
				return false;
			}
			tabuleiro.inserirCouracado(couracado);
			tabuleiro.qtdEncouracado--;
			return true;
		}
		if (TipoArma.equals("Cruzador")) {
			Cruzador cruzador = new Cruzador(linhaInicial, colunaInicial, orientacao);
			if (tabuleiro.posicaoValida(cruzador.linhaInicial, cruzador.colunaInicial, cruzador.orientacao,
					cruzador) == false) {
				System.out.println("Não foi possível inserir arma, posição inválida");
				return false;
			}
			tabuleiro.inserirCruzador(cruzador);
			tabuleiro.qtdCruzadores--;
			return true;
		}
		if (TipoArma.equals("Destroyer")) {
			Destroyer destroyer = new Destroyer(linhaInicial, colunaInicial, orientacao);
			if (tabuleiro.posicaoValida(destroyer.linhaInicial, destroyer.colunaInicial, destroyer.orientacao,
					destroyer) == false) {
				System.out.println("Não foi possível inserir arma, posição inválida");
				return false;
			}
			tabuleiro.inserirDestroyer(destroyer);
			tabuleiro.qtdDestroyers--;
			return true;
		}
		if (TipoArma.equals("Submarino")) {
			Submarino submarino = new Submarino(linhaInicial, colunaInicial, orientacao);
			if (tabuleiro.posicaoValida(submarino.linhaInicial, submarino.colunaInicial, submarino.orientacao,
					submarino) == false) {
				System.out.println("Não foi possível inserir arma, posição inválida");
				return false;
			}
			tabuleiro.inserirSubmarino(submarino);
			tabuleiro.qtdSubmarinos--;
			return true;
		}
		if (TipoArma.equals("Hidroaviao")) {
			Hidroaviao hidroaviao = new Hidroaviao(linhaInicial, colunaInicial, orientacao);
			if (tabuleiro.posicaoValida(hidroaviao.linhaInicial, hidroaviao.colunaInicial, hidroaviao.orientacao,
					hidroaviao) == false) {
				System.out.println("Não foi possível inserir arma, posição inválida");
				return false;
			}
			tabuleiro.inserirHidroaviao(hidroaviao);
			tabuleiro.qtdHidroavioes--;
			return true;
		}
		System.out.println("Não foi possível inserir arma, tipo de arma inválido");
		return false;
	}

	public char Atacar(int linhaInicial, int colunaInicial, Player player, Player adversario) {
		Tabuleiro tabuleiro = player.getTabuleiro_ataque();
		Tabuleiro tabuleiroAdversario = adversario.getTabuleiro_proprio();
		if (tabuleiro.posicaoValida(linhaInicial, colunaInicial) == false) {
			System.out.println("Não foi possível atacar, posição inválida");
			return '\0';
		}
		if (tabuleiro.tabuleiro[linhaInicial][colunaInicial] == '1'
				|| tabuleiro.tabuleiro[linhaInicial][colunaInicial] == 'A') {
			System.out.println("Não foi possível atacar, posição já atacada");
			return '\0';
		}
		if (tabuleiroAdversario.tabuleiro[linhaInicial][colunaInicial] == '0') {
			tabuleiro.tabuleiro[linhaInicial][colunaInicial] = '1';
			return '0';
		}
		tabuleiro.tabuleiro[linhaInicial][colunaInicial] = 'A';

		return tabuleiroAdversario.tabuleiro[linhaInicial][colunaInicial];
	}

	public void SalvarPartida(Player player1, Player player2) {
		PartidaSalvarCarregar.savePartidaToFile(player1, player2, "jogosalvo.txt");
	}

	public Player[] CarregarPartida() {
		return PartidaSalvarCarregar.loadPartidaFromFile("jogosalvo.txt");
	}

}