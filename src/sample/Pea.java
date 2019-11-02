package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;


import java.util.Timer;
import java.util.TimerTask;

class Pea extends TimerTask {
    ImageView a;
    double x;
    double y;
    Pea(ImageView p, double x, double y){

        this.a = p;
        this.x = x;
        this.y = y;
        System.out.println(x+" "+y);
        a.setLayoutY(y);
        a.setLayoutX(x);


    }
    public void  move() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                a.setLayoutX(a.getLayoutX() + 1);
                if(a.getLayoutY() > 600){

                    a.setLayoutY(-100);
                    a.setLayoutX(-100);
                }
            }
        }.start();
    }
    @Override
    public void run() {
        move();
    }
}