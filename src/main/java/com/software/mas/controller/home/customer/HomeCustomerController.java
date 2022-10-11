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

    public static BorderPane pub;
    public void setCenterView(String url) throws IOException {
        //Loading the view that the navigator gives it.
        container.setCenter(Loader.parentLoader(url));
    }

    /*
    * @param1 String url : To go to
    * Return the controller for the @param1
    * */
    public static  Object containerSetCenter(Parent current, String url) throws IOException {
        //Loading the view that the navigator gives it.
        FXMLLoader loader = Loader.saveParentLoader(current, url);
        pub.setCenter(loader.load());
        return loader.getController();
    }
    public static void setCenterView(Parent view){
        pub.setCenter(view);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader nav;
        try {
            nav = Loader.getLoader("/com/software/mas/UI/home/customer/sub-panes/navbar-customer.fxml");

            Parent navView = nav.load();
            ((NavbarCustomerController)nav.getController()).setHomeCustomerController(this);
            container.setLeft(navView);
            pub=container;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
