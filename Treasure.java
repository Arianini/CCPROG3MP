
import java.util.Random;

public class Treasure {
    private int areaIndex;
    private int runeGained;

    public Treasure(){
        this.areaIndex = areaIndex;
        this.runeGained = 0;
        
    }
    public int runesGained(int areaIndex){
        Random rand = new Random();
        int randTreasure = rand.nextInt(3) + 1;
        runeGained = areaIndex * randTreasure;
        System.out.println("YOU HAVE RECEIVED " +runeGained+ "RUNES");
        return runeGained;
        
    }

}
