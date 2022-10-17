package com.software.mas.controller.home.customer.subpane;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarEvent;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;

public class CalendarCustomerController implements Initializable {

    public Calendar appAppoints = new com.calendarfx.model.Calendar<>("Application - Appointy");

    @FXML
    protected BorderPane container;
    protected CalendarView calendarView = new CalendarView();
    protected void printPage(){
        Stage s = new Stage();
        s.setScene(new Scene(calendarView.getPrintView()));
        s.initModality(Modality.APPLICATION_MODAL);

        s.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*
         * We can use getPrintView() to show the calendar as alternative sol.
         *todo: understand localdate object before starting
         *
         *
         * */


        Entry<String> dentistAppointment = new Entry<>("Dentist");

        dentistAppointment.setTitle("FOOTBALL");
        Entry<String> another = new Entry<>("Bandora");
        another.setLocation("Zoo at the zoo");


        appAppoints.addEntries(dentistAppointment,another);
        appAppoints.setStyle(Calendar.Style.STYLE2);
        CalendarSource source = new CalendarSource();

        source.getCalendars().add(appAppoints);
        appAppoints.setReadOnly(true);
        calendarView.getCalendarSources().add(source);
        calendarView.setCreateEntryClickCount(100);
        calendarView.getPrintView().getCalendarSources().add(source);

        container.setCenter(calendarView.getSelectedPageView());

//        this.printPage();



//        calendarView.setShowAddCalendarButton(true);
//        Calendar birthdays = new Calendar("Birthdays");
//        Calendar holidays = new Calendar("Holidays");
//
//        birthdays.setStyle(Calendar.Style.STYLE1);
//        holidays.setStyle(Calendar.Style.STYLE2);
//
//        CalendarSource myCalendarSource = new CalendarSource("My Calendars");
//        myCalendarSource.getCalendars().addAll(birthdays, holidays);
//
//        calendarView.getCalendarSources().addAll(myCalendarSource);

//        container.setCenter(calendarView.getDayPage());


    }
}
