package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ChooseLevel implements Initializable {
    @FXML
    AnchorPane rootPane1;
    @FXML
    Label uname;
    @FXML
    ImageView b1,b2,b3,b4,b5;
    @FXML
    ImageView cancelBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        uname.setText(Main.game.player.getName());
        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);

        switch(Main.game.player.getHighestLevel())
        {
            case 1: b1.setVisible(true);
            break;
            case 2: b1.setVisible(true); b2.setVisible(true);
            break;
            case 3: b1.setVisible(true); b2.setVisible(true); b3.setVisible(true);
            break;
            case 4: b1.setVisible(true); b2.setVisible(true); b3.setVisible(true); b4.setVisible(true);
            break;
            case 5: b1.setVisible(true); b2.setVisible(true); b3.setVisible(true); b4.setVisible(true); b5.setVisible(true);
            break;
        }



    }





}
