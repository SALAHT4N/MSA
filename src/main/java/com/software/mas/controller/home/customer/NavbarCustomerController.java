package com.software.mas.controller.home.customer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NavbarCustomerController {

    private HomeCustomerController viewController;

    public void setHomeCustomerController(HomeCustomerController t){
        //This Method to assign the controller to the navbar customer to allow it to navigate through the pages
        viewController = t;
    }

    @FXML
    void navigate(MouseEvent event) throws IOException {
        Pane iconTapped = ((Pane)event.getSource());
        ImageView img = null;

        //Finding what image has selected/pressed
        for(Object temp : iconTapped.getChildren()){
            if(temp instanceof ImageView)
                img = (ImageView) temp;


        }


    if(img != null){
    viewController.setCenterView(img.getImage().getUrl());

        VBox cont =  (VBox) ((Pane)event.getSource()).getParent();

        for(Node temp :  cont.getChildren()){
            ((Pane)temp).setStyle("");
        }

        ((Pane)event.getSource()).setStyle("-fx-background-color: linear-gradient(to right, #cccccc,#ffffff)");
    }

    }




}
