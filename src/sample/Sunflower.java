package sample;

import javafx.scene.image.ImageView;

public class Sunflower extends Plant{
    ImageView a;
    volatile SunView sv;
    Sunflower(ImageView a){
        //What are these int values for
        super((int)a.getLayoutX(),(int) a.getLayoutY(), a, 30, 50);
    }
}
