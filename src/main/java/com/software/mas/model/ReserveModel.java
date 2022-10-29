package com.software.mas.model;

import com.software.mas.model.templates.AppointmentsData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReserveModel {

    public List<AppointmentsData> getAllServiceAppointments(String serviceId,  AppointmentsSearchType TYPE)  {
        Connection con = null;
        List<AppointmentsData> data = new ArrayList<>();
        try {
            con = DBHelper.connect();
            Statement st =con.createStatement();
            ResultSet rs;
            if(AppointmentsSearchType.AVAILABLE == TYPE){
                rs= st.executeQuery("SELECT * FROM appointments");
            } else if (AppointmentsSearchType.RESERVED == TYPE) {
                rs=st.executeQuery("");
            }else{
                rs=st.executeQuery("");
            }
            //RESPONSE:
            //MESSAGE:^^^ TYPE WHAT YOU WANT HERE ^^^

            con.close();
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public List<AppointmentsData> getAllAvailable(String serviceId) {
        return getAllServiceAppointments(serviceId,AppointmentsSearchType.AVAILABLE);
    }

    public void reserve(String userEmail, String service, String time) {
    }

    public List<AppointmentsData> getUserReservedAppointments(String userEmail) {
        return null;
    }
}
