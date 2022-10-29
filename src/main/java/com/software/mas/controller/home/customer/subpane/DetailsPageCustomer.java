package com.software.mas.controller.home.customer.subpane;

import com.software.mas.Loader;
import com.software.mas.controller.components.CommentController;
import com.software.mas.controller.home.customer.HomeCustomerController;
import com.software.mas.model.DetailsPageModel;
import com.software.mas.model.templates.CommentProfileData;
import com.software.mas.model.templates.DetailsPageData;
import com.software.mas.model.templates.HomeCard;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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


    ArrayList<Image> imagesSlides = new ArrayList<Image>();

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
//
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
    Rectangle imgCircle;

    @FXML
    Text name;

    @FXML
    private Rating serviceRating;



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


    @FXML
    VBox commentSection;
    DetailsPageModel model;
    public void displayAllComments(long serviceId) throws Exception {
       Queue<CommentProfileData> comments =  model.getAllComments(serviceId);

       //Settings the number of comments. ..
       int commentsNumber = comments.size();
       numberComments.setText(String.valueOf(commentsNumber));
       int ratingSum=0;

       commentSection.getChildren().clear();
       while(!comments.isEmpty()){
           CommentProfileData holder = comments.poll();

           FXMLLoader loader = Loader.getLoader("/com/software/mas/UI/components/comment.fxml");
           Parent view = loader.load();

           //Calculate the service rating ..
           ratingSum+=holder.rating();

           CommentController cont = loader.getController();
           cont.setComment(holder.content());
           cont.setImage(holder.urlImg());
           cont.setName(holder.name());
           cont.setRating((int) holder.rating());

           commentSection.getChildren().add(view);
       }

       double serviceRating =0.0;
       if(commentsNumber != 0)
           serviceRating = ratingSum/(double)commentsNumber;
        System.out.println(serviceRating);
        this.serviceRating.setRating(serviceRating);
    }

    private void setImageSlides(List<String> imgs) {
        //TODO : SET IMAGES TO THE SLIDER
        for(String img : imgs){
            imagesSlides.add(new Image(img));
        }
    }
    public void init(HomeCard data)  {
        //Init The model to fetch data into this page
        model = new DetailsPageModel();
        DetailsPageData pageData = model.getServiceData(String.valueOf(data.id()));
        List<String> imagesUrl = pageData.imageSlides();

        try {
            //Id of this service
            displayAllComments(data.id());
            header.setText(data.name());
            description.setText(data.description());
            name.setText(pageData.providerName());
            phone.setText(pageData.mobileNumber());
            setProviderProfilePhoto(pageData.providerProfilePhotoUrl());
            setImageSlides(imagesUrl);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setProviderProfilePhoto(String url){
        Image temp = new Image(url);
        imgCircle.setFill(new ImagePattern(temp));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //todo:Initilizing images for the images slider
        //todo:querying the comments to comment section example below.




    }
}
