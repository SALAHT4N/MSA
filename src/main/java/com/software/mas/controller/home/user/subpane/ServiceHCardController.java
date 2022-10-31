package com.software.mas.controller.home.user.subpane;

import com.software.mas.Loader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ServiceHCardController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Text serviceName;

    public void setServiceNameText(String name)
    {
        serviceName.setText(name);
    }

    @FXML
    void deleteService(MouseEvent event) {
        System.out.println("delete");
    }

    @FXML
    void editService(MouseEvent event) throws IOException {
        System.out.println("Edit");
        Stage stage = new Stage();
        stage.setScene(Loader.sceneLoader("/com/software/mas/UI/home/user/sub-panes/service-creation/service-stepper.fxml"));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
