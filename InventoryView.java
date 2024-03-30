
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class InventoryView extends JFrame{
    private CharacterModel model;
    private Weapon selectedWeapon;
    private JPanel panel;
    private JLabel inventoryLabel;
    private JLabel weaponLabel;
    private JLabel weaponStatsLabel;
    private JButton selectButton;
    private JButton backButton;
    private int imageWidth = 100;
    private int imageHeight = 120;
    
    
    public InventoryView(){
        selectedWeapon = null;
        setTitle("INVENTORY");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        inventoryLabel = new JLabel("INVENTORY");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 2, 2, 2);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(inventoryLabel, gbc);

        gbc.gridy++;

        JLabel weaponLabel = new JLabel("No weapon selected");
        JLabel weaponStatsLabel = new JLabel("34 ");

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 5;
        panel.add(weaponLabel, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 5;
        panel.add(weaponStatsLabel, gbc);


        gbc.gridy++;
        selectButton = new JButton("[1] SELECT");
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(selectButton, gbc);

        gbc.gridx++;
        backButton = new JButton("[2] BACK");
        panel.add(backButton, gbc);

        add(panel);

    }
    
    public void displayInventory(List<Weapon> weapons) {
        weapons.forEach(this::addWeaponImage);
    }

    public void addWeaponImage(Weapon weapon) {
        ImageIcon weaponIcon = new ImageIcon(weapon.getImagePath());
        Image scaledImage = weaponIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JButton weaponButton = new JButton(scaledIcon);
        weaponButton.setContentAreaFilled(false);
        weaponButton.addActionListener(e -> {
            selectedWeapon = weapon;
            JOptionPane.showMessageDialog(this, "You have selected: " + weapon.getWeaponClass().getWeaponName());
            weaponLabel.setText("Selected Weapon: " + weapon.getWeaponClass().getWeaponName());
            weaponStatsLabel.setText("Stats: " + weapon.getWeaponClass().getWeaponStats().toString());
        });
        panel.add(weaponButton);
        panel.revalidate();
    }

    public void addSelectButton(ActionListener listener) {
        selectButton.addActionListener(listener);
    }

    public JButton getSelectButton() {
        return selectButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public Weapon getSelectedWeapon() {
        return this.selectedWeapon;
    }
}