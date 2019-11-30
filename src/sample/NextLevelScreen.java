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

        String s = "backyard.fxml";

        switch(Game.getInstance().getLevel().getLvlNo())
        {
            case 2:
                s = "backyard1.fxml";
                break;
            case 3:
                s = "backyard2.fxml";
                break;
            case 4:
                s = "backyard3.fxml";
                break;
            case 5:
                s = "backyard4.fxml";
                break;
        }
        AnchorPane pane = FXMLLoader.load(getClass().getResource(s));
        optionPane.getChildren().setAll(pane);
    }



}
