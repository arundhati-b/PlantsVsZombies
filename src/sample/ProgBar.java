package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

import java.util.TimerTask;

public class ProgBar extends TimerTask {
    ProgressBar pb;
    ProgBar(ProgressBar pb){
        this.pb = pb;
    }
    volatile double count = 0;
    @Override
    public void run() {
        count += 0.2;
        pb.setProgress(count);
    }
}
