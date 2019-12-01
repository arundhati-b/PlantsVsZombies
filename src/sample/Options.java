package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Options {

    @FXML
    AnchorPane optionPane;
    @FXML
    Button quit, saveGame, back;

    @FXML
    void backToGame(ActionEvent event) throws Exception{
        Main.deserialize(Player.getInstance().getName());
        AnchorPane pane = FXMLLoader.load(getClass().getResource("backyard.fxml"));
        optionPane.getChildren().setAll(pane);
        event.consume();
    }
    @FXML
    void clickExit(ActionEvent event) throws IOException
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        optionPane.getChildren().setAll(pane);
        event.consume();
    }
    @FXML
    void openSaveGameMenu(ActionEvent event) throws IOException
    {
        Main.fullSerialize();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("saveGameMenu.fxml"));
        optionPane.getChildren().setAll(pane);
        event.consume();
    }



}
