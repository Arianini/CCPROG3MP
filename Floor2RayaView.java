import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Floor2RayaView extends JFrame {
    private final Floor2RayaModel model;
    private Floor2RayaController controller;
    private JLabel[][] tileLabels;
    private JLabel areaNameLabel;
    private JLabel areaGridLabel;
    private JLabel tockenLabel;
    private JLabel healthLabel;
    private JLabel levelLabel;
    private JLabel runesLabel;
    //private JLabel systmMsgLabel; wala pa
    private JLabel controlsLabel;

    public Floor2RayaView(Floor2RayaModel model, Floor2RayaController controller) {
        this.model = model;
        this.controller = controller;
        setTitle("Floor 2 - Raya Lucaria Academy");
        initializeView();
        updateView();
    }

    private void initializeView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel floorPanel = createFloorPanel();
        add(floorPanel, BorderLayout.CENTER);

        JPanel controlPanel = createControlPanel();
        add(controlPanel, BorderLayout.SOUTH);

        JPanel playerStatsPanel = createPlayerStatsPanel();
        add(playerStatsPanel, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void updateStats() {
        CharacterModel character = model.getCharacterModel();
        healthLabel.setText("Health: " + character.getStats().getHp()); //bug this.health is null
        levelLabel.setText("Level: " + character.getStats().getLevel());
        runesLabel.setText("Runes: " + character.getRunes());
       
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
    private JPanel createPlayerStatsPanel() {
        JPanel playerStatsPanel = new JPanel();
        playerStatsPanel.setLayout(new BoxLayout(playerStatsPanel, BoxLayout.Y_AXIS));
        playerStatsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        areaNameLabel = new JLabel("Area Name: " +model.getAreaName());
        areaGridLabel = new JLabel("Area Grid: "+model.getRows() + "x" +model.getColumns());

        CharacterModel character = model.getCharacterModel(); 
        if(character != null){
       // tockenLabel = new JLabel("Player Tocken: " +character.getPlayerClass().getClass().getSimpleName() + " 'P'");
        healthLabel = new JLabel("Health: " + character.getStats().getHp());
        levelLabel = new JLabel("Level: " + character.getStats().getLevel());
        runesLabel = new JLabel("Runes: " + character.getRunes());
        }
        else{
            healthLabel = new JLabel("Health: ");
            levelLabel = new JLabel("Level: ");
            runesLabel = new JLabel("Runes: ");
        }
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        areaNameLabel.setFont(labelFont);
        areaGridLabel.setFont(labelFont);
       // tockenLabel.setFont(labelFont);
        healthLabel.setFont(labelFont);
        levelLabel.setFont(labelFont);
        runesLabel.setFont(labelFont);
       // systemmsgLabel.setFont(labelFont); //where to get
    
       areaNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
       areaGridLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
       //tockenLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        healthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        levelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        runesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        JLabel controlInstructions = new JLabel(
            "<html><div style='text-align: center;'>Controls:<br/>W - Up<br/>A - Left<br/>S - Down<br/>D - Right<br/>E - Interact</div></html>",
            SwingConstants.CENTER);
        controlInstructions.setFont(new Font("Arial", Font.PLAIN, 12));
        controlInstructions.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        TitledBorder titleBorder = BorderFactory.createTitledBorder("Player Stats");
        titleBorder.setTitleJustification(TitledBorder.CENTER);
    
        playerStatsPanel.setBorder(BorderFactory.createCompoundBorder(
                titleBorder,
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    
        playerStatsPanel.add(areaNameLabel);
        playerStatsPanel.add(Box.createVerticalStrut(5)); // Spacer
        playerStatsPanel.add(areaGridLabel);
        playerStatsPanel.add(Box.createVerticalStrut(5)); // Spacer
        //playerStatsPanel.add(tockenLabel);
        //playerStatsPanel.add(Box.createVerticalStrut(5)); // Spacer
        playerStatsPanel.add(healthLabel);
        playerStatsPanel.add(Box.createVerticalStrut(5)); // Spacer
        playerStatsPanel.add(levelLabel);
        playerStatsPanel.add(Box.createVerticalStrut(5)); // Spacer
        playerStatsPanel.add(runesLabel);
        playerStatsPanel.add(Box.createVerticalStrut(10)); // Spacer for controls label
        playerStatsPanel.add(controlInstructions);
    
        return playerStatsPanel;
    }
 
    
    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel(new GridLayout(1, 4));
        String[] controls = {"A", "W", "S", "D"};
        for (String control : controls) {
            JButton button = new JButton(control);
            button.addActionListener(e -> {
                handleControlAction(control);
                requestFocusInWindow();
            });
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

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            requestFocusInWindow();
        }
    }

    @Override
    public void requestFocus() {
        super.requestFocus();
        requestFocusInWindow();
    }

    public void updateView() {
        for (int i = 0; i < model.getRows(); i++) {
            for (int j = 0; j < model.getColumns(); j++) {
                Tile tile = model.getTileAt(i, j);
                JLabel tileLabel = tileLabels[i][j];
                tileLabel.setBackground(tile.getColor());
                tileLabel.setText("");
    
                if (tile instanceof FastTravelTile) {
                    tileLabel.setText(tile.hasPlayer() ? "P" : "F");
                } else if (tile instanceof DoorTile) {
                    tileLabel.setText(tile.hasPlayer() ? "P" : "D");
                } else if (tile instanceof SpawnTile) {
                    tileLabel.setText(tile.hasPlayer() ? "P" : "S");
                } else if (tile.hasPlayer()) {
                    tileLabel.setText("P");
                }
                tileLabel.setHorizontalAlignment(JLabel.CENTER);
            }
        }
    }
    public void setController(Floor2RayaController controller) {
        this.controller = controller;
    }


}