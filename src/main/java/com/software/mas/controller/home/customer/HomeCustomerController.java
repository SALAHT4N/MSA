package com.software.mas.controller.home.customer;

import com.software.mas.Loader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeCustomerController implements Initializable {
    @FXML
    private BorderPane container;

    public void setCenterView(String url) throws IOException {
        //Loading the view that the navigator gives it.
        container.setCenter(Loader.parentLoader(url));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader nav;
        try {
            nav = Loader.getLoader("/com/software/mas/UI/home/customer/sub-panes/navbar-customer.fxml");

            Parent navView = nav.load();


            ((NavbarCustomerController)nav.getController()).setHomeCustomerController(this);



            container.setLeft(navView);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
