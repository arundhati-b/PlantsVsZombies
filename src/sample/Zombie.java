package sample;

import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Zombie implements Serializable {
    String image;
    int health;
    double speed;
    int attack ;
    double realSpeed;
    double x,y;
    int storedDelay;
    Zombie(String img,int health, double speed, int attack,double x,double y,int sd){
        this.health = health;
        this.speed = speed;
        this.image = img;
        this.attack = attack;
        this.realSpeed = speed;
        this.x = x;
        this.y = y;
        storedDelay = sd;
    }
}
