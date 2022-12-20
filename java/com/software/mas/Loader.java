package com.software.mas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Stack;

public class Loader {


    private static final Stack<Parent> parentStack = new Stack<>();

    //Inline Methods:-------------------------------------------------
    public static FXMLLoader getLoader(String url) throws IOException {
        return new FXMLLoader(App.class.getResource(url));
    }
    public static Scene sceneLoader (String url) throws IOException {
        return new Scene(getLoader(url).load());
    }
    public static Parent parentLoader(String url) throws IOException {
        return getLoader(url).load();
    }
    //Inline Methods:-------------------------------------------------


    /*This method design to handle return button action
    * After click a button the scene you gave it to the saveLoader() will be saved in the stack.
    * you can return to the previous page by invoking the popUp method.
    * this method will be used in IN-DEPTH-PAGE.
    * todo:ENHANCE IT
    * */
    public static FXMLLoader saveParentLoader(Parent currentPage , String nextUrl) throws IOException {
        pushView(currentPage);

       return getLoader(nextUrl);
    }
    public static Parent popView(){
        try{

            return parentStack.pop();
        }
        catch(Exception e){
            System.out.println("Loader.java : No parent to pop from the stack");
            return null;
        }
    }
    public static void pushView(Parent vw){
        parentStack.push(vw);
    }


}
