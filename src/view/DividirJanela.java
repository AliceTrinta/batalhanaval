package view;

import javax.swing.*;
import java.awt.*;

public class DividirJanela extends JFrame {
    private static final long serialVersionUID = 1L;

	public DividirJanela() {
        super("Batalha Naval");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 1000);

        JPanel painelEsquerda = new JPanel(new GridLayout(5, 1)); 
        JPanel painelDireita = new JPanel(new BorderLayout()); 

        Couracado couracado = new Couracado();
        Cruzador cruzador = new Cruzador();
        Destroyer destroyer = new Destroyer();
        Submarino submarino = new Submarino();
        Hidroaviao hidroaviao = new Hidroaviao();
        
        painelEsquerda.add(hidroaviao);
        painelEsquerda.add(submarino);
        painelEsquerda.add(destroyer);
        painelEsquerda.add(cruzador);
        painelEsquerda.add(couracado);

        TabuleiroDeJogo tabuleiro = new TabuleiroDeJogo(15, 15);
        painelDireita.add(tabuleiro, BorderLayout.CENTER);

        JPanel painelCentral = new JPanel(new GridLayout(1, 2));
        painelCentral.add(painelEsquerda);
        painelCentral.add(painelDireita);

        getContentPane().add(painelCentral, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DividirJanela exemplo = new DividirJanela();
            exemplo.setVisible(true);
        });
    }
}
