package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseLevel implements Initializable {
    @FXML
    AnchorPane rootPane1;
    @FXML
    Label uname;
    @FXML
    ImageView b1,b2,b3,b4,b5;
    @FXML
    ImageView cancelBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        uname.setText(Game.getInstance().getPlayer().getName());
        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);

        switch(Game.getInstance().getPlayer().getHighestLevel())
        {
            case 1: b1.setVisible(true);
            break;
            case 2: b1.setVisible(true); b2.setVisible(true);
            break;
            case 3: b1.setVisible(true); b2.setVisible(true); b3.setVisible(true);
            break;
            case 4: b1.setVisible(true); b2.setVisible(true); b3.setVisible(true); b4.setVisible(true);
            break;
            case 5: b1.setVisible(true); b2.setVisible(true); b3.setVisible(true); b4.setVisible(true); b5.setVisible(true);
            break;
        }

        b1.setOnMouseClicked(e -> {
            Game.getInstance().setLevel(new Level1(7,10));
            callBackyard();
//            Game.getInstance().playGame();
        });

        b2.setOnMouseClicked(e -> {
            Game.getInstance().setLevel(new Level2(8,15));
            callBackyard();
//            Game.getInstance().playGame();
        });

        b3.setOnMouseClicked(e -> {
            Game.getInstance().setLevel(new Level3(9,18));
            callBackyard();
//            Game.getInstance().playGame();
        });

        b4.setOnMouseClicked(e -> {
            Game.getInstance().setLevel(new Level4(10,22));
            callBackyard();
//            Game.getInstance().playGame();
        });

        b5.setOnMouseClicked(e -> {
            Game.getInstance().setLevel(new Level5(11,25));
            callBackyard();
//            Game.getInstance().playGame();
        });



    }

    public void callBackyard()
    {
        String s = "backyard.fxml";

        switch(Game.getInstance().getLevel().getLvlNo())
        {
            case 2:
                s = "backyard1.fxml";
                break;
            case 3:
                s = "backyard2.fxml";
                break;
            case 4:
                s = "backyard3.fxml";
                break;
            case 5:
                s = "backyard4.fxml";
                break;
        }
        try
        {
            AnchorPane pane = FXMLLoader.load((ChooseLevel.class).getResource(s));
            rootPane1.getChildren().setAll(pane);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void cancel() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        rootPane1.getChildren().setAll(pane);
    }





}
