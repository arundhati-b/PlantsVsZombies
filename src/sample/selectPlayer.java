package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class selectPlayer implements Initializable {

    @FXML
    ScrollPane scrollPane;
    @FXML
    VBox vb;


    ArrayList<String> players = new ArrayList<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        players.add("Arundhati");
        players.add("Shreya");
        ArrayList<RadioButton> r = new ArrayList<RadioButton>();
        vb.setSpacing(5);
        ToggleGroup tg = new ToggleGroup();
        for(int i=0; i<20; i++)
        {
            for(String name: players)
            {
                RadioButton n = new RadioButton(name);
                r.add(n);
                n.setToggleGroup(tg);
                vb.getChildren().add(n);
            }
        }
        if(r.size() > 0)
            r.get(0).setSelected(true);
    }

    public void ticked()
    {

    }
    public void crossed()
    {

    }
}
