package com.software.mas.model;

import com.software.mas.model.templates.Service;

import java.util.LinkedList;
import java.util.List;

public class ServicesPageModel {

    public List<String> getServicesNames()
    {
        // Todo: implement the following from the database
        List<String> services = new LinkedList<>();

        services.add("random");
        services.add("football");
        services.add("random shit");
        services.add("hello world");
        services.add("wedding hall");

        return services;
    }

    public List<Service> getServices()
    {
        // Todo: implement the following from the database
        return null;
    }


}
