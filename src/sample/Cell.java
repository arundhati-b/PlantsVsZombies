package sample;

import java.util.ArrayList;

public class Cell {
    int x,y;
    Plant currPlant;
    Cell(int x, int y, Plant p)
    {
        currPlant = p;
        this.x = x;
        this.y = y;
    }
}
