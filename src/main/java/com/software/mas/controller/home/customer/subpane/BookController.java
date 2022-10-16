package com.software.mas.controller.home.customer.subpane;

import com.software.mas.controller.home.customer.TestClass;
import io.github.palexdev.materialfx.controls.MFXButton;
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

import javafx.scene.control.Button;

import java.net.URL;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class BookController implements Initializable {

    @FXML
    private MFXButton bookBtn;
    @FXML
    MFXTableView <TestClass> table;

    ObservableList<TestClass> te = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table.getSelectionModel().setAllowsMultipleSelection(false);
        MFXTableColumn <TestClass> col1 = new MFXTableColumn<>("Start Date",true, Comparator.comparing(TestClass::getName));
        MFXTableColumn <TestClass> col2 = new MFXTableColumn<>("End Date",true, Comparator.comparing(TestClass::getAge));

        col1.setRowCellFactory(person -> new MFXTableRowCell<>(TestClass::getName));
        col2.setRowCellFactory(person -> new MFXTableRowCell<>(TestClass::getAge));

        table.getFilters().addAll(
                new StringFilter<>("Name", TestClass::getName),
                new StringFilter<>("Age", TestClass::getAge)

        );

        table.getTableColumns().addAll(col1,col2);

        te.add(new TestClass("Ahmad","2"));
        te.add(new TestClass("asd","2"));
        te.add(new TestClass("Abdo","2"));
        te.add(new TestClass("Abdo","2"));
        te.add(new TestClass("Abdo","2"));
        te.add(new TestClass("Abdo","2"));
        te.add(new TestClass("Abdo","2"));
        te.add(new TestClass("Abdo","2"));
        te.add(new TestClass("Abdo","2"));
        te.add(new TestClass("Abdo","2"));
        te.add(new TestClass("Abdo","2"));
        te.add(new TestClass("Abdo","2"));
        te.add(new TestClass("Abdo","2"));
        te.add(new TestClass("Abdo","2"));
        table.setItems(te);

        table.getSelectionModel().selectionProperty().addListener((InvalidationListener) e->{
            bookBtn.disableProperty().set(false);
        });


    }

    @FXML
    void book(ActionEvent event) {
        //todo:get <LocalDate>time ...

     List<TestClass> list = table.getSelectionModel().getSelectedValues();
        System.out.println(list.get(0).getName());

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
