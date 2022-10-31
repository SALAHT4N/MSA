package com.software.mas.controller.home.user.subpane;


import com.software.mas.controller.components.ServiceMenuItemController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.List;

/*
* This was changed from an interface to a class, because it provides a concrete implementation of the clearStyles() method.
*
* clearStyles need an array of HBoxes to remove the clear the styles from, this array is got from the database, it contains
* all the services names.
* We have 2 options, we either could retrieve this array from the database from this class, meaning that all the inheritors
* will have the same services names, this makes sense because ServiceMenuItem is made to display services only.
*
* the other approach is made by passing this array using super constructor from the inheritors, all the way to this class.
*
* I think this is the better approach, since in the long run, we would pass an ID to search for in the database using this
* class's constructor, and since we're creating a constructor anyway, why not 2nd approach.
*
* */
public abstract class ClearStyles {

//    List<ServiceMenuItemController<? extends ClearStyles>> availableServices;
//
//    public ClearStyles(List<ServiceMenuItemController<? extends ClearStyles>> services) {
//        this.availableServices = services;
//        setContainerController(this.availableServices);
//    }
//
//    private void setContainerController(List<ServiceMenuItemController<? extends ClearStyles>> controllers)
//    {
//        // T value in ServiceMenuItemController now is a class that is super of ClearStyles, thus pointing it to ClearStyles is Ok.
//        for (ServiceMenuItemController<? extends ClearStyles> i : controllers)
//        {
//            i.containerController = (Chil)this;
//        }
//    }
    List<HBox> availableServices;
    public ClearStyles(List<HBox> availableServices)
    {
        this.availableServices = availableServices;
    }

    public void clearStyles()
    {
        for (HBox service: availableServices )
        {
            service.getStyleClass().removeAll(service.getStyleClass());
            service.getStyleClass().add("not-selected");
            ((Text)(service.getChildren().get(0))).getStyleClass().removeAll("service-name--selected");
        }

    }
}
