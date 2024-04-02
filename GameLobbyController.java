import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class GameLobbyController {
    private GameLobbyView view;
    private CharacterModel model;
    private SpawnTile spawnTile;

    public GameLobbyController(CharacterModel model) {
        this.view = new GameLobbyView(model);
        this.model = model;
        initView();
    }

    private void initView() {
        view.getFastTravelButton().addActionListener(e -> fastTravel());
        view.getLevelUpButton().addActionListener(e -> levelUp());
        view.getInventoryButton().addActionListener(e -> openInventory());
        view.getShopButton().addActionListener(e -> openShop());
        view.getQuitButton().addActionListener(e -> quitGame());
    } 

    public void showGameLobby() {
        if (view.isVisible()) {
            view.toFront();
            view.repaint();
        } else {
            view.setVisible(true);
        }
    }

    private void fastTravel() {
        SwingUtilities.invokeLater(() -> {
            Floor1StormModel floor1StormModel = new Floor1StormModel();
            floor1StormModel.setCharacterModel(model);
            floor1StormModel.resetTiles(); // Reset tiles before starting
            SpawnTile spawnTile = new SpawnTile();
            
            new Floor1StormController(floor1StormModel, null, this, null);
            view.setVisible(false); // Hide the lobby view
        });
    }

    private void levelUp() {
        // Implementation for leveling up
        JOptionPane.showMessageDialog(view, "Level Up feature is not implemented yet.");
    }

    private void openInventory() {
        SwingUtilities.invokeLater(() -> {
            InventoryView inventoryView = new InventoryView();
            InventoryController inventoryController = new InventoryController(inventoryView, model);
            ArrayList<Weapon> inventoryArray = new ArrayList<>(model.getInventory()); // Convert to ArrayList
            inventoryView.displayInventory(inventoryArray);
            inventoryView.setVisible(true);
        });
    }
    
    private void openShop() {
        SwingUtilities.invokeLater(() -> {
            ShopView shopView = new ShopView();
            ShopController shopController = new ShopController(shopView, model);
            //shopView.displayWeapons(getWeaponsForSale());
            shopView.setVisible(true);
        });
    }
    

    private void quitGame() {
        int confirmed = JOptionPane.showConfirmDialog(view,
                "Are you sure you want to quit the game?",
                "Exit Game",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private List<Weapon> getWeaponsForSale() {
        return new ArrayList<>();
    }

    public void returnToGameLobby() {
        if (view == null || !view.isVisible()) {
            view = new GameLobbyView(model);
            initView();
        }
        view.setVisible(true);
    }
    
}
