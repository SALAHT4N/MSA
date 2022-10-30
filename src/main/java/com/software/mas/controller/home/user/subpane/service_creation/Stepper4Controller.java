package com.software.mas.controller.home.user.subpane.service_creation;

import com.software.mas.Loader;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Stepper4Controller implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            addSessions();
            sessionsContainer.getChildren().get(sessionsContainer.getChildren().size() - 1).getStyleClass().add("card--bottom");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addSessions() throws IOException {
        // Get sessions from schedule from model
        int sessionLength = 5;
        for (int i = 0; i < sessionLength; i++)
        {
            Parent session = Loader.parentLoader("/com/software/mas/UI/home/user/sub-panes/service-creation/assets/appointment-item.fxml");
            sessionsContainer.getChildren().add(session);

        }

    }

    @FXML
    private MFXTextField endTime;

    @FXML
    private VBox sessionsContainer;

    @FXML
    private MFXTextField startTime;

    @FXML
    void addSession(ActionEvent event) {

    }

    @FXML
    void deleteSession(ActionEvent event) {

    }
}
