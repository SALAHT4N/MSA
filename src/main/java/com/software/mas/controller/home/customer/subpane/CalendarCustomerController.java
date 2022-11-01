package com.software.mas.controller.home.customer.subpane;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import com.software.mas.App;
import com.software.mas.StringHelper;
import com.software.mas.model.HomeModel;
import com.software.mas.model.ReserveModel;
import com.software.mas.model.templates.BooksData;
import com.software.mas.model.templates.HomeCard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
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
    ReserveModel booksModel;
    public Entry<String> createEntry(String location, String title, LocalDateTime time1, LocalDateTime time2){
        Entry<String> temp = new Entry<>(title);
        temp.setLocation(location);
        temp.setInterval(time1,time2);
        return temp;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*
         * We can use getPrintView() to show the calendar as alternative sol.
         *todo: understand localdate object before starting
         *
         *
         * */
        try {
        booksModel = new ReserveModel();
        HomeModel serviceModel = new HomeModel();

        appAppoints.setStyle(Calendar.Style.STYLE2);

      List<BooksData> data = booksModel.getUserReservedAppointments(App.current_user.getKey());
        data.forEach(e->{
            HomeCard serviceData = serviceModel.getServiceDataWithoutBookmark(e.serviceId());
           String street= StringHelper.capitalize(serviceData.street());
           String city= StringHelper.capitalize(serviceData.city());
           String country= StringHelper.capitalize( serviceData.country());

            appAppoints.addEntries(createEntry(street+" "+city+" "+country,
                                            serviceData.name(),e.startAt(),e.endAt()));
        });


        CalendarSource source = new CalendarSource();

        source.getCalendars().add(appAppoints);
        appAppoints.setReadOnly(true);
        calendarView.getCalendarSources().add(source);
        calendarView.setCreateEntryClickCount(100);
        calendarView.getPrintView().getCalendarSources().add(source);

        container.setCenter(calendarView.getSelectedPageView());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
