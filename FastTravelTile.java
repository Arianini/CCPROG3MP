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
    public void interact(Floor2StormController controller) {
        //Do nothing
    }
}