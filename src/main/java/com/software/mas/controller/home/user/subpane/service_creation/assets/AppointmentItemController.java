package com.software.mas.controller.home.user.subpane.service_creation.assets;

import com.software.mas.App;
import com.software.mas.controller.home.user.subpane.ClearStyles;
import com.software.mas.controller.home.user.subpane.service_creation.ScheduleTabController;
import com.software.mas.controller.home.user.subpane.service_creation.Stepper4Controller;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.time.LocalTime;

public class AppointmentItemController {
    @FXML
    private Text endTime;

    @FXML
    private Text hours;

    @FXML
    private Text startTime;

    public Object containerController;


    public void setData(LocalTime start,LocalTime end)
    {
        System.out.println("Local Time String representation: " + start.toString());
        setStartTime(start.toString());

        setEndTime(end.toString());
    }
    private void setStartTime(String start)
    {
        startTime.setText(start);
    }
    private void setEndTime(String end)
    {
        endTime.setText(end);
    }
    @FXML
    void selectItem(MouseEvent event) {
        ((ScheduleTabController)containerController).clearStyles();
        HBox item = (HBox) ((Node)event.getSource());
        item.getStylesheets().removeAll(item.getStylesheets());
        item.getStylesheets().add(App.class.getResource("/com/software/mas/CSS/user/subpanes/service-creation/appointment-item--selected.css").toString());
//        System.out.println("Stylesheet added!");
    }




}
