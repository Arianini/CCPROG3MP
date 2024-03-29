public class CharacterModel {
    private String playerName;
    private JobClass playerClass;
    private int runes = 0;
    private Stats stats;
    private int currentHealth;

    public CharacterModel() {
    }

    public void initializeCharacter(JobClass chosenClass) {
        this.playerClass = chosenClass;
        this.stats = chosenClass.getStats();
        this.currentHealth = calculateMaxHealth();
    }

    private int calculateMaxHealth() {
        return 100 * ((stats.getHp() + getWeaponHealth()) / 2); // Example calculation
    }

    private int getWeaponHealth() {
        return 10; // Example value
    }

    public void takeDamage(int damage) {
        this.currentHealth = Math.max(this.currentHealth - damage, 0);
    }

    public boolean isAlive() {
        return this.currentHealth > 0;
    }

    public int calculateDamage(String attackType, Enemy enemy) {
        int damage = 0;
        switch (attackType) {
            case "Physical":
                damage = (this.stats.getStr() + getWeaponStr()) - (int)(enemy.getStats().getPhysicalDefense() * 100);
                break;
            case "Sorcery":
                damage = (this.stats.getInt() + getWeaponInt()) - (int)(enemy.getStats().getSorceryDefense() * 100);
                break;
            case "Incantation":
                damage = (this.stats.getFth() + getWeaponFth()) - (int)(enemy.getStats().getIncantationDefense() * 100);
                break;
        }
        return Math.max(damage, 0);
    }
    

    public boolean attemptDodge(Enemy enemy) {
        double dodgeChance = 20 + (this.stats.getEnd() + getWeaponEnd()) / 2.0; // Example calculation
        return Math.random() * 100 < dodgeChance;
    }

    // Getters, setters, and helper methods for weapon stats (Example values)
    private int getWeaponStr() {
        return 5;
    }

    private int getWeaponInt() {
        return 5;
    }

    private int getWeaponFth() {
        return 5;
    }

    private int getWeaponEnd() {
        return 5;
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

    public void addRunes(int runesGained) {
        this.runes += runesGained;
    }

    public Stats getStats() {
        return stats;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
}
