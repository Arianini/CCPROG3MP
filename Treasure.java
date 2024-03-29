import java.util.Random;

public class Treasure {
    private static final Random random = new Random();

    public int calculateRunesGained(int areaIndex) {
        int runes = 50 + random.nextInt(101); // Random value between 50 and 150
        return runes * areaIndex;
    }
}