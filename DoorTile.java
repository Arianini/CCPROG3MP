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
    @Override
    public void interact(Floor2StormController controller2) {
        controller2.handleDoorInteraction();
 
    }
    @Override
    public void interact(Floor3StormController controller3) {
        controller3.handleDoorInteraction();
    }
    @Override
    public void interact(Floor1RayaController controller4) {
        controller4.handleDoorInteraction();
    }
    @Override
    public void interact(Floor2RayaController controller5) {
        controller5.handleDoorInteraction();
    }
    @Override
    public void interact(Floor3RayaController controller6) {
        controller6.handleDoorInteraction();
    }
    @Override
    public void interact(Floor4RayaController controller7) {
        controller7.handleDoorInteraction();
    }
    @Override
    public void interact(Floor5RayaController controller8) {
        controller8.handleDoorInteraction();
    }
    @Override
    public void interact(Floor1EldenController controller9) {
        controller9.handleDoorInteraction();
    }
    @Override
    public void interact(Floor2EldenController controller10) {
        controller10.handleDoorInteraction();
    }

    @Override
    public void interact(Floor3EldenController controller11) {
        controller11.handleDoorInteraction();
    }
    
}