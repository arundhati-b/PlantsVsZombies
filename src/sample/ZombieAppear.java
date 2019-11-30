package sample;

import javafx.animation.AnimationTimer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

import java.util.TimerTask;

public class ZombieAppear extends TimerTask {

    int health;
    double speed;
    int k = 0;
    int attack;
    ImageView reference = new ImageView("sample/resources/Zombie_Normal.gif");
    AnimationTimer t;
    public void  move(ImageView a, ZombieAppear za) {
        t = new AnimationTimer() {
            @Override
            public void handle(long now) {
                a.setLayoutX(a.getLayoutX() - speed);
                if(a.getLayoutX() < 200){
                    za.speed = 0;
                }
                k++;
                if(a.getImage() != reference.getImage() && health <= 30){
                    a.setImage(new Image("sample/resources/Zombie_Normal.gif"));
                }

                if(k > 100){
                    plantAttacK(Game.getInstance().getLevel().PlantedPlants, za);
                    k = 0;
                }
                mowerKill(Backyard.lawnMowers, za);

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
        try {
            a.setVisible(false);
            t.stop();
        }
        catch(Exception e){

        }
        a.setVisible(false);
    }

    ImageView a;


    void mowerKill(ArrayList<LawnMower> lawn, ZombieAppear z){
        for(LawnMower l : lawn){
            if(l.lm.getLayoutY() > z.a.getLayoutY() + 40 && Math.abs(l.lm.getLayoutX() - z.a.getLayoutX()) < 50){
                l.collide(Backyard.zombieApp);
            }
        }

    }


    @Override
    public void run() {
        try{
            move(a, this);
        }
        catch (Exception e){

        }
    }

    void plantAttacK(ArrayList<Plant> plantPlanted, ZombieAppear za){
        for (Plant p : plantPlanted){
            if(p.image.isVisible()){
                p.image.setLayoutX(p.posx);
                p.image.setLayoutY(p.posy);
            }

            if(p.image.isVisible() && za.a.isVisible() && Math.abs(p.image.getLayoutX() - za.a.getLayoutX()) <= 30 && Math.abs(p.image.getLayoutY() - za.a.getLayoutY()) <= 50){
                za.speed = 0;
                System.out.println("Here");
                p.health = p.health - za.attack;
                if(p.health <= 0){

                    p.image.setVisible(false);
                    p.status = false;
                    p.image.setLayoutX(-100);
                    p.image.setLayoutY(-100);
                    za.speed = 0.5;
                    try{
                        Sunflower p1 = (Sunflower) p;
                        System.out.println("BYE");
                        p1.sv.kill();
                    }
                    catch(Exception e){

                    }
                }
            }
        }
    }
}
