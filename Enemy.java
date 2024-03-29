public abstract class Enemy {
    protected String name;
    protected EnemyStats stats;
    protected int areaIndex;

    public Enemy(String name, EnemyStats stats, int areaIndex) {
        this.name = name;
        this.stats = stats;
        this.areaIndex = areaIndex;
    }

    public abstract void takeDamage(int damage, String attackType);

    public boolean isAlive() {
        return stats.getHealth() > 0;
    }

    public String getName() {
        return name;
    }

    public EnemyStats getStats() {
        return stats;
    }

    public int getBaseAttack() {
        return stats.getAttack();
    }

    public int getHealth() {
        return stats.getHealth();
    }
}
