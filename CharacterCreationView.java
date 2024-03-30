import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CharacterCreationView extends JFrame {
    private JTextField nameField = new JTextField(20);
    private JComboBox<String> jobClassComboBox = new JComboBox<>(new String[]{"Vagabond", "Samurai", "Warrior", "Hero", "Astrologer", "Prophet"});
    private JButton confirmButton = new JButton("Confirm");
    private JButton backButton = new JButton("Back");
    private JLabel statsLabel = new JLabel("Stats will appear here");

    public CharacterCreationView() {
        super("Character Creation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setSize(400, 300);
        setLocationRelativeTo(null);
        GridBagConstraints gbc = new GridBagConstraints();

        ((JPanel)getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Name label and field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(nameField, gbc);

        // Job class label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("Job Class:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(jobClassComboBox, gbc);

        // Stats label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(statsLabel, gbc);

        // Confirm button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        add(confirmButton, gbc);

        // Back button
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(backButton, gbc);

        pack();
    }

    // Method to update the stats display
    public void updateStatsDisplay(String statsText) {
        statsLabel.setText(statsText);
    }

    // Getter methods for components
    public JTextField getNameField() {
        return nameField;
    }

    public JComboBox<String> getJobClassComboBox() {
        return jobClassComboBox;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
