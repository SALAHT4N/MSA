package com.software.mas.controller.signup;

import com.software.mas.App;
import com.software.mas.Loader;
import io.github.palexdev.materialfx.controls.MFXStepper;
import io.github.palexdev.materialfx.controls.MFXStepperToggle;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class SignUpProviderStepper implements Initializable {

    private Object[] fxmlFiles;
    @FXML
    private MFXStepper signUpStepper;

    public SignUpProviderStepper()
    {
        signUpStepper = new MFXStepper();
        fxmlFiles =  (getFileNames().toArray());
    }

    private List<String> getFileNames ()
    {
        File folder = new File("C:\\Users\\tanbo\\IdeaProjects\\mas\\target\\classes\\com\\software\\mas\\UI\\signup\\steps");
        File[] listOfFiles = folder.listFiles();

        LinkedList<String> fileNames = new LinkedList<>();

        for (File i : listOfFiles)
        {
            if(i.isFile())
                fileNames.add(i.getName());
        }

        return fileNames;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<MFXStepperToggle> steps = null;
        try {
            steps = createSteps();
            signUpStepper.getStepperToggles().addAll(steps);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private List<MFXStepperToggle> createSteps() throws IOException {
        LinkedList<MFXStepperToggle> steps = new LinkedList<>();
        String[] stepsNames = {
                "Sign Up",
                "Contact Info",
                "Billing Info",
                "Finish"
        };
        int index = 0;
//        System.out.println(Arrays.toString(fxmlFiles));
        for (Object i :  fxmlFiles)
        {
            steps.add(new MFXStepperToggle(
                    stepsNames[index++],
                    new MFXFontIcon("mfx-lock", 16, Color.web("#000000"))
                    ,createStep(i.toString())
                    )
            );
        }
        System.out.println("Number of Steps: " + steps.size());
        return steps;
    }

    private Parent createStep(String fileName) throws IOException {
        return Loader.parentLoader("/com/software/mas/UI/signup/steps/" + fileName);
    }


}
