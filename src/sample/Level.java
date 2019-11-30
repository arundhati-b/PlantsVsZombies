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
    public static ArrayList<ZombieAppear> zombieApp;
    int sunCount;
    int below;
    int top;
    int levelScore;
    int lvlNo;
    Level(int top, int below, int lveNo) {
        this.lvlNo = lveNo;
        this.below = below;
        this.top = top;
    }

    public int getLvlNo()
    {
        return lvlNo;
    }

}
