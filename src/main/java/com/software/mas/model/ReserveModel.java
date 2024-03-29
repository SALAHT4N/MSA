package com.software.mas.model;

import com.software.mas.model.templates.AppointmentsData;
import com.software.mas.model.templates.BooksData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReserveModel {

    public List<AppointmentsData> getAllServiceAppointments(String serviceId,  AppointmentsSearchType TYPE)  {
        List<AppointmentsData> data = new ArrayList<>();
        try(Connection con = DBHelper.connect();
        Statement st =con.createStatement();) {


            ResultSet rs;
            if(AppointmentsSearchType.AVAILABLE == TYPE){
                rs=st.executeQuery(" SELECT (CONCAT( dates.date,'T',start_time)) as start_date, (CONCAT( dates.date,'T',end_time)) as end_date " +
                        " FROM dates inner join appointments WHERE Day = DayWeek AND service_id ="+serviceId+" AND" +
                        " (SELECT CONCAT( dates.date,'T',start_time), CONCAT( dates.date,'T',end_time))" +
                        " not in (SELECT books.start_date, books.end_date FROM books)"
                );

            } else if (AppointmentsSearchType.RESERVED == TYPE) {
                rs= st.executeQuery("");
            }else{
                rs=st.executeQuery("SELECT (CONCAT( dates.date,'T',start_time)) as start_date, (CONCAT( dates.date,' ',end_time)) as end_date " +
                        " FROM dates inner join appointments WHERE Day = DayWeek AND service_id ="+serviceId);
            }

            //SELECT (concat('HELLO ', start_time)) as newcol FROM appointments;
            //SELECT DATE_FORMAT(CURRENT_DATe()+10, "%Y-%m-%d") FROM DUAL;
            //SELECT (CONCAT( dates.date,'T',start_time)) as start_date, (CONCAT( dates.date,' ',end_time)) as end_date FROM dates inner join appointments WHERE Day = DayWeek;
            /*
            SELECT (CONCAT( dates.date,'T',start_time)) as start_date, (CONCAT( dates.date,'T',end_time)) as end_date
            FROM dates inner join appointments WHERE Day = DayWeek AND service_id = ? AND (SELECT CONCAT( dates.date,'T',start_time), CONCAT( dates.date,'T',start_time)) not in (SELECT books.start_date, books.end_date FROM books);
             */
            //MESSAGE:^^^ TYPE WHAT YOU WANT HERE ^^^

            //Storing the result query...
            while(rs.next())
                data.add(new AppointmentsData( LocalDateTime.parse(rs.getString("start_date")) ,
                                                LocalDateTime.parse(rs.getString("end_date"))));

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

    public void reserve(String userEmail, String service, String time) throws SQLException {

        try(Connection conn = DBHelper.connect();
        Statement st = conn.createStatement();){


            String[] tok = time.split("~");
            int i= st.executeUpdate("INSERT INTO books (customer_email, service_id, start_date, end_date, status, allow_comment) VALUES " +
                    " ( '"+userEmail+"', "+service+" , '"+tok[0]+"', '"+tok[1]+"', 1, true )" );

            conn.close();
            st.close();
        }

    }

    public List<BooksData> getUserReservedAppointments(String userEmail) throws SQLException {
        List<BooksData> data = new ArrayList<>();

        try (Connection conn = DBHelper.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT service_id, start_date, end_date, status, allow_comment " +
                                            "FROM books WHERE customer_email='"+userEmail+"'");){


            while(rs.next()) {
                String serviceId = rs.getString(1);
                LocalDateTime startAt = LocalDateTime.parse(rs.getString(2));
                LocalDateTime endAt = LocalDateTime.parse(rs.getString(3));
                Boolean status = rs.getBoolean(4);
                Boolean allowComment = rs.getBoolean(5);
                data.add(new BooksData(serviceId, startAt, endAt, status, allowComment));
            }

            conn.close();
            rs.close();
            st.close();
        }
        return data;
    }
}
