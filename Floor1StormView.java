import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Floor1StormView extends JFrame {
    private final Floor1StormModel model;
    private JLabel[][] tileLabels;

    public Floor1StormView(Floor1StormModel model) {
        this.model = model;
        setTitle("Floor 1 - Stormveil Castle");
        initializeView();
        updateView();
    }

    private void initializeView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel floorPanel = createFloorPanel();
        add(floorPanel, BorderLayout.CENTER);
        add(createControlPanel(), BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createFloorPanel() {
        JPanel floorPanel = new JPanel(new GridLayout(model.getRows(), model.getColumns()));
        tileLabels = new JLabel[model.getRows()][model.getColumns()];

        for (int i = 0; i < model.getRows(); i++) {
            for (int j = 0; j < model.getColumns(); j++) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                label.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                floorPanel.add(label);
                tileLabels[i][j] = label;
            }
        }
        return floorPanel;
    }

    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel(new GridLayout(1, 4));
        String[] controls = {"W", "A", "S", "D"};
        for (String control : controls) {
            JButton button = new JButton(control);
            button.addActionListener(e -> handleControlAction(control));
            controlPanel.add(button);
        }
        return controlPanel;
    }

    private void handleControlAction(String control) {
        int currentRow = model.getPlayerRow();
        int currentCol = model.getPlayerColumn();
        switch (control) {
            case "W" -> model.movePlayer(currentRow - 1, currentCol);
            case "A" -> model.movePlayer(currentRow, currentCol - 1);
            case "S" -> model.movePlayer(currentRow + 1, currentCol);
            case "D" -> model.movePlayer(currentRow, currentCol + 1);
        }
        updateView();
    }

    public void updateView() {
        for (int i = 0; i < model.getRows(); i++) {
            for (int j = 0; j < model.getColumns(); j++) {
                Tile tile = model.getTileAt(i, j);
                tileLabels[i][j].setBackground(tile.getColor());
            }
        }
    }
}
