package com.software.mas.controller.home.customer.subpane;

import com.software.mas.Loader;
import com.software.mas.controller.home.customer.HomeCustomerController;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
// Slider ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//-----------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------
         //--------------------------------------------------------------------------

    private String personId;

    @FXML
    Text email;
    @FXML
    ScrollPane scrollMainContainer;
    @FXML
    VBox container;

    @FXML
    Label numberComments;

    @FXML
    Label phone;
    @FXML
    Text header;
    @FXML
    Text description;

    @FXML
    Circle imgCircle;

    @FXML
    Text name;

    @FXML
    private void goToProfile() throws IOException {

        ProfilePageController cont = (ProfilePageController) HomeCustomerController.containerSetCenter(scrollMainContainer , "/com/software/mas/UI/home/customer/sub-panes/profile-page.fxml");

        //todo: quering the profile and display it.
    }


    @FXML
    void bookNow(ActionEvent e) throws IOException {
        Stage st = new Stage();
        Scene sc = Loader.sceneLoader("/com/software/mas/UI/home/customer/sub-panes/book-customer.fxml");

        st.setScene(sc);
        st.show();


    }

    @FXML
    void goBack(MouseEvent event) {
        HomeCustomerController.setCenterView(Loader.popView());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //todo:Initilizing images for the images slider
        //todo:querying the comments to comment section example below.

        Image temp = new Image(String.valueOf(getClass().getResource("/com/software/mas/IMG/download.jpg")));

        imgCircle.setFill(new ImagePattern(temp));

        try {
            container.getChildren().add(Loader.parentLoader("/com/software/mas/UI/components/comment.fxml"));
            container.getChildren().add(Loader.parentLoader("/com/software/mas/UI/components/comment.fxml"));
            container.getChildren().add(Loader.parentLoader("/com/software/mas/UI/components/comment.fxml"));
            container.getChildren().add(Loader.parentLoader("/com/software/mas/UI/components/comment.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
