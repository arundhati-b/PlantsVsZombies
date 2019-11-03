package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class Options {

    @FXML
    AnchorPane optionPane;

    @FXML
    void backToGame() throws Exception{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("backyard.fxml"));
        optionPane.getChildren().setAll(pane);
    }
    public void clickExit()
    {
        System.exit(0);
    }

    public void clickLoadGame() throws Exception
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("emptySavedGamesMenu.fxml"));
        optionPane.getChildren().setAll(pane);
    }
}
