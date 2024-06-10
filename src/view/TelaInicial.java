package view;

import javax.swing.*;
import java.awt.*;

class TelaInicial extends JFrame {
    private static final long serialVersionUID = 1L;
    JButton novoJogo;
    JButton carregarJogo;
    
	TelaInicial() {
        setTitle("Batalha Naval");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel titleLabel = new JLabel("Bem-vindo a Batalha Naval!", SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);
        
        this.novoJogo = new JButton("Nova Partida");
        this.carregarJogo = new JButton("Carregar Partida");
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.add(novoJogo);
        buttonPanel.add(carregarJogo);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        add(panel);
    }
}
