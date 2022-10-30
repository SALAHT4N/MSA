package com.software.mas;


import com.software.mas.model.DBHelper;
import com.software.mas.model.HomeModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class App extends Application {

    private static Stage mainStage;

    /*
    * TODO:Change the price column in mysql_db to double.
    *
    *
    * */
    public static void setStage (Scene scene){
        mainStage.setScene(scene);
    }
    public static Stage getStage (){
        return mainStage;
    }
    @Override
    public void start(Stage stage) throws IOException {

        stage.close();
        mainStage = new Stage();
        mainStage.setTitle("Appointy");



//        mainStage.setScene(Loader.sceneLoader("/com/software/mas/UI/login/login-form.fxml")); //M7MD
//       mainStage.setScene(Loader.sceneLoader("/com/software/mas/UI/home/customer/home-customer.fxml")); //M7MD
        mainStage.setScene(Loader.sceneLoader("/com/software/mas/UI/home/user/sub-panes/service-creation/service-stepper.fxml")); // SALAHT4N
//


//        mainStage.setResizable(false);
        mainStage.show();

    }

    public static void main(String[] args) {
  launch();
    }
}