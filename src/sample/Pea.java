package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

class Pea extends TimerTask {
    ImageView a;
    double x;
    double y;
    int attack = 5;
    Pea(ImageView p, double x, double y){

        this.a = p;
        this.x = x + 10;
        this.y = y + 20;
        a.setVisible(true);

    }
    public void  move() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                a.setLayoutX(a.getLayoutX() + 10);
                if(a.getLayoutX() > 1400){
                    a.setLayoutX(x);
                    a.setVisible(true);
                    a.setLayoutY(y);
                }
                collide(Backyard.zombieApp);
            }
        }.start();
    }


    public void collide(ArrayList<ZombieAppear> zombieApp){

        for(int i = 0; i < zombieApp.size(); i++){

                ZombieAppear zombieAppear = zombieApp.get(i);

                System.out.println(a.getLayoutX() + "     " + a.getLayoutY() + "   ashjbf uisf ");
                System.out.println(zombieAppear.a.getLayoutX() + "         " + zombieAppear.a.getLayoutY());

                if(this.a.isVisible() && zombieAppear.health > 0 && Math.abs(this.a.getLayoutX() - zombieAppear.a.getLayoutX()) <= 30 && Math.abs(this.a.getLayoutY() - zombieAppear.a.getLayoutY()) <= 100 && this.a.getLayoutX() != 0 && zombieAppear.a.isVisible()){
                    System.out.println(a.getLayoutX() + "     " + a.getLayoutY() + "   ashjbf uisf ");
                    System.out.println(zombieAppear.a.getLayoutX() + "         " + zombieAppear.a.getLayoutY());
                    System.out.println(zombieAppear.health + " Left");
                    zombieAppear.health -= this.attack;
                    this.a.setVisible(false);
                    if(zombieAppear.health <= 0){
                        zombieAppear.kill();
                    }
                }
        }
    }
    @Override
    public void run() {
        move();
    }
}