module com.software.mas {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires io.cucumber.junit;
    requires MaterialFX;

    opens com.software.mas.controller.login to javafx.fxml;
    opens com.software.mas.controller.home.customer to javafx.fxml;
    opens com.software.mas to javafx.fxml;

    exports com.software.mas;

}