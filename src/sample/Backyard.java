package sample;


import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;


public class Backyard implements Initializable {

    @FXML
    GridPane gridpane;
    @FXML
    ImageView peashooter;
    @FXML
    ImageView sunflower;
    @FXML
    ImageView walnut;
    @FXML
    ImageView cherrybomb;
    @FXML
    ImageView z1;
    @FXML
    ImageView z2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<ImageView> sources = new ArrayList<>();
        sources.add(peashooter);
        sources.add(sunflower);
        sources.add(walnut);
        sources.add(cherrybomb);

        for(int i=0; i<sources.size(); i++)
        {
            ImageView source = sources.get(i);
            source.setOnDragDetected(e -> {
                Dragboard db = source.startDragAndDrop(TransferMode.ANY);
                ClipboardContent cb = new ClipboardContent();
                cb.putImage(source.getImage());
                db.setContent(cb);
                e.consume();
            });
        }

        gridpane.setOnDragDropped(e -> {
            Dragboard db = e.getDragboard();
            e.acceptTransferModes(TransferMode.ANY);
            if(db.hasImage())
            {
                ImageView pickedPlant = new ImageView(db.getImage());
//                gridpane.add(pickedPlant,0,0,1,1);
                Node node = e.getPickResult().getIntersectedNode();
                System.out.println(node.getClass());
            }
            e.consume();

        });
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                z1.setLayoutX(z1.getLayoutX()-0.5);
            }
        }.start();

        ZombieAppear a1 = new ZombieAppear(z1);
        ZombieAppear a2 = new ZombieAppear(z2);

          Timer time = new Timer();
          time.schedule(a1, 1000);
          time.schedule(a2, 2000);


    }

    public void dragPea(){
        peashooter.setOnMouseDragged(e -> {
            Image temp = new Image("/resources/peashooter.gif");
            System.out.println("Here");
            ImageView a = new ImageView();
            a.setImage(temp);
            a.setTranslateX(e.getSceneX());
            a.setTranslateY(e.getSceneY());
        });
    }




}
