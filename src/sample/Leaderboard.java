package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.*;

class playerComparator implements Comparator<Player>
{
    public int compare(Player p1, Player p2)
    {
        if(p1.getScore() < p2.getScore())
        {
            return 1;
        }
        return -1;
    }
}

public class Leaderboard implements Initializable {



    @FXML
    AnchorPane loadPane;
    @FXML
    VBox vb;
    @FXML
    ImageView okBtn;

    public void initialize(URL location, ResourceBundle resources)
    {
        ArrayList<Player> scores = new ArrayList<>();
        Player.players.forEach((k,v) -> {
            scores.add(v);
        });
//        scores.add(new Player("ryan",Game.getInstance()));
//        scores.add(new Player("hanna",Game.getInstance()));
        scores.sort(new playerComparator());

        for(Player p: scores)
        {
            Label a = new Label(p.toString());
            a.setFont(Font.font("Verdana",36));
            a.setTextFill(Color.WHITE);
            vb.getChildren().add(a);
        }

    }

    public void clickOk() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        loadPane.getChildren().setAll(pane);
    }
}
