package sample;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;

public abstract class Plant implements Serializable {
    int health;
<<<<<<< HEAD
    int attack;
=======
    int cost;
>>>>>>> 147edbaffb46d987c68b833dfbc2bd2b89274592
    double posx ;
    public boolean status = true;
    double posy;
    transient ImageView image;
    Cell loc;
    Plant(int x, int y, ImageView i, int health, int cost)
    {
        this.image = i;
        loc = new Cell(x,y,this);
        this.health = health;
        this.posx = i.getLayoutX();
        this.posy = i.getLayoutY();
        this.cost = cost;
    }
}
