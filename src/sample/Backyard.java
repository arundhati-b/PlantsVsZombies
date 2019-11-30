package sample;


import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.ProgressBar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.*;
import java.util.Timer;


public class Backyard implements Initializable {
    public static ArrayList<ZombieAppear> zombieApp;
    @FXML
    ImageView peashooter, peashooterCard;
    @FXML
    ImageView sunflower, sunflowerCard;
    @FXML
    ImageView cherryCard;
    @FXML
    ImageView walnut, walnutCard;
    @FXML
    Label Score,sunCount;
    @FXML
    AnchorPane hello;
    @FXML
    ImageView z1;
    @FXML
    ImageView z2;
    @FXML
    ImageView sun1;
    @FXML
    ImageView sun2;
    @FXML
    ImageView sun3;
    @FXML
    ProgressBar pb;
    @FXML
    ImageView lm3;
    @FXML
    Button optionsBtn;

    @FXML
    VBox vx00,vx01,vx02,vx03,vx04,vx10,vx11,vx12,vx13,vx14,vx20,vx21,vx22,vx23,vx24,vx30,vx31,vx32,vx33,vx34,vx40,vx41,vx42,vx43,vx44,vx50,vx51,vx52,vx53,vx54,vx60,vx61,vx62,vx63,vx64,vx70,vx71,vx72,vx73,vx74,vx80,vx81,vx82,vx83,vx84;

    private VBox cell[][];
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Level l = Game.getInstance().getLevel();

        System.out.println("In Backyard at level: "+l.getLvlNo());

        zombieApp = new ArrayList<>();
        intializecells();
        ArrayList<ImageView> sources = new ArrayList<>();
        sources.add(peashooter);
        sources.add(sunflower);
        ArrayList<Pea> shotPeas = new ArrayList<>();

        for(int i=0; i<9; i++)
        {
            for(int j=0; j<5; j++)
            {
                final VBox target = cell[i][j];
                for (int k=0; k<sources.size(); k++)
                {
                    final ImageView source = sources.get(k);
                    addFunctionalities(source,target, shotPeas);
                }
            }
        }
        Random r = new Random();
        for(int i = 0; i < l.lvlNo; i++){
            if( i == 0 ){
                Zombie t1 = new ZombieNormal();
                int ran1 = r.nextInt(l.top) + l.below;
                System.out.println("ran1 "+ran1);
                for(int j = 0; j < ran1; j++) {
                    ZombieAppear temp = new ZombieAppear(new ImageView(t1.image), t1.health, t1.speed);
                    temp.a.setLayoutX(1500);
                    temp.a.setLayoutY(Level.pos[r.nextInt(Level.pos.length)]);
                    System.out.println(temp.a.getLayoutX() + " " + temp.a.getLayoutY());
                    hello.getChildren().addAll(temp.a);
                    zombieApp.add(temp);
                }
            }
            else if (i == 1){
                Zombie t1 = new ZombieCone();
                int ran1 = r.nextInt(l.top) + l.below;
                System.out.println("ran1 "+ran1);
                for(int j = 0; j < ran1; j++) {
                    ZombieAppear temp = new ZombieAppear(new ImageView(t1.image), t1.health, t1.speed);
                    temp.a.setLayoutX(1500);
                    temp.a.setLayoutY(Level.pos[r.nextInt(Level.pos.length)]);
                    System.out.println(temp.a.getLayoutX() + " " + temp.a.getLayoutY());
                    hello.getChildren().addAll(temp.a);
                    zombieApp.add(temp);
                }
            }
            else if (i == 2){

            }
            else if (i == 3){

            }
            else if (i == 4){

            }


        }


        SunView sunView1  = new SunView(sun1, sunCount);
        ProgBar progressbar = new ProgBar(pb);
        Timer time = new Timer();
        int c = 0;
        for(ZombieAppear z : zombieApp){
            System.out.println("Here");
            c += r.nextInt(5000) + (6000 - l.lvlNo*1000);
            if(c > 50000000){
                c = 0;
            }
            time.schedule(z, c);
        }

