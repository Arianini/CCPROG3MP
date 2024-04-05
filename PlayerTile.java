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

    public void interact(Floor3StormController controller) {
        // Interaction for player tile not necessary since the player is here
    }

    public void interact(Floor1RayaController controller) {
        // Interaction for player tile not necessary since the player is here
    }

    public void interact(Floor2RayaController controller) {
        // Interaction for player tile not necessary since the player is here
    }

    public void interact(Floor3RayaController controller) {
        // Interaction for player tile not necessary since the player is here
    }

    public void interact(Floor4RayaController controller) {
        // Interaction for player tile not necessary since the player is here
    }

    public void interact(Floor5RayaController controller) {
        // Interaction for player tile not necessary since the player is here
    }

    public void interact(Floor1EldenController controller) {
        // Interaction for player tile not necessary since the player is here
    }
    public void interact(Floor2EldenController controller) {
        // Interaction for player tile not necessary since the player is here
    }
    public void interact(Floor3EldenController controller) {
        // Interaction for player tile not necessary since the player is here
    }
}