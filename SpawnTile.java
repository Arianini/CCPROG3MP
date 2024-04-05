import java.awt.Color;
import java.util.Random;

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

    @Override
    public void interact(Floor3StormController controller3) {
        if (!isDisabled) {
            int chance = random.nextInt(100);
            if (chance < 75) {
                // There's a 75% chance to spawn an enemy
                controller3.spawnEnemy();
            } else {
                // There's a 25% chance to spawn treasure
                controller3.spawnTreasure();
            }
            isDisabled = true; // Disable this tile so it cannot be interacted with again
        }
    }

    @Override
    public void interact(Floor1RayaController controller4) {
        if (!isDisabled) {
            int chance = random.nextInt(100);
            if (chance < 75) {
                // There's a 75% chance to spawn an enemy
                controller4.spawnEnemy();
            } else {
                // There's a 25% chance to spawn treasure
                controller4.spawnTreasure();
            }
            isDisabled = true; // Disable this tile so it cannot be interacted with again
        }
    }

  
    @Override
    public void interact(Floor2RayaController controller5) {
        if (!isDisabled) {
            int chance = random.nextInt(100);
            if (chance < 75) {
                // There's a 75% chance to spawn an enemy
                controller5.spawnEnemy();
            } else {
                // There's a 25% chance to spawn treasure
                controller5.spawnTreasure();
            }
            isDisabled = true; // Disable this tile so it cannot be interacted with again
        }
    }
    @Override
    public void interact(Floor3RayaController controller6) {
        if (!isDisabled) {
            int chance = random.nextInt(100);
            if (chance < 75) {
                // There's a 75% chance to spawn an enemy
                controller6.spawnEnemy();
            } else {
                // There's a 25% chance to spawn treasure
                controller6.spawnTreasure();
            }
            isDisabled = true; // Disable this tile so it cannot be interacted with again
        }
    }
    @Override
    public void interact(Floor4RayaController controller7) {
        if (!isDisabled) {
            int chance = random.nextInt(100);
            if (chance < 75) {
                // There's a 75% chance to spawn an enemy
                controller7.spawnEnemy();
            } else {
                // There's a 25% chance to spawn treasure
                controller7.spawnTreasure();
            }
            isDisabled = true; // Disable this tile so it cannot be interacted with again
        }
    }
    @Override
    public void interact(Floor5RayaController controller8) {
        if (!isDisabled) {
            int chance = random.nextInt(100);
            if (chance < 75) {
                // There's a 75% chance to spawn an enemy
                controller8.spawnEnemy();
            } else {
                // There's a 25% chance to spawn treasure
                controller8.spawnTreasure();
            }
            isDisabled = true; // Disable this tile so it cannot be interacted with again
        }
    }
    @Override
    public void interact(Floor1EldenController controller9) {
        if (!isDisabled) {
            int chance = random.nextInt(100);
            if (chance < 75) {
                // There's a 75% chance to spawn an enemy
                controller9.spawnEnemy();
            } else {
                // There's a 25% chance to spawn treasure
                controller9.spawnTreasure();
            }
            isDisabled = true; // Disable this tile so it cannot be interacted with again
        }
    }
    @Override
    public void interact(Floor2EldenController controller10) {
        if (!isDisabled) {
            int chance = random.nextInt(100);
            if (chance < 75) {
                // There's a 75% chance to spawn an enemy
                controller10.spawnEnemy();
            } else {
                // There's a 25% chance to spawn treasure
                controller10.spawnTreasure();
            }
            isDisabled = true; // Disable this tile so it cannot be interacted with again
        }
    }
    @Override
    public void interact(Floor3EldenController controller11) {
        if (!isDisabled) {
            int chance = random.nextInt(100);
            if (chance < 75) {
                // There's a 75% chance to spawn an enemy
                controller11.spawnEnemy();
            } else {
                // There's a 25% chance to spawn treasure
                controller11.spawnTreasure();
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
