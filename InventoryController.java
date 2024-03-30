import javax.swing.JOptionPane;

public class InventoryController {
    private InventoryView view;
    private CharacterModel model;

    public InventoryController(InventoryView view, CharacterModel model) {
        this.view = view;
        this.model = model;
        initView();
    }

    private void initView(){
        view.getSelectButton().addActionListener(e -> selectWeapon());
        view.getBackButton().addActionListener(e -> goBack());
        view.setVisible(true);
    }

    private void selectWeapon() {
        Weapon selectedWeapon = view.getSelectedWeapon();
        if (selectedWeapon == null) {
            JOptionPane.showMessageDialog(view, "No weapon selected");
            return;
        }
        
        int playerDex = model.getStats().getDex();
        int weaponDex = selectedWeapon.getWeaponClass().getWeaponStats().getWDex();

        int confirmEquip = JOptionPane.showConfirmDialog(view,
                "Do you want to equip this weapon?",
                "Equip Weapon", JOptionPane.YES_NO_OPTION);
        if (confirmEquip == JOptionPane.YES_OPTION) {
            if (playerDex >= weaponDex) {
                model.equipWeapon(selectedWeapon);
                JOptionPane.showMessageDialog(view, "You have equipped " + selectedWeapon.getWeaponClass().getWeaponName());
            } else {
                JOptionPane.showMessageDialog(view, "Sorry, you do not have enough dexterity to equip this weapon");
            }
        }
    }

    private void goBack() {
        GameLobbyController gameLobbyController = new GameLobbyController(model);
        gameLobbyController.showGameLobby();
        view.dispose();
    }
}
