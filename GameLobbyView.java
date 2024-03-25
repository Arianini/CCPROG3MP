import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameLobbyView extends JFrame {
    private JLabel welcomeLabel;
    private JButton fastTravelButton = new JButton("[1] Fast Travel");
    private JButton levelUpButton = new JButton("[2] Level Up");
    private JButton inventoryButton = new JButton("[3] Inventory");
    private JButton shopButton = new JButton("[4] Shop");
    private JButton quitButton = new JButton("[5] Quit");

    public GameLobbyView(CharacterModel character) {
        super("Game Lobby");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        welcomeLabel = new JLabel("Welcome " + character.getPlayerName() +
                                  ", you are a " + character.getPlayerClass().getClass().getSimpleName(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 16));
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(welcomeLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy++;
        add(fastTravelButton, gbc);
        
        gbc.gridx++;
        add(levelUpButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(inventoryButton, gbc);
        
        gbc.gridx++;
        add(shopButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(quitButton, gbc);
    }

    public void addFastTravelButtonListener(ActionListener listener) {
        fastTravelButton.addActionListener(listener);
    }

    public void addLevelUpButtonListener(ActionListener listener) {
        levelUpButton.addActionListener(listener);
    }

    public void addInventoryButtonListener(ActionListener listener) {
        inventoryButton.addActionListener(listener);
    }

    public void addShopButtonListener(ActionListener listener) {
        shopButton.addActionListener(listener);
    }

    public void addQuitButtonListener(ActionListener listener) {
        quitButton.addActionListener(listener);
    }

    public JButton getFastTravelButton() {
        return fastTravelButton;
    }

    public JButton getLevelUpButton() {
        return levelUpButton;
    }

    public JButton getInventoryButton() {
        return inventoryButton;
    }

    public JButton getShopButton() {
        return shopButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }
}
