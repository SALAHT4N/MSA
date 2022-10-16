package com.software.mas.controller.home.customer.subpane;

import com.software.mas.Loader;
import com.software.mas.controller.home.customer.HomeCustomerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfilePageController implements Initializable {


    @FXML
    private Text email;

    @FXML
    private Text mobilePhone;

    @FXML
    private Text name;

    @FXML
    private Text phone;

    @FXML
    private Rectangle profilePicture;

    @FXML
    private Rating rating;

    @FXML
    private Text type;

    @FXML
    void goBack(MouseEvent event) {
        HomeCustomerController.setCenterView(Loader.popView());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image img = new Image(String.valueOf(getClass().getResource("/com/software/mas/IMG/download.jpg")));
        profilePicture.setFill(new ImagePattern(img));

    }


}
