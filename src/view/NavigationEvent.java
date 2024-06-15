package view;

public class NavigationEvent {
    private String jogador1Name;
    private String jogador2Name;
    private int panelNumber;

    public NavigationEvent(String jogador1Name, String jogador2Name, int panelNumber) {
        this.jogador1Name = jogador1Name;
        this.jogador2Name = jogador2Name;
        this.panelNumber = panelNumber;
    }

    public String getJogador1Name() {
        return jogador1Name;
    }

    public String getJogador2Name() {
        return jogador2Name;
    }

    public int getPanelNumber() {
        return panelNumber;
    }
}
