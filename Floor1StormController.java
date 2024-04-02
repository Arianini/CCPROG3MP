import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Floor1StormController{
    private Floor1StormModel model;
    private Floor1StormView view;
    private GameLobbyController gameLobbyController;
    //private CharacterModel Cmodel;
    private Floor2StormController floor2StormController;
    

    public Floor1StormController(Floor1StormModel model, Floor1StormView view, GameLobbyController gameLobbyController, Floor2StormController floor2StormController) {
        this.model = model;
        this.gameLobbyController = gameLobbyController;
        this.floor2StormController = floor2StormController;
        
        if (view == null) {
            this.view = new Floor1StormView(model, this);
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

    private void travelToStormveilCastle() {
        SwingUtilities.invokeLater(() -> {
            Floor1StormModel floor1StormModel = new Floor1StormModel();
            Floor1StormView floor1StormView = new Floor1StormView(floor1StormModel, this);
            if (this.view != null) {
                this.view.dispose();
            }
            this.view = floor1StormView;
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
            Floor2StormModel floor2StormModel = new Floor2StormModel();
            Floor2StormView floor2StormView = new Floor2StormView(floor2StormModel, null);
    
            Floor2StormController floor2StormController = new Floor2StormController(floor2StormModel, floor2StormView, this);
    
            floor2StormView.setController(floor2StormController);
    
            CharacterModel character = this.model.getCharacterModel();
    
            floor2StormController.startFloor2(character);
    
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
        return 1;
    }

    public void showFloor1() {
        if (view == null) {
            view = new Floor1StormView(model, this);
        }

        view.setVisible(true);
    }
}