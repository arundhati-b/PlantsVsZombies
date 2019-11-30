package sample;


import javafx.scene.image.ImageView;

public abstract class Plant {
    int health;
    ImageView image;
    Cell loc;
    Plant(int x, int y, ImageView i, int health)
    {
        image = i;
        loc = new Cell(x,y,this);
        this.health = health;
    }
}
