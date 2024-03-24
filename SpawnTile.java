import java.util.ArrayList;
import java.util.Random;

public class SpawnTile extends Tile{
    private int areaIndex;
    private char spawnTileSymbol;
    private int spawnTileXcoor;
    private int spawnTileYcoor;
    private boolean isSpawnTile;
    private boolean isSpawnType;
    private boolean isDisabled;
    private Enemy enemy;
    private Treasure treasure;

    public SpawnTile(int areaIndex, char spawnTileSymbol, int spawnTileXcoor, int spawnTileYcoor)
    {
        super(spawnTileSymbol, spawnTileXcoor, spawnTileYcoor);
        this.areaIndex = areaIndex;
        this.spawnTileSymbol = spawnTileSymbol;
        this.spawnTileXcoor = spawnTileXcoor;
        this.spawnTileYcoor = spawnTileYcoor;
        this.isSpawnTile = true;
        this.isSpawnType = SpawnType();
        this.isDisabled = false;

        /*this.enemyType = 0;
        this.enemyName = enemyName;
        this.runeGained = 0;*/
    }
    public void addTiletoList(ArrayList<ArrayList<Tile>> tilesList){
        if (tilesList != null && tilesList.size() > spawnTileXcoor && tilesList.get(spawnTileXcoor).size() > spawnTileYcoor) {
            tilesList.get(spawnTileXcoor).set(spawnTileYcoor, new SpawnTile(areaIndex, spawnTileSymbol, spawnTileXcoor, spawnTileYcoor));
        } else {
            System.out.println("Invalid tilesList dimensions.");
        }
    }

    public boolean isSpawnTile()
    {
        return this.isSpawnTile;
    }

    public void disableSpawn()
    {
        this.isDisabled = true;
    }
    public boolean SpawnType()
    {
        Random rand = new Random();
        int spawnRandom = rand.nextInt(100) + 1;

        if(spawnRandom <= 75){
            //disableSpawn();
            return true;
        }
        else
        {
            //disableSpawn();
            return false;
        }
    }

    public void interactSpawn()
    {
        if (isEnemy())
        {
            Enemy enemy = new Enemy();
            enemy.generateEnemyType(areaIndex);
            
        }
        else if(isTreasure())
        {
            Treasure treasure = new Treasure();
            treasure.runesGained(areaIndex);
            
        }
    }


    public char getspawnTileSymbol(){
        return this.spawnTileSymbol;
    }

    public int getspawnTileXcoor()
    {
        return this.spawnTileXcoor;
    }

    public int getspawnTileYcoor()
    {
        return this.spawnTileYcoor;
    }

    public boolean isEnemy()
    {
        return isSpawnType;
    }

    public boolean isTreasure(){
        return !isSpawnType;
    }

    }



