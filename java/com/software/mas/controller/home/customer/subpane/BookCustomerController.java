package com.software.mas.controller.home.customer.subpane;


import com.software.mas.App;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import javafx.scene.Node;

import java.net.URL;
import java.util.ResourceBundle;

//Markup controller *Saved posts*
public class BookCustomerController extends MainCustomerController {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            super.setCardsWithBookMark( model.getAllBookMarked(App.current_user.getKey()),true);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
