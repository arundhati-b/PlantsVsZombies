package sample;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

    }




}
