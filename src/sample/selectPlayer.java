package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class selectPlayer implements Initializable {

    @FXML
    AnchorPane loadPane;
    @FXML
    ScrollPane scrollPane;
    @FXML
    VBox vb;

    ArrayList<RadioButton> r = new ArrayList<RadioButton>();
    ToggleGroup tg = new ToggleGroup();


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        vb.setSpacing(5);
        System.out.println("list size"+playerList.getInstance().getList().size());
        for(String p: playerList.getInstance().getList().keySet())
        {
            RadioButton n = new RadioButton(p);
            r.add(n);
            n.setToggleGroup(tg);
            vb.getChildren().add(n);
        }
        if(r.size() > 0)
            r.get(0).setSelected(true);
    }

    public void ticked() throws IOException, ClassNotFoundException
    {
        RadioButton rb = (RadioButton) tg.getSelectedToggle();
        if(rb == null)
            return;
        String n = rb.getText();

        Main.fullDeserialize(n);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        loadPane.getChildren().setAll(pane);
    }
    public void crossed() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        loadPane.getChildren().setAll(pane);
    }
}
