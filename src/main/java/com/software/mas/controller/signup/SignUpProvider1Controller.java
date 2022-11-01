package com.software.mas.controller.signup;

import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXStepper;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.skins.MFXStepperSkin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpProvider1Controller implements Initializable, Validation {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    private MFXDatePicker birthDate;

    @FXML
    private MFXPasswordField confirmPassword;

    @FXML
    private MFXTextField firstNameTxt;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private MFXTextField lastNameTxt;

    @FXML
    private MFXTextField middleNameTxt;

    @FXML
    private MFXPasswordField password;


    @Override
    public void validate() {
        System.out.println("Validate Step1");
    }
}
