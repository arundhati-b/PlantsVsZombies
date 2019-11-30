package sample;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.concurrent.Task;
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
import sun.security.provider.Sun;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;


public class Backyard4 implements Initializable {
    public static ArrayList<ZombieAppear> zombieApp = new ArrayList<>();
    @FXML
    AnchorPane hello;
    @FXML
    ImageView peashooter, c1;
    @FXML
    ImageView sunflower, c2;
    @FXML
    ImageView cherrybomb, c3;
    @FXML
    ImageView walnut, c4;
    @FXML
    ImageView shovel;
    @FXML
    Label Score,sunCount;
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
    ImageView lm1, lm2, lm3, lm4, lm5;
    @FXML
    Button optionsBtn, lolBtn;

    @FXML
    VBox vx00,vx01,vx02,vx03,vx04,vx10,vx11,vx12,vx13,vx14,vx20,vx21,vx22,vx23,vx24,vx30,vx31,vx32,vx33,vx34,vx40,vx41,vx42,vx43,vx44,vx50,vx51,vx52,vx53,vx54,vx60,vx61,vx62,vx63,vx64,vx70,vx71,vx72,vx73,vx74,vx80,vx81,vx82,vx83,vx84;

    private VBox cell[][];
    ArrayList<LawnMower> lawnMowers = new ArrayList<LawnMower>();

    @FXML
    void clickOptions(ActionEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("options.fxml"));
        hello.getChildren().setAll(pane);
        event.consume();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Level l = Game.getInstance().getLevel();
        lawnMowers.add(new LawnMower ((int)lm1.getLayoutX(), (int)lm1.getLayoutY(),lm1));
        lawnMowers.add(new LawnMower ((int)lm2.getLayoutX(), (int)lm2.getLayoutY(),lm2));
        lawnMowers.add(new LawnMower ((int)lm3.getLayoutX(), (int)lm3.getLayoutY(),lm3));
        lawnMowers.add(new LawnMower ((int)lm4.getLayoutX(), (int)lm4.getLayoutY(),lm4));
        lawnMowers.add(new LawnMower ((int)lm5.getLayoutX(), (int)lm5.getLayoutY(),lm5));
        System.out.println("In Backyard at level: "+l.getLvlNo());

//        zombieApp = new ArrayList<>();
        intializecells();
        ArrayList<ImageView> sources = new ArrayList<>();
        addSources(sources);
        ArrayList<Pea> shotPeas = new ArrayList<>();
//         PlantedPlants = new ArrayList<>();

        for(int i=0; i<9; i++)
        {
            for(int j=0; j<5; j++)
            {
                final VBox target = cell[i][j];
                for (int k=0; k<sources.size(); k++)
                {
                    final ImageView source = sources.get(k);
                    addFunctionalities(source,target, shotPeas, Game.getInstance().getLevel().PlantedPlants);
                }
            }
        }

        Random r = new Random();
        for(int i = 0; i < l.getLvlNo(); i++){
            if( i == 0 ){
                Zombie t1 = new ZombieNormal();
                int ran1 = r.nextInt(l.getTop()) + l.getBelow();
//                System.out.println("ran1 "+ran1);
                for(int j = 0; j < ran1; j++) {
                    ZombieAppear temp = new ZombieAppear(new ImageView(t1.image), t1.health, t1.speed, t1.attack);
                    temp.a.setLayoutX(1200);
                    temp.a.setLayoutY(Level.pos[r.nextInt(Level.pos.length)]);
                    hello.getChildren().addAll(temp.a);
                    zombieApp.add(temp);
                }
            }
            else if (i == 1){
                Zombie t1 = new ZombieCone();
                int ran1 = r.nextInt(l.getTop()) + l.getBelow();
                System.out.println("ran1 "+ran1);
                for(int j = 0; j < ran1; j++) {
                    ZombieAppear temp = new ZombieAppear(new ImageView(t1.image), t1.health, t1.speed, t1.attack);
                    temp.a.setLayoutX(1500);
                    temp.a.setLayoutY(Level.pos[r.nextInt(Level.pos.length)]);
                    hello.getChildren().addAll(temp.a);
                    zombieApp.add(temp);
                }
            }
        }

        SunView sunView1  = new SunView(sun1, sunCount,0);
        ProgBar progressbar = new ProgBar(pb);
        Timer time = new Timer();
        int c = 0;
        for(ZombieAppear z : zombieApp){
//            System.out.println("Here");
            c += r.nextInt(5000) + (6000 - l.getLvlNo()*1000);
//            c += 100;
            if(c > 50000000){
                c = 0;
            }
            time.schedule(z, c);
        }

        time.schedule(sunView1, 8000);
        time.schedule(progressbar, 1000, 1000);

