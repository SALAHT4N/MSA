package com.software.mas;

import com.software.mas.model.templates.AppointmentsData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DateHelper {

    //This two methods was created to avoid the undesirable returned value from getDayOfWeek() method.
    //This two methods will help us return the required value. Ex: Sunday => 1 ....
    public static int getDayNumber(LocalDateTime date){
        return (date.getDayOfWeek().getValue()%7)+1;
    }
    public static int getDayNumber(LocalDate date){
        return (date.getDayOfWeek().getValue()%7)+1;
    }
    public static List<AppointmentsData> findAppiontmentsBetween(List<AppointmentsData> data,LocalDateTime time1 , LocalDateTime time2){
        List<AppointmentsData> result = new ArrayList<>();

        for(AppointmentsData temp : data){

            if(temp.start().isAfter(time1) && temp.end().isBefore(time2))
                result.add(temp);

        }

        return result;
    }
    public static String dateToString(LocalDateTime date){
        String[] tok = date.toString().split("T");
        return tok[0]+" "+tok[1];
    }
}
