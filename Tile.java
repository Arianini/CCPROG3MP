public class Tile{

    private char tileSymbol;
    private int tileXcoor;
    private int tileYcoor;
    

    public Tile(char tileSymbol, int tileXcoor, int tileYcoor)
    { 
        this.tileSymbol = tileSymbol;
        this.tileXcoor = tileXcoor;
        this.tileYcoor = tileYcoor;
    }

    public char getTileSymbol()
    {
        return this.tileSymbol;
    }
    public int getTileXcoor()
    {
        return this.tileXcoor;
    }
    public int getTileYcoor()
    {
        return this.tileYcoor;
    }

    public boolean canInteract() {
        return false;
    }
    
    // Method to get the next floor index if this is a door tile
    public int getNextFloorIndex() {
        return -1;
    }

    public void setTileSymbol(char symbol)
    {
        this.tileSymbol = symbol;
    }

}

