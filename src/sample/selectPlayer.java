package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class selectPlayer implements Initializable {

    @FXML
    ScrollPane scrollPane;


    ArrayList<String> players = new ArrayList<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        players.add("Arundhati");
        players.add("Shreya");
        ArrayList<RadioButton> r = new ArrayList<RadioButton>();
        for(int i=0; i<5; i++)
        {
            for(String name: players)
            {
                RadioButton n = new RadioButton(name);
                r.add(n);
//                nameGrid
            }
        }
    }
}
