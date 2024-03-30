import java.util.Scanner;

public class Inventory extends GameLobby {
    private Scanner scanner = new Scanner(System.in);
    private WeaponClass weaponClass;

    public Inventory(CharacterCreation character) {
        super(character);
    }

    public void execute() {
        System.out.println("OPTIONS");
        System.out.println("[1] SELECT WEAPON");
        System.out.println("[2] BACK");

        int optionchoice = Driver.scanner.nextInt();
        Driver.scanner.nextLine();

        

        if (optionchoice == 2) {
            lobbyMenu();
            return;
        }
        else if(optionchoice == 1){
            //view
            
        }
    
        public void equipWeapon()
        {
            int playerDex = getCharacter().getPlayerClass().getStats().getDex();
            int weaponDex = getWeaponClass().getWDex();

            if(playerDex >= weaponDex)
            {
                System.out.println("You have equipped" +getWeaponClass().getClass().getSimpleName());
            }
            else 
            {
                System.out.println("Sorry, you do not have enough dexterity to equip this weapon");
            }
        }

    public WeaponClass getWeaponName()
    {
        return weaponName;
    }
