package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.Random;
import java.util.TimerTask;

public class SunView extends TimerTask  {
    Random rand  = new Random();
    public void  move(ImageView a) {
        a.setOnMouseClicked(e -> {
            int temp = Integer.parseInt(s.getText() )+ 25;
            s.setText(temp + "");
            a.setLayoutY(-300);
            a.setLayoutX(rand.nextInt(700) + 300);
        });
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                a.setLayoutY(a.getLayoutY() + 1);
                if (a.getLayoutY() > 400) {
                    a.setLayoutY(-200);
                    a.setLayoutX(rand.nextInt(700) + 300);
                }
            }
        }.start();
    }


    SunView (ImageView a, Label s){
        this.a = a;
        this.s = s;
    }

    ImageView a;
    Label s;
    @Override
    public void run() {
        try{
            move(a);
        }
        catch (Exception e){

        }
    }
}
