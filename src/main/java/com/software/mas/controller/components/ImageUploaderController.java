package com.software.mas.controller.components;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class ImageUploaderController implements Initializable {
    @FXML
    WebView webView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WebEngine engine = webView.getEngine();


        engine.load("http://localhost/upload_image/index.php?profile=asdsad");

//        engine.executeScript("pass('profile');");

    }
}
