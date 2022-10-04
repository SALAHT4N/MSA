package com.software.mas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class Loader {


    public static FXMLLoader getLoader(String url) throws IOException {

        return new FXMLLoader(App.class.getResource(url));
    }
    public static Scene sceneLoader (String url) throws IOException {

        return new Scene(getLoader(url).load());

    }

    public static Parent parentLoader(String url) throws IOException {
        Parent loaded = getLoader(url).load();
        return loaded;
    }



}
