package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class loginOption {
    @FXML
    ImageView tick,cross;
    @FXML
    AnchorPane loadPane;

    public void ticked() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        loadPane.getChildren().setAll(pane);
    }
    public void crossed() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        loadPane.getChildren().setAll(pane);
    }
}
