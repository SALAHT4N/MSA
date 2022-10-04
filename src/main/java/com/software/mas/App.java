package com.software.mas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Stage mainStage;


    public static void setStage (Scene sc){
        mainStage.setScene(sc);
    }
    public static Stage getStage (){
        return mainStage;
    }
    @Override
    public void start(Stage stage) throws IOException {
        stage.close();
        mainStage = new Stage();
        mainStage.setTitle("Appointy");
        mainStage.setScene(new Scene(Loader.getLoader("UI/login/login-form.fxml").load()));
        mainStage.setResizable(false);
        mainStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}