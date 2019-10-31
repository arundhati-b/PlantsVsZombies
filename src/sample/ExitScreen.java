package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ExitScreen {
    public ImageView yesBtn;
    public ImageView noBtn;
    public AnchorPane rootPane3;

    public void clickOnYes()
    {
        Stage s = (Stage) rootPane3.getScene().getWindow();
        s.close();
    }
    public void clickOnNo() throws Exception
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        rootPane3.getChildren().setAll(pane);
    }
}
