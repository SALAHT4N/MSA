package com.software.mas.controller.login;

import com.software.mas.App;
import javafx.css.Stylesheet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    private VBox customerCard;

    @FXML
    private VBox providerCard;

    @FXML
    void selectUserType(MouseEvent event) {
        clearStyles();
        int state = 0;
        state = ((VBox)(event.getSource()) == providerCard) ? 1 : 2;

        if (state == 1) {
            providerCard.getStylesheets().add(App.class.getResource("/com/software/mas/CSS/signup/sign-ip--selected.css").toString());
        }
        else {
            customerCard.getStylesheets().add(App.class.getResource("/com/software/mas/CSS/signup/sign-ip--selected.css").toString());
        }

    }
    private void clearStyles() {
        customerCard.getStylesheets().removeAll(customerCard.getStylesheets());
        providerCard.getStylesheets().removeAll(providerCard.getStylesheets());
    }



}
