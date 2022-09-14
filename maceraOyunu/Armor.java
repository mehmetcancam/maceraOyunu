package maceraOyunu;

public class Armor {
    String name;
    private int id;
    private int engelleme;
    private int price;

    public Armor(String name, int id, int engelleme, int price) {
        this.name = name;
        this.id = id;
        this.engelleme = engelleme;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armors = new Armor[3];
        armors[0]= new Armor("Hafif",1,1,15);
        armors[1]= new Armor("Orta",2,3,25);
        armors[2]= new Armor("Agir",3,5,40);
        return armors;
    }

    public static Armor getArmorObjById(int id){
        for (Armor a: Armor.armors()){
            if (a.getId()==id){
                return a;
            }
        }
        return null;
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


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEngelleme() {
        return engelleme;
    }

    public void setEngelleme(int engelleme) {
        this.engelleme = engelleme;
    }
}
