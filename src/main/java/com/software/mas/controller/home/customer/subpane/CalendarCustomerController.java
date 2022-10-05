package com.software.mas.controller.home.customer.subpane;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CalendarCustomerController implements Initializable {
    @FXML
    private BorderPane container;
    private CalendarView calendarView = new CalendarView();
    private void printPage(){
        Stage s = new Stage();
        s.setScene(new Scene(calendarView.getPrintView()));
        s.initModality(Modality.APPLICATION_MODAL);

        s.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*
         * We can use getPrintView() to show the calendar as alternative sol.
         *
         *
         * */

        Calendar mode = new com.calendarfx.model.Calendar<>("Home");
        Entry<String> dentistAppointment = new Entry<>("Dentist");


        mode.addEntries(dentistAppointment);
        CalendarSource source = new CalendarSource();
        source.getCalendars().add(mode);
        mode.setReadOnly(true);
        calendarView.getCalendarSources().add(source);
        calendarView.setCreateEntryClickCount(100);
        calendarView.getPrintView().getCalendarSources().add(source);
        this.printPage();
        container.setCenter(calendarView.getSelectedPageView());


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
