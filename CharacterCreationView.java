import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CharacterCreationView extends JFrame {
    private JTextField nameField = new JTextField(20);
    private JComboBox<String> jobClassComboBox = new JComboBox<>(new String[]{"Vagabond", "Samurai", "Warrior", "Hero", "Astrologer", "Prophet"});
    private JButton confirmButton = new JButton("Confirm");
    private JButton backButton = new JButton("Back");
    private JLabel statsLabel = new JLabel("Stats will appear here");

    public CharacterCreationView() {
        super("Character Creation");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null); // Center on screen

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Job Class:"));
        add(jobClassComboBox);
        add(statsLabel); 
        add(confirmButton);
        add(backButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
