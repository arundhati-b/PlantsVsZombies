package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
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
        if(!in.matches("^[_A-Za-z0-9]+$") || in.length() >= 10)
        {
//            System.out.println("yoo");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid username");
            alert.setContentText("Username should only contain A-Z characters (upper and lower), digits 0-9 and underscore ('_') and should have maximum length 10");
            alert.showAndWait();
            return;
        }
        System.out.print("Username: "+in);
        Player.setClear();
        Player p = Player.getInstance(in);
        p.setGame(Game.getInstance(p));
//        playerList.getInstance().addPlayer(p);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        loadPane.getChildren().setAll(pane);
    }
    public void crossed() throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        loadPane.getChildren().setAll(pane);
    }
}
