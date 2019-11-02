package sample;

import javafx.animation.AnimationTimer;

import javax.swing.text.html.ImageView;
import java.util.Timer;
import java.util.TimerTask;

class Pea extends TimerTask {
    ImageView p;
    int x;
    int y;
    Pea(ImageView p, int x, int y){
        this.p =p;
        this.x = x;
        this.y = y;

    }
    public void  move(javafx.scene.image.ImageView a) {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                a.setLayoutY(a.getLayoutY() + 1);
                if(a.getLayoutY() > 600){
                    a.setLayoutY(x);
                    a.setLayoutX(y);
                }
            }
        }.start();
    }
    @Override
    public void run() {

    }
}