        time.schedule(sunView1, 8000);
        time.schedule(progressbar, 1000, 1000);

    }

    void addFunctionalities(final ImageView source, final VBox target, ArrayList<Pea> shotPea) {
        Timer time = new Timer();
        source.setOnDragDetected(e -> {
//            System.out.println("Drag detected");

            Dragboard db = source.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent cb = new ClipboardContent();
            cb.putImage(source.getImage());
            db.setContent(cb);
            e.consume();
        });

        target.setOnDragOver(e -> {
//            System.out.println("Dragged over");

            if(e.getDragboard().hasImage())
            {
//                System.out.println("here");
                e.acceptTransferModes(TransferMode.ANY);
                target.setStyle("-fx-background-color: rgb(0,0,0,0.3)");
            }
            e.consume();
        });

        target.setOnDragExited(e -> {
//            System.out.println("Drag exited");

            target.setBackground(Background.EMPTY);
//            target.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

            e.consume();
        });

        target.setOnDragDropped(e -> {
//            System.out.println("Drag dropped");
            e.acceptTransferModes(TransferMode.ANY);

            Dragboard db = e.getDragboard();
            if(db.hasImage())
            {
                ImageView pickedPlant = new ImageView();
                Object s = e.getGestureSource();
                if(s.getClass() == ImageView.class)
                    pickedPlant.setImage(((ImageView)s).getImage());
                else
                    pickedPlant.setImage(db.getImage());
                pickedPlant.setPreserveRatio(true);
                pickedPlant.fitWidthProperty().bind(target.widthProperty());
                pickedPlant.fitHeightProperty().bind(target.heightProperty());
//                pickedPlant.preserveRatioProperty();
                target.getChildren().add(pickedPlant);
                if(pickedPlant.getImage() == peashooter.getImage()) {
                    ImageView p = new ImageView("sample/resources/pea.png");
                    p.setVisible(true);
                    p.setLayoutX(target.getLayoutX() + 10);
                    p.setLayoutY(target.getLayoutY() + 5);
                    p.setFitHeight(20);
                    p.setFitWidth(20);
                    Pea temp = new Pea(p, target.getLayoutX(), target.getLayoutY(), pickedPlant);
                    shotPea.add(temp);
                    time.schedule( temp , 0);
                    hello.getChildren().add(p);
                }
            }
            e.consume();
        });
    }

    @FXML
    void clickOptions(ActionEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("options.fxml"));
        hello.getChildren().setAll(pane);
        event.consume();
    }


    void intializecells() {
        cell = new VBox[9][5];
        cell[0][0] = vx00;
        cell[0][1] = vx01;
        cell[0][2] = vx02;
        cell[0][3] = vx03;
        cell[0][4] = vx04;
        cell[1][0] = vx10;
        cell[1][1] = vx11;
        cell[1][2] = vx12;
        cell[1][3] = vx13;
        cell[1][4] = vx14;
        cell[2][0] = vx20;
        cell[2][1] = vx21;
        cell[2][2] = vx22;
        cell[2][3] = vx23;
        cell[2][4] = vx24;
        cell[3][0] = vx30;
        cell[3][1] = vx31;
        cell[3][2] = vx32;
        cell[3][3] = vx33;
        cell[3][4] = vx34;
        cell[4][0] = vx40;
        cell[4][1] = vx41;
        cell[4][2] = vx42;
        cell[4][3] = vx43;
        cell[4][4] = vx44;
        cell[5][0] = vx50;
        cell[5][1] = vx51;
        cell[5][2] = vx52;
        cell[5][3] = vx53;
        cell[5][4] = vx54;
        cell[6][0] = vx60;
        cell[6][1] = vx61;
        cell[6][2] = vx62;
        cell[6][3] = vx63;
        cell[6][4] = vx64;
        cell[7][0] = vx70;
        cell[7][1] = vx71;
        cell[7][2] = vx72;
        cell[7][3] = vx73;
        cell[7][4] = vx74;
        cell[8][0] = vx80;
        cell[8][1] = vx81;
        cell[8][2] = vx82;
        cell[8][3] = vx83;
        cell[8][4] = vx84;
    }



}
