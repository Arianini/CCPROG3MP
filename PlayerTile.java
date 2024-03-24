import java.util.ArrayList;

public class PlayerTile extends Tile {
    private char playerSymbol;
    private int pX;
    private int pY;
    private StormveilCastle stormveilCastle;
    private boolean isTriggered;

    public PlayerTile(char playerSymbol, int pX, int pY, StormveilCastle stormveilCastle) {
        super(playerSymbol, pX, pY);
        this.playerSymbol = playerSymbol;
        this.pX = pX;
        this.pY = pY;
        this.stormveilCastle = stormveilCastle;
        this.isTriggered = false;
    }

    public void setPX(int pX) {
        this.pX = pX;
    }

    public void setPY(int pY) {
        this.pY = pY;
    }

    public void addTiletoList(ArrayList<ArrayList<Tile>> tilesList) {
        if (tilesList != null && tilesList.size() > pX && tilesList.get(pX).size() > pY) {
            tilesList.get(pX).set(pY, this);
        } else {
            System.out.println("Invalid tilesList dimensions.");
        }
    }

    public void movePosition(String move, ArrayList<ArrayList<Tile>> tilesList) {
        int updateX = pX;
        int updateY = pY;

        switch (move.toUpperCase()) {
            case "W":
                updateX--;
                break;
            case "S":
                updateX++;
                break;
            case "A":
                updateY--;
                break;
            case "D":
                updateY++;
                break;
            case "E":  // to be removed
                System.out.println("INTERACTING");
                break;
            default:
                System.out.println("INVALID KEY. TRY AGAIN\n");
                return;
        }
        if (isValidMove(updateX, updateY, tilesList)) {
            Tile destTile = tilesList.get(updateX).get(updateY); 
             tilesList.get(pX).set(pY, null);
             pX = updateX;
             pY = updateY;
             tilesList.get(pX).set(pY, this); 
            // Check the destination tile for special interactions
            triggerInteraction(destTile, move, tilesList);
            
        } else {
            System.out.println("INVALID MOVE. TRY AGAIN\n");
        }
    }

    private boolean isValidMove(int newX, int newY, ArrayList<ArrayList<Tile>> tilesList) {
        return newX >= 0 && newX < tilesList.size() && newY >= 0 && newY < tilesList.get(0).size();
    }

    private void triggerInteraction(Tile tile, String move, ArrayList<ArrayList<Tile>> tilesList) {
        int updateX = pX;
        int updateY = pY;    
        if (tile instanceof SpawnTile) {
                System.out.println("You've encountered a Spawn Tile. Do you want to use it? (PRESS E TO INTERACT\n PRESS ANY KEY IF NOT)");
                if(move.equalsIgnoreCase("e"))
                {
                    stormveilCastle.interactWithSpawnTile((SpawnTile) tile);
                }
                else
                {
                    tilesList.get(pX).set(pY, this);
                    pX = updateX;
                    pY = updateY;
                    tilesList.get(pX).set(pY, (SpawnTile) tile);

                }
            } else if (tile instanceof DoorTile) {
                System.out.println("You've encountered a Door Tile. Do you want to use it? (PRESS E TO INTERACT\n PRESS ANY KEY IF NOT)");
                if(move.equalsIgnoreCase("e"))
                {
                    stormveilCastle.interactWithDoorTile((DoorTile) tile);
                }
                else
                {
                    tilesList.get(pX).set(pY, this);
                    pX = updateX;
                    pY = updateY;
                    tilesList.get(pX).set(pY, (DoorTile) tile);

                }
            } else if (tile instanceof FastTravelTile) {
                System.out.println("You've encountered a Fast Travel Tile. Do you want to use it? (PRESS E TO INTERACT\n PRESS ANY KEY IF NOT)");
                if(move.equalsIgnoreCase("e"))
                {
                    stormveilCastle.interactWithFastTravelTile((FastTravelTile) tile);
                }
                else
                {
                    tilesList.get(pX).set(pY, this);
                    pX = updateX;
                    pY = updateY;
                    tilesList.get(pX).set(pY, (FastTravelTile) tile);

                }
            }
            else if (tile instanceof BossTile) {
                System.out.println("You've encountered a Boss Tile. Do you want to interact with it? (PRESS E TO INTERACT\n PRESS ANY KEY IF NOT)");
                if(move.equalsIgnoreCase("e"))
                { 
                    stormveilCastle.interactWithBossTile((BossTile) tile);
                }
                else
                {
                    tilesList.get(pX).set(pY, this);
                    pX = updateX;
                    pY = updateY;
                    tilesList.get(pX).set(pY, (BossTile) tile);

                }
            }
            else if (move.equalsIgnoreCase("e")){
                System.out.println("Nothing to interact with.\n");
            }

           
        }
        
    /*private void symbolRemain(Tile tile, ArrayList<ArrayList<Tile>> tilesList)
    {
        if(isTriggered)
        {
            tilesList.get(pX).get(pY).getTileSymbol();
        }
    }*/

    public char getPlayerSymbol() {
        return this.playerSymbol;
    }

    public int getPX() {
        return this.pX;
    }

    public int getPY() {
        return this.pY;
    }

    public boolean isPlayer() {
        return true;
    }
}
