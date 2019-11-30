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

    transient static int[] pos = {90 ,200, 310, 420,500};
    ArrayList<Plant> currentPlants = new ArrayList<Plant>();
    ArrayList<Plant> PlantedPlants = new ArrayList<>();
    private int sunCount;
    private int below;
    private int top;
    private int levelScore;
    private int lvlNo;
    Level(int top, int below, int lvlNo) {
        this.lvlNo = lvlNo;
        this.below = below;
        this.top = top;
    }

    public void play() throws GameLostException
    {
//        ChooseLevel.callBackyard();
    }

    public int getSunCount() {
        return sunCount;
    }

    public int getBelow() {
        return below;
    }

    public int getTop() {
        return top;
    }

    public int getLevelScore() {
        return levelScore;
    }

    public int getLvlNo()
    {
        return lvlNo;
    }

    public void setSunCount(int sunCount) {
        this.sunCount = sunCount;
    }

    public void setLevelScore(int levelScore) {
        this.levelScore = levelScore;
    }

    public void print()
    {
        System.out.println("Level number: "+lvlNo);
        System.out.println("Sun count: "+sunCount);
        System.out.println("Level Score: "+levelScore);
    }

}
