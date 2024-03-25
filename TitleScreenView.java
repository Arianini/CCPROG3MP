import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TitleScreenView extends JFrame {
    private JButton startButton = new JButton("Start");
    private JButton exitButton = new JButton("Exit");
    private JLabel welcomeLabel = new JLabel("Welcome to Elden Rogue");

    public TitleScreenView() {
        // Initialize the JFrame
        setTitle("Title Screen");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Use FlowLayout for the buttons
        setLayout(new FlowLayout());

        add(welcomeLabel);
        add(startButton);
        add(exitButton);
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
