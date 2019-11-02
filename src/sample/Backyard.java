package sample;


import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.*;


public class Backyard implements Initializable {

    @FXML
    ImageView peashooter;
    @FXML
    ImageView sunflower;
//    @FXML
//    ImageView walnut;
//    @FXML
//    ImageView cherrybomb;
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
    int counter = 0;

    @FXML
    VBox vx00,vx01,vx02,vx03,vx04,vx10,vx11,vx12,vx13,vx14,vx20,vx21,vx22,vx23,vx24,vx30,vx31,vx32,vx33,vx34,vx40,vx41,vx42,vx43,vx44,vx50,vx51,vx52,vx53,vx54,vx60,vx61,vx62,vx63,vx64,vx70,vx71,vx72,vx73,vx74,vx80,vx81,vx82,vx83,vx84;

    private VBox cell[][];
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        intializecells();
        ArrayList<ImageView> sources = new ArrayList<>();
        sources.add(peashooter);
        sources.add(sunflower);
//        sources.add(walnut);
//        sources.add(cherrybomb);

//        for(int i=0; i<sources.size(); i++)
//        {
//            final ImageView source = sources.get(i);
//            source.setOnDragDetected(e -> {
//                Dragboard db = source.startDragAndDrop(TransferMode.ANY);
//                ClipboardContent cb = new ClipboardContent();
//                cb.putImage(source.getImage());
//                db.setContent(cb);
//                e.consume();
//            });
//        }


//        sources.add(walnut);
//        sources.add(cherrybomb);

//        for(int i=0; i<sources.size(); i++)
//        {
//            final ImageView source = sources.get(i);
//            source.setOnDragDetected(e -> {
//                Dragboard db = source.startDragAndDrop(TransferMode.ANY);
//                ClipboardContent cb = new ClipboardContent();
//                cb.putImage(source.getImage());
//                db.setContent(cb);
//                e.consume();
//            });
//        }


        for(int i=0; i<9; i++)
        {
            for(int j=0; j<5; j++)
            {
                final VBox target = cell[i][j];
                for (int k=0; k<sources.size(); k++)
                {
                    final ImageView source = sources.get(k);
                    addFunctionalities(source,target);
                }


//                target.setOnDragOver(e -> {
//                    if(e.getSource() != target && e.getDragboard().hasImage())
//                    {
//                        e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//                        target.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
//                    }
//                    e.consume();
//                });
//
//                target.setOnDragExited(e -> {
//                    target.setBackground(Background.EMPTY);
//                    e.consume();
//                });
//
//                target.setOnDragDropped(e -> {
//            Dragboard db = e.getDragboard();
//            e.acceptTransferModes(TransferMode.ANY);
//            if(db.hasImage())
//            {
//                ImageView pickedPlant = new ImageView(db.getImage());
//                target.getChildren().add(pickedPlant);
//                System.out.println(target.getClass());
//            }
//            e.consume();
//        });
            }
        }
//        gridpane.setOnDragDropped(e -> {
//            Dragboard db = e.getDragboard();
//            e.acceptTransferModes(TransferMode.ANY);
//            if(db.hasImage())
//            {
//                ImageView pickedPlant = new ImageView(db.getImage());
////                gridpane.add(pickedPlant,0,0,1,1);
//                Node node = e.getPickResult().getIntersectedNode();
//                System.out.println(node.getClass());
//            }
//            e.consume();
//
//        });
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                z1.setLayoutX(z1.getLayoutX()-0.5);
            }
        }.start();


        ZombieAppear a1 = new ZombieAppear(z1);
        ZombieAppear a2 = new ZombieAppear(z2);
        SunView sunView1  = new SunView(sun1);

          Timer time = new Timer();
          time.schedule(a1, 1000);
          time.schedule(a2, 5000);
          time.schedule(sunView1, 8000);

    }

    void addFunctionalities(final ImageView source, final VBox target)
    {
//        ImageView holder = new ImageView();
        source.setOnDragDetected(e -> {
            System.out.println("Drag detected");

            Dragboard db = source.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent cb = new ClipboardContent();
            cb.putImage(source.getImage());
            db.setContent(cb);
            e.consume();
        });

        target.setOnDragOver(e -> {
            System.out.println("Dragged over");

//            if(e.getSource() != target && e.getDragboard().hasImage())
            if(e.getDragboard().hasImage())
            {
                System.out.println("here");
                e.acceptTransferModes(TransferMode.ANY);
//                target.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
                target.setStyle("-fx-background-color: rgb(0,0,0,0.3)");
            }
            e.consume();
        });

        target.setOnDragExited(e -> {
            System.out.println("Drag exited");

            target.setBackground(Background.EMPTY);
//            target.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

            e.consume();
        });

        target.setOnDragDropped(e -> {
            System.out.println("Drag dropped");
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
                System.out.println(s.getClass());
//                pickedPlant.setImage(db.getImage());
                pickedPlant.setPreserveRatio(true);
                pickedPlant.fitWidthProperty().bind(target.widthProperty());
                pickedPlant.fitHeightProperty().bind(target.heightProperty());
//                pickedPlant.preserveRatioProperty();
                target.getChildren().add(pickedPlant);
//                System.out.println(target.getClass());
            }
            e.consume();
        });


    }

//    public void dragPea(){
//        peashooter.setOnMouseDragged(e -> {
//            Image temp = new Image("/resources/peashooter.gif");
//            System.out.println("Here");
//            ImageView a = new ImageView();
//            a.setImage(temp);
//            a.setTranslateX(e.getSceneX());
//            a.setTranslateY(e.getSceneY());
//        });
//    }

    void intializecells()
    {
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
