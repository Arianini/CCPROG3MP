import javax.swing.JOptionPane;
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
        view.getJobClassComboBox().addActionListener(e -> updateStatsDisplay());
        updateStatsDisplay();
    }

    private void updateStatsDisplay() {
        String selectedClass = (String) view.getJobClassComboBox().getSelectedItem();
        JobClass jobClassInstance = createJobClassInstance(selectedClass);
        if (jobClassInstance != null) {
            view.updateStatsDisplay(jobClassInstance.getStats().toString());
        }
    }

    private void confirmCharacter() {
        String name = view.getNameField().getText().trim();
    
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Error: Name should be at least 1 character long.");
            return;
        }
    
        if (name.length() > 25) {
            JOptionPane.showMessageDialog(view, "Note: Name will be truncated to 25 characters.");
            name = name.substring(0, 25);
        }
    
        String jobClassName = (String) view.getJobClassComboBox().getSelectedItem();
        JobClass jobClassInstance = createJobClassInstance(jobClassName);

        model.setPlayerName(name);
        model.initializeCharacter(jobClassInstance); // Initialize the character with the selected job class

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
        view.dispose();
        TitleScreenView titleScreenView = new TitleScreenView();
        new TitleScreenController(titleScreenView, new CharacterModel()).showTitleScreen();
    }
}
