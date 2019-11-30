package sample;


import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;

public abstract class Plant {
    int health;
    double posx ;
    double posy;
    ImageView image;
    Cell loc;
    Plant(int x, int y, ImageView i, int health)
    {
        this.image = i;
        loc = new Cell(x,y,this);
        this.health = health;
        this.posx = i.getLayoutX();
        this.posy = i.getLayoutY();
    }
}
