package com.software.mas;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;

public class FXHelper {

    public static Parent findParentToDetailsPage(Node child){
        try {
            while (!(child instanceof FlowPane) ) {
                child = child.getParent();
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return (Parent) child;
    }

}
