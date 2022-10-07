package com.software.mas.controller.components;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Rating;

public class MiniServiceCardController {

    //This id will help us in the future to navigate to the full page
    //This id will be set in the initializing of the main-customer.fxml view --QUERYING--
    private String id;
    @FXML
    private ImageView img;

    @FXML
    private Rating rating;

    @FXML
    private Label txtDesc;

    @FXML
    private Label txtHeader;

    //NOTE:
    /*
    * Any recommended setter or getter write it Here:
    *
    *
    * */

    //getters
    public String getStringHeader(){
        return txtHeader.getText();
    }
    public String getStringDescription(){
        return txtDesc.getText();
    }
    public double getRating(){
        return rating.getRating();
    }

    public String getImageUrl(){
        return img.getImage().getUrl();
    }

    //Setters
    public void setStringHeader(String header){
        txtHeader.setText( header);
    }
    public void setStringDescription(String desc){
        txtDesc.setText(desc);
    }
    public void setRating (double rated){
        rating.setRating(rated);
    }
    public void setImage (Image img){
        this.img.setImage(img);
    }

    @FXML
    void onClicked(MouseEvent event) {
        //todo: Routing to the main service page that have the full Description
        System.out.println("A specific card has been clicked");
    }
}
