import java.awt.Color;

public class PlayerTile extends Tile {
    public PlayerTile() {
        super(true);
    }

    @Override
    public Color getColor() {
        return Color.PINK;
    }

    @Override
    public void interact(Floor1StormController controller) {
        // Interaction for player tile not necessary since the player is here
    }

    public void interact(Floor2StormController controller) {
        // Interaction for player tile not necessary since the player is here
    }
}