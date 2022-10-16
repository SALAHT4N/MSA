package com.software.mas.controller.signup;

import io.github.palexdev.materialfx.controls.MFXStepper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class SignUpProviderStepper extends ViewFilesGetter implements Initializable  {


    @FXML
    private MFXStepper signUpStepper;

    static private String[] stepsNames = {
                "Sign Up",
                "Contact Info",
                "Billing Info",
                "Finish"
        };
    public SignUpProviderStepper() throws URISyntaxException {
        super(stepsNames);
        // super(); // Implicit Call
//        fileNames =  (getFileNames().toArray()); // This will be done by the super constructor.

    }

    @Override
    public void addFileName(File i, LinkedList<String> returnedFiles) {
        if(i.isFile())
                returnedFiles.add(i.getName());

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

//    private List<MFXStepperToggle> createSteps() throws IOException {
//        LinkedList<MFXStepperToggle> steps = new LinkedList<>();
//        String[] stepsNames = {
//                "Sign Up",
//                "Contact Info",
//                "Billing Info",
//                "Finish"
//        };
//        int index = 0;
////        System.out.println(Arrays.toString(fxmlFiles));
//        for (Object i :  fileNames)
//        {
//            steps.add(new MFXStepperToggle(
//                    stepsNames[index++],
//                    new MFXFontIcon("mfx-lock", 16, Color.web("#000000"))
//                    ,createStep(i.toString())
//                    )
//            );
//        }
//        System.out.println("Number of Steps: " + steps.size());
//        return steps;
//    }
//
//    private Parent createStep(String fileName) throws IOException {
//        return Loader.parentLoader("/com/software/mas/UI/signup/provider-steps/" + fileName);
//    }


}
