import java.util.Scanner;

public class LevelUp extends GameLobby {
    private Scanner scanner = new Scanner(System.in);

    public LevelUp(CharacterCreation character) {
        super(character);
    }

    public void execute() {
        System.out.println("Select a stat to level up:");
        System.out.println("[1] Health");
        System.out.println("[2] Dexterity");
        System.out.println("[3] Intelligence");
        System.out.println("[4] Endurance");
        System.out.println("[5] Strength");
        System.out.println("[6] Faith");
        System.out.println("[7] Back");

        int choice = scanner.nextInt();
        if (choice == 7) {
            lobbyMenu();
            return;
        }
        int playerLevel = getCharacter().getPlayerClass().getStats().getLevel();
        int cost = calculateRuneCost(playerLevel);
        if (getCharacter().spendRunes(cost)) {
            levelUpStat(choice);
            getCharacter().getPlayerClass().getStats().increaseLevel();
        } else {
            System.out.println("Not enough runes for leveling up.");
        }
        lobbyMenu(); 
    }

    private int calculateRuneCost(int playerLevel) {
        return (playerLevel * 100) / 2;
    }

    private void levelUpStat(int statChoice) {
        Stats stats = getCharacter().getPlayerClass().getStats();
        switch (statChoice) {
            case 1:
                stats.increaseHp();
                break;
            case 2:
                stats.increaseDex();
                break;
            case 3:
                stats.increaseInt();
                break;
            case 4:
                stats.increaseEnd();
                break;
            case 5:
                stats.increaseStr();
                break;
            case 6:
                stats.increaseFth();
                break;
            default:
                System.out.println("Invalid input!");

        }
        System.out.println("Stat increased! New stats: " + stats);
    }
}

