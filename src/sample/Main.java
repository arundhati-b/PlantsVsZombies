package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static Game game;

    @Override
    public void start(Stage primaryStage) throws Exception{

            Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
            primaryStage.setTitle("Plants Vs Zombies");
            primaryStage.setScene(new Scene(root, 1116, 645));
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image("sample/resources/title.png"));
            primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }



    public static void setGame(Game g)
    {
        game = g;
    }

    void serialize()
    {
//        game.level.saveValues();
    }
    void deserialize()
    {

    }


}
