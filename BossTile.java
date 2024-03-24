import java.util.ArrayList;

public class BossTile extends Tile{
    private char BossTileSymbol;
    private int BossTileXcoor;
    private int BossTileYcoor;
    private boolean isBossTile;
    private boolean isBossTileInteracted;
    private String BossName;

    public BossTile(char BossTileSymbol, int BossTileXcoor, int BossTileYcoor)
    {
        super(BossTileSymbol, BossTileXcoor, BossTileYcoor);
        this.BossTileSymbol = BossTileSymbol;
        this.BossTileXcoor = BossTileXcoor;
        this.BossTileYcoor = BossTileYcoor;
        this.isBossTile = isBossTile;
        this.isBossTileInteracted = isBossTileInteracted;
        this.BossName = null;
    }

    public boolean isBossTile(){ 
        return isBossTile;
    }

    public boolean isBossTileInteracted(){
        return isBossTileInteracted = false;
    }

    public void addTiletoList(ArrayList<ArrayList<Tile>> tilesList)
    {
        if (tilesList != null && tilesList.size() > BossTileXcoor && tilesList.get(BossTileXcoor).size() > BossTileYcoor) {
            tilesList.get(BossTileXcoor).set(BossTileYcoor, this);
        } else {
            System.out.println("Invalid tilesList dimensions.");
        }
    }

    public void interactBossTile()
    {
        BossName = "GODRICK THE GRAFTED";
        System.out.println("--- "+getBossName()+"  HAS APPEARED ---");
        System.out.println("------- "+getBossName()+" -------");
        System.out.println("HEALTH     DAMAGE                DEFENSE");
        System.out.println("          LOW  HIGH    PHYSICAL  SORCERY INCANTATION");
        System.out.println(" 200      150  300       0.35      0.20      0.15 ");
        System.out.println("\n\n");
        isBossTileInteracted = true;
    }
   
    public char getBossTileSymbol(){
        return this.BossTileSymbol;
    }
    public int getTileXcoor()
    {
        return this.BossTileXcoor;
    }
    public int getTileYcoor()
    {
        return this.BossTileYcoor;
    }
    public String getBossName()
    {
        return this.BossName;
    }
}
