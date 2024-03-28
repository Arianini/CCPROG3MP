import java.util.Random;

public class Enemy {
    private int enemyType;
    private String enemyName;
    private int baseHealth;
    private int baseAttack;
    private double physicalDefense;
    private double sorceryDefense;
    private double incantationDefense;

    public Enemy(int areaIndex) {
        Random rand = new Random();
        this.enemyType = rand.nextInt(3) + 1; // Random enemy type between 1 and 3
        
        generateEnemyType(areaIndex);
    }

    public void generateEnemyType(int areaIndex) {
        switch (this.enemyType) {
            case 1:
                this.enemyName = "Godrick Soldier";
                this.baseHealth = 20 + new Random().nextInt(11); // Random between 20-30
                this.baseAttack = 70 + new Random().nextInt(11); // Random between 70-80
                this.physicalDefense = 0.2;
                this.sorceryDefense = 0.15;
                this.incantationDefense = 0.1;
                break;
            case 2:
                this.enemyName = "Godrick Archer";
                this.baseHealth = 25 + new Random().nextInt(11); // Random between 25-35
                this.baseAttack = 110 + new Random().nextInt(11); // Random between 110-120
                this.physicalDefense = 0.5;
                this.sorceryDefense = 0.15;
                this.incantationDefense = 0.2;
                break;
            case 3:
                this.enemyName = "Godrick Knight";
                this.baseHealth = 70 + new Random().nextInt(11); // Random between 70-80
                this.baseAttack = 120 + new Random().nextInt(11); // Random between 120-130
                this.physicalDefense = 0.25;
                this.sorceryDefense = 0.25;
                this.incantationDefense = 0.2;
                break;
            default:
                // Default stats or throw an exception if the type is unknown
                throw new IllegalStateException("Unknown enemy type: " + this.enemyType);
        }
    }

    // Getters for enemy properties
    public int getEnemyType() {
        return enemyType;
    }

    public String getEnemyName() {
        return enemyName;
    }
    
}
