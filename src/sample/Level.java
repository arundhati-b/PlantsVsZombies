package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Level implements Serializable {

    static int[] pos = {90 ,200, 310, 420,500};
    ArrayList<Plant> currentPlants = new ArrayList<Plant>();
    static public ArrayList<ZombieAppear> zombieApp;
    Map<Cell,Plant> cells = new HashMap<Cell,Plant>();
    int sunCount;
    int levelScore;
    int lvlNo;
    Level(int top, int below, int lveNo) {
        Backyard.zombieApp = new ArrayList<>();
        sunCount = 100;
        levelScore = 0;
        this.lvlNo = lveNo;
        Random rand = new Random();
        for(int i = 0; i < lveNo; i++){
            System.out.println("i");
            int ran1 = rand.nextInt(top) + below;

            if(i == 0){
                Zombie t1 = new ZombieNormal();
                for(int j = 0; j < ran1; j++) {
                    ZombieAppear temp = new ZombieAppear(new ImageView(t1.image), t1.health, t1.speed);
                    temp.a.setLayoutX(1500);
                    temp.a.setLayoutY(pos[rand.nextInt(pos.length)]);
                    System.out.println(temp.a.getX() + " " + temp.a.getY());
                    Backyard.zombieApp.add(temp);
                }
            }
            else if (i == 1){
                Zombie t2 = new ZombieNormal();
                for(int j = 0; j < ran1; j++) {
                    ZombieAppear temp = new ZombieAppear(new ImageView(t2.image), t2.health, t2.speed);
                    temp.a.setLayoutX(1500);
                    temp.a.setLayoutY(pos[rand.nextInt(pos.length)]);
                    System.out.println(temp.a.getX() + " " + temp.a.getY());
                    Backyard.zombieApp.add(temp);
                }
            }
        }
    }

    public int getLvlNo()
    {
        return lvlNo;
    }

}
