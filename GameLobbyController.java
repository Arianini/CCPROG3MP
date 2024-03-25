import javax.swing.JOptionPane;

public class GameLobbyController {
    private GameLobbyView view;
    private CharacterModel model;

    public GameLobbyController(CharacterModel model) {
        this.view = new GameLobbyView(model);
        this.model = model;
        initView();
    }

    private void initView() {
        view.getFastTravelButton().addActionListener(e -> fastTravel());
        view.getLevelUpButton().addActionListener(e -> levelUp());
        //view.getInventoryButton().addActionListener(e -> openInventory());
        //view.getShopButton().addActionListener(e -> openShop());
        view.getQuitButton().addActionListener(e -> quitGame());
    }

    public void showGameLobby() {
        view.setVisible(true);
    }

    private void fastTravel() {
        FastTravelView fastTravelView = new FastTravelView();
        FastTravelController fastTravelController = new FastTravelController(fastTravelView, model);
        fastTravelView.setVisible(true);
    }

    private void levelUp() {
        // Implementation for leveling up
        JOptionPane.showMessageDialog(view, "Level Up feature is not implemented yet.");
    }

    private void quitGame() {
        int confirmed = JOptionPane.showConfirmDialog(view,
                "Are you sure you want to quit the game?",
                "Exit Game",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
