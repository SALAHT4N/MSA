package com.software.mas.controller.signup;

import com.software.mas.Loader;
import io.github.palexdev.materialfx.controls.MFXStepper;
import io.github.palexdev.materialfx.controls.MFXStepperToggle;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StepperTest implements Initializable {

    @FXML
    private MFXStepper stepper;

    public StepperTest() throws IOException {
        stepper = new MFXStepper();
        fxmlWindow = Loader.getLoader("/com/software/mas/UI/signup/stepper_content.fxml");
        root = fxmlWindow.load();
        login = new MFXTextField();
        password = new MFXTextField();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            stepper.getStepperToggles().add(createSteps());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Steps added!");
    }
    FXMLLoader fxmlWindow;
    Parent root;
    MFXTextField login, password;
    private MFXStepperToggle createSteps() throws IOException {
        MFXStepperToggle step1 = new MFXStepperToggle("Step 1", new MFXFontIcon("mfx-lock", 16, Color.web("#f1c40f")));
        FXMLLoader fxmlWindow = Loader.getLoader("/com/software/mas/UI/signup/steps/sign-up-provider-1.fxml");
        Parent root = fxmlWindow.load();
        step1.setContent(root); /*This function takes Node as a parameter, so it may take an FXML File*/
//
//        VBox vbox = new VBox(20,login,password);
//        vbox.setAlignment(Pos.CENTER);
//        step1.setContent(vbox);


//        MFXStepperToggle step2 = new MFXStepperToggle();
//        FXMLLoader fxmlWindow2 = Loader.getLoader("/com/software/mas/UI/signup/sign-up-provider-1.fxml");
//        step2.setContent(fxmlWindow2.load()); /*This function takes Node as a parameter, so it may take an FXML File*/
        return step1;
    }

}
