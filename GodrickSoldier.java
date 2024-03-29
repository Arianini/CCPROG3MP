import java.util.Random;

public class GodrickSoldier extends Enemy {
    public GodrickSoldier(int areaIndex) {
        super("Godrick Soldier", new EnemyStats(20 + new Random().nextInt(11), 70 + new Random().nextInt(11), 0.2, 0.15, 0.1), areaIndex);
    }

    @Override
    public void takeDamage(int damage, String attackType) {
        double defenseModifier = switch (attackType) {
            case "Physical" -> stats.getPhysicalDefense();
            case "Sorcery" -> stats.getSorceryDefense();
            case "Incantation" -> stats.getIncantationDefense();
            default -> 1.0;
        };
        int finalDamage = (int) (damage * (1 - defenseModifier));
        stats.setHealth(stats.getHealth() - finalDamage);
    }
}
