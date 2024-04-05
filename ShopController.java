import javax.swing.JOptionPane;

public class ShopController {
    private ShopView view;
    private CharacterModel model;

    public ShopController(ShopView view, CharacterModel model){
        this.view = view;
        this.model = model;
        initView();
    }

    private void initView(){
        view.getBuyButton().addActionListener(e -> purchaseWeapon());
        view.getBackButton().addActionListener(e -> backButton());
        view.setVisible(true);
    }

    private void purchaseWeapon(){
        Weapon selectedWeapon = view.getSelectedWeapon();

        if(selectedWeapon != null){
            int confirmPurchase = JOptionPane.showConfirmDialog(view,
                "Are you sure you want to purchase this weapon?",
                "Purchase Weapon", JOptionPane.YES_NO_OPTION);
            
            if(confirmPurchase == JOptionPane.YES_OPTION) {
                WeaponClass weaponclass = selectedWeapon.getWeaponClass();
                int weaponCost = selectedWeapon.getWeaponClass().getWeaponCost();
                if(model.spendRunes(weaponCost)) {
                    model.addWeapon(weaponclass);
                    JOptionPane.showMessageDialog(view, "You have purchased " + weaponclass.getClass().getSimpleName());
                } else {
                    JOptionPane.showMessageDialog(view, "Sorry, you do not have enough runes to purchase this.");
                }
            }
        }
    }

    private void backButton(){
        view.dispose();
        GameLobbyController gameLobbyController = new GameLobbyController(model);
        gameLobbyController.showGameLobby();
    }
}
