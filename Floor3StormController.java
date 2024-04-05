import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

public class Floor3StormController{
    private Floor3StormModel model;
    private Floor3StormView view;
    //private CharacterModel Cmodel;
    private Floor2StormController floor2StormController;
    

    public Floor3StormController(Floor3StormModel model, Floor3StormView view, Floor2StormController floor2StormController) {
        this.model = model;
        this.floor2StormController = floor2StormController;
        
        if (view == null) {
            this.view = new Floor3StormView(model, this);
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
    
    /*public void handleFastTravel() {
        view.dispose(); // Dispose the current view
       // if(bossTile is defeated else unlocked)
        gameLobbyController.showGameLobby(); // Show the game lobby
    }*/
    
    public void handleDoorInteraction() {
        if (floor2StormController != null) {
            view.dispose(); // Dispose current Floor 3 view
            floor2StormController.showFloor2(); // Show Floor 2 view
        } else {
            JOptionPane.showMessageDialog(view, "Error: Cannot return to Floor 2.");
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
        return 1;
    }

    public void startFloor3(CharacterModel characterModel){
        model.setCharacterModel(characterModel);
        model.resetTiles();
        showFloor3();
    }
}

