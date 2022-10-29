package com.software.mas.controller.home.customer.subpane;

import com.software.mas.DateHelper;
import com.software.mas.controller.home.customer.Appointment;
import com.software.mas.model.ReserveModel;
import com.software.mas.model.templates.AppointmentsData;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.time.LocalDateTime;
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

    List<AppointmentsData> availableDates;


    ObservableList<Appointment> te = FXCollections.observableArrayList();

    public void init(String serviceId) {
        //init model - >

        model = new ReserveModel();
        availableDates = model.getAllAvailable(serviceId);
        availableDates = DateHelper.findAppiontmentsBetween(availableDates, LocalDateTime.now(), LocalDateTime.now().plusMonths(2));
        setTableData(availableDates);

        table.getSelectionModel().setAllowsMultipleSelection(false);
        MFXTableColumn <Appointment> col1 = new MFXTableColumn<>("Start Date",true, Comparator.comparing(Appointment::getStart));
        MFXTableColumn <Appointment> col2 = new MFXTableColumn<>("End Date",true, Comparator.comparing(Appointment::getEnd));

        col1.setRowCellFactory(person -> new MFXTableRowCell<>(Appointment::getStart));
        col2.setRowCellFactory(person -> new MFXTableRowCell<>(Appointment::getEnd));

        table.getFilters().addAll(
                new StringFilter<>("Name", Appointment::getStart),
                new StringFilter<>("Age", Appointment::getEnd)

        );

        table.getTableColumns().addAll(col1,col2);

//        te.add(new Appointment("Ahmad","2"));

        table.setItems(te);

        table.getSelectionModel().selectionProperty().addListener((InvalidationListener) e->{
            bookBtn.disableProperty().set(false);
        });


    }
    public void setTableData(List<AppointmentsData> data){
        te.clear();
        System.out.println("gello");
        for(AppointmentsData temp : data) {
            te.add(new Appointment(DateHelper.dateToString(temp.start()), DateHelper.dateToString(temp.end())));
            System.out.println(temp.start());
        }
        table.setItems(te);

    }
    @FXML
    void book(ActionEvent event) {
        //todo:get <LocalDate>time ...

     List<Appointment> list = table.getSelectionModel().getSelectedValues();
        System.out.println(list.get(0).getStart());

        //Remove the selected Item
     table.getItems().remove(list.get(0));


     if(table.getItems().isEmpty()){
         bookBtn.disableProperty().set(true);
     }

    }
    @FXML
    void search(ActionEvent event) {
        //todo: Model to get the data



    }

}
