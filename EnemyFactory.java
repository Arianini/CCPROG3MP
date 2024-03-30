import java.util.Random;

public class EnemyFactory {
    public static Enemy generateRandomEnemy(int areaIndex) {
        Random rand = new Random();
        int enemyType = rand.nextInt(3);

        switch (enemyType) {
            case 0:
                return new GodrickSoldier(areaIndex);
            case 1:
                return new GodrickArcher(areaIndex);
            case 2:
                return new GodrickKnight(areaIndex);
            default:
                return null;
        }
    }
}
