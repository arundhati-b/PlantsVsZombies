package sample;

import javafx.scene.image.ImageView;

public abstract class Zombie {
    String image;
    int health;
    double speed;
    int attack ;
    double realSpeed;
    Zombie(String img,int health, double speed, int attack){
        this.health = health;
        this.speed = speed;
        this.image = img;
        this.attack = attack;
        this.realSpeed = speed;
    }
}
