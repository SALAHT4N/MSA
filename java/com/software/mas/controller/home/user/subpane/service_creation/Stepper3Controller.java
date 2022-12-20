package com.software.mas.controller.home.user.subpane.service_creation;

import com.software.mas.Loader;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

import com.software.mas.controller.components.MiniServiceCardController;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class Stepper3Controller implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imagesList.getSelectionModel().setAllowsMultipleSelection(false);
        box = imageBox.getFill();

        tagColors.getItems().addAll(
                "Red",
                "Black",
                "Blue",
                "Yellow",
                "Pink",
                "Green"
        );
    }

    @FXML
    private Rectangle imageBox;

    @FXML
    private MFXListView<String> imagesList;

    @FXML
    private MFXComboBox<String> tagColors;

    @FXML
    private MFXTextField tagName;

    private List<File> imageFiles;
    Paint box;
    public Stepper3Controller()
    {
        imageFiles = new LinkedList<>();

    }
    @FXML
    void addImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter ex = new FileChooser.ExtensionFilter("images", "*.png");

        fileChooser.setTitle("Select Photos");
        fileChooser.setInitialDirectory(new File("C:\\Users\\tanbo\\Desktop\\University"));
        fileChooser.getExtensionFilters().add(ex);
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(((Node) event.getSource()).getScene().getWindow());
        if (selectedFiles != null)
        {
            imageFiles.addAll(selectedFiles);
            imagesList.getItems().addAll(getImagesNames(selectedFiles));
        }

    }

    private List<String> getImagesNames(List<File> files)
    {
        List<String> names = new LinkedList<String>();
        for (File i: files)
        {
            names.add(i.getName());
        }
        return names;
    }
    @FXML
    private HBox tagsContainer;


    @FXML
    void addTag(ActionEvent event) {
        String color = tagColors.getSelectedItem().toLowerCase();
        Label tag = MiniServiceCardController.createTag(tagName.getText(), color);
        tag.setOnMouseClicked(e -> {
            Label pressedTag = (Label) e.getSource();
            ((HBox)(pressedTag).getParent()).getChildren().remove(pressedTag);
        });
        tagsContainer.getChildren().add(0,tag);
//        ((Node)event.getSource()).getParent().getCo
    }


    @FXML
    void selectImage(MouseEvent event) {

        if(imagesList.getSelectionModel().getSelection().keySet().toArray().length != 0)
        {
            // Get index of selected item

            Integer selectedIndex = (Integer) imagesList.getSelectionModel().getSelection().keySet().toArray()[0];

            // using that index to create an image
            Image image = new Image((imageFiles.get(selectedIndex)).getPath());

            // assigning that image to the image rectangle
            imageBox.setFill(new ImagePattern(image));
        }


    }

    @FXML
    void onDelete(ActionEvent event) {
        int selectedIndex = (Integer) imagesList.getSelectionModel().getSelection().keySet().toArray()[0];
        imagesList.getItems().remove(selectedIndex);
        imageBox.setFill(box);
    }
}
