import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TitleScreenView extends JFrame {
    private JButton startButton = new JButton("Start");
    private JButton exitButton = new JButton("Exit");
    private JLabel welcomeLabel = new JLabel("Welcome to Elden Rogue", JLabel.CENTER);

    public TitleScreenView() {
        // Initialize the JFrame
        setTitle("Title Screen");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        // Style the welcome label
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 20));
        welcomeLabel.setBorder(new EmptyBorder(20, 0, 10, 0));

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 50, 5, 50); // Padding for the buttons

        // Style the buttons
        startButton.setFont(new Font("Arial", Font.BOLD, 15));
        startButton.setFocusPainted(false);
        exitButton.setFont(new Font("Arial", Font.BOLD, 15));
        exitButton.setFocusPainted(false);

        // Add components to the panel
        buttonPanel.add(startButton, gbc);
        buttonPanel.add(exitButton, gbc);

        // Add components to the frame
        add(welcomeLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
