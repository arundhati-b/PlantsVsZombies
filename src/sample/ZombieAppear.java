package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;
import java.util.TimerTask;

public class ZombieAppear extends TimerTask  {
    int health;
    double speed;
    ImageView reference = new ImageView("sample/resources/Zombie_Normal.gif");
    AnimationTimer t;
    public void  move(ImageView a) {
        t = new AnimationTimer() {
            @Override
            public void handle(long now) {
                a.setLayoutX(a.getLayoutX() - speed);
                if(a.getImage() != reference.getImage() && health <= 30){
                    a.setImage(new Image("sample/resources/Zombie_Normal.gif"));
                }
            }
        };
        t.start();
    }

    ZombieAppear(ImageView a, int health, double speed){
        this.a = a;
        this.health = health;
        this.speed = speed;
    }

    void kill(){
        t.stop();
        a.setVisible(false);
    }

    ImageView a;

    @Override
    public void run() {
        try{
            move(a);
        }
        catch (Exception e){

        }
    }

}
