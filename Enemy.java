
import java.util.Random;

public class Enemy{
    private int enemyType;
    private String enemyName;
    private int areaIndex;

    public Enemy(){
        this.enemyType = 0;
        this.enemyName = null;
        this.areaIndex = areaIndex;
    }

    public int getEnemyType(){
        return this.enemyType;
    }
    public String getEnemyName(){
        return this.enemyName;
    }
 
    public void generateEnemyType(int areaIndex){
        Random rand = new Random();
        int randEnemyType = rand.nextInt(3) + 1;

        if(areaIndex == 1)
        {
            if(randEnemyType == 1)
            {
                enemyType = 1;
                enemyName = "GODRICK SOLDIER";
                System.out.println("--- A "+getEnemyName()+"  HAS APPEARED ---");
                System.out.println("------- "+getEnemyName()+" -------");
                System.out.println("STATISTICS          LOW     HIGH");
                System.out.println("HEALTH              20      30");
                System.out.println("ATTACK              70      80");
                System.out.println("PHYSICAL DEFENSE       0.20   ");
                System.out.println("SORCERY DEFENSE        0.15   ");
                System.out.println("INCANTATION DEFENSE    0.10   ");
    
            }else if(randEnemyType == 2)
            {
                enemyType = 2;
                enemyName = "GODRICK ARCHER";
                System.out.println("--- A "+getEnemyName()+"  HAS APPEARED ---");
                System.out.println("------- "+getEnemyName()+" -------");
                System.out.println("STATISTICS          LOW     HIGH");
                System.out.println("HEALTH              25       35 ");
                System.out.println("ATTACK              110      120");
                System.out.println("PHYSICAL DEFENSE       0.50   ");
                System.out.println("SORCERY DEFENSE        0.15   ");
                System.out.println("INCANTATION DEFENSE    0.20   ");
            }
            else if(randEnemyType == 3)
            {
                enemyType = 3;
                enemyName = "GODRICK KNIGHT";
                System.out.println("--- A "+getEnemyName()+"  HAS APPEARED ---");
                System.out.println("------- "+getEnemyName()+" -------");
                System.out.println("STATISTICS          LOW     HIGH");
                System.out.println("HEALTH              70      80");
                System.out.println("ATTACK              120      130");
                System.out.println("PHYSICAL DEFENSE       0.25   ");
                System.out.println("SORCERY DEFENSE        0.25   ");
                System.out.println("INCANTATION DEFENSE    0.20   ");
            }
        }
    }


}
