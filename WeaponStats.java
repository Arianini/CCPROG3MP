public class WeaponStats{
    private int whp, wdex, wint, wend, wstr, wfth;


    public WeaponStats(int whp, int wdex, int wint, int wend, int wstr, int wfth){
        this.whp = whp;
        this.wdex = wdex;
        this.wint = wint;
        this.wend = wend;
        this.wstr = wstr;
        this.wfth = wfth;
    }
    public int getWHp()
    {
        return whp;
    }
    public int getWDex()
    {
        return wdex;
    }
    public int getWIntel()
    {
        return wint;
    }
    public int getWEnd()
    {
        return wend;
    }
    public int getWStr()
    {
        return wstr;
    }
    public int getWFth()
    {
        return wfth;
    }

    public String toString() {
        return String.format("HP: %d, DEX: %d, INT: %d, END: %d, STR: %d, FTH: %d",
                 whp, wdex, wint, wend, wstr, wfth);
    }
}