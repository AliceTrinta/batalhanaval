package control;

import model.AccessModel;

class Ataque {
	AccessModel accessModel;

	Ataque() {
		this.accessModel = new AccessModel();
	}
	
	void realizaAtaque(int linha, int coluna, String nomeAtacante) {
		String nomeAtacado = null;
		if(nomeAtacante.equals(this.accessModel.pegaNomeJogador1())) {
			nomeAtacado = this.accessModel.pegaNomeJogador2();
		} else if (nomeAtacante.equals(this.accessModel.pegaNomeJogador2())) {
			nomeAtacado = this.accessModel.pegaNomeJogador1();
		}
		
		char[][] tabuleiroAtacado = this.accessModel.pegaTabuleiroAtaque(nomeAtacado);
		char tipoDeArma = tabuleiroAtacado[linha][coluna];
		switch (tipoDeArma) {
		case 'C':
			this.accessModel.pintarQuadrado(linha, coluna, "ROSA");
			break;
		case 'c':
			this.accessModel.pintarQuadrado(linha, coluna, "ROSA");
			break;
		case 'd':
			this.accessModel.pintarQuadrado(linha, coluna, "ROSA");
			break;
		case 'h':
			this.accessModel.pintarQuadrado(linha, coluna, "ROSA");
			break;
		case 's':
			this.accessModel.pintarQuadrado(linha, coluna, "ROSA");
			break;
		case '0':
			this.accessModel.pintarQuadrado(linha, coluna, "AZUL");
			break;
		}
	}

}
