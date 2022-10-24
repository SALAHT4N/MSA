module com.software.mas {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires io.cucumber.junit;
    requires MaterialFX;
    requires com.calendarfx.view;
    requires javafx.web;
    requires java.sql;


    opens com.software.mas.controller.components to javafx.fxml;
    opens com.software.mas.controller.login to javafx.fxml;
    opens com.software.mas.controller.home to javafx.fxml;
    opens com.software.mas.controller.home.customer to javafx.fxml;
    opens com.software.mas.controller.home.customer.subpane to javafx.fxml;
    opens com.software.mas to javafx.fxml;
    opens com.software.mas.controller.signup to javafx.fxml;
    opens com.software.mas.controller.home.user.subpane to javafx.fxml;
    opens com.software.mas.controller.home.user to javafx.fxml;
    opens com.software.mas.controller.home.user.subpane.service_creation to javafx.fxml;
    exports com.software.mas;
    opens com.software.mas.controller to javafx.fxml;


}