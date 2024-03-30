import java.util.ArrayList;
import java.util.List;

public class CharacterModel {
    private String playerName;
    private JobClass playerClass;
    private int runes = 0;
    private Stats stats;
    private int currentHealth;
    private List<Weapon> inventory = new ArrayList<>();
    private Weapon equippedWeapon = null; // No weapon equipped initially

    public CharacterModel() {
    }

    public void initializeCharacter(JobClass chosenClass) {
        this.playerClass = chosenClass;
        this.stats = chosenClass.getStats();
        this.currentHealth = calculateMaxHealth();
    }

    private int calculateMaxHealth() {
        return 100 * ((stats.getHp() + getWeaponHp()) / 2);
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
        double dodgeChance = (20 + (this.stats.getEnd() + getWeaponEnd()) / 2.0) / 100.0;
        return Math.random() < dodgeChance;
    }

    private int getWeaponHp() {
        if (equippedWeapon != null) {
            return equippedWeapon.getWeaponClass().getWeaponStats().getWHp();
        }
        return 0; // Default health from weapon is 0 if not equipped
    }

    private int getWeaponDex() {
        if (equippedWeapon != null) {
            return equippedWeapon.getWeaponClass().getWeaponStats().getWDex();
        }
        return 0; // Default dex from weapon is 0 if not equipped
    }

    private int getWeaponStr() {
        if (equippedWeapon != null) {
            return equippedWeapon.getWeaponClass().getWeaponStats().getWStr();
        }
        return 0; // Default str from weapon is 0 if not equipped
    }

    private int getWeaponInt() {
        if (equippedWeapon != null) {
            return equippedWeapon.getWeaponClass().getWeaponStats().getWIntel();
        }
        return 0; // Default int from weapon is 0 if not equipped
    }

    private int getWeaponFth() {
        if (equippedWeapon != null) {
            return equippedWeapon.getWeaponClass().getWeaponStats().getWFth();
        }
        return 0; // Default fth from weapon is 0 if not equipped
    }

    private int getWeaponEnd() {
        if (equippedWeapon != null) {
            return equippedWeapon.getWeaponClass().getWeaponStats().getWEnd();
        }
        return 0; // Default end from weapon is 0 if not equipped
    }

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

    public List<Weapon> getInventory() {
        return inventory;
    }

    public void addWeaponToInventory(Weapon weapon) {
        this.inventory.add(weapon);
    }

    public void removeWeaponFromInventory(Weapon weapon) {
        this.inventory.remove(weapon);
    }

    public void equipWeapon(Weapon weapon) {
        if (inventory.contains(weapon)) {
            equippedWeapon = weapon;
        }
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public boolean spendRunes(int weaponCost) {
        if (this.runes >= weaponCost) {
            this.runes -= weaponCost;
            return true;
        }
        return false;
    }

    public void addWeapon(WeaponClass weaponClass) {

    }

    public CharacterModel getCharacter() {
        return this;
    }
}
