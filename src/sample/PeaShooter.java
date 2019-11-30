package sample;


import javafx.scene.image.ImageView;

import java.util.TimerTask;

public class PeaShooter extends Plant {

    PeaShooter(ImageView i) {
        super((int) i.getLayoutX(), (int) i.getLayoutY(), i, 40, 100);
    }
}