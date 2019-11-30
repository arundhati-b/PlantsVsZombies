package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class GameWonScreen {

    @FXML
    ImageView yesBtn;
    @FXML
    AnchorPane optionPane;

    public void back() throws Exception
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        optionPane.getChildren().setAll(pane);
    }
}
