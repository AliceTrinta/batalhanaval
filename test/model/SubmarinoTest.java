package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubmarinoTest {
    private Submarino submarino;
    private char[][] matriz;

    @BeforeEach
    void setUp() {
        submarino = new Submarino(5, 5);
        matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
    }

    @Test
    void testCasasAdajacentesValido() {
        assertTrue(submarino.casasAdajacentes(matriz, 5, 5, 0));
    }

    @Test
    void testCasasAdajacentesInvalido() {
        matriz[5][5] = '1';
        assertFalse(submarino.casasAdajacentes(matriz, 5, 5, 0));
    }

    @Test
    void testCasasAdajacentesLimiteInferior() {
        assertTrue(submarino.casasAdajacentes(matriz, 0, 0, 0));
    }

    @Test
    void testCasasAdajacentesLimiteSuperior() {
        assertTrue(submarino.casasAdajacentes(matriz, 14, 14, 0));
    }

    @Test
    void testPosicaoValidaDentroDosLimites() {
        assertTrue(submarino.posicaoValida(matriz, 5, 5, 0));
    }

    @Test
    void testPosicaoValidaForaDosLimitesNegativo() {
        assertFalse(submarino.posicaoValida(matriz, -1, 5, 0));
        assertFalse(submarino.posicaoValida(matriz, 5, -1, 0));
    }

    @Test
    void testPosicaoValidaForaDosLimitesPositivo() {
        assertFalse(submarino.posicaoValida(matriz, 15, 5, 0));
        assertFalse(submarino.posicaoValida(matriz, 5, 15, 0));
    }

    @Test
    void testPosicaoValidaCasasAdajacentesInvalido() {
        matriz[5][5] = '1';
        assertFalse(submarino.posicaoValida(matriz, 5, 5, 0));
    }

    @Test
    void testPosicaoValidaCasasAdajacentesValido() {
        assertTrue(submarino.posicaoValida(matriz, 5, 5, 0));
    }

    @Test
    void testPosicaoValidaLimiteInferior() {
        assertTrue(submarino.posicaoValida(matriz, 0, 0, 0));
    }

    @Test
    void testPosicaoValidaLimiteSuperior() {
        assertTrue(submarino.posicaoValida(matriz, 14, 14, 0));
    }
}
