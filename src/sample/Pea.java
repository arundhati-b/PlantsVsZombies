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
        this.x = x + 10;
        this.y = y + 5;
        a.setVisible(true);

    }
    public void  move() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                a.setLayoutX(a.getLayoutX() + 10);
                if(a.getLayoutX() > 1000){
                    a.setLayoutX(x);
                    a.setLayoutY(y);
                }
            }
        }.start();
    }
    @Override
    public void run() {
        move();
    }
}