package com.software.mas.controller.home.customer.subpane;

import com.software.mas.App;
import com.software.mas.DateHelper;
import com.software.mas.FXHelper;
import com.software.mas.controller.home.customer.Appointment;
import com.software.mas.model.ReserveModel;
import com.software.mas.model.templates.AppointmentsData;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class BookController {


    @FXML
    private MFXButton bookBtn;
    @FXML
    MFXTableView <Appointment> table;

    @FXML
    private MFXDatePicker fromDate;

    private ReserveModel model;

    @FXML
    private MFXDatePicker toDate;

    List<AppointmentsData> availableDates ;


    ObservableList<Appointment> te = FXCollections.observableArrayList();

    String serviceId;

    public void init(String serviceId) {
        //init model - >
        //THIS SHOULD BE IN ANOTHER THREAD ->:
        this.serviceId=serviceId;
        model = new ReserveModel();
        availableDates = model.getAllAvailable(serviceId);
        availableDates = DateHelper.findAppointmentsAfter(availableDates, LocalDateTime.now());
        if(availableDates.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There's no appointments");
            return;
        }

        //UI STUFFS
        table.getSelectionModel().setAllowsMultipleSelection(false);
        MFXTableColumn <Appointment> col1 = new MFXTableColumn<>("Start Date",true, Comparator.comparing(Appointment::getStart));
        MFXTableColumn <Appointment> col2 = new MFXTableColumn<>("End Date",true, Comparator.comparing(Appointment::getEnd));

        col1.setRowCellFactory(person -> new MFXTableRowCell<>(Appointment::getStart));
        col2.setRowCellFactory(person -> new MFXTableRowCell<>(Appointment::getEnd));

        table.getFilters().addAll(
                new StringFilter<>("Start Date", Appointment::getStart),
                new StringFilter<>("End Date", Appointment::getEnd)

        );

        table.getTableColumns().addAll(col1,col2);

//        te.add(new Appointment("Ahmad","2"));



        table.getSelectionModel().selectionProperty().addListener((InvalidationListener) e->{
            bookBtn.disableProperty().set(false);
        });


    }
    public void setTableData(List<AppointmentsData> data){
        te.clear();
        for(AppointmentsData temp : data) {
            te.add(new Appointment(DateHelper.dateToString(temp.startAt()), DateHelper.dateToString(temp.endAt())));
        }

        table.setItems(te);

    }
    @FXML
    void book(ActionEvent event) throws SQLException {
        //todo:get <LocalDate>time ...

     Appointment reservingTime = table.getSelectionModel().getSelectedValues().get(0);

        String startTime = reservingTime.getStart().replaceAll(" ","T");
        String endTime = reservingTime.getEnd().replaceAll(" ","T");

        model.reserve(App.current_user.getKey(),serviceId,(startTime+"~"+endTime));

        //Remove the selected Item
     table.getItems().remove(reservingTime);
     te.remove(reservingTime);
     if(table.getItems().isEmpty()){
         bookBtn.disableProperty().set(true);
     }
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();

    }


    @FXML
    void search(ActionEvent event) {
        //todo: Model to get the data
        if(fromDate.getValue() == null || toDate.getValue() == null){
            if (fromDate.getValue() == null)
                fromDate.setStyle(FXHelper.errorCSS);
            else
                fromDate.setStyle("");

            if(toDate.getValue() == null)
                toDate.setStyle(FXHelper.errorCSS);
            else
                fromDate.setStyle("");

            return;
        }
        setTableData(DateHelper.findAppointmentsBetween(availableDates,fromDate.getValue().atStartOfDay() ,
                                                        toDate.getValue().atStartOfDay().plusHours(24)));
        //RESET STYLES
        FXHelper.resetStyles(toDate, fromDate);

    }



}
