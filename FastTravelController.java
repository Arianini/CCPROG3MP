import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class FastTravelController {
    private FastTravelView view;
    private CharacterModel model;
    private GameLobbyController gameLobbyController;
    private Floor1StormController floor1StormController;
    private Floor1RayaController floor1RayaController;

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
            floor1StormModel.setCharacterModel(model);
            floor1StormModel.resetTiles(); // Reset tiles before starting
            SpawnTile spawnTile = new SpawnTile();
            
            new Floor1StormController(floor1StormModel, null, gameLobbyController, null);
            view.setVisible(false); // Hide the lobby view
        });
    }
    

    private void travelToRayaLucariaAcademy() {
        SwingUtilities.invokeLater(() -> {
            Floor1RayaModel floor1RayaModel = new Floor1RayaModel();
            floor1RayaModel.setCharacterModel(model);
            floor1RayaModel.resetTiles(); // Reset tiles before starting
            SpawnTile spawnTile = new SpawnTile();
            
            new Floor1RayaController(floor1RayaModel, null, gameLobbyController, null);
            view.setVisible(false); // Hide the lobby view
        });
    }

    private void travelToTheEldenThrone() {
        SwingUtilities.invokeLater(() -> {
            Floor1EldenModel floor1EldenModel = new Floor1EldenModel();
            floor1EldenModel.setCharacterModel(model);
            floor1EldenModel.resetTiles(); // Reset tiles before starting
            SpawnTile spawnTile = new SpawnTile();
            
            new Floor1EldenController(floor1EldenModel, null, gameLobbyController, null);
            view.setVisible(false); // Hide the lobby view
        });
    }

    private void goBackToGameLobby() {
        view.dispose();
        gameLobbyController.showGameLobby();
    }
}
