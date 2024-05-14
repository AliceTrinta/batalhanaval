package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TabuleiroTest {

    @Test
    public void testGetPosicao(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        assertEquals('0', tabuleiro.getPosicao(5, 5));
    }

    @Test
    public void testSetPosicao(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        tabuleiro.setPosicao(5, 5, 'X');
        assertEquals('X', tabuleiro.getPosicao(5, 5));
    }

    @Test
    public void testPosicaoValidaTrue(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        assertEquals(true, tabuleiro.posicaoValida(5, 5));
    }

    @Test
    public void testPosicaoFalse(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        assertEquals(false, tabuleiro.posicaoValida(500, 500));
    }

    @Test
    public void testInserirCouracado(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        Couracado courado = new Couracado(5, 5, 0);
        tabuleiro.inserirCouracado(courado);
        assertEquals('1', tabuleiro.getPosicao(5, 5));
        assertEquals('1', tabuleiro.getPosicao(5, 6));
        assertEquals('1', tabuleiro.getPosicao(5, 7));
        assertEquals('1', tabuleiro.getPosicao(5, 8));
        assertEquals('1', tabuleiro.getPosicao(5, 9));
    }

    @Test
    public void testInserirCouracado90(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        Couracado courado = new Couracado(5, 5, 90);
        tabuleiro.inserirCouracado(courado);
        assertEquals('1', tabuleiro.getPosicao(5, 5));
        assertEquals('1', tabuleiro.getPosicao(6, 5));
        assertEquals('1', tabuleiro.getPosicao(7, 5));
        assertEquals('1', tabuleiro.getPosicao(8, 5));
        assertEquals('1', tabuleiro.getPosicao(9, 5));
    }

    @Test
    public void testInserirCruzador(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        Cruzador cruzador = new Cruzador(5, 5, 0);
        tabuleiro.inserirCruzador(cruzador);
        assertEquals('1', tabuleiro.getPosicao(5, 5));
        assertEquals('1', tabuleiro.getPosicao(5, 6));
        assertEquals('1', tabuleiro.getPosicao(5, 7));
    }

    @Test
    public void testInserirCruzador90(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        Cruzador cruzador = new Cruzador(5, 5, 90);
        tabuleiro.inserirCruzador(cruzador);
        assertEquals('1', tabuleiro.getPosicao(5, 5));
        assertEquals('1', tabuleiro.getPosicao(6, 5));
        assertEquals('1', tabuleiro.getPosicao(7, 5));
    }

    @Test
    public void testInserirDestroyer(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        Destroyer destroyer = new Destroyer(5, 5, 0);
        tabuleiro.inserirDestroyer(destroyer);
        assertEquals('1', tabuleiro.getPosicao(5, 5));
        assertEquals('1', tabuleiro.getPosicao(5, 6));
    }

    @Test
    public void testInserirDestroyer90(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        Destroyer destroyer = new Destroyer(5, 5, 90);
        tabuleiro.inserirDestroyer(destroyer);
        assertEquals('1', tabuleiro.getPosicao(5, 5));
        assertEquals('1', tabuleiro.getPosicao(6, 5));
    }

    @Test
    public void testInserirSubmarino(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        Submarino submarino = new Submarino(5, 5, 5);
        tabuleiro.inserirSubmarino(submarino);
        assertEquals('1', tabuleiro.getPosicao(5, 5));
    }

    @Test
    public void testInserirHidroaviao(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        Hidroaviao hidroaviao = new Hidroaviao(5, 5, 0);
        tabuleiro.inserirHidroaviao(hidroaviao);
        assertEquals('1', tabuleiro.getPosicao(5, 5));
        assertEquals('1', tabuleiro.getPosicao(6, 6));
        assertEquals('1', tabuleiro.getPosicao(6, 4));
    }

    @Test
    public void testInserirHidroaviao90(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        Hidroaviao hidroaviao = new Hidroaviao(5, 5, 90);
        tabuleiro.inserirHidroaviao(hidroaviao);
        assertEquals('1', tabuleiro.getPosicao(5, 5));
        assertEquals('1', tabuleiro.getPosicao(6, 6));
        assertEquals('1', tabuleiro.getPosicao(4, 6));
    }

    @Test
    public void testInserirHidroaviao180(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        Hidroaviao hidroaviao = new Hidroaviao(5, 5, 180);
        tabuleiro.inserirHidroaviao(hidroaviao);
        assertEquals('1', tabuleiro.getPosicao(5, 5));
        assertEquals('1', tabuleiro.getPosicao(4, 6));
        assertEquals('1', tabuleiro.getPosicao(4, 4));
    }

    @Test
    public void testInserirHidroaviao270(){
        Tabuleiro tabuleiro = new Tabuleiro(false);
        Hidroaviao hidroaviao = new Hidroaviao(5, 5, 270);
        tabuleiro.inserirHidroaviao(hidroaviao);
        assertEquals('1', tabuleiro.getPosicao(5, 5));
        assertEquals('1', tabuleiro.getPosicao(4, 4));
        assertEquals('1', tabuleiro.getPosicao(6, 4));
    }
}
