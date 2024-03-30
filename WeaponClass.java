public abstract class WeaponClass{
    protected WeaponStats weaponStats;
    protected int weaponCost;
    protected String weaponName;
    
    public WeaponStats getWeaponStats(){
        return weaponStats;
    }

    public int getWeaponCost()
    {
        return weaponCost;
    }

    public String getWeaponName()
    {
        return this.weaponName;
    }

}