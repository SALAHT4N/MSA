package com.software.mas.controller.signup;

import com.software.mas.App;
import com.software.mas.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
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
        final int PROVIDER_SELECTED = 1, CUSTOMER_SELECTED = 2;
        clearStyles();
        int state = 0;
        state = ((VBox)(event.getSource()) == providerCard) ? PROVIDER_SELECTED : CUSTOMER_SELECTED;

        if (state == 1) {
            providerCard.getStylesheets().add(App.class.getResource("/com/software/mas/CSS/signup/sign-up--selected.css").toString());
        }
        else {
            customerCard.getStylesheets().add(App.class.getResource("/com/software/mas/CSS/signup/sign-up--selected.css").toString());
        }

    }
    @FXML
    void nextPage(ActionEvent event) throws IOException
    {
        Scene nextScene = Loader.sceneLoader("/com/software/mas/UI/signup/provider-steps/sign-up-provider-1.fxml");
//        (Node)(event.getSource())
        App.getStage().setScene(nextScene);
    }

    private void clearStyles() {
        customerCard.getStylesheets().removeAll(customerCard.getStylesheets());
        providerCard.getStylesheets().removeAll(providerCard.getStylesheets());
    }



}
