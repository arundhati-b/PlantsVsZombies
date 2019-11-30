package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainScreen implements Initializable {
    public ImageView newgameBtn;
    public ImageView loadgameBtn;
    public ImageView leaderboardBtn;
    public ImageView chooseLevelBtn;
    public ImageView exitBtn;
    public AnchorPane rootPane1;
    public Label uname;
    public void p1()
    {
        newgameBtn.setRotate(5);
    }
    public void r1()
    {
        newgameBtn.setRotate(0);
    }
    public void p2()
    {
        loadgameBtn.setRotate(5);
    }
    public void r2()
    {
        loadgameBtn.setRotate(0);
    }
    public void p3()
    {
        leaderboardBtn.setRotate(5);
    }
    public void r3()
    {
        leaderboardBtn.setRotate(0);
    }
    public void p4()
    {
        chooseLevelBtn.setRotate(5);
    }
    public void r4()
    {
        chooseLevelBtn.setRotate(0);
    }
    public void p5()
    {
        exitBtn.setRotate(5);
    }
    public void r5()
    {
        exitBtn.setRotate(0);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        uname.setText(Game.getInstance().getPlayer().getName());
    }
    public void clickNewGame() throws Exception
    {
//        throw new Exception();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ChooseLevel.fxml"));
        rootPane1.getChildren().setAll(pane);
    }
    public void clickLoadGame() throws Exception
    {
        Main.deserialize(Player.getInstance().getName());
        AnchorPane pane = FXMLLoader.load(getClass().getResource("backyard.fxml"));
        rootPane1.getChildren().setAll(pane);

//        AnchorPane pane = FXMLLoader.load(getClass().getResource("emptySavedGamesMenu.fxml"));
//        rootPane1.getChildren().setAll(pane);
    }
    public void clickLeaderboard() throws Exception
    {
        AnchorPane pane;
//        if(Player.players.size() == 0 || (Player.players.size() == 1 && Player.players.get(0).getScore() == 0))
//        {
//            pane = FXMLLoader.load(getClass().getResource("emptyLeaderboard.fxml"));
//            rootPane1.getChildren().setAll(pane);
//            return;
//        }
        pane = FXMLLoader.load(getClass().getResource("Leaderboard.fxml"));
        rootPane1.getChildren().setAll(pane);
    }
    public void clickExit() throws Exception
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("exitScreen.fxml"));
        rootPane1.getChildren().setAll(pane);
    }

}
