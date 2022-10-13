package com.software.mas.controller.home.customer.subpane;

import com.software.mas.Loader;
import com.software.mas.controller.home.customer.HomeCustomerController;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DetailsPageCustomer implements Initializable {
    @FXML
    AnchorPane nextPane;
    @FXML
    AnchorPane currentPane;

    @FXML
    ImageView currentImage;
    @FXML
    ImageView nextImage;

    private boolean animationFlag = true;
    private int index = 0;
    private boolean clrFlag = true;


    ArrayList<Image> ImagesSlider = new ArrayList<Image>();

//    private void SliderInitialize() throws IOException {
//
//        for(int i = 0 ; i < 3 ; i++){
//            ImagesSlider temp = new ImagesSlider((i+1)+". Department Name");
//        }
//
//    }



    private void swap(){
        ImageView temp;
        temp = nextImage;
        nextImage = currentImage;
        currentImage = temp;

        AnchorPane tempAnchor;
        tempAnchor = nextPane;
        nextPane = currentPane;
        currentPane = tempAnchor;


    }
    @FXML
    void leftArrowPressed(MouseEvent event) {

        if(animationFlag){
//            if(index == 0){
////                nextPane.getChildren().removeAll(nextPane.getChildren());
//                int lastIndex=ImagesSlider.size()-1;
////                nextPane.getChildren().add(ImagesSlider.get(size).getParent());
//                nextImage.setImage(ImagesSlider.get(lastIndex));
//                index = lastIndex;
//            }else{
////                nextPane.getChildren().removeAll(nextPane.getChildren());
//                index--;
//                nextImage.setImage(ImagesSlider.get(index));
////                nextPane.getChildren().add(ImagesSlider.get(index).getParent());
//
//            }



            animationFlag = !animationFlag;
            nextPane.setLayoutX(currentPane.getLayoutX()-1160);
            TranslateTransition transitionCurr = new TranslateTransition();
            transitionCurr.setDuration(Duration.seconds(0.5));
            transitionCurr.setNode(currentPane);
            transitionCurr.setInterpolator(Interpolator.EASE_BOTH);
            transitionCurr.setByX(+1160);

            TranslateTransition transitionNext = new TranslateTransition();
            transitionNext.setDuration(Duration.seconds(0.5));
            transitionNext.setNode(nextPane);
            transitionNext.setInterpolator(Interpolator.EASE_BOTH);
            transitionNext.setByX(+1160);

            transitionCurr.play();
            transitionNext.play();

            transitionNext.setOnFinished(e->{
                animationFlag=!animationFlag;
                swap();




            });

        }


    }

    @FXML
    void rightArrowPressed(MouseEvent event) {

        if(animationFlag){

//            if(index ==size ){
//            int size=ImagesSlider.size()-1;

//                index = 0;
//                nextImage.setImage(ImagesSlider.get(index));
////                nextPane.getChildren().removeAll(nextPane.getChildren());
////                nextPane.getChildren().add(ImagesSlider.get(index).getParent());
//
//            }else{
//                index++;
//                nextImage.setImage(ImagesSlider.get(index));
////                nextPane.getChildren().removeAll(nextPane.getChildren());
////                nextPane.getChildren().add(ImagesSlider.cards.get(index).getParent());
//
//            }

            animationFlag = !animationFlag;
            nextPane.setLayoutX(currentPane.getLayoutX()+1160);
            TranslateTransition transitionCurr = new TranslateTransition();
            transitionCurr.setDuration(Duration.seconds(0.5));
            transitionCurr.setNode(currentPane);
            transitionCurr.setInterpolator(Interpolator.EASE_BOTH);
            transitionCurr.setByX(-1160);

            TranslateTransition transitionNext = new TranslateTransition();
            transitionNext.setDuration(Duration.seconds(0.5));
            transitionNext.setNode(nextPane);
            transitionNext.setInterpolator(Interpolator.EASE_BOTH);
            transitionNext.setByX(-1160);

            transitionCurr.play();
            transitionNext.play();

            transitionNext.setOnFinished(e->{
                animationFlag=!animationFlag;
                swap();
            });

        }
    }

    @FXML
    void goBack(MouseEvent event) {

        HomeCustomerController.setCenterView(Loader.popView());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //todo:Initilizing images for the images slider
    }
}
