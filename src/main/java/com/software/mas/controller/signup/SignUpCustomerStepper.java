package com.software.mas.controller.signup;

import com.software.mas.controller.StepsGenerator;
import io.github.palexdev.materialfx.controls.MFXStepper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class SignUpCustomerStepper extends StepsGenerator implements Initializable {


    @FXML
    private MFXStepper signUpStepper;

    private int state;

    public void setState(int state) {
        this.state = state;
    }

    /*
         * This is made static, so it can be passed to the super constructor, as you can't reference non-static references
           before calling the super constructor, this makes sense because the super constructor is called well before the
           *  "this" constructor (before the class object is made), so there isn't anything to pass.
        */
    private static String stepsFileName = "/com/software/mas/UI/signup/provider-steps";
    private static String iconsFileName = "/com/software/mas/IMG/signup/steps-icons";
    static private String[] stepsNames = {
            "Sign Up",
            "Contact Info",
            "Finished"
    };

    public SignUpCustomerStepper() throws URISyntaxException {
        super(stepsNames, stepsFileName, iconsFileName);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            signUpStepper.getStepperToggles().addAll(createSteps());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addFileName(File i, LinkedList<String> returnedFiles) {
        if (i.isFile() && ! "sign-up-provider-3.fxml".equals(i.getName()))
            returnedFiles.add(i.getName());
    }
}
