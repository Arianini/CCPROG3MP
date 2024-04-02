import java.awt.Color;

public class DoorTile extends Tile {
    public DoorTile() {
        super(false);
    }

    @Override
    public Color getColor() {
        return hasPlayer() ? Color.PINK : Color.ORANGE;
    }

    @Override
    public void interact(Floor1StormController controller) {
        controller.handleDoorInteraction();
    }

    public void interact(Floor2StormController controller2) {
        controller2.handleDoorInteraction();
    }
}