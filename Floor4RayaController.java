import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

public class Floor4RayaController{
    private Floor4RayaModel model;
    private Floor4RayaView view;
    //private CharacterModel Cmodel;
    private Floor3RayaController floor3RayaController;
    

    public Floor4RayaController(Floor4RayaModel model, Floor4RayaView view, Floor3RayaController floor3RayaController) {
        this.model = model;
        this.floor3RayaController = floor3RayaController;
        
        if (view == null) {
            this.view = new Floor4RayaView(model, this);
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
    
    public void handleDoorInteraction() {
        if (floor3RayaController != null) {
            view.dispose(); // Dispose current Floor 3 view
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

    public void startFloor4(CharacterModel characterModel){
        model.setCharacterModel(characterModel);
        model.resetTiles();
        showFloor3();
    }
}

