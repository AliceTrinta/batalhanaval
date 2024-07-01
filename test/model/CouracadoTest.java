package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CouracadoTest {

    Couracado couracado;

    @Before
    public void setUp() {
        couracado = new Couracado();
    }

    @Test
    public void testCasasAdajacentesOrientacao90Positivo() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        assertTrue(couracado.casasAdajacentes(matriz, 5, 5, 90));
    }

    @Test
    public void testCasasAdajacentesOrientacao90Negativo() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        matriz[6][5] = '1';
        assertFalse(couracado.casasAdajacentes(matriz, 5, 5, 90));
    }

    @Test
    public void testCasasAdajacentesOrientacao0Positivo() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        assertTrue(couracado.casasAdajacentes(matriz, 5, 5, 0));
    }

    @Test
    public void testCasasAdajacentesOrientacao0Negativo() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        matriz[5][6] = '1';
        assertFalse(couracado.casasAdajacentes(matriz, 5, 5, 0));
    }

    @Test
    public void testPosicaoValidaOrientacao90Positivo() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        assertTrue(couracado.posicaoValida(matriz, 5, 5, 90));
    }

    @Test
    public void testPosicaoValidaOrientacao90Negativo() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        matriz[6][5] = '1';
        assertFalse(couracado.posicaoValida(matriz, 5, 5, 90));
    }

    @Test
    public void testPosicaoValidaOrientacao0Positivo() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        assertTrue(couracado.posicaoValida(matriz, 5, 5, 0));
    }

    @Test
    public void testPosicaoValidaOrientacao0Negativo() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        matriz[5][6] = '1';
        assertFalse(couracado.posicaoValida(matriz, 5, 5, 0));
    }

    @Test
    public void testPosicaoValidaOrientacao90ForaDosLimites() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        assertFalse(couracado.posicaoValida(matriz, 12, 5, 90));
    }

    @Test
    public void testPosicaoValidaOrientacao0ForaDosLimites() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        assertFalse(couracado.posicaoValida(matriz, 5, 12, 0));
    }
}

