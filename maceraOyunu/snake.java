package maceraOyunu;

import java.util.Random;

public class snake extends Obstacle{


    public snake() {
        super("Yilan",4,6,12,0);

    }

    public int snakeDamage(){
        Random r = new Random();
        return r.nextInt(4)+3;

    }

    public void snakee(){
        this.setDamage(snakeDamage());
    }


}
