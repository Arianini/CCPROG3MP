import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

public class Floor5RayaController{
    private Floor5RayaModel model;
    private Floor5RayaView view;
    private GameLobbyController gameLobbyController;
    //private CharacterModel Cmodel;
    private Floor3RayaController floor3RayaController;
    

    public Floor5RayaController(Floor5RayaModel model, Floor5RayaView view, GameLobbyController gameLobbyController, Floor3RayaController floor3RayaController) {
        this.model = model;
        this.view = view;
        this.gameLobbyController = gameLobbyController;
        this.floor3RayaController = floor3RayaController;
        
        if (view == null) {
            this.view = new Floor5RayaView(model, this);
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

    private void showFloor3(){
        if (view.isVisible()) {
            view.toFront();
            view.repaint();
        } else {
            view.setVisible(true);
        }
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
        if (floor3RayaController != null) {
            view.dispose(); // Dispose current Floor 5 view
            floor3RayaController.showFloor3(); // Show Floor 3 view
        } else {
            JOptionPane.showMessageDialog(view, "Error: Cannot return to Floor 3.");
        }
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
    //spawn boss

    public int getAreaIndex() {
        return 2;
    }

    public void startFloor5(CharacterModel characterModel){
        model.setCharacterModel(characterModel);
        model.resetTiles();
        showFloor3();
    }
}

