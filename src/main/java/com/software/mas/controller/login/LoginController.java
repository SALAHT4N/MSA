package com.software.mas.controller.login;


import com.software.mas.App;
import com.software.mas.Loader;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.io.IOException;


// <CONTROLLER VIEW>
public class LoginController {

    @FXML
    private Text firstLabel;

    @FXML
    private Label invalidPass;

    @FXML
    private Label invalidUser;

    @FXML
    private Button loginBtn;

    @FXML
    private MFXPasswordField passField;

    @FXML
    private Text secLabel;

    @FXML
    private MFXTextField userName;

    @FXML
    void loginKey(KeyEvent event) {

    }

    @FXML
    void loginPressed(ActionEvent event) {

    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
        //Navigate to The Sign Up View
        App.setStage(Loader.sceneLoader(""));

    }
}
