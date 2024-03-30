import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BattleView extends JFrame {
    private JLabel playerHealthLabel, enemyHealthLabel, incomingDamageLabel;
    private JButton physicalAttackButton, sorceryAttackButton, incantationAttackButton, dodgeButton;
    private JTextArea systemMessagesArea;

    public BattleView() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Battle");
        setLayout(new BorderLayout(10, 10));
        setSize(500, 300);

        // Player and enemy health
        JPanel healthPanel = new JPanel(new GridLayout(2, 1));
        playerHealthLabel = new JLabel("Player Health: ");
        enemyHealthLabel = new JLabel("Enemy Health: ");
        incomingDamageLabel = new JLabel("Incoming Enemy Damage: ");
        healthPanel.add(playerHealthLabel);
        healthPanel.add(enemyHealthLabel);
        healthPanel.add(incomingDamageLabel);

        // Buttons for actions
        JPanel actionPanel = new JPanel();
        physicalAttackButton = new JButton("Physical Attack");
        sorceryAttackButton = new JButton("Sorcery Attack");
        incantationAttackButton = new JButton("Incantation Attack");
        dodgeButton = new JButton("Dodge");
        actionPanel.add(physicalAttackButton);
        actionPanel.add(sorceryAttackButton);
        actionPanel.add(incantationAttackButton);
        actionPanel.add(dodgeButton);

        // System messages
        systemMessagesArea = new JTextArea(10, 40);
        systemMessagesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(systemMessagesArea);

        add(healthPanel, BorderLayout.NORTH);
        add(actionPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void setPlayerHealth(int health) {
        playerHealthLabel.setText("Player Health: " + health);
    }

    public void setEnemyHealth(int health) {
        enemyHealthLabel.setText("Enemy Health: " + health);
    }

    public void setIncomingEnemyDamage(int damage) {
        incomingDamageLabel.setText("Incoming Enemy Damage: " + damage);
    }

    public void appendSystemMessage(String message) {
        systemMessagesArea.append(message + "\n");
    }

    public JButton getPhysicalAttackButton() {
        return physicalAttackButton;
    }

    public JButton getSorceryAttackButton() {
        return sorceryAttackButton;
    }

    public JButton getIncantationAttackButton() {
        return incantationAttackButton;
    }

    public JButton getDodgeButton() {
        return dodgeButton;
    }
}
