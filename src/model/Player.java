package model;

class Player {
	Tabuleiro tabuleiro_proprio;
	Tabuleiro tabuleiro_ataque;
	boolean turno;

	void CriaTabuleiros() {
		this.tabuleiro_proprio = new Tabuleiro();
		this.tabuleiro_ataque = new Tabuleiro();
	}

	boolean getTurno() {
		return this.turno;
	}

	void setTurno(boolean turno) {
		this.turno = turno;
	}

	Tabuleiro getTabuleiro_proprio() {
		return tabuleiro_proprio;
	}

	Tabuleiro getTabuleiro_ataque() {
		return tabuleiro_ataque;
	}

	void setTabuleiro_proprio(Tabuleiro tabuleiro_proprio) {
		this.tabuleiro_proprio = tabuleiro_proprio;
	}

	void setTabuleiro_ataque(Tabuleiro tabuleiro_ataque) {
		this.tabuleiro_ataque = tabuleiro_ataque;
	}
}