package com.software.mas.controller.home.user.subpane;

import com.software.mas.Loader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentsUserController implements Initializable {
    @FXML
    private VBox appointmentsContainer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i = 0; i < 5; i++)
        {
            try {
                Parent appointment = Loader.parentLoader("/com/software/mas/UI/components/pending-card.fxml");
                appointmentsContainer.getChildren().add(appointment);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
