package com.software.mas.controller.home.user;

import com.software.mas.Loader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeUserController implements Initializable {
    @FXML
    private BorderPane container;

    public void setCenterView(String url) throws IOException {
        //Loading the view that the navigator gives it.
        container.setCenter(Loader.parentLoader(url));
    }

    public void specialCaseCenterCalendar(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader nav;
        try {
            nav = Loader.getLoader("/com/software/mas/UI/home/user/sub-panes/navbar-customer.fxml");

            Parent navView = nav.load();
            ((NavbarUserController)nav.getController()).setHomeCustomerController(this);
            container.setLeft(navView);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
