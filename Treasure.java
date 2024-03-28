import java.util.Random;

public class Treasure {
    private int runes;

    public Treasure() {
        this.runes = 0;
    }

    public int runesGained(int areaIndex) {
        Random rand = new Random();
        int minRunes = 50;
        int maxRunes = 150;
        this.runes = rand.nextInt(maxRunes - minRunes + 1) + minRunes;
        this.runes *= areaIndex;
        System.out.println("You have received " + this.runes + " runes.");
        return this.runes;
    }
    
}
