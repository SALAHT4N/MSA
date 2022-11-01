package com.software.mas;




import com.software.mas.model.DBHelper;
import okhttp3.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class App extends Application {

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