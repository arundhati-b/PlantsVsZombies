package sample;

import javax.swing.text.html.ImageView;

public abstract class Plant {
    ImageView image;
    Cell loc;
    Plant(int x, int y, ImageView i)
    {
        image = i;
        loc = new Cell(x,y,this);
    }
}
