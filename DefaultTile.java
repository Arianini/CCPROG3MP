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
}