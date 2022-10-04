package com.software.mas.controller.home;

import com.software.mas.controller.home.customer.HomeCustomerController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

abstract public class NavbarController <T>{
    protected T viewController;
    public void setHomeCustomerController(T t){
        //This Method to assign the controller to the navbar customer to allow it to navigate through the pages
        viewController = t;
    }
    protected static void clearIconBackground(VBox cont){
        for(Node temp :  cont.getChildren()){
            ((Pane)temp).setStyle("");
        }

    }

    protected static ImageView getImageViewOfIcon (Pane iconPressed){
        //Finding what image has selected/pressed
        for(Object temp : iconPressed.getChildren()){
            if(temp instanceof ImageView)
                return (ImageView) temp;
        }
        return null;
    }
    protected static String getFXMLViewName(String fullURL){
        String []tokens =fullURL.split("/") ;
        String iconName=tokens[tokens.length-1].split("\\.")[0];
        return iconName;
    }

//    protected abstract void navigate(MouseEvent event) throws IOException


    @FXML
    public void navigate(MouseEvent event) throws IOException {

        Pane iconClicked = ((Pane)event.getSource());
        ImageView img = getImageViewOfIcon(iconClicked);
        //Check if this icon is pressed or not
        if(!iconClicked.getStyle().equals(""))
            return;

        if(img != null){
            String fullURL = img.getImage().getUrl();

            //The Icon name must match the view name
            String fxmlName = getFXMLViewName(fullURL);
             setRoute(fxmlName);

        /*
        This Comment Will Execute only and only if we put all the icons and all related views
         ^^^^^^^^^^^^^^-------------IMPORTANT-------------------^^^^^^^^^^^^^^^^^^^^^^
         */


            VBox cont =  (VBox) ((Pane)event.getSource()).getParent();
            clearIconBackground(cont);
            ((Pane)event.getSource()).setStyle("-fx-background-color: rgba(0,0,0,0.15)");

        }
    }

    protected abstract void setRoute(String FXMLViewName) throws IOException;

}
