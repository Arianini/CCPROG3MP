public class TitleScreen {

    public void screenDisplay() {
        System.out.println("================================");
        System.out.println("--|| WELCOME TO ELDEN ROGUE ||--");
        System.out.println("================================");
        System.out.println("---> OPTIONS <---");
        System.out.println("[1] START");
        System.out.println("[2] EXIT");
        getUserInput();
    }

    private void getUserInput() {
        System.out.print("Select option: ");
        int option = Driver.scanner.nextInt();
        Driver.scanner.nextLine();

        switch (option) {
            case 1:
                Driver.characterCreation();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option, please try again.");
                screenDisplay();
                break;
        }
    }
}
