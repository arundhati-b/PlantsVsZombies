package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ResourceBundle;

public class Leaderboard implements Initializable {

    @FXML
    VBox vb;

    public void initialize(URL location, ResourceBundle resources)
    {
        Queue<Player> scores = new PriorityQueue<>();
        Player.players.forEach((k,v) -> {
            scores.add(v);
        });

        scores.add(new Player("hanna",Game.getInstance()));
        scores.add(new Player("ryan",Game.getInstance()));

        for(Player p: scores)
            vb.getChildren().add(new Label(p.toString()));

    }
}
