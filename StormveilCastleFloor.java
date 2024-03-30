public abstract class StormveilCastleFloor {
    protected int rows, columns;
    protected int playerRow, playerColumn;

    public StormveilCastleFloor(int rows, int columns, int playerStartRow, int playerStartColumn) {
        this.rows = rows;
        this.columns = columns;
        this.playerRow = playerStartRow;
        this.playerColumn = playerStartColumn;
    }

    public abstract void movePlayer(int newRow, int newColumn);
    public abstract void renderFloor();
}
