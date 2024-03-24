public class FastTravel extends GameLobby {

    public FastTravel(CharacterCreation character) {
        super(character);
    }

    public void execute() {
        System.out.println("Select a destination for Fast Travel:");
        System.out.println("[1] Stormveil Castle");
        System.out.println("[2] Raya Lucaria Academy");
        System.out.println("[3] The Elden Throne");
        int destination = Driver.scanner.nextInt();
        Driver.scanner.nextLine();

        switch (destination) {
            case 1:
                StormveilCastle stormveilCastle = new StormveilCastle(0);
                stormveilCastle.travel();
                break;
            case 2:
                System.out.println("Nothing to see here. Please come back again later");
                execute();
                break;
            case 3:
                System.out.println("Nothing to see here. Please come back again later");
                execute();
                break;
            default:
                System.out.println("Invalid destination. Please try again.");
                execute();
                break;
        }
    }
}
