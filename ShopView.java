
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ShopView extends JFrame{
    private Weapon selectedWeapon;
    private JButton buyButton;
    private JPanel panel;
    private JLabel shopLabel;
    private JLabel weaponLabel;
    private JLabel weaponCostLabel;
    private JLabel weaponStatsLabel;
    
    public ShopView(){
        selectedWeapon = null;
        setTitle("SHOP");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        shopLabel = new JLabel("Welcome to the Shop");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 2, 2, 2);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(shopLabel, gbc);

        JLabel swordLabel = new JLabel("SWORDS");
        gbc.gridy++;
        panel.add(swordLabel, gbc);

        gbc.gridwidth = 1;

        int imageWidth = 100;
        int imageHeight = 120;
        gbc.gridy++;

        JLabel weaponLabel = new JLabel("No weapon selected");
        JLabel weaponCostLabel = new JLabel(" ");
        JLabel weaponStatsLabel = new JLabel(" ");

        Weapon[] swords = {
            new Weapon("shortsword.png", new ShortSword()),
            new Weapon("rogiersrapier.png", new RogiersRapier()),
            new Weapon("codedsword.png", new codedSword()),
            new Weapon("swordofnightandflame.png", new swordOfNightAndFlame()),
        };

        int column = 0;
        int row = gbc.gridy;

        for(Weapon sword: swords)
        {
            ImageIcon swordIcon = new ImageIcon(sword.getImagePath());
            Image scaledImage = swordIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JButton swordButton = new JButton(scaledIcon);
            swordButton.setContentAreaFilled(false);
    
                ActionListener listener = new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        JOptionPane.showMessageDialog(ShopView.this, "You have selected "+ sword.getWeaponClass().getWeaponName());
                        selectedWeapon = sword;
                        weaponLabel.setText("Selected Weapon: "+selectedWeapon.getWeaponClass().getWeaponName());
                        weaponCostLabel.setText("COST: "+ selectedWeapon.getWeaponClass().getWeaponCost());
                        weaponStatsLabel.setText("STATS: "+ selectedWeapon.getWeaponClass().getWeaponStats().toString());
                    }
                };
    
                swordButton.addActionListener(listener);
                
            gbc.gridx = column;
            gbc.gridy = row;
            panel.add(swordButton, gbc);

            column++;

        }
      
        JLabel katanaLabel = new JLabel("KATANAS");
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(katanaLabel, gbc);

        Weapon[] katanas = {
            new Weapon("uchigatana.png", new Uchigatana()),
            new Weapon("moonveil.png", new Moonveil()),
            new Weapon("riversofblood.png", new riversOfBlood()),
            new Weapon("handofmalenia.png", new handOfMalenia())
        };

        column = 0;
        row = gbc.gridy + 1;

        for(Weapon katana: katanas)
        {
            ImageIcon katanaIcon = new ImageIcon(katana.getImagePath());
            Image scaledImage = katanaIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JButton katanaButton = new JButton(scaledIcon);
            katanaButton.setContentAreaFilled(false);
    
                ActionListener listener = new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        selectedWeapon = katana;
                        JOptionPane.showMessageDialog(ShopView.this, "You have selected "+ katana.getWeaponClass().getWeaponName());
                        weaponLabel.setText("Selected Weapon: "+selectedWeapon.getWeaponClass().getWeaponName());
                        weaponCostLabel.setText("COST: "+ selectedWeapon.getWeaponClass().getWeaponCost());
                        weaponStatsLabel.setText("STATS: "+ selectedWeapon.getWeaponClass().getWeaponStats().toString());
                    }
                };
    
                katanaButton.addActionListener(listener);
    

            gbc.gridx = column;
            gbc.gridy = row;
            panel.add(katanaButton, gbc);

            
            column++;
        }

        JLabel whipLabel = new JLabel("WHIPS");
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(whipLabel, gbc);

        Weapon[] whips = {
            new Weapon("whip.png", new Whip()),
            new Weapon("urumi.png", new Urumi()),
            new Weapon("thornedwhip.png", new ThornedWhip()),
            new Weapon("hoslows.png", new HoslowsPetalWhip())
        };

        column = 0;
        row = gbc.gridy + 1;

        for(Weapon whip: whips)
        {
            ImageIcon whipIcon = new ImageIcon(whip.getImagePath());
            Image scaledImage = whipIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JButton whipButton = new JButton(scaledIcon);
            whipButton.setContentAreaFilled(false);
    
                ActionListener listener = new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        selectedWeapon = whip;
                        JOptionPane.showMessageDialog(ShopView.this, "You have selected "+ whip.getWeaponClass().getWeaponName());
                        weaponLabel.setText("Selected Weapon: "+selectedWeapon.getWeaponClass().getWeaponName());
                        weaponCostLabel.setText("COST: "+ selectedWeapon.getWeaponClass().getWeaponCost());
                        weaponStatsLabel.setText("STATS: "+ selectedWeapon.getWeaponClass().getWeaponStats().toString());
                    }
                };
    
                whipButton.addActionListener(listener);
    

            gbc.gridx = column;
            gbc.gridy = row;
            panel.add(whipButton, gbc);

            
            column++;
        }


        JLabel gswordLabel = new JLabel("GREATSWORDS");
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(gswordLabel, gbc);

        Weapon[] greatSwords = {
            new Weapon("claymore.png", new Claymore()),
            new Weapon("starscourge.png", new Starscourge()),
            new Weapon("inseparable.png", new InseparableSword()),
            new Weapon("maliketh.png", new Maliketh())
        };

        column = 0;
        row = gbc.gridy + 1;

        for(Weapon greatSword: greatSwords)
        {
            ImageIcon greatSwordIcon = new ImageIcon(greatSword.getImagePath());
            Image scaledImage = greatSwordIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JButton greatSwordButton = new JButton(scaledIcon);
            greatSwordButton.setContentAreaFilled(false);
    
                ActionListener listener = new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        selectedWeapon = greatSword;
                        JOptionPane.showMessageDialog(ShopView.this, "You have selected "+ greatSword.getWeaponClass().getWeaponName());
                        weaponLabel.setText("Selected Weapon: "+selectedWeapon.getWeaponClass().getWeaponName());
                        weaponCostLabel.setText("COST: "+ selectedWeapon.getWeaponClass().getWeaponCost());
                        weaponStatsLabel.setText("STATS: "+ selectedWeapon.getWeaponClass().getWeaponStats().toString());
                    }
                };
    
                greatSwordButton.addActionListener(listener);
    

            gbc.gridx = column;
            gbc.gridy = row;
            panel.add(greatSwordButton, gbc);

            
            column++;
        }

        JLabel stavesLabel = new JLabel("STAVES");
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(stavesLabel, gbc);

        Weapon[] staves = {
            new Weapon("astrologerstaff.png", new AstrologersStaff()),
            new Weapon("albinauric.png", new Albinauric()),
            new Weapon("staffoftheguilty.png", new Staffoftheguilty()),
            new Weapon("carian.png", new CarianRegal())
        };

        column = 0;
        row = gbc.gridy + 1;

        for(Weapon staff: staves)
        {
            ImageIcon staffIcon = new ImageIcon(staff.getImagePath());
            Image scaledImage = staffIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JButton staffButton = new JButton(scaledIcon);
            staffButton.setContentAreaFilled(false);
    
                ActionListener listener = new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        selectedWeapon = staff;
                        JOptionPane.showMessageDialog(ShopView.this, "You have selected "+ staff.getWeaponClass().getWeaponName());
                        weaponLabel.setText("Selected Weapon: "+selectedWeapon.getWeaponClass().getWeaponName());
                        weaponCostLabel.setText("COST: "+ selectedWeapon.getWeaponClass().getWeaponCost());
                        weaponStatsLabel.setText("STATS: "+ selectedWeapon.getWeaponClass().getWeaponStats().toString());
                    }
                };
    
                staffButton.addActionListener(listener);
    

            gbc.gridx = column;
            gbc.gridy = row;
            panel.add(staffButton, gbc);

            
            column++;
        }

        JLabel sealLabel = new JLabel("SEALS");
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(sealLabel, gbc);

        Weapon[] seals = {
            new Weapon("fingerseal.png", new FingerSeal()),
            new Weapon("godslayer.png", new GodslayersSeal()),
            new Weapon("golden.png", new GoldenOrderSeal()),
            new Weapon("dragon.png", new DragonCommunionSeal())
        };

        column = 0;
        row = gbc.gridy + 1;

        for(Weapon seal: seals)
        {
            ImageIcon sealIcon = new ImageIcon(seal.getImagePath());
            Image scaledImage = sealIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JButton sealButton = new JButton(scaledIcon);
            sealButton.setContentAreaFilled(false);
    
                ActionListener listener = new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        selectedWeapon = seal;
                        JOptionPane.showMessageDialog(ShopView.this, "You have selected "+ seal.getWeaponClass().getWeaponName());
                        weaponLabel.setText("Selected Weapon: "+selectedWeapon.getWeaponClass().getWeaponName());
                        weaponCostLabel.setText("COST: "+ selectedWeapon.getWeaponClass().getWeaponCost());
                        weaponStatsLabel.setText("STATS: "+ selectedWeapon.getWeaponClass().getWeaponStats().toString());
                    }
                };

            sealButton.addActionListener(listener);

            gbc.gridx = column;
            gbc.gridy = row;
            panel.add(sealButton, gbc);

            column++;
        }

        
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 5;
        panel.add(weaponLabel, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 5;
        panel.add(weaponCostLabel, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 5;
        panel.add(weaponStatsLabel, gbc);
        
        gbc.gridy++;
        buyButton = new JButton("Buy");
        gbc.gridx = 0;
        gbc.gridwidth = 5;
        panel.add(buyButton, gbc);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        setVisible(true);
    }

   /* public void displayWeapons(List<Weapon> weapons) {
        panel.removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Loop through each weapon in the list and create a button for it
        for (Weapon weapon : weapons) {
            JButton weaponButton = new JButton();
            weaponButton.setText(weapon.getWeaponClass().getWeaponName()); // Set button text to weapon name
            weaponButton.addActionListener(e -> {
                selectedWeapon = weapon; // Set the selected weapon
                weaponLabel.setText("Selected Weapon: " + weapon.getWeaponClass().getWeaponName());
                weaponCostLabel.setText("Cost: " + weapon.getWeaponClass().getWeaponCost());
                weaponStatsLabel.setText("Stats: " + weapon.getWeaponClass().getWeaponStats().toString());
            });

            panel.add(weaponButton, gbc);
        }
        panel.revalidate();
        panel.repaint();
    }*/ 


    public void addBuybutton(ActionListener listener){
        buyButton.addActionListener(listener);
    }

    public JButton getBuyButton() {
        return buyButton;
    }

    public Weapon getSelectedWeapon() {
        return selectedWeapon;
    }
}

