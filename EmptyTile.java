import java.awt.Color;

public class EmptyTile extends Tile {
    public EmptyTile() {
        super(false);
    }

    @Override
    public Color getColor() {
        return Color.LIGHT_GRAY;
    }

    @Override
    public void interact(Floor1StormController controller) {
        // No action needed, player cannot move here
    }

    @Override
    public void interact(Floor2StormController controller2) {
        // No action needed, player cannot move here
    }

    @Override
    public void interact(Floor3StormController controller3) {
        // No action needed, player cannot move here
    }

    @Override
    public void interact(Floor1RayaController controller4) {
        // No action needed, player cannot move here
    }

    @Override
    public void interact(Floor2RayaController controller5) {
        // No action needed, player cannot move here
    }

    @Override
    public void interact(Floor3RayaController controller6) {
        // No action needed, player cannot move here
    }

    @Override
    public void interact(Floor4RayaController controller7) {
        // No action needed, player cannot move here
    }

    @Override
    public void interact(Floor5RayaController controller8) {
        // No action needed, player cannot move here
    }

    public void interact(Floor1EldenController controller9) {
        //do nothingss
    }
    @Override
    public void interact(Floor2EldenController controller10) {
         //do nothing
    }
    @Override
    public void interact(Floor3EldenController controller11) {
        // No action needed, player cannot move here
    }
}
