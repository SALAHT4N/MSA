package com.software.mas.controller.login;


import com.software.mas.App;
import com.software.mas.Loader;
import com.software.mas.model.LoginModel;
import com.software.mas.model.templates.LoginStatus;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


// <CONTROLLER VIEW>
public class LoginController {


    //MODEL INIT HERE
    @FXML
    private Text firstLabel;

    @FXML
    private Label invalidPass;

    @FXML
    private Label invalidUser;

    @FXML
    private Button loginBtn;

    @FXML
    private MFXPasswordField passField;

    @FXML
    private Text secLabel;

    @FXML
    private MFXTextField userName;

    @FXML
    void loginKey(KeyEvent event) {

    }
    private void incorrect(MFXTextField email, MFXTextField password){
        email.setStyle("-fx-border-color: rgba(242, 0, 0,0.6)");
        password.setStyle("-fx-border-color: rgba(242, 0, 0,0.6)");
    }

    private void loadScene(String url, Stage st) throws Exception {

        st.hide();
        st.setScene(Loader.sceneLoader(url));
        st.show();

    }
    @FXML
    void loginPressed(ActionEvent event) {
        //MODEL
        LoginModel model = new LoginModel();
        String email = userName.getText();
        String password = passField.getText();
        LoginStatus status;
        try {

            status = model.authenticate(email, password);

            //
            if(status.isCorrect())
            {
                Stage st = App.getStage();
                if(status.getLvl() == 0){
                    loadScene("/com/software/mas/UI/home/customer/home-customer.fxml", st);

                    // In this cas lvl will equal to 1 (Provider)
                }else{
                    loadScene("/com/software/mas/UI/home/user/home-user.fxml", st);
                }

            }else
                incorrect(userName,passField);


        }catch(Exception e){
            e.printStackTrace();
        }



    }

    @FXML
    void onGuest(ActionEvent event) throws IOException {
        App.getStage().setScene(Loader.sceneLoader("/com/software/mas/UI/home/customer/home-customer.fxml"));
    }
    @FXML
    void signUp(ActionEvent event) throws IOException {
        //Navigate to The Sign Up View
        //App.setStage(Loader.sceneLoader("/com/software/mas/UI/login/sign-up.fxml"));
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(Loader.sceneLoader("/com/software/mas/UI/signup/sign-up.fxml"));
        secondaryStage.setTitle("Sign Up");
        secondaryStage.initModality(Modality.APPLICATION_MODAL);
        secondaryStage.show();

    }
}
