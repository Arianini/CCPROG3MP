import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameLobbyView extends JFrame {
    private JLabel welcomeLabel;
    private JButton fastTravelButton = new JButton("Fast Travel");
    private JButton levelUpButton = new JButton("Level Up");
    private JButton quitButton = new JButton("Quit");

    public GameLobbyView(CharacterModel character) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        welcomeLabel = new JLabel("Welcome to the Game Lobby, " + character.getPlayerName() +
                                  ". Your class is " + character.getPlayerClass().getClass().getSimpleName() + ".");
        add(welcomeLabel);
        add(fastTravelButton);
        add(levelUpButton);
        add(quitButton);
    }

    public void addFastTravelButtonListener(ActionListener listener) {
        fastTravelButton.addActionListener(listener);
    }

    public void addLevelUpButtonListener(ActionListener listener) {
        levelUpButton.addActionListener(listener);
    }

    public void addQuitButtonListener(ActionListener listener) {
        quitButton.addActionListener(listener);
    }
}
