package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Cell implements Serializable {
    int x,y;
    Plant currPlant;
    Cell(int x, int y, Plant p)
    {
        currPlant = p;
        this.x = x;
        this.y = y;
    }
}
