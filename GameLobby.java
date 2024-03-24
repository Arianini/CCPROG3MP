public class GameLobby {
    private CharacterCreation character;
    private StormveilCastle stormveilCastle; 

    public GameLobby(CharacterCreation character) {
        this.character = character;
        this.stormveilCastle = new StormveilCastle(1);
    }

    public void enterLobby() {
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("Welcome to the Game Lobby, " + character.getPlayerName() + 
                           ". Your class is " + character.getPlayerClass().getClass().getSimpleName() + ".");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        lobbyMenu();
    }

    protected void lobbyMenu() {
        System.out.println("[1] Fast Travel");
        System.out.println("[2] Level Up");
        System.out.println("[3] Quit");
        System.out.print("Choose an option: ");
        int choice = Driver.scanner.nextInt();
        Driver.scanner.nextLine();
        
        switch (choice) {
            case 1:
                new FastTravel(character).execute();
                break;
            case 2:
                new LevelUp(character).execute();
                break;
            case 3:
                System.out.println("Exiting game...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                lobbyMenu();
                break;
        }
    }
    

    public CharacterCreation getCharacter() {
        return character;
    }

    public void travelToStormveilCastle() {
        stormveilCastle.travel();
    }
} 