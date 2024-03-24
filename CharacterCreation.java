public class CharacterCreation {
    private String playerName;
    private JobClass playerClass;
    private int runes = 0;

    public void createCharacter() {
        System.out.println("YOU ARE NOW CREATING YOUR CHARACTER");
        enterName();
        chooseJobClass();
        confirmCharacter();
    }

    private void enterName() {
        while(true) {
            System.out.print("Enter name: ");
            playerName = Driver.scanner.nextLine().trim();

            if(playerName.isEmpty()){
                System.out.println("Character name must be at least 1 character length");
            }else if (playerName.length() > 25){
                playerName = playerName.substring(0, 25);
                break;
            }else {
                break;
            }
        }
    }

    private void chooseJobClass() {
        System.out.println("Choose a job class:");
        System.out.println("(A) Vagabond");
        System.out.println("(B) Samurai");
        System.out.println("(C) Warrior");
        System.out.println("(D) Hero");
        System.out.println("(E) Astrologer");
        System.out.println("(F) Prophet");
        
        String choice = Driver.scanner.nextLine();
        
        switch (choice.toUpperCase()) {
            case "A":
                playerClass = new Vagabond();
                break;
            case "B":
                playerClass = new Samurai();
                break;
            case "C":
                playerClass = new Warrior();
                break;
            case "D":
                playerClass = new Hero();
                break;
            case "E":
                playerClass = new Astrologer();
                break;
            case "F":
                playerClass = new Prophet();
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                chooseJobClass();
                break;
        }
        playerClass.displayStats();
    }

    private void confirmCharacter() {
        System.out.println("Do you want to confirm your character? (Yes/No)");
        String confirmChoice = Driver.scanner.nextLine();

        if (confirmChoice.equalsIgnoreCase("Yes")) {
            Driver.gameLobby();
        } else {
            createCharacter();
        }
    }

    public void addRunes(int amount) {
        this.runes += amount;
    }

    public boolean spendRunes(int amount) {
        if (amount <= runes) {
            runes -= amount;
            return true;
        }
        return false;
    }

    public String getPlayerName() {
        return playerName;
    }
    
    public JobClass getPlayerClass() {
        return playerClass;
    }

    public int getRunes() {
        return runes;
    }
}
