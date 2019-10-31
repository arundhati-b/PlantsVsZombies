package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class EmptyLeaderboard {
    public ImageView okBtn;
    public AnchorPane rootPane2;

    public void clickOnOk() throws Exception
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        rootPane2.getChildren().setAll(pane);
    }
}
