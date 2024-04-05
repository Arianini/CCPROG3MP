import java.awt.Color;

public class FastTravelTile extends Tile {
    public FastTravelTile() {
        super(false);
    }

    @Override
    public Color getColor() {
        return hasPlayer() ? Color.PINK : Color.GREEN;
    }

    @Override
    public void interact(Floor1StormController controller) {
        controller.handleFastTravel();
    }
    public void interact(Floor2StormController controller2) {
        //Do nothing
    }

    public void interact(Floor3StormController controller3) {
        //Do nothing
    }

    public void interact(Floor1RayaController controller4) {
        controller4.handleFastTravel();
    }
    public void interact(Floor2RayaController controller5) {
        //Do nothing
    }

    public void interact(Floor3RayaController controller6) {
        //Do nothing
    }

    public void interact(Floor4RayaController controller7) {
        //Do nothing
    }

    public void interact(Floor5RayaController controller8) {
        controller8.handleFastTravel();
    }
}