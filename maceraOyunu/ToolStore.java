package maceraOyunu;

import java.util.Scanner;

public class ToolStore extends NormalLoc{
    private Scanner input = new Scanner(System.in);
    public ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Magazaya Hosgeldiniz.");
        return menu();
    }

    public boolean menu(){
        System.out.println(" 1- Silahlar \n 2- Zirhlar \n 3- Cikis\n");
        System.out.print("Almak istediginiz item cesidini seciniz: ");
        int selectItem = input.nextInt();
        while (selectItem < 0 || selectItem > 3){
            System.out.print("Gecersiz deger girdiniz , tekrar deneyin.");
            selectItem =input.nextInt();
        }
        switch (selectItem){
            case 1:
                printWeapons();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                System.out.println("Birdaha bekleriz.");
                return true;
            default:

        }
        return true;
    }


    public void printWeapons(){
        System.out.println("----------Silahlar----------");
        for (Weapon w: Weapon.weapons()) {
            System.out.println(w.getId()+" "+w.getName() + " Hasar: " + w.getDamage() + " Fiyat: " + w.getPrice());
        }

    }
    public void buyWeapon(){
        System.out.print("Almak istediginiz itemi seciniz: ");
        int selectWeapon = input.nextInt();
        if (selectWeapon == 1 & getPlayer().getMoney()>25){
            getPlayer().setDamage(getPlayer().getDamage()+2);
            getPlayer().setMoney(getPlayer().getMoney()-25);
            System.out.println("Yeni Hasariniz: "+getPlayer().getDamage());
            System.out.println("Yeni Bakiyeniz: "+getPlayer().getMoney());
        }else if (selectWeapon ==2 &  getPlayer().getMoney()>35){
            getPlayer().setDamage(getPlayer().getDamage()+3);
            getPlayer().setMoney(getPlayer().getMoney()-35);
            System.out.println("Yeni Hasariniz: "+getPlayer().getDamage());
            System.out.println("Yeni Bakiyeniz: "+getPlayer().getMoney());
        }else if (selectWeapon==3 & getPlayer().getMoney()>45){
            getPlayer().setDamage(getPlayer().getDamage()+7);
            getPlayer().setMoney(getPlayer().getMoney()-45);
            System.out.println("Yeni Hasariniz: "+getPlayer().getDamage());
            System.out.println("Yeni Bakiyeniz: "+getPlayer().getMoney());
        }else {
            System.out.println("Bakiyeniz yetersiz.");
        }
    }
    public void printArmor(){
        System.out.println("-----------Zirhlar----------");
        for (Armor a: Armor.armors()) {
            System.out.println(a.getId()+" "+a.getName() + " Engelleme Degeri: " + a.getEngelleme() + " Fiyat: " + a.getPrice());
        }
    }

    public void buyArmor(){
        System.out.print("Almak istediginiz itemi seciniz: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID <1 || selectArmorID >Armor.armors().length){
            System.out.println("Gecersiz Deger Girdiniz.");
        }

        Armor selectedArmor = Armor.getArmorObjById(selectArmorID);

        if (selectedArmor != null){
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yetersiz Bakiye!");
            }else{
                System.out.println(selectedArmor.getName()+ " Zirhini aldiniz!");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println(this.getPlayer().getInventory().getArmor());
                System.out.println(" Yeni Bakiyeniz: "+this.getPlayer().getMoney());
            }
        }

    }

}
