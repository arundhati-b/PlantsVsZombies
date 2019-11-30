package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Walnut extends Plant {
    ImageView a;
    Walnut(ImageView a) {
        super((int)a.getLayoutX(),(int) a.getLayoutY(), a, 100);
    }

}
