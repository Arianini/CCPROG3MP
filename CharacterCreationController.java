import javax.swing.SwingUtilities;

public class CharacterCreationController {
    private CharacterCreationView view;
    private CharacterModel model;

    public CharacterCreationController(CharacterCreationView view, CharacterModel model) {
        this.view = view;
        this.model = model;
        initView();
    }

    private void initView() {
        view.getConfirmButton().addActionListener(e -> confirmCharacter());
        view.getBackButton().addActionListener(e -> goBack());
    }

    private void confirmCharacter() {
    model.setPlayerName(view.getNameField().getText());
    
    String jobClassName = (String) view.getJobClassComboBox().getSelectedItem();
    model.setPlayerClass(createJobClassInstance(jobClassName));
    
    // Transition to the game lobby
    SwingUtilities.invokeLater(() -> {
        view.setVisible(false); 
        GameLobbyController gameLobbyController = new GameLobbyController(model);
        gameLobbyController.showGameLobby();
        });
    }

    private JobClass createJobClassInstance(String jobClassName) {
        switch (jobClassName) {
            case "Vagabond":
                return new Vagabond();
            case "Samurai":
                return new Samurai();
            case "Warrior":
                return new Warrior();
            case "Hero":
                return new Hero();
            case "Astrologer":
                return new Astrologer();
            case "Prophet":
                return new Prophet();
            default:
                return null;
        }
    }

    private void goBack() {
        view.setVisible(false);
    }
}
