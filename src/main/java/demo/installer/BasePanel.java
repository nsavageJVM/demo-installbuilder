package demo.installer;

import javafx.application.Platform;
import javafx.event.ActionEvent;

/**
 * Created by ubu on 25.11.16.
 */
public class BasePanel {



    public void exit(ActionEvent actionEvent) {

        Platform.exit();
    }
}
