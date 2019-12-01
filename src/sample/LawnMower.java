package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class LawnMower extends TimerTask{
    transient ImageView lm;
    boolean detected = false;
    Timer time = new Timer();
    int x ;
    int y;
    int attack = 10000;
    LawnMower(int x, int y, ImageView lm){
        this.x = x;
        this.y = y;

//        super(x , y , lm ,100,100);

        this.lm = lm;
    }

    public void collide(ArrayList<ZombieAppear> zombieApp){

        for(int i = 0; i < zombieApp.size(); i++){
            ZombieAppear zombieAppear = zombieApp.get(i);

            if(this.lm.isVisible() && zombieAppear.health > 0 && Math.abs(this.lm.getLayoutX() - zombieAppear.a.getLayoutX()) <= 30 && Math.abs(this.lm.getLayoutY() - zombieAppear.a.getLayoutY()) <= 50 && this.lm.getLayoutX() != 0 && zombieAppear.a.isVisible()){
                detected = true;
                System.out.println("abuisfghiuasghf");
                    zombieAppear.health -= this.attack;
                    if(zombieAppear.health <= 0){
                        zombieAppear.kill();
                    }
            }
        }
    }



    @Override
    public void run() {
        try {
            if (detected) {
                lm.setLayoutX(lm.getLayoutX() + 10);
            }
//            System.out.println("Now " + lm.getLayoutY());
            if (lm.getLayoutY() > 500) {
//                lm.setVisible(false);
                lm.setDisable(true);
            }
            this.collide(Backyard.zombieApp);
        }
        catch(Exception e){

        }
    }
}
