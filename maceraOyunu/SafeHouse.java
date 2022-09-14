package maceraOyunu;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Guvenli Ev");
    }

    public boolean onLocation(){
        System.out.println("Guvenli Evdesiniz.");
        System.out.println("Caniniz Yenilendi.");
        this.getPlayer().setHealth(this.getPlayer().getOrjHealth());
        return true;
    }


}
