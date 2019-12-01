package sample;


import javafx.scene.image.ImageView;

import java.util.TimerTask;

public class PeaShooter extends Plant {

    PeaShooter(ImageView i,int x, int y) {
        super(x,y , i, 40, 100);
    }
}