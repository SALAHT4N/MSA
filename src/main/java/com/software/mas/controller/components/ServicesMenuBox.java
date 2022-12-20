package com.software.mas.controller.components;

import com.software.mas.Loader;
import com.software.mas.controller.home.user.subpane.CalendarUserController;
import com.software.mas.controller.home.user.subpane.ClearStyles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ServicesMenuBox /*extends ClearStyles*/ implements Initializable {


    public static Object containerController;
    @FXML
    private VBox listOfServices;

    private LinkedList<HBox> availableServices;

    public ServicesMenuBox()
    {
        availableServices = new LinkedList<>();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        String[] serviceNames = {
                "Swimming pool",
                "Football playground",
                "random service 1",
                "random 2",
                "shit"
        };
        try {
//            ServiceMenuItemController.containerController = this;

            for (int i = 0; i < 5; i++) {

                FXMLLoader tempLoader = Loader.getLoader("/com/software/mas/UI/components/service-menu-item.fxml");
//
//                // This could be used instead of making a static reference in the child view.
//                //((ServiceMenuItemController)tempLoader.getController()).containerController;
//
//                Parent service = tempLoader.load();
//                ServiceMenuItemController<? extends ClearStyles> itemController = tempLoader.getController();
//                itemController.setServiceName(serviceNames[i]);
//                itemController.containerController = this;
//
//                availableServices.add((HBox) service);
//                listOfServices.getChildren().add(service);
            }
            ServiceMenuItemController.makeItemSelected(availableServices.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearStyles() {
        for (HBox service: availableServices )
        {
            service.getStyleClass().removeAll(service.getStyleClass());
            service.getStyleClass().add("not-selected");
            ((Text)(service.getChildren().get(0))).getStyleClass().removeAll("service-name--selected");
        }
    }
    private HBox getSelectedItem()
    {
        HBox returned = new HBox();
        for (HBox service: availableServices )
        {
            if ("selected".equals(service.getStyleClass().get(0)))
            {
                returned = service;
            }
        }
        return returned;
    }
    public String getSelectedService()
    {
        return((Text)(getSelectedItem().getChildren().get(0))).getText(); // Simply to get the selected service name.
    }

    @FXML
    private void onSelect(ActionEvent event) {
        Stage popUp = (Stage) ((Node)(event.getSource())).getScene().getWindow();
        popUp.close();
        ((CalendarUserController)containerController).setPageHeading(getSelectedService());
    }


}
