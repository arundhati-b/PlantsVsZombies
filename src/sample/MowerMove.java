package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

public class MowerMove extends AnimationTimer {
    ImageView lm;
    @Override
    public void handle(long now) {
        lm.setLayoutY(lm.getLayoutY() + 10);
        System.out.println("Now");
        if(lm.getLayoutY() > 1200){
            lm.setVisible(false);
        }
    }
}
