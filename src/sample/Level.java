package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Level implements Serializable {

    ArrayList<Plant> currentPlants = new ArrayList<Plant>();
    ArrayList<Zombie> activeZombies = new ArrayList<Zombie>();
    ArrayList<Zombie> availableZombies = new ArrayList<Zombie>();
    Map<Cell,Plant> cells = new HashMap<Cell,Plant>();
    int sunCount;
    int levelScore;
    int lvlNo;
    Level()
    {
        sunCount = 100;
        levelScore = 0;
    }
    public abstract void play() throws GameLostException;
    public int getLvlNo()
    {
        return lvlNo;
    }
}
