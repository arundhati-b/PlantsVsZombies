package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.TimerTask;

public class SunFSun extends TimerTask {
    ImageView a;
    ImageView parent;
    Label s;
    SunFSun(ImageView a, ImageView parent, Label s){
        this.a = a;
        this.parent = parent;
        this.s = s;
        a.setLayoutX(parent.getLayoutX());
        a.setLayoutY(parent.getLayoutY());
        a.setVisible(true);
    }

    AnimationTimer t;
    public void  move(ImageView a) {
        a.setOnMouseClicked(e -> {
                int temp = Integer.parseInt(s.getText() )+ 25;
                s.setText(temp + "");
                a.setVisible(false);
        });
        t = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(parent.isVisible()){
                    a.setVisible(true);
                    a.setLayoutY(a.getLayoutY() + 1);
                    if(a.getLayoutY() - parent.getLayoutY() > 5){
                        a.setVisible(false);
                    }
                    if(a.getLayoutY() - parent.getLayoutY() > 15){
                        a.setLayoutY(parent.getLayoutY());
                    }
                }
            }
        };

        t.start();

    }
    @Override
    public void run() {
        System.out.println("Here");
        move(a);
    }
}
