package sample;

import javafx.scene.image.ImageView;

public abstract class Zombie {
    String image;
    int health;
    double speed;
    int attack ;
    Zombie(String img,int health, double speed, int attack){
        this.health = health;
        this.speed = speed;
        this.image = img;
        this.attack = attack;
    }
}
