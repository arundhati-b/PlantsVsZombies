package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SaveGameMenu {

    @FXML
    ImageView save ,dontsave;
    @FXML
    AnchorPane goBackPane;

    @FXML
    void goback() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("options.fxml"));
        goBackPane.getChildren().setAll(pane);
    }

}
