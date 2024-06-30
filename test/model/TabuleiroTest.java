package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TabuleiroTest {
    private Tabuleiro tabuleiro;
    private char[][] tabuleiroAtaque;
    private char[][] tabuleiroDefesa;

    @BeforeEach
    void setUp() {
        tabuleiro = new Tabuleiro();
        tabuleiroAtaque = new char[15][15];
        tabuleiroDefesa = new char[15][15];
    }

    @Test
    void testInicializaDePartidaAnteriorCouracadoHorizontal() {
        // Monta o tabuleiro de ataque com um couraçado horizontal
        tabuleiroAtaque[5][5] = 'C';
        tabuleiroAtaque[5][6] = 'C';
        tabuleiroAtaque[5][7] = 'C';
        tabuleiroAtaque[5][8] = 'C';
        tabuleiroAtaque[5][9] = 'C';

        tabuleiro.inicializaDePartidaAnterior(tabuleiroAtaque, tabuleiroDefesa, 1, 0, 0, 0, 0);

        // Verifica se o couraçado foi adicionado corretamente
        assertNotNull(tabuleiro.couracado);
        assertEquals(5, tabuleiro.couracado.linhaInicial);
        assertEquals(5, tabuleiro.couracado.colunaInicial);
        assertEquals(5, tabuleiro.couracado.coordenadas.size());
    }

    @Test
    void testInicializaDePartidaAnteriorCouracadoVertical() {
        // Monta o tabuleiro de ataque com um couraçado vertical
        tabuleiroAtaque[5][5] = 'C';
        tabuleiroAtaque[6][5] = 'C';
        tabuleiroAtaque[7][5] = 'C';
        tabuleiroAtaque[8][5] = 'C';
        tabuleiroAtaque[9][5] = 'C';

        tabuleiro.inicializaDePartidaAnterior(tabuleiroAtaque, tabuleiroDefesa, 1, 0, 0, 0, 0);

        // Verifica se o couraçado foi adicionado corretamente
        assertNotNull(tabuleiro.couracado);
        assertEquals(5, tabuleiro.couracado.linhaInicial);
        assertEquals(5, tabuleiro.couracado.colunaInicial);
        assertEquals(5, tabuleiro.couracado.coordenadas.size());
    }

    @Test
    void testInicializaDePartidaAnteriorCruzadorHorizontal() {
        // Monta o tabuleiro de ataque com um cruzador horizontal
        tabuleiroAtaque[5][5] = 'c';
        tabuleiroAtaque[5][6] = 'c';
        tabuleiroAtaque[5][7] = 'c';
        tabuleiroAtaque[5][8] = 'c';

        tabuleiro.inicializaDePartidaAnterior(tabuleiroAtaque, tabuleiroDefesa, 0, 1, 0, 0, 0);

        // Verifica se o cruzador foi adicionado corretamente
        assertEquals(1, tabuleiro.cruzadores.size());
        Cruzador cruzador = tabuleiro.cruzadores.get(0);
        assertEquals(5, cruzador.linhaInicial);
        assertEquals(5, cruzador.colunaInicial);
        assertEquals(4, cruzador.coordenadas.size());
    }

    @Test
    void testInicializaDePartidaAnteriorCruzadorVertical() {
        // Monta o tabuleiro de ataque com um cruzador vertical
        tabuleiroAtaque[5][5] = 'c';
        tabuleiroAtaque[6][5] = 'c';
        tabuleiroAtaque[7][5] = 'c';
        tabuleiroAtaque[8][5] = 'c';

        tabuleiro.inicializaDePartidaAnterior(tabuleiroAtaque, tabuleiroDefesa, 0, 1, 0, 0, 0);

        // Verifica se o cruzador foi adicionado corretamente
        assertEquals(1, tabuleiro.cruzadores.size());
        Cruzador cruzador = tabuleiro.cruzadores.get(0);
        assertEquals(5, cruzador.linhaInicial);
        assertEquals(5, cruzador.colunaInicial);
        assertEquals(4, cruzador.coordenadas.size());
    }


    @Test
    void testInicializaDePartidaAnteriorDestroyerVertical() {
        // Monta o tabuleiro de ataque com um destroyer vertical
        tabuleiroAtaque[5][5] = 'd';
        tabuleiroAtaque[6][5] = 'd';

        tabuleiro.inicializaDePartidaAnterior(tabuleiroAtaque, tabuleiroDefesa, 0, 0, 0, 0, 1);

        // Verifica se o destroyer foi adicionado corretamente
        assertEquals(1, tabuleiro.destroyers.size());
        Destroyer destroyer = tabuleiro.destroyers.get(0);
        assertEquals(5, destroyer.linhaInicial);
        assertEquals(5, destroyer.colunaInicial);
        assertEquals(2, destroyer.coordenadas.size());
    }

    @Test
    void testInicializaDePartidaAnteriorSubmarino() {
        // Monta o tabuleiro de ataque com um submarino
        tabuleiroAtaque[5][5] = 's';

        tabuleiro.inicializaDePartidaAnterior(tabuleiroAtaque, tabuleiroDefesa, 0, 0, 0, 1, 0);

        // Verifica se o submarino foi adicionado corretamente
        assertEquals(1, tabuleiro.submarinos.size());
        Submarino submarino = tabuleiro.submarinos.get(0);
        assertEquals(5, submarino.linhaInicial);
        assertEquals(5, submarino.colunaInicial);
    }

    @Test
    void testInicializaDePartidaAnteriorHidroaviao() {
        // Monta o tabuleiro de ataque com um hidroavião
        tabuleiroAtaque[5][5] = 'h';
        tabuleiroAtaque[4][4] = 'h';
        tabuleiroAtaque[6][4] = 'h';

        tabuleiro.inicializaDePartidaAnterior(tabuleiroAtaque, tabuleiroDefesa, 0, 0, 1, 0, 0);

        // Verifica se o hidroavião foi adicionado corretamente
        assertEquals(1, tabuleiro.hidroavioes.size());
        Hidroaviao hidroaviao = tabuleiro.hidroavioes.get(0);
        assertEquals(5, hidroaviao.linhaInicial);
        assertEquals(5, hidroaviao.colunaInicial);
        assertEquals(3, hidroaviao.coordenadas.size());
    }

}
