import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FastTravelView extends JFrame {
    private JButton stormveilCastleButton = new JButton("Stormveil Castle");
    private JButton rayaLucariaAcademyButton = new JButton("Raya Lucaria Academy");
    private JButton theEldenThroneButton = new JButton("The Elden Throne");
    private JLabel titleLabel = new JLabel("Select a destination for Fast Travel:");

    public FastTravelView() {
        setTitle("Fast Travel");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setLocationRelativeTo(null); // Center on screen

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(20, 0, 20, 0);

        // Title
        add(titleLabel, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 50, 10, 50);
        
        // Stormveil Castle Button
        add(stormveilCastleButton, gbc);

        // Raya Lucaria Academy Button
        add(rayaLucariaAcademyButton, gbc);

        // The Elden Throne Button
        add(theEldenThroneButton, gbc);

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public JButton getStormveilCastleButton() {
        return stormveilCastleButton;
    }

    public JButton getRayaLucariaAcademyButton() {
        return rayaLucariaAcademyButton;
    }

    public JButton getTheEldenThroneButton() {
        return theEldenThroneButton;
    }
}
