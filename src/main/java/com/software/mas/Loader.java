package com.software.mas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class Loader {


    public static FXMLLoader getLoader(String url) throws IOException {

        return new FXMLLoader(App.class.getResource(url));
    }
    public static Scene sceneLoader (String url) throws IOException {

        return new Scene(getLoader(url).load());

    }


}
