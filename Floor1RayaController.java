import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Floor1RayaController{
    private Floor1RayaModel model;
    private Floor1RayaView view;
    private GameLobbyController gameLobbyController;
    //private CharacterModel Cmodel;
    private Floor2RayaController floor2RayaController;
    

    public Floor1RayaController(Floor1RayaModel model, Floor1RayaView view, GameLobbyController gameLobbyController, Floor2RayaController floor2RayaController) {
        this.model = model;
        this.gameLobbyController = gameLobbyController;
        this.floor2RayaController = floor2RayaController;
        
        if (view == null) {
            this.view = new Floor1RayaView(model, this);
        } else {
            this.view = view;
        }
    
        initView();
    }

    private void initView() {
        view.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPressed(e);
            }
        });
        view.setFocusable(true);
        view.requestFocusInWindow();
    }

    private void travelToRayaLucaria() {
        SwingUtilities.invokeLater(() -> {
            Floor1RayaModel floor1RayaModel = new Floor1RayaModel();
            Floor1RayaView floor1RayaView = new Floor1RayaView(floor1RayaModel, this);
            if (this.view != null) {
                this.view.dispose();
            }
            this.view = floor1RayaView;
            this.view.setVisible(true);
        });
    }

    private void handleKeyPressed(KeyEvent e) {
        int newRow = model.getPlayerRow();
        int newCol = model.getPlayerColumn();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> newRow--;
            case KeyEvent.VK_S -> newRow++;
            case KeyEvent.VK_A -> newCol--;
            case KeyEvent.VK_D -> newCol++;
            case KeyEvent.VK_E -> interactWithTile();
        }
        model.movePlayer(newRow, newCol);
        view.updateView();
    }
    
    public void interactWithTile() {
        Tile currentTile = model.getTileAt(model.getPlayerRow(), model.getPlayerColumn());
        if (currentTile != null && !(currentTile instanceof SpawnTile && ((SpawnTile)currentTile).isDisabled())) {
            currentTile.interact(this);
        }
    }
    
    public void handleFastTravel() {
        view.dispose(); // Dispose the current view
        gameLobbyController.showGameLobby(); // Show the game lobby
    }
    
    public void handleDoorInteraction() {
        JOptionPane.showMessageDialog(null, "Going to Floor2");
        SwingUtilities.invokeLater(() -> {
            Floor2RayaModel floor2RayaModel = new Floor2RayaModel();
            Floor2RayaView floor2RayaView = new Floor2RayaView(floor2RayaModel, null);
    
            Floor2RayaController floor2RayaController = new Floor2RayaController(floor2RayaModel, floor2RayaView, this, gameLobbyController);
    
            floor2RayaView.setController(floor2RayaController);

            floor2RayaView.setVisible(true);
    
            CharacterModel character = this.model.getCharacterModel();
    
            floor2RayaController.startFloor2(character);
    
            this.view.setVisible(false);
        });
    }

    public void spawnEnemy() {
        int areaIndex = getAreaIndex();
        CharacterModel player = model.getCharacterModel();
        Enemy enemy = EnemyFactory.generateRandomEnemy(areaIndex);
        BattleView battleView = new BattleView();
        new BattleController(player, enemy).showBattleScreen();
    }
    
    public void spawnTreasure() {
        // Spawn treasure
        Treasure treasure = new Treasure();
        int runesGained = treasure.calculateRunesGained(getAreaIndex());
        CharacterModel character = model.getCharacterModel();
        character.addRunes(runesGained);
        new TreasureView(runesGained, character.getRunes());
        view.updateStats();
    }

    public int getAreaIndex() {
        return 2;
    }

    public void showFloor1() {
        if (view == null) {
            view = new Floor1RayaView(model, this);
        }

        view.setVisible(true);
    }
}