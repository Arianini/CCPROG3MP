public abstract class StormveilCastleFloor {
    protected int rows, columns;
    protected int playerRow, playerColumn;
    protected String areaName;

    public StormveilCastleFloor(int rows, int columns, int playerStartRow, int playerStartColumn, String areaName) {
        this.rows = rows;
        this.columns = columns;
        this.playerRow = playerStartRow;
        this.playerColumn = playerStartColumn;
        this.areaName = areaName;
    }

    public abstract void movePlayer(int newRow, int newColumn);
    public abstract void renderFloor();
}
