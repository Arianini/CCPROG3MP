import javax.swing.JOptionPane;

public class FastTravelController {
    private FastTravelView view;
    private CharacterModel model;

    public FastTravelController(FastTravelView view, CharacterModel model) {
        this.view = view;
        this.model = model;
        initView();
    }

    private void initView() {
        view.getStormveilCastleButton().addActionListener(e -> travelToStormveilCastle());
        view.getRayaLucariaAcademyButton().addActionListener(e -> travelToRayaLucariaAcademy());
        view.getTheEldenThroneButton().addActionListener(e -> travelToTheEldenThrone());
        view.setVisible(true);
    }

    private void travelToStormveilCastle() {
        // Implement travel logic here
        JOptionPane.showMessageDialog(view, "Traveling to Stormveil Castle...");
        view.dispose();
    }

    private void travelToRayaLucariaAcademy() {
        // Implement travel logic here
        JOptionPane.showMessageDialog(view, "Traveling to Raya Lucaria Academy...");
        view.dispose();
    }

    private void travelToTheEldenThrone() {
        // Implement travel logic here
        JOptionPane.showMessageDialog(view, "Traveling to The Elden Throne...");
        view.dispose();
    }
}
