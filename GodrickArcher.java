import java.util.Random;

public class GodrickArcher extends Enemy {
    public GodrickArcher(int areaIndex) {
        super("Godrick Archer", new EnemyStats(25 + new Random().nextInt(11), 110 + new Random().nextInt(11), 0.5, 0.15, 0.2), areaIndex);
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
