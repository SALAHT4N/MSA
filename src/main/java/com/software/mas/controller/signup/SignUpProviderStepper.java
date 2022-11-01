package com.software.mas.controller.signup;

import com.software.mas.controller.StepsGenerator;
import io.github.palexdev.materialfx.controls.MFXStepper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SignUpProviderStepper extends StepsGenerator implements Initializable  {


    @FXML
    private MFXStepper signUpStepper;
    private static String stepFileNames = "/com/software/mas/UI/signup/provider-steps";
    private static String iconsFileName = "/com/software/mas/IMG/signup/steps-icons";
    static private String[] stepsNames = {
                "Sign Up",
                "Contact Info",
                "Billing Info",
                "Finish"
        };
    public SignUpProviderStepper() throws URISyntaxException {
        super(stepsNames, stepFileNames,iconsFileName );
        // super(); // Implicit Call
//        fileNames =  (getFileNames().toArray()); // This will be done by the super constructor.

    }

    @Override
    public void addFileName(File i, LinkedList<String> returnedFiles) {
        if(i.isFile())
                returnedFiles.add(i.getName());
    }
    private int state;

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // AtomicInteger to increment variables in lambda expressions.

        try {
            signUpStepper.getStepperToggles().addAll(createSteps());
            signUpStepper.setOnNext(e -> onNextCallBack());
            signUpStepper.setOnPrevious(e -> onPrevCallBack());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    private void onPrevCallBack() {
        List<Object> controllers = getControllers();
        stepNumber.getAndDecrement();
        switch (stepNumber.get())
        {
            case 0:
                ((SignUpProvider1Controller)controllers.get(stepNumber.get())).validate();
//                stepNumber.getAndDecrement();
                break;
            case 1:
                ((SignUpProvider2Controller)controllers.get(stepNumber.get())).validate();
//                stepNumber.getAndDecrement();
                break;
            case 2:
                if (state == 1)
                {
                    ((SignUpProvider3Controller)controllers.get(stepNumber.get())).validate();
                } else {
                    ((SignUpProvider4Controller)controllers.get(stepNumber.get())).validate();
                }
//                stepNumber.getAndDecrement();
                break;
            case 3:
                ((SignUpProvider4Controller)controllers.get(stepNumber.get())).validate();
//                stepNumber.getAndDecrement();
                break;
        }
    }

    AtomicInteger stepNumber = new AtomicInteger(-1);
    private void onNextCallBack()
    {

        List<Object> controllers = getControllers();
        stepNumber.getAndIncrement();
        switch (stepNumber.get())
        {
            case 0:
                ((SignUpProvider1Controller)controllers.get(stepNumber.get())).validate();
//                stepNumber.getAndIncrement();
                break;
            case 1:
                ((SignUpProvider2Controller)controllers.get(stepNumber.get())).validate();
//                stepNumber.getAndIncrement();
                break;
            case 2:
                if (state == 1)
                {
                    ((SignUpProvider3Controller)controllers.get(stepNumber.get())).validate();
                } else {
                    ((SignUpProvider4Controller)controllers.get(stepNumber.get())).validate();
                }
//                stepNumber.getAndIncrement();
                break;
            case 3:
                ((SignUpProvider4Controller)controllers.get(stepNumber.get())).validate();
//                stepNumber.getAndIncrement();
                break;
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
