import java.util.ArrayList;

public class Floor {
    // A 2D ArrayList to store tiles of the floor
    protected ArrayList<ArrayList<Tile>> tilesList;
    // Stores the player tile on the floor
    protected PlayerTile player;
    // Width of the floor
    protected int x;
    // Height of the floor
    protected int y;

    // Constructor to initialize the floor with given dimensions
    // @param x The width of the floor
    // @param y The height of the floor
    public Floor(int x, int y) {
        this.x = x; // Set the width of the floor
        this.y = y; // Set the height of the floor
        tilesList = new ArrayList<>(x); // Initialize the 2D ArrayList with the width
        for (int i = 0; i < x; i++) { // Loop through each row
            ArrayList<Tile> rowList = new ArrayList<>(y); // Create a new row with the height
            for (int j = 0; j < y; j++) { // Fill the row with nulls to represent empty tiles
                rowList.add(null);
            }
            tilesList.add(rowList); // Add the row to the 2D ArrayList
        }
    }

    // Sets the player on the floor at the player's position
    // @param player The player tile to be placed on the floor
    public void setPlayer(PlayerTile player) {
        this.player = player; // Store the player tile
        updatePlayerPositionInTilesList(player);
    }

    public void viewFloor() {
        // Iterate through each row of the floor
        for (ArrayList<Tile> row : tilesList) {
            // Iterate through each tile in the row
            for (Tile tile : row) {
                if (tile == null) { // If the tile is empty
                    System.out.print("[     ]"); // Print an empty space
                } else { // If there is a tile
                    System.out.print("[  " + tile.getTileSymbol() + "  ]"); // Print the tile's symbol
                }
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }

    // Moves the player in a specified direction
    // @param moves A string representing the direction(s) the player should move
    public void moveDirection(String moves) {
        player.movePosition(moves, tilesList);
    }

    public void setPlayerStartingPosition(int x, int y) {
        if (this.player != null) {
            // Update player's position
            this.player.setPX(x);
            this.player.setPY(y);
            // Update tile list to reflect new player position
            updatePlayerPositionInTilesList(this.player);
        }
    }

    private void updatePlayerPositionInTilesList(PlayerTile player) {
        // Clear previous player position, if necessary
        clearPreviousPlayerPosition();
        // Ensure the coordinates are valid
        if (player.getPX() >= 0 && player.getPX() < this.x && player.getPY() >= 0 && player.getPY() < this.y) {
            this.tilesList.get(player.getPX()).set(player.getPY(), player); // Place the player at the new position
        }
    }

    private void clearPreviousPlayerPosition() {
        // Optionally clear the previous player position from the tilesList
        for (ArrayList<Tile> row : tilesList) {
            for (Tile tile : row) {
                if (tile instanceof PlayerTile) {
                    // Clear the previous player position, if needed
                }
            }
        }
    }

    public int getFloorX()
    {
        return this.x;
    }

    public int getFloorY()
    {
        return this.y;
    }
}
