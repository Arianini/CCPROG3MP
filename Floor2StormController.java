import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Floor2StormController{
    private Floor2StormModel model;
    private Floor2StormView view;
    private Floor1StormController floor1StormController;
    private Floor3StormController floor3StormController;
    
    public Floor2StormController(Floor2StormModel model, Floor2StormView view, Floor1StormController floor1Controller) {
        this.model = model;
        this.view = view;
        this.floor1StormController = floor1Controller;
        if (view == null) {
            this.view = new Floor2StormView(model, this);
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

    public void showFloor2() {
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
        if(currentTile != null && !(currentTile instanceof SpawnTile && ((SpawnTile)currentTile).isDisabled())){
            currentTile.interact(this);
        }
    }

    public void handleDoorInteraction() {
        if (model.getPlayerRow() == 6 && model.getPlayerColumn() == 3) {
            JOptionPane.showMessageDialog(view, "Returning to Floor 1");
            if (floor1StormController != null) {
                view.dispose(); // Dispose current Floor 2 view
                floor1StormController.showFloor1(); // Show Floor 1 view
            } else {
                JOptionPane.showMessageDialog(view, "Error: Cannot return to Floor 1.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Going to Floor 3");
            SwingUtilities.invokeLater(() -> {
            Floor3StormModel floor3StormModel = new Floor3StormModel();
            Floor3StormView floor3StormView = new Floor3StormView(floor3StormModel, null);
    
            Floor3StormController floor3StormController = new Floor3StormController(floor3StormModel, floor3StormView, this);
    
            floor3StormView.setController(floor3StormController);
    
            CharacterModel character = this.model.getCharacterModel();
    
            floor3StormController.startFloor3(character);
    
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

    public int getAreaIndex() {
        return 1;
    }

    public void startFloor2(CharacterModel characterModel) {
        model.setCharacterModel(characterModel);
        model.resetTiles();
        showFloor2();
    }

    private void switchToFloor1() {
        if (floor1StormController != null) {
            view.dispose(); // Dispose current Floor 2 view
            floor1StormController.showFloor1(); // Show Floor 1 view
        } else {
            JOptionPane.showMessageDialog(view, "Error: Cannot return to Floor 1.");
        }
    }

}
