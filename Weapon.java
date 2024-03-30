import javax.swing.*;

public class Weapon{
    private String imagePath;
    private WeaponClass weaponClass;
    private Weapon selectedWeapon;

    public Weapon(String imagePath, WeaponClass weaponClass){
        this.imagePath = imagePath;
        this.weaponClass = weaponClass;
    }
    
    public Weapon getSelectedWeapon()
    {
        return selectedWeapon;
    }

    public void setSelectedWeapon(Weapon weapon){
       this.selectedWeapon = weapon;
    }

    
    public String getImagePath(){
        return imagePath;
    }

    public WeaponClass getWeaponClass(){
        return weaponClass;
    }
}