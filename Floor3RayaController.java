import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Floor3RayaController{
    private Floor3RayaModel model;
    private Floor3RayaView view;
    private GameLobbyController gameLobbyController;
    //private CharacterModel Cmodel;
    private Floor2RayaController floor2RayaController;
    private Floor4RayaController floor4RayaController;
    private Floor5RayaController floor5RayaController;
    

    public Floor3RayaController(Floor3RayaModel model, Floor3RayaView view, Floor2RayaController floor2RayaController,
    Floor4RayaController floor4RayaController, Floor5RayaController floor5RayaController, GameLobbyController gameLobbyController) {
        this.model = model;
        this.gameLobbyController = gameLobbyController;
        this.floor2RayaController = floor2RayaController;
        this.floor4RayaController = floor4RayaController;
        this.floor5RayaController = floor5RayaController;
        
        if (view == null) {
            this.view = new Floor3RayaView(model, this);
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

    public void showFloor3(){
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

    public void handleDoorInteraction() {
        if (model.getPlayerRow() == 3 && model.getPlayerColumn() == 0) {
            JOptionPane.showMessageDialog(view, "Returning to Floor 2");
            if (floor2RayaController != null) {
                view.dispose(); // Dispose current Floor 3 view
                floor2RayaController.showFloor2(); // Show Floor 2 view
            } else {
                JOptionPane.showMessageDialog(view, "Error: Cannot return to Floor 2.");
            }
        } else if (model.getPlayerRow() == 3 && model.getPlayerColumn() == 4) {
            JOptionPane.showMessageDialog(view, "Going to Floor 4");
            SwingUtilities.invokeLater(() -> {
            Floor4RayaModel floor4RayaModel = new Floor4RayaModel();
            Floor4RayaView floor4RayaView = new Floor4RayaView(floor4RayaModel, null);
    
            Floor4RayaController floor4RayaController = new Floor4RayaController(floor4RayaModel, floor4RayaView, this);
    
            floor4RayaView.setController(floor4RayaController);
    
            CharacterModel character = this.model.getCharacterModel();
    
            floor4RayaController.startFloor4(character);
    
            this.view.setVisible(false);
            });
        } else {
            JOptionPane.showMessageDialog(view, "Going to Floor 5");
            SwingUtilities.invokeLater(() -> {
            Floor5RayaModel floor5RayaModel = new Floor5RayaModel();
            Floor5RayaView floor5RayaView = new Floor5RayaView(floor5RayaModel, null);
    
            Floor5RayaController floor5RayaController = new Floor5RayaController(floor5RayaModel, floor5RayaView, gameLobbyController, this);
    
            floor5RayaView.setController(floor5RayaController);
    
            CharacterModel character = this.model.getCharacterModel();
    
            floor5RayaController.startFloor5(character);
    
            this.view.setVisible(false);
        });
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

    public void startFloor3(CharacterModel characterModel){
        model.setCharacterModel(characterModel);
        model.resetTiles();
        showFloor3();
    }
}

