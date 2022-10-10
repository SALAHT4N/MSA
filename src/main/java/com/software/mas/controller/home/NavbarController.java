package com.software.mas.controller.home;

import com.software.mas.controller.home.customer.HomeCustomerController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
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
            //Try&Catch used because of the separator
           if(temp instanceof Pane)
               try {
                   ((Pane) ((Pane) temp).getChildren().get(0)).setStyle("");
               }catch (Exception e){
//                   e.printStackTrace();

               }
        }

    }

    protected static void deleteAllEffects(VBox cont){

        for(Node child : cont.getChildren()){
            try {
                Pane temp = (Pane) ((Pane) (child)).getChildren().get(0);
                ImageView img = (ImageView)temp.getChildren().get(0);
                img.setEffect(null);
            }catch(Exception e){
                //Maybe Separator

            }

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
        return tokens[tokens.length-1].split("\\.")[0];
    }

//    protected abstract void navigate(MouseEvent event) throws IOException


    @FXML
    public void navigate(MouseEvent event) throws IOException {
        VBox cont =  (VBox) ((Pane)event.getSource()).getParent().getParent();
        Pane iconClicked = ((Pane)event.getSource());
        ImageView img = getImageViewOfIcon(iconClicked);

        //Check if this icon is pressed or not

        if(!(img.getEffect() == null))
            return;


        if(img != null){
            //delete accentofallphotos

            deleteAllEffects(cont);

            ColorAdjust accentColor = new ColorAdjust(); // creating the instance of the ColorAdjust effect.
            accentColor.setBrightness(0.32); // setting the brightness of the color.
            accentColor.setContrast(-1.0); // setting the contrast of the color
            accentColor.setHue(-1.0); // setting the hue of the color
            accentColor.setSaturation(1); // setting the hue of the color.
            img.setEffect(accentColor); //applying effect on the image

            System.out.println(iconClicked.getEffect() == null);

            String fullURL = img.getImage().getUrl();

            //The Icon name must match the view name
            String fxmlName = getFXMLViewName(fullURL);
            setRoute(fxmlName);

        /*
        This Comment Will Execute only and only if we put all the icons and all related views
         ^^^^^^^^^^^^^^-------------IMPORTANT-------------------^^^^^^^^^^^^^^^^^^^^^^
         */



//            clearIconBackground(cont); //removing the gray-active background(OLD CODE).
//            ((Pane)event.getSource()).setStyle("-fx-background-color: rgba(0,0,0,0.15)");

        }
    }

    protected abstract void setRoute(String FXMLViewName) throws IOException;

}
