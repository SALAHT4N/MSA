package com.software.mas.controller.components;

import com.software.mas.FXHelper;
import com.software.mas.controller.home.customer.HomeCustomerController;
import com.software.mas.controller.home.customer.subpane.DetailsPageCustomer;
import com.software.mas.model.HomeModel;
import com.software.mas.model.templates.HomeCard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MiniServiceCardController implements Initializable{

    //This id will help us in the future to navigate to the full page
    //This id will be set in the initializing of the main-customer.fxml view --QUERYING--
    private HomeCard source;
    @FXML
    private ImageView img;
    @FXML
    private Label location;
    @FXML
    private Rating rating;
    @FXML
    private FlowPane tagsContainer;
    @FXML
    private Text textDesc;

    @FXML
    private Text txtHeader;


    @FXML
    private ImageView bookMark;
    private String serviceId;

    //NOTE:
    /*
    * Any recommended setter or getter write it Here:
    * HERE COLOURS FUCK YOU
    *
    *
    *
    *
    * */
    public static Label createTag(String tag, String color){
        Label lb = new Label();
        lb.setText(tag.toUpperCase());
        String colorClass = "tag--" + color;
        lb.getStyleClass().addAll("tag", colorClass );
        return lb;
    }
    //ADD
    public void addTags(String ...str){
        List<Label> tags = new ArrayList<>();
        for(String temp : str){
        tags.add(createTag(temp,"black"));
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
        return textDesc.getText();
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
        textDesc.setText(desc);
    }
    public void setRating (double rated){
        rating.setRating(rated);
    }
    public void setImage (Image img){
        this.img.setImage(img);
    }


    public void setBookMark(boolean status){
        if(status){
            Image filled = new Image(String.valueOf(getClass().getResource("/com/software/mas/ICONS/components/f_bookmark.png")));
            bookMark.setImage(filled);
        }else{

            Image unfilled = new Image(String.valueOf(getClass().getResource("/com/software/mas/ICONS/components/bookmark.png")));
            bookMark.setImage(unfilled);
        }
    }

    @FXML
    void addBookMark(MouseEvent event) throws Exception {
        ImageView img = (ImageView) event.getSource();

        String tokens[] = img.getImage().getUrl().split("/");
        String firstChar = tokens[tokens.length-1];

        if(Character.toString(firstChar.charAt(0)).equals("f")){
            setBookMark(false);
            new HomeModel().unBookMarkService(serviceId);
        }else{
            setBookMark(true);
            new HomeModel().bookMarkService(serviceId);


        }

    }

    @FXML
    void onClicked(MouseEvent event) throws IOException {
        Text current = (Text) event.getSource();
        Parent parent = FXHelper.findParentToDetailsPage(current);

        if(parent == null)
            return;
      DetailsPageCustomer cont = (DetailsPageCustomer)HomeCustomerController.containerSetCenter(parent,"/com/software/mas/UI/home/customer/sub-panes/details-page-customer.fxml");
        //todo: Passing the Data of this <MiniServiceCardController> to <DetailsPageCustomer> by using a connection methods.
        cont.init(source);

    }
    public void setDataSource(HomeCard temp){
        this.source = temp;
    }


    public void setServiceId(String serviceId) {
        this.serviceId= serviceId;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
