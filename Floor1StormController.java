import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Floor1StormController {
    private Floor1StormModel model;
    private Floor1StormView view;
    private GameLobbyController gameLobbyController;

    public Floor1StormController(Floor1StormModel model, Floor1StormView view, GameLobbyController gameLobbyController) {
        this.model = model;
        this.gameLobbyController = gameLobbyController;
        
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
        if (currentTile != null) {
            currentTile.interact(this);
        }
    }
    
    public void handleFastTravel() {
        view.dispose(); // Dispose the current view
        gameLobbyController.showGameLobby(); // Show the game lobby
    }
    
    public void handleDoorInteraction() {
        JOptionPane.showMessageDialog(null, "Going to Floor2");
    }
}