package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.TimerTask;

public class ZombieAppear extends TimerTask {
    public void  temp(ImageView a) {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                a.setLayoutX(a.getLayoutX() - 01);
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
            temp(a);
        }
        catch (Exception e){

        }
    }

    public void scheduledExecutionTime(int i) {
        run();
    }
}
