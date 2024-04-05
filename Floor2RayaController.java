import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Floor2RayaController{
    private Floor2RayaModel model;
    private Floor2RayaView view;
    private GameLobbyController gameLobbyController;
    private Floor1RayaController floor1RayaController;
    private Floor3RayaController floor3RayaController;
    
    public Floor2RayaController(Floor2RayaModel model, Floor2RayaView view, Floor1RayaController floor1Controller, GameLobbyController gameLobbyController) {
        this.model = model;
        this.view = view;
        this.gameLobbyController = gameLobbyController;
        this.floor1RayaController = floor1Controller;
        if (view == null) {
            this.view = new Floor2RayaView(model, this);
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
        if (model.getPlayerRow() == 0 && model.getPlayerColumn() == 1) {
            JOptionPane.showMessageDialog(view, "Returning to Floor 1");
            if (floor1RayaController != null) {
                view.dispose(); // Dispose current Floor 2 view
                floor1RayaController.showFloor1(); // Show Floor 1 view
            } else {
                JOptionPane.showMessageDialog(view, "Error: Cannot return to Floor 1.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Going to Floor 3");
            SwingUtilities.invokeLater(() -> {
            Floor3RayaModel floor3RayaModel = new Floor3RayaModel();
            Floor3RayaView floor3RayaView = new Floor3RayaView(floor3RayaModel, null);
    
            Floor3RayaController floor3RayaController = new Floor3RayaController(floor3RayaModel, floor3RayaView, this, null, null, gameLobbyController);
    
            floor3RayaView.setController(floor3RayaController);
    
            CharacterModel character = this.model.getCharacterModel();
    
            floor3RayaController.startFloor3(character);
    
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
        return 2;
    }

    public void startFloor2(CharacterModel characterModel) {
        model.setCharacterModel(characterModel);
        model.resetTiles();
        showFloor2();
    }

    private void switchToFloor1() {
        if (floor1RayaController != null) {
            view.dispose(); // Dispose current Floor 2 view
            floor1RayaController.showFloor1(); // Show Floor 1 view
        } else {
            JOptionPane.showMessageDialog(view, "Error: Cannot return to Floor 1.");
        }
    }

}
