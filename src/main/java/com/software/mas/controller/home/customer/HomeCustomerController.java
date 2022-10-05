package com.software.mas.controller.home.customer;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarFXControl;
import com.calendarfx.view.CalendarView;
import com.software.mas.Loader;
import impl.com.calendarfx.view.CalendarViewSkin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;

import java.time.LocalDate;
import java.util.ResourceBundle;



public class HomeCustomerController implements Initializable {
    @FXML
    private BorderPane container;

    public void setCenterView(String url) throws IOException {
        //Loading the view that the navigator gives it.
        container.setCenter(Loader.parentLoader(url));
    }

    public void specialCaseCenterCalendar(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader nav;
        try {
            nav = Loader.getLoader("/com/software/mas/UI/home/customer/sub-panes/navbar-customer.fxml");

            Parent navView = nav.load();
            ((NavbarCustomerController)nav.getController()).setHomeCustomerController(this);
            container.setLeft(navView);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
