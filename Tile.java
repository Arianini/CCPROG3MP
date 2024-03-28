import java.awt.Color;

public class Tile {
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

    public Color getColor() {
        return hasPlayer ? Color.PINK : Color.BLACK;
    }
}
