import java.util.ArrayList;

public class DoorTile extends Tile {

    private char doorTileSymbol;
    private int doorTileXcoor;
    private int doorTileYcoor;
    private boolean isDoorTile;
    private StormveilCastle stormveilCastle;

    public DoorTile(char doorTileSymbol, int doorTileXcoor, int doorTileYcoor, StormveilCastle stormveilCastle){
        super(doorTileSymbol, doorTileXcoor, doorTileYcoor);
        this.doorTileSymbol = doorTileSymbol;
        this.doorTileXcoor = doorTileXcoor;
        this.doorTileYcoor = doorTileYcoor;
        this.isDoorTile = true;
        this.stormveilCastle = stormveilCastle;
    }
    public void addTiletoList(ArrayList<ArrayList<Tile>> tilesList)
    {
        if (tilesList != null && tilesList.size() > doorTileXcoor && tilesList.get(doorTileXcoor).size() > doorTileYcoor) {
            tilesList.get(doorTileXcoor).set(doorTileYcoor, this);
        } else {
            System.out.println("Invalid tilesList dimensions.");
        }
    }

    public boolean isDoorTile(){
        return this.isDoorTile;
    }
    public char doorTileSymbol(){
        return this.doorTileSymbol;
    }
    public int doorlTileXcoor()
    {
        return this.doorTileYcoor;
    }
    public int doorTileYcoor()
    {
        return this.doorTileYcoor;
    }

    public boolean isPlayer()
    {
        return false;
    }

    public void interactDoorTile(){
        if(stormveilCastle.floorIndex == 0){
            stormveilCastle.floorIndex+= 1; 
                System.out.println("-+-+-+-+-+-+-WELCOME TO FLOOR " + (stormveilCastle.floorIndex + 1) + "-+-+-+-+-+-+-");
                stormveilCastle.displayArea();
                stormveilCastle.handlePlayerMovement();
            } else if (stormveilCastle.floorIndex == 1){
                stormveilCastle.floorIndex += 1;
                System.out.println("-+-+-+-+-+-+-WELCOME TO FLOOR " + (stormveilCastle.floorIndex + 1) + "-+-+-+-+-+-+-");
                stormveilCastle.displayArea();
                stormveilCastle.handlePlayerMovement();
        }
        else
        {
            stormveilCastle.displayArea();
                System.out.println("Staying on current tile.");
        }
    }

}
