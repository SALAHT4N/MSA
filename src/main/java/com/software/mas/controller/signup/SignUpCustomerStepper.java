package com.software.mas.controller.signup;

import com.software.mas.model.ViewFilesGetter;
import io.github.palexdev.materialfx.controls.MFXStepper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class SignUpCustomerStepper extends ViewFilesGetter implements Initializable {


    @FXML
    private MFXStepper signUpStepper;

    /*
     * This is made static, so it can be passed to the super constructor, as you can't reference non-static references
       before calling the super constructor, this makes sense because the super constructor is called well before the
       *  "this" constructor (before the class object is made), so there isn't anything to pass.
    */
    static private String[] stepsNames = {

    };

    public SignUpCustomerStepper() {
        super(stepsNames);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void addFileName(File i, LinkedList<String> returnedFiles) {
        if (i.isFile() && ! "sign-up-provider-3.fxml".equals(i.getName()))
            returnedFiles.add(i.getName());
    }
}
