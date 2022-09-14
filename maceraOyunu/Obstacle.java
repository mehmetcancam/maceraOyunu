package maceraOyunu;

public abstract class Obstacle {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int paraAward;
    private int defaultHealth;


    public Obstacle(String name, int id, int damage, int health, int paraAward) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.defaultHealth=health;
        this.paraAward = paraAward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getParaAward() {
        return paraAward;
    }

    public void setParaAward(int paraAward) {
        this.paraAward = paraAward;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }
}
