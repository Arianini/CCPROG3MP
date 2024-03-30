public class EnemyStats {
    private int health;
    private int attack; // Adjusted to use a single attack value
    private double physicalDefense, sorceryDefense, incantationDefense;

    public EnemyStats(int health, int attack, double physicalDefense, double sorceryDefense, double incantationDefense) {
        this.health = health;
        this.attack = attack;
        this.physicalDefense = physicalDefense;
        this.sorceryDefense = sorceryDefense;
        this.incantationDefense = incantationDefense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public double getPhysicalDefense() {
        return physicalDefense;
    }

    public void setPhysicalDefense(double physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    public double getSorceryDefense() {
        return sorceryDefense;
    }

    public void setSorceryDefense(double sorceryDefense) {
        this.sorceryDefense = sorceryDefense;
    }

    public double getIncantationDefense() {
        return incantationDefense;
    }

    public void setIncantationDefense(double incantationDefense) {
        this.incantationDefense = incantationDefense;
    }
}
