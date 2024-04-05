public class Floor3StormModel extends StormveilCastleFloor{
    private Tile[][] tiles;
    private CharacterModel characterModel;

    public Floor3StormModel() {
        super(7, 5, 6, 2, "Stormveil Castle"); // 7 rows, 3 columns, player starts at (6,1)
        initializeTiles();
    }

    private void initializeTiles() {
        tiles = new Tile[rows][columns];

        // Initialize all tiles to DefaultTile initially
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tiles[i][j] = new DefaultTile();
            }
        }

        // Set specific tiles based on their position
        tiles[0][2] = new FastTravelTile();
        tiles[6][2] = new DoorTile();
       // tiles[3][2] = new BossTile();
       
        // Set the player's starting tile
        tiles[playerRow][playerColumn] = new PlayerTile();
    }

    @Override
    public void movePlayer(int newRow, int newColumn) {
        if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns) {
            Tile currentTile = tiles[playerRow][playerColumn];
            Tile destinationTile = tiles[newRow][newColumn];
    
            // Reset the previous tile if necessary
            if (currentTile instanceof PlayerTile && currentTile.hasPlayer()) {
                if (playerRow == 0 && playerColumn == 2) {
                    tiles[playerRow][playerColumn] = new FastTravelTile();
                } else if (playerRow == 6 && playerColumn == 2) {
                    tiles[playerRow][playerColumn] = new DoorTile();
                } else if ((playerRow == 3 && playerColumn == 2)) {
                   // tiles[playerRow][playerColumn] = new BossTile(); //wala pa
                } else {
                    tiles[playerRow][playerColumn] = new DefaultTile();
                }
            }
    
            playerRow = newRow;
            playerColumn = newColumn;
    
            // If destination is a special tile, do not override it with PlayerTile.
            if (!(destinationTile instanceof FastTravelTile) && !(destinationTile instanceof DoorTile) && !(destinationTile instanceof SpawnTile)) {
                tiles[playerRow][playerColumn] = new PlayerTile();
            }
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

    public String getAreaName(){
        return areaName;
    }

    // Method to retrieve the tile at a certain position
    public Tile getTileAt(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            return tiles[row][column];
        }
        return null; // Out of bounds
    }

    public void setCharacterModel(CharacterModel model) {
        this.characterModel = model;
    }

    public CharacterModel getCharacterModel() {
        return characterModel;
    }
    
    public void resetTiles() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (tiles[i][j] instanceof SpawnTile) {
                    ((SpawnTile)tiles[i][j]).reset();
                }
            }
        }
    }

}
