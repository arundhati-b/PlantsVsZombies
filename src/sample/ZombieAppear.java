package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.Random;
import java.util.TimerTask;

public class ZombieAppear extends TimerTask {
    Random rand = new Random();
    int health;
    public void  move(ImageView a) {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                a.setLayoutX(a.getLayoutX() - 0.5);
            }
        }.start();
    }

    ZombieAppear(ImageView a){
        this.a = a;
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
