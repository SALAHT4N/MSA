package com.software.mas.controller.home.customer.subpane;

import com.software.mas.Loader;
import com.software.mas.StringHelper;
import com.software.mas.controller.components.MiniServiceCardController;
import com.software.mas.model.HomeModel;
import com.software.mas.model.templates.HomeCard;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXFilterComboBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Set;

public class MainCustomerController implements Initializable {

    @FXML
    VBox cardContainer;

    @FXML
    private MFXFilterComboBox<String> comboCity;

    @FXML
    private MFXFilterComboBox<String> comboCountry;

    @FXML
    private MFXFilterComboBox<String> comboStreet;

    @FXML
    private TextField searchField;

    HomeModel model = new HomeModel();

    public void setCards(Queue<HomeCard> cards) throws IOException {
        cardContainer.getChildren().removeAll(cardContainer.getChildren());
        while (!cards.isEmpty()){
            HomeCard card = cards.poll();
            FXMLLoader loader = Loader.getLoader("/com/software/mas/UI/components/service-card.fxml");
        Parent view = loader.load();
        MiniServiceCardController cont = (MiniServiceCardController) loader.getController();

        cont.setDataSource(card);
        cont.setImage(new Image("http://localhost/mas/main_img/" + card.img()));
        cont.setLocation(StringHelper.capitalize(card.street())  + " " + StringHelper.capitalize(card.city()) + " " + StringHelper.capitalize(card.country()));
        cont.addTags(card.tags().split(" "));
        cont.setStringHeader(card.name());
        cont.setStringDescription(card.description());

        cardContainer.getChildren().add(view);
    }

    }

    @FXML
    private void search() throws IOException {

        String tags = searchField.getText();
        String street = comboStreet.getSelectedItem() == null ?"":comboStreet.getSelectedItem().toLowerCase();
        String city = comboCity.getSelectedItem()==null  ?"":comboCity.getSelectedItem().toLowerCase();
        String country = comboCountry.getSelectedItem() == null ?"":comboCountry.getSelectedItem().toLowerCase();

        setCards(model.searchFor(tags, street, city, country));

    }


        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

           setCards( model.getAll());

          Queue<Set<String>> list = model.getLocations();



          comboStreet.getItems().setAll(StringHelper.capitalizeSet(list.poll()));
          comboCity.getItems().setAll(StringHelper.capitalizeSet(list.poll()));
          comboCountry.getItems().setAll(StringHelper.capitalizeSet(list.poll()));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
