package com.software.mas.controller.home.user.subpane;

import com.software.mas.Loader;
import com.software.mas.controller.components.ServicesMenuBox;
import com.software.mas.controller.home.customer.subpane.CalendarCustomerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/*This must be done in a different way
*
* A CalendarController, and both the customer and provider extends it*/
public class CalendarUserController  implements Initializable {


    @FXML
    private Text appointmentTab;

    @FXML
    private Text calendarTab;

    @FXML
    BorderPane container;

    @FXML
    private Text pageHeading;

    @FXML
    void changeTab(MouseEvent event) throws IOException {
        Parent requestedTab;
        if (appointmentTab.equals(pressedTab(event)))
        {
            requestedTab = appointmentsView;

            activateTabStyle(appointmentTab);
            removeTabStyle(calendarTab);

            container.setCenter(requestedTab);
        } else {
            requestedTab = calendarView;

            activateTabStyle(calendarTab);
            removeTabStyle(appointmentTab);

            container.setCenter(requestedTab);
        }

    }

    private void activateTabStyle(Text tab)
    {
        tab.getStyleClass().add("tab-heading--selected");
    }
    private void removeTabStyle(Text tab)
    {
        tab.getStyleClass().removeAll("tab-heading--selected");
    }
    private Text pressedTab(MouseEvent event)
    {
        return ((Text)event.getSource());
    }
    @FXML
    void chooseService(MouseEvent event) throws IOException {
        Stage services = new Stage();
        services.initStyle(StageStyle.UNDECORATED);

//        Scene scene = new Scene(Loader.parentLoader(App.class.getResource("/com/software/mas/UI/components/pending-card.fxml")));
        FXMLLoader servicesPopUp = Loader.getLoader("/com/software/mas/UI/components/services-menu-box.fxml");
        services.setScene(new Scene(servicesPopUp.load()));

        ServicesMenuBox.containerController = this;

        services.initModality(Modality.APPLICATION_MODAL);

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        double x = currentStage.getX();
        double y = currentStage.getY();

        services.setX(x + 20);
        services.setY(y + 100);
        services.show();
    }
    public void setPageHeading(String heading)
    {
        pageHeading.setText(heading);
    }


    Parent calendarView, appointmentsView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            calendarView = Loader.parentLoader("/com/software/mas/UI/home/user/sub-panes/calendar-view.fxml");
            appointmentsView = Loader.parentLoader("/com/software/mas/UI/home/user/sub-panes/appointments-user.fxml");

            // So that the first pane is the appointments' pane.
            container.setCenter(appointmentsView);
            appointmentTab.getStyleClass().add("tab-heading--selected");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
