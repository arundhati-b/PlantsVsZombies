package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sun.security.provider.Sun;

import java.util.Random;
import java.util.TimerTask;

public class SunView extends TimerTask  {
    Random rand  = new Random();
    double[] where ;
    public void  move(ImageView a) {
        a.setOnMouseClicked(e -> {
            if(type == 0){
                int temp = Integer.parseInt(s.getText() )+ 25;
                s.setText(temp + "");
                a.setLayoutY(-300);
                a.setLayoutX(rand.nextInt(700) + 300);
            }
            else if (type == 1){

                    int temp = Integer.parseInt(s.getText()) + 25;
                    s.setText(temp + "");
                    a.setVisible(false);

            }

        });
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(type == 0) {
                    a.setLayoutY(a.getLayoutY() + 1);
                    if (a.getLayoutY() > 400) {
                        a.setLayoutY(-200);
                        a.setLayoutX(rand.nextInt(700) + 300);
                    }
                }
                if(type == 1){
                    a.setLayoutY(a.getLayoutY() + 0.5);
                    a.setLayoutX(where[0]+50);
//                    System.out.println(a.getLayoutX() + "  "  + a.getLayoutY());

                    if(a.getLayoutY() > where[1] + 40){
                        a.setVisible(false);
                    }
                    if(a.getLayoutY() > where[1] + 400){
                        a.setLayoutY(where[1]);
                        a.setLayoutX(where[0]);
                        a.setVisible(true);
                    }
                }
            }
        }.start();
    }


    SunView (ImageView a, Label s, int type){
        this.a = a;
        this.s = s;
        this.type = type;
    }
    SunView(ImageView a, Sunflower sou, Label s, int type, double[] where){
        this.a = a;
        this.where = where;
        this.sou = sou;
        this.s = s;
        this.type = type;
//        System.out.println(where[0] + "  " + where[1]);
//        System.out.println(sou.image.getLayoutX());
    }
    void kill(){
        a.setLayoutY(-1000);
        a.setLayoutX(-1000);
    }
    ImageView a;
    Sunflower sou;
    Label s;
    int type;
    @Override
    public void run() {
        try{
            move(a);
        }
        catch (Exception e){

        }
    }
}
