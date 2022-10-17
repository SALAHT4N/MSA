package com.software.mas;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Stage mainStage;


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


       mainStage.setScene(Loader.sceneLoader("/com/software/mas/UI/home/customer/home-customer.fxml")); //M7MD
//        mainStage.setScene(Loader.sceneLoader("/com/software/mas/UI/signup/sign-up-provider-stepper.fxml")); // SALAHT4N
//


//        mainStage.setResizable(false);
        mainStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}