package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

import java.util.Random;
import java.util.TimerTask;

public class SunView extends TimerTask {
    Random rand  = new Random();
    public void  move(ImageView a) {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                a.setLayoutY(a.getLayoutY() + 1);
                if(a.getLayoutY() > 400){
                    a.setLayoutY(-200);
                    a.setLayoutX(rand.nextInt(700) + 300);
                }
            }
        }.start();
    }

    SunView (ImageView a){
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
