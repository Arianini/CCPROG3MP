import java.util.Random;

public class GodrickKnight extends Enemy {
    public GodrickKnight(int areaIndex) {
        super("Godrick Knight", new EnemyStats(70 + new Random().nextInt(11), 120 + new Random().nextInt(11), 0.25, 0.25, 0.2), areaIndex);
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
