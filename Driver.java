import javax.swing.SwingUtilities;

public class Driver {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TitleScreenView view = new TitleScreenView();
            CharacterModel model = new CharacterModel();
            TitleScreenController titleScreenController = new TitleScreenController(view, model);
            titleScreenController.showTitleScreen();
        });
    }
}
