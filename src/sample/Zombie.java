package sample;

import javafx.scene.image.ImageView;

public abstract class Zombie {
    String image;
    int health;
    double speed;
    Zombie(String img,int health, double speed){
        this.health = health;
        this.speed = speed;
        this.image = img;

    }
}
