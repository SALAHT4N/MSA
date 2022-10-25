package com.software.mas.controller.home.user.subpane.service_creation;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Stepper2Controller {
    @FXML
    private TextArea serviceDesc;

    public String getDescription()
    {
        return serviceDesc.getText();
    }

}
