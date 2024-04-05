import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Floor1EldenController {
    private Floor1EldenModel model;
    private Floor1EldenView view;
    private GameLobbyController gameLobbyController;
    private Floor2EldenController floor2EldenController;    

    public Floor1EldenController(Floor1EldenModel model, Floor1EldenView view, GameLobbyController gameLobbyController, Floor2EldenController floor2EldenController) {
        this.model = model;
        this.gameLobbyController = gameLobbyController;
        this.floor2EldenController = floor2EldenController;
        
        if (view == null) {
            this.view = new Floor1EldenView(model, this);
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

    private void travelToEldenThrone() {
        SwingUtilities.invokeLater(() -> {
            Floor1EldenModel floor1EldenModel = new Floor1EldenModel();
            Floor1EldenView floor1EldenView = new Floor1EldenView(floor1EldenModel, this);
            if (this.view != null) {
                this.view.dispose();
            }
            this.view = floor1EldenView;
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
            Floor2EldenModel floor2EldenModel = new Floor2EldenModel();
            Floor2EldenView floor2EldenView = new Floor2EldenView(floor2EldenModel, null);
    
            Floor2EldenController floor2EldenController = new Floor2EldenController(floor2EldenModel, floor2EldenView, this);
    
            floor2EldenView.setController(floor2EldenController);

            floor2EldenView.setVisible(true);
    
            CharacterModel character = this.model.getCharacterModel();
    
            floor2EldenController.startFloor2(character);
    
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
        return 3;
    }

    public void showFloor1() {
        if (view == null) {
            view = new Floor1EldenView(model, this);
        }

        view.setVisible(true);
    }
}
