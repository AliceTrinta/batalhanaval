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
		if(tipoDeArma == '0') {
			this.accessModel.pintarQuadrado(linha, coluna, "AZUL");
		}
		boolean afundou = this.accessModel.verificaSeAfundou(linha, coluna, tipoDeArma, nomeAtacante);
		if(!afundou) {
			this.accessModel.pintarQuadrado(linha, coluna, "ROSA");
			return;
		} else {
			boolean vencedor = this.accessModel.verificaSeTodosAfundaram(nomeAtacante);
			if(vencedor) {
				this.accessModel.anunciaVencedor();
			} else {
				return;
			}
		}
	}

}
