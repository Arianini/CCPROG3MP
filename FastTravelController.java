import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class FastTravelController {
    private FastTravelView view;
    private CharacterModel model;
    private GameLobbyController gameLobbyController;
    private Floor1StormController floor1StormController;

    public FastTravelController(FastTravelView view, CharacterModel model, GameLobbyController gameLobbyController) {
        this.view = view;
        this.model = model;
        this.gameLobbyController = gameLobbyController;
        initView();
    }

    private void initView() {
        view.getStormveilCastleButton().addActionListener(e -> travelToStormveilCastle());
        view.getRayaLucariaAcademyButton().addActionListener(e -> travelToRayaLucariaAcademy());
        view.getTheEldenThroneButton().addActionListener(e -> travelToTheEldenThrone());
        view.getBackButton().addActionListener(e -> goBackToGameLobby());
        view.setVisible(true);

        view.getBackButton().addActionListener(e -> goBackToGameLobby());
    }
    
    private void travelToStormveilCastle() {
        SwingUtilities.invokeLater(() -> {
            Floor1StormModel floor1StormModel = new Floor1StormModel();
            Floor1StormView floor1StormView = new Floor1StormView(floor1StormModel, floor1StormController);
            Floor1StormController controller = new Floor1StormController(floor1StormModel, floor1StormView, gameLobbyController);
            floor1StormView.setVisible(true);
            view.dispose(); // Close the FastTravelView
        });
    }
    

    private void travelToRayaLucariaAcademy() {
        // Implement travel logic here
        JOptionPane.showMessageDialog(view, "Traveling to Raya Lucaria Academy...");
        view.dispose();
    }

    private void travelToTheEldenThrone() {
        // Implement travel logic here
        JOptionPane.showMessageDialog(view, "Traveling to The Elden Throne...");
        view.dispose();
    }

    private void goBackToGameLobby() {
        view.dispose();
        gameLobbyController.showGameLobby();
    }
}
