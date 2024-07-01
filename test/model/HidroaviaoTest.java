package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HidroaviaoTest {
    Hidroaviao hidroaviao;
    char[][] matriz;

    @Before
    public void setUp() {
        hidroaviao = new Hidroaviao(5, 5);
        matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
    }

    @Test
    public void testCasasAdajacentesOrientacao0Valido() {
        assertTrue(hidroaviao.casasAdajacentes(matriz, 5, 5, 0));
    }

    @Test
    public void testCasasAdajacentesOrientacao90Valido() {
        assertTrue(hidroaviao.casasAdajacentes(matriz, 5, 5, 90));
    }

    @Test
    public void testCasasAdajacentesOrientacao180Valido() {
        assertTrue(hidroaviao.casasAdajacentes(matriz, 5, 5, 180));
    }

    @Test
    public void testCasasAdajacentesOrientacao270Valido() {
        assertTrue(hidroaviao.casasAdajacentes(matriz, 5, 5, 270));
    }

    @Test
    public void testCasasAdajacentesOrientacao0Invalido() {
        matriz[6][6] = '1';
        assertFalse(hidroaviao.casasAdajacentes(matriz, 5, 5, 0));
    }

    @Test
    public void testCasasAdajacentesOrientacao90Invalido() {
        matriz[6][6] = '1';
        assertFalse(hidroaviao.casasAdajacentes(matriz, 5, 5, 90));
    }

    @Test
    public void testCasasAdajacentesOrientacao180Invalido() {
        matriz[6][6] = '1';
        assertFalse(hidroaviao.casasAdajacentes(matriz, 5, 5, 180));
    }

    @Test
    public void testCasasAdajacentesOrientacao270Invalido() {
        matriz[6][6] = '1';
        assertFalse(hidroaviao.casasAdajacentes(matriz, 5, 5, 270));
    }

    @Test
    public void testPosicaoValidaOrientacao0DentroDosLimites() {
        assertTrue(hidroaviao.posicaoValida(matriz, 5, 5, 0));
    }

    @Test
    public void testPosicaoValidaOrientacao90DentroDosLimites() {
        assertTrue(hidroaviao.posicaoValida(matriz, 5, 5, 90));
    }

    @Test
    public void testPosicaoValidaOrientacao180DentroDosLimites() {
        assertTrue(hidroaviao.posicaoValida(matriz, 5, 5, 180));
    }

    @Test
    public void testPosicaoValidaOrientacao270DentroDosLimites() {
        assertTrue(hidroaviao.posicaoValida(matriz, 5, 5, 270));
    }

    @Test
    public void testPosicaoValidaOrientacao0ForaDosLimites() {
        assertFalse(hidroaviao.posicaoValida(matriz, 13, 5, 0));
    }

    @Test
    public void testPosicaoValidaOrientacao90ForaDosLimites() {
        assertFalse(hidroaviao.posicaoValida(matriz, 5, 13, 90));
    }

    @Test
    public void testPosicaoValidaOrientacao180ForaDosLimites() {
        assertFalse(hidroaviao.posicaoValida(matriz, 0, 5, 180));
    }

    @Test
    public void testPosicaoValidaOrientacao270ForaDosLimites() {
        assertFalse(hidroaviao.posicaoValida(matriz, 5, 0, 270));
    }

    @Test
    public void testPosicaoValidaOrientacao0Invalido() {
        matriz[6][6] = '1';
        assertFalse(hidroaviao.posicaoValida(matriz, 5, 5, 0));
    }

    @Test
    public void testPosicaoValidaOrientacao90Invalido() {
        matriz[6][6] = '1';
        assertFalse(hidroaviao.posicaoValida(matriz, 5, 5, 90));
    }

    @Test
    public void testPosicaoValidaOrientacao180Invalido() {
        matriz[6][6] = '1';
        assertFalse(hidroaviao.posicaoValida(matriz, 5, 5, 180));
    }

    @Test
    public void testPosicaoValidaOrientacao270Invalido() {
        matriz[6][6] = '1';
        assertFalse(hidroaviao.posicaoValida(matriz, 5, 5, 270));
    }
}
