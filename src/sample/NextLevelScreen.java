package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class NextLevelScreen {

    @FXML
    ImageView yesBtn;
    @FXML
    AnchorPane optionPane;

    public void nextLevel() throws Exception
    {
        try
        {
            Game.getInstance().setNextLevel();
        }
        catch(GameWinException e)
        {
            try
            {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("gameWonScreen.fxml"));
                optionPane.getChildren().setAll(pane);
            }
            catch(IOException ex)
            {

            }
        }

        AnchorPane pane = FXMLLoader.load(getClass().getResource("backyard.fxml"));
        optionPane.getChildren().setAll(pane);
    }



}
