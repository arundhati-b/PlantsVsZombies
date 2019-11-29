package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.Random;
import java.util.TimerTask;

public class ZombieAppear extends TimerTask {
    int health = 30;
    AnimationTimer t;
    public void  move(ImageView a) {
        t = new AnimationTimer() {
            @Override
            public void handle(long now) {
                a.setLayoutX(a.getLayoutX() - 0.5);
            }
        };
        t.start();
    }

    ZombieAppear(ImageView a){
        this.a = a;
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
