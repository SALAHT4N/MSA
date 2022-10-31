package com.software.mas.controller.home.user.subpane;

import com.software.mas.Loader;
import com.software.mas.controller.components.ServiceMenuItemController;
import com.software.mas.controller.components.ServicesMenuBox;
import com.software.mas.model.ServicesPageModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;


/*This must be done in a different way
*
* A CalendarController, and both the customer and provider extends it*/
public class CalendarUserController extends ClearStyles implements Initializable {


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
//            requestedTab = appointmentsView;
            requestedTab = appointmentsContainer;
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

    private static final ServicesPageModel servicesModel;
    private static final List<String> serviceNames;
    private static final List<ServiceMenuItemController<CalendarUserController>> availableServicesControllers;

    // This code is done before the constructor is started.
    static {
        servicesModel = new ServicesPageModel();
        serviceNames = getServicesNamesFromModel();
        availableServicesControllers = new LinkedList<>();
    }


    private static List<String> getServicesNamesFromModel()
    {
        return servicesModel.getServicesNames();
    }


    public CalendarUserController() {
        // Here we need to pass on the array of HBoxes
        super(getAvailableServices());

        // essential for items to work properly.
        setContainerControllerForItems();

        // for the view.
        servicesPane = new TitledPane();
        vboxServices = new VBox();
        appointmentsView = appointmentsContainer;
    }

    private static List<HBox> getAvailableServices() {
        try {
//            ServiceMenuItemController.containerController = this;
            List<HBox> availableServices = new LinkedList<>();


            for (int i = 0; i < serviceNames.size(); i++) {

                FXMLLoader tempLoader = Loader.getLoader("/com/software/mas/UI/components/service-menu-item.fxml");

                // This could be used instead of making a static reference in the child view.
                //((ServiceMenuItemController)tempLoader.getController()).containerController;

                Parent service = tempLoader.load();
                ServiceMenuItemController<CalendarUserController> itemController = tempLoader.getController();
                itemController.setServiceName(serviceNames.get(i));

                availableServicesControllers.add(itemController);
                availableServices.add((HBox) service);
            }
//            ServiceMenuItemController.makeItemSelected(availableServicesLoaders.get(0));
            return availableServices;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void setContainerControllerForItems()
    {
        for (ServiceMenuItemController<CalendarUserController> i : availableServicesControllers)
            i.containerController = this;
    }

    // this needs to be static since otherwise we need to make an object from this class to be able to use its method.
    // but the super constructor is called before the creation of the child object, therefore we have to make it static
    // to be able to be called before the creation of the object.
    @FXML
    VBox vboxServices;

    @FXML
    private GridPane gridPane;


    @FXML
    private TitledPane servicesPane;

    @FXML
    private ScrollPane appointmentsContainer;
    @FXML
    private VBox appointmentsVBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            calendarView = Loader.parentLoader("/com/software/mas/UI/home/user/sub-panes/calendar-view.fxml");
            //appointmentsView = Loader.parentLoader("/com/software/mas/UI/home/user/sub-panes/appointments-user.fxml");
            for(int i = 0; i < 5; i++)
            {
                Parent appointment = Loader.parentLoader("/com/software/mas/UI/components/pending-card.fxml");
                appointmentsVBox.getChildren().add(appointment);

            }

            // So that the first pane is the appointments' pane.
//            container.setCenter();
            appointmentTab.getStyleClass().add("tab-heading--selected");

//            VBox vboxServices = new VBox();
            List<String> servicesNames = servicesModel.getServicesNames();
            for (String serviceName: servicesNames)
            {
                FXMLLoader serviceItem = Loader.getLoader("/com/software/mas/UI/components/service-menu-item.fxml");

                vboxServices.getChildren().add(serviceItem.load());
                ServiceMenuItemController<CalendarUserController> itemController = serviceItem.getController();
                itemController.containerController = this;
                itemController.setServiceName(serviceName);
            }
            //ScrollPane sp = new ScrollPane();
            //sp.setContent(vboxServices);
            //servicesPane.setContent(sp);
            //servicesPane.setPrefWidth(200);
            servicesPane.setContent(vboxServices);
            servicesPane.setText("Service Name");
            servicesPane.setAnimated(true);
            servicesPane.setExpanded(false);
//            servicesPane.setAl
//            servicesPane.toFront();
            //gridPane.add(servicesPane,0,0);
//            servicesPane.set
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
