import java.util.Random;
import java.awt.Color;

public class SpawnTile extends Tile {
    private boolean isDisabled;
    private Random random;

    public SpawnTile() {
        super(false);
        this.isDisabled = false;
        this.random = new Random();
    }

    @Override
    public Color getColor() {
        if (isDisabled) {
            return Color.GRAY; // Color for disabled tiles
        }
        return Color.BLUE; // Color for active spawn tiles
    }

    @Override
    public void interact(Floor1StormController controller) {
        if (isDisabled) {
            System.out.println("This tile is disabled and cannot be interacted with.");
            return;
        }

        if (random.nextInt(100) < 75) {
            spawnEnemy(controller);
        } else {
            spawnTreasure(controller);
        }

        this.isDisabled = true; // Disable the tile after interaction
    }

    private void spawnEnemy(Floor1StormController controller) {
        // Spawn enemy logic
        Enemy enemy = new Enemy();
        enemy.generateEnemyType(controller.getAreaIndex());
        controller.encounterEnemy(enemy);
    }

    private void spawnTreasure(Floor1StormController controller) {
        // Spawn treasure logic
        Treasure treasure = new Treasure();
        int runes = treasure.runesGained(controller.getAreaIndex());
        controller.addRunes(runes);
    }
}
