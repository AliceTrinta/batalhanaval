package view;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
        // Configurar a janela principal (JFrame)
        JFrame frame = new JFrame("Batalha Naval");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1000);

        PainelDeJogo panel = new PainelDeJogo(15, 15);
        frame.add(panel);

        frame.setVisible(true);
    }
}
