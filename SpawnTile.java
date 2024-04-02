import java.util.Random;
import java.awt.Color;

public class SpawnTile extends Tile {
    private boolean isDisabled;
    private Random random = new Random();

    public SpawnTile() {
        super(false);
        this.isDisabled = false;
    }

    @Override
    public Color getColor() {
        return isDisabled ? Color.BLACK : Color.CYAN;
    }

    @Override
    public void interact(Floor1StormController controller) {
        if (!isDisabled) {
            int chance = random.nextInt(100);
            if (chance < 75) {
                // There's a 75% chance to spawn an enemy
                controller.spawnEnemy();
            } else {
                // There's a 25% chance to spawn treasure
                controller.spawnTreasure();
            }
            isDisabled = true; // Disable this tile so it cannot be interacted with again
        }
    }

    @Override
    public void interact(Floor2StormController controller2) {
        if (!isDisabled) {
            int chance = random.nextInt(100);
            if (chance < 75) {
                // There's a 75% chance to spawn an enemy
                controller2.spawnEnemy();
            } else {
                // There's a 25% chance to spawn treasure
                controller2.spawnTreasure();
            }
            isDisabled = true; // Disable this tile so it cannot be interacted with again
        }
    }

    public void reset() {
        isDisabled = false;
    }

    public boolean isDisabled() {
        return isDisabled;
    }
}
