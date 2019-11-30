package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SavedGamesMenu {
    public ImageView okBtn;
    public ImageView cancelBtn;
    public AnchorPane rootPane3;

    public void clickOnOk() throws Exception
    {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        rootPane3.getChildren().setAll(pane);
    }
}
