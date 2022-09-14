package maceraOyunu;

import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int orjHealth;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;


    public Player(String name) {
        this.name = name;
        this.inventory= new Inventory();
    }

    public void selectChar(){

        System.out.println("--------------------------------");
        gameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        for (gameChar gameChar: charList){

            System.out.println("ID: " + gameChar.getId()+
                    "\tKarakter: "+ gameChar.getName() +
                    "\t Hasar: "+gameChar.getDamage() +
                    "\t Saglik: "+gameChar.getHealth() +
                    "\t Para: "+ gameChar.getMoney());
        }
        System.out.println("-------------------------------");
        System.out.print("Karakter Seciniz: ");

        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());

        }
        System.out.println("Sectiginiz Karakter: "
                + this.getCharName() + " Hasar: "
                + this.getDamage() + " Saglik: "
                + this.getHealth() + " Para: "+ this.getMoney());

    }

    public void initPlayer(gameChar gamechar){
        this.setDamage(gamechar.getDamage());
        this.setHealth(gamechar.getHealth());
        this.setOrjHealth(gamechar.getHealth());
        this.setMoney(gamechar.getMoney());
        this.setCharName(gamechar.getName());
    }
    public void printInfo(){
        System.out.println( "Hasariniz: "
                + this.getDamage() +" - " + " Saglik: "
                + this.getHealth() +" - " + " Para: "+ this.getMoney()+" - "+
                " Zirhiniz: "+ this.getInventory().getArmor().getName()+" - "+
                " Blok Degeri: "+ this.getInventory().getArmor().getEngelleme());
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }
}
