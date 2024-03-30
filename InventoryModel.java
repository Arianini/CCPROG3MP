import java.util.ArrayList;

public class InventoryModel{
    private WeaponClass weaponClass;
    private ArrayList<Weapon> weapons = new ArrayList<>();

    public InventoryModel(CharacterModel model) {
    }

    public void addWeapon(WeaponClass weapon)
    {
            weapons.add(weapon);
    }

    public WeaponClass getWeaponName()
    {
        return weaponName;
    }

    public ArrayList<Weapon> getWeapons()
    {
        return weapons;
    }

}