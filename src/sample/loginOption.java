package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class loginOption {
    @FXML
    ImageView tick,cross;
    @FXML
    AnchorPane loadPane;
    @FXML
    TextField usernameField;

    public void ticked() throws IOException
    {
        String in = usernameField.getText();
        if(in.length() == 0)
        {
            return;
        }
        System.out.print("Username: "+in);
        Main.setGame(new Game(in));
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        loadPane.getChildren().setAll(pane);
    }
    public void crossed() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        loadPane.getChildren().setAll(pane);
    }
}
