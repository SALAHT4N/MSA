package com.software.mas.controller.components;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MiniServiceCardController implements Initializable {

    //This id will help us in the future to navigate to the full page
    //This id will be set in the initializing of the main-customer.fxml view --QUERYING--
    private String id;
    @FXML
    private ImageView img;
    @FXML
    private Label location;
    @FXML
    private Rating rating;
    @FXML
    private FlowPane tagsContainer;
    @FXML
    private Label txtDesc;

    @FXML
    private Label txtHeader;

    //NOTE:
    /*
    * Any recommended setter or getter write it Here:
    * HERE COLOURS FUCK YOU
    *
    * */
    private Label createTag(String tag){
        Label lb = new Label();
        lb.setText(tag);
        lb.getStyleClass().add("tag");
        return lb;
    }
    //ADD
    public void addTags(String ...str){
        List<Label> tags = new ArrayList<>();
        for(String temp : str){
        tags.add(createTag(temp));
        }

        tagsContainer.getChildren().addAll(tags);

    }

    //getters
    public String getLocation(){
        return location.getText();
    }
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
    public void setLocation(String loc){
        location.setText(loc);
    }
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
    void addBookMark(MouseEvent event) throws URISyntaxException, IOException {
        ImageView img = (ImageView) event.getSource();

        String tokens[] = img.getImage().getUrl().split("/");
        String firstChar = tokens[tokens.length-1];

        if(Character.toString(firstChar.charAt(0)).equals("f")){

            Image unfilled = new Image(String.valueOf(getClass().getResource("/com/software/mas/ICONS/components/bookmark.png")));
            img.setImage(unfilled);


            System.out.println(firstChar);
        }else{

            Image filled = new Image(String.valueOf(getClass().getResource("/com/software/mas/ICONS/components/f_bookmark.png")));
            img.setImage(filled);

            System.out.println("HELLO");
            System.out.println(firstChar);


        }

    }

    @FXML
    void onClicked(MouseEvent event) {
        //todo: Routing to the main service page that have the full Description
        System.out.println("A specific card has been clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addTags("ENTERTAINMENT", "SPORT", "GAMES", "ANYTHING");
    }
}
