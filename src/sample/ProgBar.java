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
        count += 0.01;
        System.out.println(count);
        pb.setProgress(count);
    }
}
