package com.software.mas.controller.components;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ServiceMenuItemController implements Initializable {
    @FXML
    private HBox hBox;
    private String serviceName = "service 1";
    // Mouse Clicked method actually gets called 2 times per a click.
    public static Object containerController;
    @FXML
    void changeSelection(MouseEvent event) {
        ((ServicesMenuBox)containerController).clearStyles();
        hBox.getStyleClass().removeAll(hBox.getStyleClass());
        hBox.getStyleClass().add("selected");
        ((Text)(hBox.getChildren().get(0))).getStyleClass().add("service-name--selected");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getTextOfService().setText(serviceName);
    }

    private Text getTextOfService()
    {
        return ((Text)(hBox.getChildren().get(0)));
    }

    public static void makeItemSelected(HBox item)
    {
        item.getStyleClass().removeAll(item.getStyleClass());
        item.getStyleClass().add("selected");
        ((Text)(item.getChildren().get(0))).getStyleClass().add("service-name--selected");
    }


    public void setServiceName(String serviceName)
    {
        getTextOfService().setText(serviceName);
    }



}
