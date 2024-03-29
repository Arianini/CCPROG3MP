import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class TreasureView extends JFrame {
    public TreasureView(int runesGained, int totalRunes) {
        setTitle("Treasure Found!");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JLabel messageLabel = new JLabel(String.format(
            "<html><center>You just found a TREASURE!<br/>You gained %d runes!<br/>Total Runes: %d</center></html>",
            runesGained, totalRunes), SwingConstants.CENTER);
        panel.add(messageLabel);
        
        getContentPane().add(panel);
        setVisible(true);
    }
}
