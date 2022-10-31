package com.software.mas.controller.home.user.subpane.service_creation;

import com.software.mas.Loader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Stepper4Controller extends Parent implements Initializable {
    String[] days = {
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday"
    };
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            for (String s : days) {
                Tab day = new Tab();
                day.setText(s);

                Parent tabContent = Loader.parentLoader("/com/software/mas/UI/home/user/sub-panes/service-creation/assets/schedule-tab.fxml");

                day.setContent(tabContent);
                dayTabs.getTabs().add(day);

            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }

    }


    @FXML
    private TabPane dayTabs;


//    private void addSessions() throws IOException {
//        // Get sessions from schedule from model
//        int sessionLength = 8;
//        for (int i = 0; i < sessionLength; i++)
//        {
//            FXMLLoader sessionLoader = Loader.getLoader("/com/software/mas/UI/home/user/sub-panes/service-creation/assets/appointment-item.fxml");
//
//            sessionsContainer.getChildren().add(sessionLoader.load());
//            ((AppointmentItemController)sessionLoader.getController()).containerController = this;
//
//        }
//
//    }
//
//    @FXML
//    private MFXTextField endTime;
//
//    @FXML
//    private VBox sessionsContainer;
//
//    @FXML
//    private MFXTextField startTime;
//
//    @FXML
//    void addSession(ActionEvent event) throws IOException {
//
//    }
//
//
//
//    public void clearStyles()
//    {
//
//    }
//
//    @FXML
//    void deleteSession(ActionEvent event) {
//
//    }


}
