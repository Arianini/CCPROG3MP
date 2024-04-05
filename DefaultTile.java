import java.awt.Color;

public class DefaultTile extends Tile {
    public DefaultTile() {
        super(false);
    }

    @Override
    public Color getColor() {
        return hasPlayer() ? Color.PINK : Color.BLACK;
    }

    @Override
    public void interact(Floor1StormController controller) {
        // No interaction for default tile
    }

    public void interact(Floor2StormController controller2) {
        // No specific interaction for default tile on Floor 2
    }

    public void interact(Floor3StormController controller3) {
        // No specific interaction for default tile on Floor 2
    }

    public void interact(Floor1RayaController controller4) {
        // No specific interaction for default tile on Floor 2
    }

    public void interact(Floor2RayaController controller5) {
        // No specific interaction for default tile on Floor 2
    }

    public void interact(Floor3RayaController controller6) {
        // No specific interaction for default tile on Floor 2
    }

    public void interact(Floor4RayaController controller7) {
        // No specific interaction for default tile on Floor 2
    }

    public void interact(Floor5RayaController controller8) {
        // No specific interaction for default tile on Floor 2
    }
}