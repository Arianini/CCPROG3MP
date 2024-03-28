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
}