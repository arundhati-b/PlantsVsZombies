package sample;

import javafx.scene.image.ImageView;

public class Cherrybomb extends Plant {

    Cherrybomb(ImageView i) {
        super((int) i.getLayoutX(), (int) i.getLayoutY(), i, 160000, 150);
    }
}
