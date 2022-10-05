package com.software.mas.controller.home.customer;

import com.software.mas.controller.home.NavbarController;

import java.io.IOException;


public class NavbarCustomerController extends NavbarController<HomeCustomerController> {
    /*   --SMART NAVBAR--
    This method used for :
    *Determine the route.
    *Update to a new view according to the corresponding view to the icon that you have clicked.
    *You must follow the rules in naming the icons.
    *You can start it and see the result and try to figure it out.
    *The parent class is abstract to re-use the methods in the next navbar (USER-NAVBAR).
     */
    @Override
    protected void setRoute(String FXMLViewName) throws IOException {

            String route = "/com/software/mas/UI/home/customer/sub-panes/" + FXMLViewName + ".fxml";
            viewController.setCenterView(route);
    }
}
