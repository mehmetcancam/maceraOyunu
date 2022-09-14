package maceraOyunu;

import java.lang.invoke.MethodHandles;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);


    public void start(){
        System.out.println("Macera Oyununa Hosgeldiniz!");
        System.out.print("Lutfen bir isim giriniz: ");
        String playerName = input.nextLine();
        Player p1 = new Player(playerName);
        System.out.println(p1.getName()+ " Zindan Adasina Hosgeldin :)");
        System.out.println("Burada Yasananlarin Hepsi Gercek!");
        System.out.println("Karakterini Sec!");
        p1.selectChar();
        Location location = null;
        while (true){
            p1.printInfo();
            System.out.println("------------------------");
            System.out.println("Bolgeler");
            System.out.println("------------------------");
            System.out.println("1- Guvenli Ev --> Burasi sizin icin guvenli ev, dusman yoktur.");
            System.out.println("2- Esya Dukkani --> Silah veya Zirh satin alabilirsiniz.");
            System.out.println("3- Magara --> Odul <Yemek> , dikkatli ol zombi cikabilir.");
            System.out.println("4- Orman --> Odul <Odun> , dikkatli ol vampir cikabilir.");
            System.out.println("5- Nehir --> Odul <Su> , dikkatli ol ayi cikabilir.");
            System.out.println("6- Maden --> Odul <Silah veya Zirh> , dikkatli ol yilan cikabilir.");
            System.out.println("0- Cikis Yap --> Oyunu Sonlandir.");
            System.out.print("Lutfen gitmek istediginiz bolgeyi seciniz: ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(p1);
                    break;
                case 2:
                    location = new ToolStore(p1);
                    break;
                case 3:
                    location = new Cave(p1);
                    break;
                case 4:
                    location = new Forest(p1);
                    break;
                case 5:
                    location= new River(p1);
                    break;
                case 6:
                    location= new Mine(p1);
                    break;
                default:
                    location = new SafeHouse(p1);
            }
            if (location == null){
                System.out.println("Oyundan Cikis Yapildi.");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!!");
                break;
            }

        }



    }

}
