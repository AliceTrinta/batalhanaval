package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DestroyerTest {
    
	Destroyer destroyer;

    @Before
    public void setUp() {
        destroyer = new Destroyer(5, 5);
    }

    @Test
    public void testConstructorAndInitialValues() {
        assertEquals(5, destroyer.linhaInicial);
        assertEquals(5, destroyer.colunaInicial);
        assertFalse(destroyer.afundou);
        assertNotNull(destroyer.coordenadas);
    }

    @Test
    public void testCasasAdajacentesOrientacao90SemObstaculos() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        assertTrue(destroyer.casasAdajacentes(matriz, 5, 5, 90));
    }

    @Test
    public void testCasasAdajacentesOrientacao90ComObstaculos() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        matriz[6][5] = '1';
        assertFalse(destroyer.casasAdajacentes(matriz, 5, 5, 90));
    }

    @Test
    public void testCasasAdajacentesOrientacao0SemObstaculos() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        assertTrue(destroyer.casasAdajacentes(matriz, 5, 5, 0));
    }

    @Test
    public void testCasasAdajacentesOrientacao0ComObstaculos() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        matriz[5][6] = '1';
        assertFalse(destroyer.casasAdajacentes(matriz, 5, 5, 0));
    }

    @Test
    public void testPosicaoValidaOrientacao90DentroDosLimites() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        assertTrue(destroyer.posicaoValida(matriz, 5, 5, 90));
    }

    @Test
    public void testPosicaoValidaOrientacao90ForaDosLimites() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        assertFalse(destroyer.posicaoValida(matriz, 14, 5, 90));
    }

    @Test
    public void testPosicaoValidaOrientacao0DentroDosLimites() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        assertTrue(destroyer.posicaoValida(matriz, 5, 5, 0));
    }

    @Test
    public void testPosicaoValidaOrientacao0ForaDosLimites() {
        char[][] matriz = new char[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                matriz[i][j] = '0';
            }
        }
        assertFalse(destroyer.posicaoValida(matriz, 5, 14, 0));
    }
}
