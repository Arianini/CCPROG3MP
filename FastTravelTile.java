import java.util.ArrayList;


public class FastTravelTile extends Tile {
    
    private char fastTravelTileSymbol;
    private int fastTravelTileXcoor;
    private int fastTravelTileYcoor;
    private boolean isLocked; //kung di pa tapos
    private boolean isFastTravelTile;
    private StormveilCastle stormveilCastle;
    private GameLobby gamelobby;
    private BossTile bossTile;

    public FastTravelTile (char fastTravelTileSymbol, int fastTravelTileXcoor, int fastTravelTileYcoor, boolean isLocked, StormveilCastle stormveilCastle, GameLobby gamelobby, BossTile bossTile)
    {
        super(fastTravelTileSymbol, fastTravelTileXcoor, fastTravelTileYcoor);
        this.fastTravelTileSymbol = fastTravelTileSymbol;
        this.fastTravelTileXcoor = fastTravelTileXcoor;
        this.fastTravelTileYcoor = fastTravelTileYcoor;
        this.isLocked = isLocked;
        this.isFastTravelTile = true;
        this.stormveilCastle = stormveilCastle;
        this.gamelobby = gamelobby;
        this.bossTile = bossTile;
    }

    public boolean isLocked()
    {
        return this.isLocked; //if(fastTravelTile.isLocked) then cannot use
    }

    public boolean isFastTravelTile(){ //to confirm that the tile is a fast travel tile
        return isFastTravelTile;
    }

    public void unlock()
    {
        this.isLocked = false; //unlocked
    }

    public void addTiletoList(ArrayList<ArrayList<Tile>> tilesList)
    {
        if (tilesList != null && tilesList.size() > fastTravelTileXcoor && tilesList.get(fastTravelTileXcoor).size() > fastTravelTileYcoor) {
            tilesList.get(fastTravelTileXcoor).set(fastTravelTileYcoor, this);
        } else {
            System.out.println("Invalid tilesList dimensions.");
        }
    }
   
    public char getfastTravelTileSymbol(){
        return this.fastTravelTileSymbol;
    }
    public int getTileXcoor()
    {
        return this.fastTravelTileXcoor;
    }
    public int getTileYcoor()
    {
        return this.fastTravelTileYcoor;
    }

    public void interactFastTravelTile(){
        if(stormveilCastle.floorIndex == 1){
            gamelobby.enterLobby();
        }
        else if(stormveilCastle.floorIndex == 3){
            if(bossTile.isBossTileInteracted())
            {
                unlock();
            }
            else{
                System.out.println("THIS FAST TRAVEL TILE IS LOCKED. DEFEAT THE BOSS TO UNLOCK.");
            }
        }
}
}
