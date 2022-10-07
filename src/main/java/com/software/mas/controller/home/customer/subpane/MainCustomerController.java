package com.software.mas.controller.home.customer.subpane;

import com.software.mas.Loader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainCustomerController implements Initializable {

    @FXML
    VBox cardContainer;

    @FXML
    void makeIt(MouseEvent event) {
        System.out.println("I ENTERED");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            System.out.println("Hello1");
            cardContainer.getChildren().addAll(Loader.parentLoader("/com/software/mas/UI/components/service-card.fxml"),Loader.parentLoader("/com/software/mas/UI/components/service-card.fxml"),Loader.parentLoader("/com/software/mas/UI/components/service-card.fxml"),Loader.parentLoader("/com/software/mas/UI/components/service-card.fxml"),Loader.parentLoader("/com/software/mas/UI/components/service-card.fxml"),Loader.parentLoader("/com/software/mas/UI/components/service-card.fxml"),Loader.parentLoader("/com/software/mas/UI/components/service-card.fxml"),Loader.parentLoader("/com/software/mas/UI/components/service-card.fxml"),Loader.parentLoader("/com/software/mas/UI/components/service-card.fxml"));
            System.out.println("Hello2");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
