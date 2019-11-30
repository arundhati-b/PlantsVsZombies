package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

import java.util.TimerTask;

public class ProgBar extends TimerTask {
    ProgressBar pb;
    ProgBar(ProgressBar pb){
        this.pb = pb;
    }
    double count = 0;
    @Override
    public void run() {
        count += 0.1;
        pb.setProgress(count);
        if(count == 1)
            Game.getInstance().getLevel().levelCompleted= true;
    }
}
