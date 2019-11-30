package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

public class ZombieAppear extends TimerTask {
    int health;
    double speed;
    int attack;
    ImageView reference = new ImageView("sample/resources/Zombie_Normal.gif");
    AnimationTimer t;
    public void  move(ImageView a) {
        t = new AnimationTimer() {
            @Override
            public void handle(long now) {
                a.setLayoutX(a.getLayoutX() - speed);
                if(a.getImage() != reference.getImage() && health <= 30){
                    a.setImage(new Image("sample/resources/Zombie_Normal.gif"));
                }
            }
        };
        t.start();
    }

    ZombieAppear(ImageView a, int health, double speed, int attack){
        this.a = a;
        this.health = health;
        this.speed = speed;
        this.attack = attack;
    }

    void kill(){
        t.stop();
        a.setVisible(false);
    }

    ImageView a;

    @Override
    public void run() {
        try{
            move(a);
            plantAttacK(Backyard.PlantedPlants, this);
        }
        catch (Exception e){

        }
    }

    void plantAttacK(ArrayList<Plant> plantPlanted, ZombieAppear za){
        for (Plant p : plantPlanted){
            System.out.println(p.image.getLayoutX() + " " + za.a.getLayoutX());
            System.out.println(p.image.getLayoutY() + " " + za.a.getLayoutY());
            if(p.image.isVisible() && za.a.isVisible() && Math.abs(p.image.getLayoutX() - za.a.getLayoutX()) <= 100 && Math.abs(p.image.getLayoutY() - za.a.getLayoutY()) <= 100){
                za.speed = 0;
                p.health = p.health - za.attack;
                if(p.health <= 0){
                    p.image.setVisible(false);
                    p.image.setLayoutX(-100);
                    p.image.setLayoutY(-100);
                    za.speed = 0.5;

                }
            }
        }
    }
}
