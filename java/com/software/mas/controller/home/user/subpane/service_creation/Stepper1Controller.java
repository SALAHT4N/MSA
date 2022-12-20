package com.software.mas.controller.home.user.subpane.service_creation;

import com.software.mas.App;
import com.software.mas.Loader;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXFilterComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class Stepper1Controller implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private MFXTextField serviceName;

    @FXML
    private GridPane perCustomerPlan;

    @FXML
    private GridPane perServicePlan;

    @FXML
    private MFXTextField capacity;

    @FXML
    void selectPaymentPlan(MouseEvent event) {
        GridPane payment = ((GridPane) event.getSource());
        clearStyles();
        int status = (payment == perServicePlan) ? 1 : 0;
        if (status == 1)
        {
            perServicePlan.getStylesheets().add(App.class.getResource("/com/software/mas/CSS/user/subpanes/service-creation/create-service-1--selected.css").toString());

        }
        else {
            perCustomerPlan.getStylesheets().add(App.class.getResource("/com/software/mas/CSS/user/subpanes/service-creation/create-service-1--selected.css").toString());
        }

    }

    private void clearStyles() {
        perCustomerPlan.getStylesheets().removeAll(perCustomerPlan.getStylesheets());
        perServicePlan.getStylesheets().removeAll(perServicePlan.getStylesheets());
    }
}
