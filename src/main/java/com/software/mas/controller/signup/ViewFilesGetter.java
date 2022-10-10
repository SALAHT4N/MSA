package com.software.mas.controller.signup;

import com.software.mas.Loader;
import io.github.palexdev.materialfx.controls.MFXStepperToggle;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;



/*
* The idea of this class is to remove all the misplaced methods in the controllers of the signup section.
* with misplaced I mean, methods that their behaviour doesn't have a place in the controller.
* Methods like creating a view should be done only by the model, the controller is responsible for displaying that data
* without the ability to create or generate any.
*/
public abstract class ViewFilesGetter {
    public Object[] fileNames;
    private String[] stepsNames;


    /*
        No Arguments constructor was removed to ensure that no subclass can use these methods without specifying
        the stepsNames value
        This value is essential in displaying the stepper with complete info
    */

//    public ViewFilesGetter()
//    {
//        fileNames = getFileNames().toArray();
//    }
    public ViewFilesGetter(String[] stepsNames) throws URISyntaxException {
        /*
        * The only reason a variable should be put in the constructor in this scenario, is when it depends on a value got
        * from the child class.
        *
        * So fileNames doesn't have to be a field of the parent class.
        * it can be simply a local variable declared in the createSteps method.
        * */
        fileNames = getFileNames().toArray();
        this.stepsNames = stepsNames;
    }

    /*
    * The stepsNames reference is set to private since the subclass shouldn't deal with it besides specifying the value
    * in the constructor.
    *
    * The class traversal is as follows:
    * (1) the subclass calls this class constructor along with the value for the stepsNames
    * (2) this value is used in the createSteps method. the implementation is the same across subclasses, so it's not abstract.
    * (3) the createStep method is private, since it is only needed by this class to complete the behaviour of the createSteps
    * (4) addFileName method is abstract,that's due to each subclass having its own implementation.
    *     you can notice that the abstract method was called from a concrete one, that is possible, since the complete method
    *     will be called by the concrete subclass, and that class provides an implementation for the abstract method,
    *     so in theory, the method would be called with no problems

    *
    *
    * getFileNames is private, since it is called from the parent class to initialize the fileNames variable so it can be used
    * in the createSteps method.
    *
    *
    * No methods are public aside from the ones that are NEEDED TO BE CALLED FROM THE SUBCLASS.
    *
    * */
    private List<String> getFileNames() throws URISyntaxException {
        File folder = new File(getClass().getResource("/com/software/mas/UI/signup/provider-steps").toURI());
        File[] listOfFiles = folder.listFiles();

        LinkedList<String> returnedFiles = new LinkedList<>();

        for (File i : listOfFiles)
        {
            addFileName(i,returnedFiles); // is Implemented based on the subclass specification
        }

        return returnedFiles;
    }

    public List<MFXStepperToggle> createSteps() throws IOException {
        LinkedList<MFXStepperToggle> steps = new LinkedList<>();
        int index = 0;
        for (Object i :  fileNames)
        {
            steps.add(new MFXStepperToggle(
                            stepsNames[index++],
                            new MFXFontIcon("mfx-lock", 16, Color.web("#000000"))
                            ,createStep(i.toString())
                    )
            );
        }
        System.out.println("Number of Steps: " + steps.size());
        return steps;
    }
    private Parent createStep(String fileName) throws IOException {
        return Loader.parentLoader("/com/software/mas/UI/signup/provider-steps/" + fileName);
    }


    abstract public void addFileName(File i, LinkedList<String> returnedFiles);


}
