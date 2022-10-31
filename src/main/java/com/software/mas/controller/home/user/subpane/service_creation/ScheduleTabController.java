package com.software.mas.controller.home.user.subpane.service_creation;

import com.software.mas.App;
import com.software.mas.Loader;
import com.software.mas.controller.home.user.subpane.service_creation.assets.AppointmentItemController;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

public class ScheduleTabController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            addSessions();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addSessions() throws IOException {
        // Get sessions from schedule from model
        int sessionLength = 8;
        for (int i = 0; i < sessionLength; i++)
        {
            FXMLLoader sessionLoader = Loader.getLoader("/com/software/mas/UI/home/user/sub-panes/service-creation/assets/appointment-item.fxml");

            sessionsContainer.getChildren().add(sessionLoader.load());
            ((AppointmentItemController)sessionLoader.getController()).containerController = this;

        }

    }

    @FXML
    private MFXTextField endTime;

    @FXML
    private VBox sessionsContainer;

    @FXML
    private MFXTextField startTime;

    @FXML
    void addSession(ActionEvent event) throws IOException {
            LocalTime start = null, end = null;

            try {
                start = getLocalTimeFor(startTime.getText());
                end = getLocalTimeFor(endTime.getText());

                if (start != null && end != null)
                {
                    FXMLLoader sessionLoader = Loader.getLoader("/com/software/mas/UI/home/user/sub-panes/service-creation/assets/appointment-item.fxml");

                    sessionsContainer.getChildren().add(sessionLoader.load());

                    ((AppointmentItemController)sessionLoader.getController()).setData(start, end);
                    ((AppointmentItemController)sessionLoader.getController()).containerController = this;
                    markValidInput();
                } else {

                }

            } catch (DateTimeException e) {
                markInvalidInput();
            }

    }
    private LocalTime getLocalTimeFor(String time) throws DateTimeException
    {
        String[] values = time.split(":");
        LocalTime returnedTime = null;

        final int HOURS = 0, MINUTES = 1, SECONDS = 2;

        try {
            if (values.length == 0)
                throw new DateTimeException("nothing entered");
            else if (values.length < 3)
                returnedTime = LocalTime.of(Integer.parseInt(values[HOURS]),Integer.parseInt(values[MINUTES]),0);
            else {
                returnedTime = LocalTime.of(Integer.parseInt(values[HOURS]),Integer.parseInt(values[MINUTES]),Integer.parseInt(values[SECONDS]));
            }

        } catch (IndexOutOfBoundsException ex) {
            throw new DateTimeException("little entered");
        } catch (InputMismatchException ex2) {
            throw new DateTimeException("input numbers");

        } catch (NumberFormatException ex3) {
            throw new DateTimeException("numbers only");

        }

        return returnedTime;
    }

    private String validStylesheet = App.class.getResource("/com/software/mas/CSS/ColorThemes.css").toString();
    private String invalidStylesheet = App.class.getResource("/com/software/mas/CSS/user/subpanes/service-creation/textfield-invalid-input.css").toString();
    private void markInvalidInput()
    {
        System.out.println("Invalid Input");
//        startTime.getStyleClass().add("invalid-text-field");
//        startTime.setStyle("-fx-border-color: red");
        addInvalidStylesheet(startTime);

        for (int i = 0; i < startTime.getStylesheets().size(); i++)
            System.out.println("startTime stylesheet: " + startTime.getStylesheets().get(i));
//        startTime.getStylesheets().removeAll();
        addInvalidStylesheet(endTime);
    }
    private void markValidInput()
    {
        addValidStylesheet(startTime);
//        startTime.setStyle("");
        for (int i = 0; i < startTime.getStylesheets().size(); i++)
            System.out.println("startTime stylesheet: " + startTime.getStylesheets().get(i));
//        startTime.getStylesheets().removeAll();
        addValidStylesheet(endTime);
    }

    private void addInvalidStylesheet(MFXTextField text)
    {
        text.getStylesheets().removeAll(text.getStylesheets());
        text.getStylesheets().add(invalidStylesheet);
    }
    private void addValidStylesheet(MFXTextField text)
    {
        text.getStylesheets().removeAll(text.getStylesheets());
        text.getStylesheets().add(validStylesheet);
    }

    public void clearStyles()
    {
        for (Node item : sessionsContainer.getChildren() )
        {
            if (item instanceof HBox)
            {
                ((HBox)item).getStylesheets().removeAll(App.class.getResource("/com/software/mas/CSS/user/subpanes/service-creation/appointment-item--selected.css").toString());
                ((HBox)item).getStylesheets().add(App.class.getResource("/com/software/mas/CSS/user/subpanes/service-creation/appointment-item.css").toString());
                //System.out.println(((HBox)item).getStylesheets().get(0));
            }

        }
    }

    @FXML
    void deleteSession(ActionEvent event) {
        Node toRemove = null;
        for (Node item : sessionsContainer.getChildren() )
        {
            if (item instanceof HBox)
            {
                String currentStylesheet = ((HBox) item).getStylesheets().get(0);
                String comparedTo =  App.class.getResource("/com/software/mas/CSS/user/subpanes/service-creation/appointment-item--selected.css").toString();

//                System.out.println(currentStylesheet);
                if (currentStylesheet.equals(comparedTo))
                {
//                    System.out.println("removed element");
                    //removeFromChildren(sessionsContainer, item);
                    toRemove = item;
                }
            }
        }
        removeFromChildren(sessionsContainer,toRemove);
    }

    private void removeFromChildren(VBox parent, Node item)
    {
        parent.getChildren().removeAll(item);
    }

}