        System.out.println("Initialization done");

        Task<Integer> task = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (true) {
                        if (progressbar.count == 1) {
                            break;
                        }
                    }
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                            time.cancel();

                            System.out.println("Changing level");
                            try
                            {
                                AnchorPane pane = FXMLLoader.load(getClass().getResource("nextLevelScreen.fxml"));
                                hello.getChildren().setAll(pane);
                            }
                            catch(IOException e)
                            {

                            }
                            System.out.println("level changed");
                        }
                    });
                    return null;
                }
            }
        };
        Thread t = new Thread(task);
        t.start();

    }

    void addFunctionalities(final ImageView source, final VBox target, ArrayList<Pea> shotPea, ArrayList<Plant> PlantedPlants) {
        Timer time = new Timer();
        source.setOnDragDetected(e -> {

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

            target.setBackground(Background.EMPTY);

            e.consume();
        });

        target.setOnDragDropped(e -> {
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

                if(pickedPlant.getImage() == shovel.getImage())
                {
                    if(target.getChildren().size() == 0)
                        return;
                    Node x = target.getChildren().get(0);
                    x.setVisible(false);
                    target.getChildren().clear();
                    return;
                }
                if(target.getChildren().size() == 0)
                {
                    System.out.println("here");

                    target.getChildren().add(pickedPlant);
                    if(pickedPlant.getImage() == peashooter.getImage()) {
                        ImageView p = new ImageView("sample/resources/pea.png");
                        p.setVisible(true);
                        p.setLayoutX(target.getLayoutX() + 10);
                        p.setLayoutY(target.getLayoutY() + 5);
                        p.setFitHeight(20);
                        p.setFitWidth(20);

                        Pea temp = new Pea(p, target.getLayoutX(), target.getLayoutY(), pickedPlant);
                        pickedPlant.setLayoutX(target.getLayoutX());
                        pickedPlant.setLayoutY(target.getLayoutY());
                        shotPea.add(temp);
                        time.schedule( temp , 0);
                        PlantedPlants.add(new PeaShooter(pickedPlant));
                        hello.getChildren().add(p);
                    }
                    if(pickedPlant.getImage() == sunflower.getImage()){
                        ImageView p = new ImageView("sample/resources/sun.png");
                        p.setVisible(true);
                        p.setLayoutX(target.getLayoutX());
                        p.setFitWidth(60);
                        p.setFitHeight(60);
                        p.setLayoutY(target.getLayoutY());
                        hello.getChildren().add(p);
                        double[] a = {target.getLayoutX(), target.getLayoutY()};
                        pickedPlant.setLayoutX(target.getLayoutX());
                        pickedPlant.setLayoutY(target.getLayoutY());
                        Sunflower sf = new Sunflower(pickedPlant);
                        SunView k = new SunView(p, sf, sunCount,1, a);
                        sf.sv = k;
                        System.out.println(sf.image.getLayoutX());
                        k.run();
                        PlantedPlants.add(new Sunflower(pickedPlant));
                    }

                    if(pickedPlant.getImage()  == walnut.getImage()){
                        pickedPlant.setLayoutX(target.getLayoutX());
                        pickedPlant.setLayoutY(target.getLayoutY());
                        PlantedPlants.add(new Walnut(pickedPlant));
                    }

                }
                System.out.println("here2");
            }
            e.consume();
        });
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

    public void changeLevel(ActionEvent event) throws IOException,GameWinException
    {
        Game.getInstance().setNextLevel();
        System.out.println("Changing level");

        AnchorPane pane = FXMLLoader.load(getClass().getResource("backyard.fxml"));
        hello.getChildren().setAll(pane);
        System.out.println("level changed");
        event.consume();

    }

    void addSources(ArrayList<ImageView> sources)
    {
        c1.setVisible(false);
        c2.setVisible(false);
        c3.setVisible(false);
        c4.setVisible(false);
        shovel.setVisible(false);

        peashooter.setVisible(false);
        sunflower.setVisible(false);
        cherrybomb.setVisible(false);
        walnut.setVisible(false);

        for(int i=1; i<=Game.getInstance().getLevel().getLvlNo(); i++)
        {
            switch(i)
            {
                case 1: c1.setVisible(true); peashooter.setVisible(true);
                    sources.add(peashooter);
                    break;
                case 2: c2.setVisible(true); sunflower.setVisible(true); sources.add(sunflower);
                    break;
                case 3: c3.setVisible(true); cherrybomb.setVisible(true); sources.add(cherrybomb);
                    break;
                case 4: c4.setVisible(true); walnut.setVisible(true); sources.add(walnut);
                    break;
                case 5: shovel.setVisible(true); sources.add(shovel);
                    break;
            }
        }
    }


}
