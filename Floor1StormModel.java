public class Floor1StormModel extends StormveilCastleFloor {
    private Tile[][] tiles;

    public Floor1StormModel() {
        super(7, 3, 6, 1); // 7 rows, 3 columns, player starts at (6,1)
        initializeTiles();
    }

    private void initializeTiles() {
        tiles = new Tile[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == playerRow && j == playerColumn) {
                    tiles[i][j] = new PlayerTile();
                } else {
                    tiles[i][j] = new DefaultTile();
                }
            }
        }
    }

    public void movePlayer(int newRow, int newColumn) {
        if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
            tiles[playerRow][playerColumn].setHasPlayer(false);
            playerRow = newRow;
            playerColumn = newColumn;
            tiles[playerRow][playerColumn].setHasPlayer(true);
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    @Override
    public void renderFloor() {
        //
    }

    // Getters for rows, columns, playerRow, playerColumn

    public int getRows() {
        return rows;
    }
    
    public int getColumns() {
        return columns;
    }
    
    public int getPlayerRow() {
        return playerRow;
    }
    
    public int getPlayerColumn() {
        return playerColumn;
    }

    // Method to retrieve the tile at a certain position
    public Tile getTileAt(int row, int column) {
        return tiles[row][column];
    }
}
