import java.awt.FlowLayout;

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
        setSize(400, 200);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null); // Center on screen
        add(titleLabel);
        add(stormveilCastleButton);
        add(rayaLucariaAcademyButton);
        add(theEldenThroneButton);
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
