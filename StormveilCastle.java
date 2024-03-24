

import java.util.ArrayList;

public class StormveilCastle {
    protected int floorIndex;
    protected ArrayList<Floor> floors;
    protected PlayerTile player;
    private JobClass playerStats;
    private CharacterCreation characterrunes;
    private Treasure treasure;
    private GameLobby gameLobby;
    private int areaIndex;

    public StormveilCastle(int floorIndex) {
        this.floorIndex = floorIndex;
        this.floors = new ArrayList<>();
        //this.player = new PlayerTile('P', 6, 1, this); // to change
        //this.playerStats = new JobClass(); 
        this.characterrunes = new CharacterCreation();
        this.treasure = new Treasure();
        initFloors();
        this.areaIndex = 1;
    }

    private void initFloors() {
        // Initialize each floor here
        floors.add(new Floor1(7, 3, this));
        floors.add(new Floor2(7, 7, this));
        floors.add(new Floor3(7, 5, this));
    }

    public void transitionToFloor(int floorIndex, int startX, int startY) {
        this.floorIndex = floorIndex;
        Floor currentFloor = floors.get(floorIndex); // 
        currentFloor.setPlayer(this.player);
        currentFloor.setPlayerStartingPosition(startX, startY);
    }


    public void travel() {
        System.out.println("You have arrived at Stormveil Castle.");
        displayArea();
        //handlePlayerMovement();
    }

    public void displayArea() {
        for(Floor floor : floors){
            floors.get(floorIndex).viewFloor();
            System.out.println("\n");
            while (true) {
                System.out.println("OPTIONS:\n[W] MOVE UP\n[S] MOVE DOWN\n[A] MOVE LEFT\n[D] MOVE RIGHT\n[E] INTERACT\n");
                System.out.println("DETAILS:\n[1] AREA NAME\n[2] AREA GRID\n[3] PLAYER TOKEN\n[4] PLAYER HEALTH\n[5] LEVEL \n[6] RUNES\n[7] SYSTEM MESSAGE\n");
                System.out.println("PRESS OPTION KEYS TO MOVE: ");
                
                    String moves = Driver.scanner.nextLine();
                        floors.get(floorIndex).moveDirection(moves);
                        floors.get(floorIndex).viewFloor();   
            }
        }
        
    }

    public void handlePlayerMovement() { //di na need

        boolean keepPlaying = true;
        
        while (keepPlaying) {
            System.out.println("OPTIONS:\n[W] MOVE UP\n[S] MOVE DOWN\n[A] MOVE LEFT\n[D] MOVE RIGHT\n[E] INTERACT\n");
            System.out.println("DETAILS:\n[1] AREA NAME\n[2] AREA GRID\n[3] PLAYER TOKEN\n[4] PLAYER HEALTH\n[5] LEVEL \n[6] RUNES\n[7] SYSTEM MESSAGE\n");
            System.out.println("PRESS OPTION KEYS TO MOVE: ");
            if(Driver.scanner.hasNextLine())
            {
                String moves = Driver.scanner.nextLine();
                //Floor currentFloor = floors.get(0); 
                for (Floor floor : floors) {
                    floor.moveDirection(moves);
                    floors.get(floorIndex).viewFloor();
            }}
           else {
                System.out.println("No input available. Exiting.");
                keepPlaying = false;
           }
         }
    }


    public void interactWithFastTravelTile(FastTravelTile fastTravelTile) { // need of update, when interacted, error
       
        String response = Driver.scanner.nextLine();

        if (response.equalsIgnoreCase("e")) {
           // System.out.println("Going back to game lobby...");
           // gameLobby.lobbyMenu();
            fastTravelTile.interactFastTravelTile();
        } else {
                System.out.println("Stayin on current tile.");
                displayArea();
            
        }

    }

    public void interactWithSpawnTile(SpawnTile spawnTile) { // need of update, when not interacted, does not move
       
        String response = Driver.scanner.nextLine();

        if (response.equalsIgnoreCase("e")) {
            spawnTile.interactSpawn();
        }else {
            displayArea();
        }

    }

    public void interactWithDoorTile(DoorTile doorTile) { 
      
        String response = Driver.scanner.nextLine();

        if (response.equalsIgnoreCase("e")) {
            doorTile.interactDoorTile(); 
        }
        else{
            displayArea();
        }

    }

    public void interactWithBossTile(BossTile bossTile){
       
        String response = Driver.scanner.nextLine();
        if(response.equalsIgnoreCase("e")){
            bossTile.interactBossTile();
        }
        else{
            System.out.println("Staying on current tile");
        }
    }
    
    private void displayDetails(Floor floor, PlayerTile player, JobClass playerStats, CharacterCreation characterrunes, Treasure treasure)
    {
        int details = Driver.scanner.nextInt();

        switch(details){
            case 1:
            System.out.println("AREA NAME -  Stormveil Castle");
            break;
            case 2:
            System.out.println("AREA GRID -  " + floor.getFloorX() +"," + floor.getFloorY());
            break;
            case 3:
            System.out.println("PLAYER TOKEN [" + player.getPlayerSymbol() +"]");
            break;
            case 4:
            System.out.println("PLAYER HEALTH DETAILS -  ["+ playerStats.getStats().getHp() +"]");
            break;
            case 5:
            System.out.println("LEVEL DETAILS [" + playerStats.getStats().getLevel() + "]");
            break;
            case 6:
            //int addRunes = characterrunes.addRunes(treasure.runesGained(areaIndex));
            System.out.println("RUNES DETAILS "+ treasure.runesGained(areaIndex) +"]");
            break;
            case 7:
            System.out.println("SYSTEM MESSAGES DETAILS - NO MESSAGES");
            break;
            default:
                System.out.println("Invalid choice, please try again.");
                displayDetails(floor, player, playerStats, characterrunes, treasure);
                break;
            }
    }
    
}

