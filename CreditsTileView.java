
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

public class CreditsTileView extends JFrame {
    private JButton exitButton = new JButton("Exit");
    private JLabel thanksLabel;
    private JLabel titleLabel;
    private JLabel developersLabel;
    private JLabel developerNameLabel1;
    private JLabel developerNameLabel2;
    private JLabel specialLabel;
    private JLabel sourceLabel;
    private JLabel dividerLabel;

    public CreditsTileView() {
        // Initialize the JFrame
        setTitle("Credits Screen");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Style the credits 
        thanksLabel = new JLabel("THANK YOU FOR PLAYING!");
        thanksLabel.setForeground(Color.WHITE);
        thanksLabel.setFont(new Font("Courier", Font.BOLD, 15));
        thanksLabel.setBorder(new EmptyBorder(20, 0, 10, 0));
        
        titleLabel = new JLabel("ELDEN ROGUE");
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        titleLabel.setBorder(new EmptyBorder(20, 0, 10, 0));

        dividerLabel = new JLabel("----------------------------");
        dividerLabel.setForeground(Color.YELLOW);
        dividerLabel.setFont(new Font("Serif", Font.BOLD, 15));
        dividerLabel.setBorder(new EmptyBorder(20, 0, 10, 0));

        developersLabel = new JLabel("DEVELOPERS");
        developersLabel.setForeground(Color.YELLOW);
        developersLabel.setFont(new Font("Courier", Font.BOLD, 15));
        developersLabel.setBorder(new EmptyBorder(20, 0, 10, 0));

        developerNameLabel1 = new JLabel("LLENAREZ, GABRIELLE DENISE D.");
        developerNameLabel1.setForeground(Color.WHITE);
        developerNameLabel1.setFont(new Font("Courier", Font.BOLD, 15));
        developerNameLabel1.setBorder(new EmptyBorder(20, 0, 10, 0));

        developerNameLabel2 = new JLabel("RANADA, ARIANNE M.");
        developerNameLabel2.setForeground(Color.WHITE);
        developerNameLabel2.setFont(new Font("Courier", Font.BOLD, 15));
        developerNameLabel2.setBorder(new EmptyBorder(20, 0, 10, 0));

       specialLabel = new JLabel("SPECIAL THANKS");
        specialLabel.setForeground(Color.YELLOW);
        specialLabel.setFont(new Font("Courier", Font.BOLD, 15));
        specialLabel.setBorder(new EmptyBorder(20, 0, 10, 0));

        /*JLabel thanksLabel = new JLabel("THANK YOU FOR PLAYING!");
        thanksLabel.setForeground(Color.WHITE);
        thanksLabel.setFont(new Font("Courier", Font.BOLD, 20));
        thanksLabel.setBorder(new EmptyBorder(20, 0, 10, 0));*/ //SOURCE LABEL

        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        //buttonPanel.setOpaque(false); 
       buttonPanel.setBackground(Color.BLACK);
       

        // Style the buttons
        exitButton.setFont(new Font("Arial", Font.BOLD, 15));
        exitButton.setFocusPainted(false);

        // Add components to the panel
        buttonPanel.add(exitButton, gbc);

        // Add components to the frame
        panel.add(thanksLabel, gbc);
        panel.add(titleLabel, gbc);
        panel.add(developersLabel, gbc);
        panel.add(dividerLabel, gbc);
        panel.add(developerNameLabel1, gbc);
        panel.add(developerNameLabel2, gbc);
        panel.add(specialLabel, gbc);
        //add(developerNameLabel2, BorderLayout.NORTH);
        add(buttonPanel, gbc);
        add(panel, gbc);
        add(panel, BorderLayout.CENTER); // Add main content panel to center
        add(buttonPanel, BorderLayout.SOUTH); // Add buttons panel to the bottom
       
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(thanksLabel, gbc);

        gbc.gridy++;
        panel.add(titleLabel, gbc);

        gbc.gridy++;
        panel.add(developersLabel, gbc);

        gbc.gridy++;
        panel.add(dividerLabel, gbc);

        gbc.gridy++;
        panel.add(developerNameLabel1, gbc);

        gbc.gridy++;
        panel.add(developerNameLabel2, gbc);

        gbc.gridy++;
        panel.add(specialLabel, gbc);

        add(buttonPanel, BorderLayout.SOUTH);
        
        setVisible(true);
 }
    public JButton getExitButton() {
        return exitButton;
    }
}


