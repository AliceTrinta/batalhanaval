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

        JPanel painelDireita = new JPanel(new BorderLayout());
        TabuleiroDeJogo tabuleiro = new TabuleiroDeJogo(15, 15);
        painelDireita.add(tabuleiro, BorderLayout.CENTER);

        JPanel painelCentral = new JPanel(new GridLayout(1, 2));
        painelCentral.add(painelEsquerda);
        painelCentral.add(painelDireita);

        JPanel painelInferior = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 50, 0); // Espaçamento: topo, esquerda, baixo, direita
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel label = new JLabel("Mensagem Centralizada");
        painelInferior.add(label, gbc);

        gbc.gridy = 1;
        JButton botao = new JButton("Tabuleiro Pronto");
        botao.setPreferredSize(new Dimension(200, 50));
        painelInferior.add(botao, gbc);

        // Adicionar os painéis ao frame
        getContentPane().add(painelCentral, BorderLayout.CENTER);
        getContentPane().add(painelInferior, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaDeSelecao tela = new TelaDeSelecao();
            tela.setVisible(true);
            tela.setFocusable(true);
    		tela.requestFocus();
    		
        });
    }
}