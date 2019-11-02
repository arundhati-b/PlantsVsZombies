package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;

public class EmptySavedGamesMenu {

    @FXML
    AnchorPane rootPane3;

    public void clickOnOk() throws Exception
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        rootPane3.getChildren().setAll(pane);
    }
}
