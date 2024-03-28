import javax.swing.SwingUtilities;

public class TitleScreenController {
    private TitleScreenView view;
    private CharacterModel model;

    public TitleScreenController(TitleScreenView view, CharacterModel model) {
        this.view = view;
        this.model = model;
        initView();
    }

    private void initView() {
        // Initialization code, such as setting up listeners
        view.getStartButton().addActionListener(e -> startGame());
        view.getExitButton().addActionListener(e -> System.exit(0));
    }

    private void startGame() {
        SwingUtilities.invokeLater(() -> {
            view.setVisible(false); // Hide title screen
            CharacterCreationView characterCreationView = new CharacterCreationView();
            CharacterCreationController characterCreationController = new CharacterCreationController(characterCreationView, model);
            characterCreationView.setVisible(true);
        });
    }


    public void showTitleScreen() {
        view.setVisible(true);
    }
}
