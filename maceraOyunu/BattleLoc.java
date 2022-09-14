package maceraOyunu;

import java.util.Random;
import java.util.*;

public abstract class BattleLoc extends Location{
    Scanner input = new Scanner(System.in);

    private  Obstacle obstacle;
    private String award;
    private int maxObs;

    public BattleLoc(Player player, String name, Obstacle obstacle,String award,int maxObs) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObs=maxObs;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObs() {
        return maxObs;
    }

    public void setMaxObs(int maxObs) {
        this.maxObs = maxObs;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObsNumber();
        System.out.println("-------------------------------------------------");
        System.out.println("Suan buradasiniz: "+this.getName());
        System.out.println("Dikkatli ol!! Burada "+obsNumber+" "+ this.getObstacle().getName()+ " yasiyor!");
        System.out.print("<S>avas veya <K>ac: ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")){
            if (combat(obsNumber)){
                System.out.println(this.getName()+ " tum dusmanlari yenidiniz !");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0 ){
            System.out.println("Oldunuz!!");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber){
        for (int i = 1; i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getDefaultHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 & this.getObstacle().getHealth() > 0){
                System.out.print("<V>ur veya <K>ac: ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                    System.out.println("Siz vurdunuz !");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0 ){
                        System.out.println();
                        System.out.println(this.getObstacle().getName()+ " size vurdu!! ");
                        int obstacleDamgae = this.getObstacle().getDamage()- this.getPlayer().getInventory().getArmor().getEngelleme();
                        if (this.getObstacle().getHealth() < 0 ){
                            obstacleDamgae=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamgae);
                        afterHit();
                    }
                    if (this.getObstacle().getHealth()<=0){
                        System.out.println(this.getObstacle().getName()+ " oldu!");
                        backingHome();
                    }
                }
                if (selectCombat.equals("K")){
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Dusmani Yendiniz!");
                System.out.println(this.getObstacle().getParaAward()+ " para kazandiniz");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getParaAward());
                System.out.println("Guncel paraniz: "+ this.getPlayer().getMoney());
            }
        }
        return false;
    }



    public void afterHit(){
        if (this.getObstacle().getHealth()<0){
            this.getObstacle().setHealth(0);
        }
        System.out.println("Sagliginiz: "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" "+this.getObstacle().getHealth()+" cani");
        System.out.println();

    }
    public void playerStats(){
        System.out.println("---------------------");
        System.out.println("Oyuncu Degerleri: ");
        System.out.println("Saglik: "+this.getPlayer().getHealth());
        System.out.println("Hasar: "+ this.getPlayer().getDamage());
        System.out.println("Zirh: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Engelleme Gucu: "+ this.getPlayer().getInventory().getArmor().getEngelleme());
        System.out.println("----------------------");
    }
    public void obstacleStats(int i){
        System.out.println( i + ". "+ this.getObstacle().getName());
        System.out.println("----------------------");
        System.out.println(this.getObstacle().getName()+" Degerleri ");
        System.out.println("Saglik: "+this.getObstacle().getHealth());
        System.out.println("Hasar: "+ this.getObstacle().getDamage());
        System.out.println("Odul: "+ this.getObstacle().getParaAward());
        System.out.println("----------------------");
    }

    public int randomObsNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObs())+1;
    }
    public void backingHome(){
        this.getPlayer().getInventory().setFood("Yemek");
        System.out.println("Odul alindi.");
    }
}
