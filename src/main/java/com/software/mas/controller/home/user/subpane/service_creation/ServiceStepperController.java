package com.software.mas.controller.home.user.subpane.service_creation;

import com.software.mas.controller.ViewFilesGetter;
import io.github.palexdev.materialfx.controls.MFXStepper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ServiceStepperController extends ViewFilesGetter implements Initializable {

    private static String stepsFileName = "/com/software/mas/UI/home/user/sub-panes/service-creation";
    private static String iconsFileName = "/com/software/mas/IMG/signup/steps-icons";
    static private String[] stepsNames = {
            "Options",
            "Description",
            "Front",
            "Open Time",
            "Finish"
    };

    public ServiceStepperController() throws URISyntaxException {
        super(stepsNames, stepsFileName, iconsFileName);
    }

    @Override
    public void addFileName(File i, LinkedList<String> returnedFiles) {
        if(i.isFile() && ! "service-stepper.fxml".equals(i.getName()))
            returnedFiles.add(i.getName());
    }

    @FXML
    private MFXStepper createServiceStepper;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            createServiceStepper.getStepperToggles().addAll(createSteps());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
