package com.software.mas;




import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;


import java.io.IOException;
import java.sql.SQLException;


public class App extends Application {

    //current_user used for determine what is the current user email.
    public static Pair<String,Integer> current_user ;
    private static Stage mainStage;

    /*
    * TODO:Change the price column in mysql_db to double.
    * TODO:Add the location of the service to details_page..
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
        mainStage.setScene(Loader.sceneLoader("/com/software/mas/UI/signup/sign-up.fxml")); // SALAHT4N
//


//        mainStage.setResizable(false);
        mainStage.show();

    }

    public static void main(String[] args) throws SQLException {
        launch();
    }
}