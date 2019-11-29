package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class loginScreen {
    @FXML
    ImageView yes,no;
    @FXML
    AnchorPane loadPane;

    public void selectYes() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("selectPlayer.fxml"));
        loadPane.getChildren().setAll(pane);
    }
    public void selectNo() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loginOption.fxml"));
        loadPane.getChildren().setAll(pane);
    }
}
