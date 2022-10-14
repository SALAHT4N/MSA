package com.software.mas.controller.home.customer.subpane;

import com.software.mas.Loader;
import com.software.mas.controller.home.customer.HomeCustomerController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class ProfilePageController {

    @FXML
    void goBack(MouseEvent event) {
        HomeCustomerController.setCenterView(Loader.popView());
    }
}
