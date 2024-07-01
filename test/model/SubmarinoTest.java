package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SubmarinoTest {
    Submarino submarino;
    char[][] matriz;

    @Before
    public void setUp() {
        submarino = new Submarino(5, 5);
        matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
    }

    @Test
    public void testCasasAdajacentesValido() {
        assertTrue(submarino.casasAdajacentes(matriz, 5, 5, 0));
    }

    @Test
    public void testCasasAdajacentesInvalido() {
        matriz[5][5] = '1';
        assertFalse(submarino.casasAdajacentes(matriz, 5, 5, 0));
    }

    @Test
    public void testCasasAdajacentesLimiteInferior() {
        assertTrue(submarino.casasAdajacentes(matriz, 0, 0, 0));
    }

    @Test
    public void testCasasAdajacentesLimiteSuperior() {
        assertTrue(submarino.casasAdajacentes(matriz, 14, 14, 0));
    }

    @Test
    public void testPosicaoValidaDentroDosLimites() {
        assertTrue(submarino.posicaoValida(matriz, 5, 5, 0));
    }

    @Test
    public void testPosicaoValidaForaDosLimitesNegativo() {
        assertFalse(submarino.posicaoValida(matriz, -1, 5, 0));
        assertFalse(submarino.posicaoValida(matriz, 5, -1, 0));
    }

    @Test
    public void testPosicaoValidaForaDosLimitesPositivo() {
        assertFalse(submarino.posicaoValida(matriz, 15, 5, 0));
        assertFalse(submarino.posicaoValida(matriz, 5, 15, 0));
    }

    @Test
    public void testPosicaoValidaCasasAdajacentesInvalido() {
        matriz[5][5] = '1';
        assertFalse(submarino.posicaoValida(matriz, 5, 5, 0));
    }

    @Test
    public void testPosicaoValidaCasasAdajacentesValido() {
        assertTrue(submarino.posicaoValida(matriz, 5, 5, 0));
    }

    @Test
    public void testPosicaoValidaLimiteInferior() {
        assertTrue(submarino.posicaoValida(matriz, 0, 0, 0));
    }

    @Test
    public void testPosicaoValidaLimiteSuperior() {
        assertTrue(submarino.posicaoValida(matriz, 14, 14, 0));
    }
}
