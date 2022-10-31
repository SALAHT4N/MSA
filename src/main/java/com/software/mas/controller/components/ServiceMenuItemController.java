package com.software.mas.controller.components;

import com.software.mas.controller.home.user.subpane.ClearStyles;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/*
* This menu item needs to know its parent controller, my first approach was to pass the Type of the parent controller which
* loaded the menu item as an argument to a field with type Object in the menu item.
* But this approach wasn't professional, so I added a generic to this class, and replaced the field containing the parent controller
* with the generic type instead of Object.
*
* But this menu item started being used in many controllers, and each one of these controllers had to have a clearStyles() method
* that needed to be called from the ServiceMenuItemController calling the method simply from the T type doesn't work, since Java
* can't be sure if the generic type actually contains that method, so a solution was needed.
*
* How to make that method visible to ServiceMenuItemController ?
* we can make an interface that contains that method, and make this class implement it, but that doesn't work since the implementation
* is in the parent controller, not the child.
*
* so the parent class must implement that interface.
* but the child controller doesn't know which interfaces the parent class implements, so calling the method from the T type isn't possible.
*
* Therefore, we somehow need a way to guarantee Java that the class passed as a generic contains the method we're about to call.
* I came up with writing <T implements ClearStyles>, but that didn't work as expected, I googled it to check the syntax, and the
* solution to the problem was exactly the same one I came up with, but instead of writing "implements", we should write "extends".
*
* With this, from this class point of view, it's clear that T type has access to the clearStyles() method,
* and that guarantees that any class passed as a generic to this one must implement the ClearStyles interface since it is required
* to have a certain method called clearStyles().
*
* // Simple change//
* Since the implementation of the clearStyles() method is common in all the implementing classes, then we should replace the interface
* with an abstract class as abstract classes can provide implementations unlike interfaces.
*
* */
public class ServiceMenuItemController <T extends ClearStyles >implements Initializable {
    @FXML
    private HBox hBox;
    private String serviceName = "service 1";
    // Mouse Clicked method actually gets called 2 times per a click.
    public  T containerController;
//    public static int testVar;
    @FXML
    void changeSelection(MouseEvent event) {
        containerController.clearStyles();
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
