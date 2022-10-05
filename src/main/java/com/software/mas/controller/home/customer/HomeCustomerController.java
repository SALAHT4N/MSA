package com.software.mas.controller.home.customer;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.view.CalendarView;
import com.software.mas.Loader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeCustomerController implements Initializable {
    @FXML
    private BorderPane container;

    public void setCenterView(String url) throws IOException {
        //Loading the view that the navigator gives it.
        container.setCenter(Loader.parentLoader(url));
    }

    public void specialCaseCenterCalendar(){

        CalendarView calendarView = new CalendarView();

        calendarView.setShowDeveloperConsole(true);
        calendarView.setShowAddCalendarButton(false);
        calendarView.setShowNoonMarker(false);
        calendarView.setShowPageSwitcher(false);
        calendarView.setShowPrintButton(true);
        calendarView.setShowPageToolBarControls(false);
        calendarView.setShowSearchField(false);
        calendarView.setShowSearchResultsTray(false);
        calendarView.setShowPageToolBarControls(false);
        calendarView.setShowSourceTray(false);
        calendarView.setShowToday(false);
        calendarView.setShowAddCalendarButton(false);




        Calendar birthdays = new Calendar("Birthdays");
        Calendar holidays = new Calendar("Holidays");

        birthdays.setStyle(Calendar.Style.STYLE1);
        holidays.setStyle(Calendar.Style.STYLE2);

        CalendarSource myCalendarSource = new CalendarSource("My Calendars");
        myCalendarSource.getCalendars().addAll(birthdays, holidays);

        calendarView.getCalendarSources().addAll(myCalendarSource);

        container.setCenter(calendarView);

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
