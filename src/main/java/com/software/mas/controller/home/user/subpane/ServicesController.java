package com.software.mas.controller.home.user.subpane;

import com.software.mas.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ServicesController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            for(int i = 0; i < 5; i++)
            {
//                Parent card = Loader.parentLoader("/com/software/mas/UI/home/user/sub-panes/service-hcard.fxml");
                FXMLLoader card = Loader.getLoader("/com/software/mas/UI/home/user/sub-panes/service-hcard.fxml");
                availabeServicesContainer.getChildren().add(card.load());
                ((ServiceHCardController)card.getController()).setServiceNameText("hhhh");
            }
            for(int i = 0; i < 7; i++)
            {
                Parent card = Loader.parentLoader("/com/software/mas/UI/home/user/sub-panes/service-hcard.fxml");
                offlineServicesContainer.getChildren().add(card);
            }
            offlineServicesContainer.getChildren().get(offlineServicesContainer.getChildren().size()-1).getStyleClass().add("card--bottom");
            offlineServicesContainer.getChildren().get(0).getStyleClass().add("card--top");
            availabeServicesContainer.getChildren().get(0).getStyleClass().add("card--top");
            availabeServicesContainer.getChildren().get(availabeServicesContainer.getChildren().size()-1).getStyleClass().add("card--bottom");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void addService(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(Loader.sceneLoader("/com/software/mas/UI/home/user/sub-panes/service-creation/service-stepper.fxml"));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    @FXML
    private VBox servicesContainer;

    @FXML
    private VBox availabeServicesContainer;

    @FXML
    private VBox offlineServicesContainer;
}
