package com.software.mas;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;

import java.util.Arrays;

public class FXHelper {


    public static String errorCSS = "-fx-background-color: #FFECE8;";

    public static void resetStyles(Node ...nodes){
        Arrays.stream(nodes).forEach(e->e.setStyle(""));
    }

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
    public static Parent findParentToDetailsPageScrollPane(Node child){
        try {
            while (!(child instanceof ScrollPane) ) {
                child = child.getParent();
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return (Parent) child;
    }


}
