import java.util.Scanner;

public class Driver {
    public static final Scanner scanner = new Scanner(System.in);
    private static TitleScreen titleScreen = new TitleScreen();
    private static CharacterCreation characterCreation;
    
    public static void main(String[] args) {
        titleScreen.screenDisplay();
    }

    public static void characterCreation() {
        characterCreation = new CharacterCreation();
        characterCreation.createCharacter();
    }
    public static void gameLobby() {
        GameLobby gameLobby = new GameLobby(characterCreation);
        gameLobby.enterLobby();
        
    }
}