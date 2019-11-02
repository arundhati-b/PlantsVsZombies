package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

import java.util.TimerTask;

public class LawnMower extends TimerTask {
    ImageView lm;

    LawnMower(ImageView lm){
        this.lm = lm;
    }
    @Override
    public void run() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(lm.getLayoutX() < 1000)
                lm.setLayoutX(lm.getLayoutX() + 5);
            }
        }.start();
    }
}
