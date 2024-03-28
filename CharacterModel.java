public class CharacterModel {
    private String playerName;
    private JobClass playerClass;
    private int runes = 0;
    private Stats stats;

    // Constructor
    public CharacterModel() {
    }

    public void initializeCharacter(JobClass chosenClass) {
        this.playerClass = chosenClass;
        this.stats = chosenClass.getStats();
    }

    // Getters and Setters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public JobClass getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(JobClass playerClass) {
        this.playerClass = playerClass;
    }

    public int getRunes() {
        return runes;
    }

    public void setRunes(int runes) {
        this.runes = runes;
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

    public Stats getStats() {
        return stats;
    }
}
