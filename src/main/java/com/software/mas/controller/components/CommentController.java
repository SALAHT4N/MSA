package com.software.mas.controller.components;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;


import java.net.URL;
import java.util.ResourceBundle;

public class CommentController implements Initializable {


    String personId;

    @FXML
    Circle imgCircle;

    @FXML
    Text comment;

    @FXML
    Text name;

    @FXML
    Rating rating;

    @FXML
    private void goToProfile(){
        //todo: quering the profile and display it.

    }

    public void setImage (String url){
        Image temp = new Image(String.valueOf(getClass().getResource(url)));
        imgCircle.setFill(new ImagePattern(temp));
    }
    public void setComment (String str){
        comment.setText(str);
    }
    public void setName(String str){
        name.setText(str);
    }
    public void setRating (int rating){
        this.rating.setRating(rating);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       Image temp = new Image(String.valueOf(getClass().getResource("/com/software/mas/IMG/download.jpg")));

       imgCircle.setFill(new ImagePattern(temp));

    }
}
