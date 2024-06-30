package model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AccessModelTest {

    private AccessModel accessModel;

    @Before
    public void setUp() {
        accessModel = new AccessModel();
    }

    @Test
    public void testCriaJogadores() {
        accessModel.criaJogadores("Jogador1", "Jogador2");
        assertEquals("Jogador1", accessModel.pegaNomeJogador1());
        assertEquals("Jogador2", accessModel.pegaNomeJogador2());
    }

    @Test
    public void testInicializaComDadosDeArquivo() {
        char[][] tabuleiroAtaque1 = new char[10][10];
        char[][] tabuleiroDefesa1 = new char[10][10];
        char[][] tabuleiroAtaque2 = new char[10][10];
        char[][] tabuleiroDefesa2 = new char[10][10];
        
        accessModel.inicializaComDadosDeArquivo("Jogador1", "Jogador2", tabuleiroAtaque1, tabuleiroDefesa1, "1", "2", "3", "4", "5", tabuleiroAtaque2, tabuleiroDefesa2, "1", "2", "3", "4", "5");

        assertEquals("Jogador1", accessModel.pegaNomeJogador1());
        assertEquals("Jogador2", accessModel.pegaNomeJogador2());
    }

    @Test
    public void testPegaNaviosRestantes() {
        char[][] tabuleiroAtaque1 = new char[10][10];
        char[][] tabuleiroDefesa1 = new char[10][10];
        char[][] tabuleiroAtaque2 = new char[10][10];
        char[][] tabuleiroDefesa2 = new char[10][10];
        
        accessModel.inicializaComDadosDeArquivo("Jogador1", "Jogador2", tabuleiroAtaque1, tabuleiroDefesa1, "1", "2", "3", "4", "5", tabuleiroAtaque2, tabuleiroDefesa2, "1", "2", "3", "4", "5");

        assertEquals((Integer) 1, accessModel.pegaNaviosRestantes("Jogador1", 'C'));
        assertEquals((Integer) 2, accessModel.pegaNaviosRestantes("Jogador1", 'c'));
        assertEquals((Integer) 4, accessModel.pegaNaviosRestantes("Jogador2", 's'));
    }

    @Test
    public void testSalvaTabuleiroAtaque() {
        char[][] tabuleiroAtaque = new char[10][10];
        accessModel.criaJogadores("Jogador1", "Jogador2");
        accessModel.salvaTabuleiroAtaque(tabuleiroAtaque, "Jogador1");

        assertArrayEquals(tabuleiroAtaque, accessModel.pegaTabuleiroAtaque("Jogador1"));
    }

    @Test
    public void testCriaTabuleiroDefesa() {
        char[][] tabuleiroDefesa = new char[10][10];
        accessModel.criaJogadores("Jogador1", "Jogador2");
        accessModel.criaTabuleiroDefesa(tabuleiroDefesa, "Jogador1");

        assertArrayEquals(tabuleiroDefesa, accessModel.pegaTabuleiroDefesa("Jogador1"));
    }

    @Test
    public void testCouracadoNoTabuleiro() {
        char[][] matriz = new char[10][10];
        accessModel.criaJogadores("Jogador1", "Jogador2");
        char[][] resultado = accessModel.couracadoNoTabuleiro(matriz, 0, 0, 0, "Jogador1");

        for (int i = 0; i < 5; i++) {
            assertEquals('C', resultado[0][i]);
        }
    }

    @Test
    public void testRemoveCouracadoDoTabuleiro() {
        char[][] matriz = new char[10][10];
        accessModel.criaJogadores("Jogador1", "Jogador2");
        char[][] resultado = accessModel.couracadoNoTabuleiro(matriz, 0, 0, 0, "Jogador1");
        resultado = accessModel.removeCouracadoDoTabuleiro(resultado, 0, 0, 0, "Jogador1");

        for (int i = 0; i < 5; i++) {
            assertEquals('0', resultado[0][i]);
        }
    }
}

