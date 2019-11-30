package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.util.InputMismatchException;

public class Main extends Application {

//    public Game g;
    static boolean loadedSession = false;

    @Override
    public void start(Stage primaryStage) throws Exception{

//            Player p = Player.getInstance("Default_player");
//            Game g = Game.getInstance(p);
//            p.setGame(g);
//            playersSerialize();
//            serialize();
//            System.exit(0);
            playersDeserialize();
            Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
            primaryStage.setTitle("Plants Vs Zombies");
            primaryStage.setScene(new Scene(root, 1108, 636));
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image("sample/resources/title.png"));
            primaryStage.show();
//            playersSerialize();
    }

    public static void main(String[] args) {
        launch(args);
    }

    static void serialize() throws IOException, NullPointerException
    {
        Game g = Game.getInstance();

        ObjectOutputStream outstream = null;
        try {
            String fileName = g.getPlayer().getName();
            outstream = new ObjectOutputStream( new FileOutputStream("Database/"+fileName+".txt"));
            outstream.writeObject(g);
        }

        finally
        {
            outstream.close();
        }


    }
    static void deserialize(String fileName) throws IOException, ClassNotFoundException, InputMismatchException, NullPointerException
    {
        loadedSession = true;

        ObjectInputStream instream = null;
        try
        {
            instream = new ObjectInputStream(new FileInputStream("Database/"+fileName+".txt"));

            Game g = (Game) instream.readObject();
            Game.setClear();
            Player.setClear();
            Game.getInstance(g);
            Player.getInstance(g.getPlayer());
            g.print();
        }
        finally
        {
            instream.close();
        }

    }

    static void playersSerialize() throws IOException, NullPointerException
    {
        ObjectOutputStream outstream = null;
        playerList list = playerList.getInstance();
        try {
            outstream = new ObjectOutputStream( new FileOutputStream("Database/PlayerList.txt"));
            outstream.writeObject(list);
        }

        finally
        {
            outstream.close();
        }
    }

    static void playersDeserialize() throws IOException, ClassNotFoundException, InputMismatchException, NullPointerException
    {
        loadedSession = true;

        ObjectInputStream instream = null;
        try
        {
            instream = new ObjectInputStream(new FileInputStream("Database/PlayerList.txt"));

            playerList p = (playerList) instream.readObject();
            if(p != null)
                playerList.getInstance(p);
        }
        catch (IOException e)
        {
            System.out.println("oops");
        }
        finally
        {
            instream.close();
        }

    }


}
