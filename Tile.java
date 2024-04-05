import java.awt.Color;

public abstract class Tile {
    private boolean hasPlayer;

    public Tile(boolean hasPlayer) {
        this.hasPlayer = hasPlayer;
    }

    public boolean hasPlayer() {
        return hasPlayer;
    }

    public void setHasPlayer(boolean hasPlayer) {
        this.hasPlayer = hasPlayer;
    }

    public abstract Color getColor();

    public abstract void interact(Floor1StormController controller);
    public abstract void interact(Floor2StormController controller2);
    public abstract void interact(Floor3StormController controller3);
    public abstract void interact(Floor1RayaController controller4);
    public abstract void interact(Floor2RayaController controller5);
    public abstract void interact(Floor3RayaController controller6);
    public abstract void interact(Floor4RayaController controller7);
    public abstract void interact(Floor5RayaController controller8);
}