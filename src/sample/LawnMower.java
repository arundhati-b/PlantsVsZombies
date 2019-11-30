package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

import java.util.TimerTask;

public class LawnMower extends Plant {
    ImageView lm;

    LawnMower(int x, int y, ImageView lm){
        super(x , y , lm ,100,100);
        this.lm = lm;
    }
}
