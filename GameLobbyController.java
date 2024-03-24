public class GameLobbyController {
    private GameLobbyView view;
    private CharacterModel model;

    public GameLobbyController(CharacterModel model) {
        this.model = model;
        this.view = new GameLobbyView(model);
        initView();
    }

    private void initView() {
        view.addFastTravelButtonListener(e -> fastTravel());
        view.addLevelUpButtonListener(e -> levelUp());
        view.addQuitButtonListener(e -> quitGame());
        view.setVisible(true);
    }

    private void fastTravel() {
        // Implementation for fast travel
    }

    private void levelUp() {
        // Implementation for leveling up
    }

    private void quitGame() {
        System.exit(0);
    }
}
