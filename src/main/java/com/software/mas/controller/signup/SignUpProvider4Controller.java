package com.software.mas.controller.signup;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpProvider4Controller implements Initializable, Validation {
    @Override
    public void validate() {
        System.out.println("Validate Step4");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
