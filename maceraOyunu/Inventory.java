package maceraOyunu;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private String food;


    public Inventory() {
       this.weapon = new Weapon("Yumruk",0,0,0);
       this.armor = new Armor("Pacavra",0,0,0);
       this.food=food;

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
