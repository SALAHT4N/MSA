package com.software.mas.model;

import com.software.mas.model.templates.CommentProfileData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class DetailsPageModel {
    //todo:Comment Section - DONE
    //todo:Image Slider (Easy I think)
    //todo:Book Feature - Working
    //      todo:Available Appointments
    //      todo:reservation



    public Queue<CommentProfileData> getAllComments(long id) throws Exception {

        Connection con = DBHelper.connect();

        Queue<CommentProfileData> data = new LinkedList<>();

        PreparedStatement preSt =
                con.prepareStatement("SELECT first_name, middle_name, last_name" +
                                        " , comment_date, content, rating, profile_photo " +
                                        " FROM customers INNER JOIN comments INNER JOIN  services WHERE  " +
                                       "  customers.email=comments.customer_id AND " +
                                        " services.id = comments.service_id AND service_id=?");
        preSt.setLong(1,id);

        ResultSet rs = preSt.executeQuery();

        while(rs.next()){
            //todo: getting data and store it in the queue
            String fName = rs.getString(1);
            String mName = rs.getString(2);
            mName = mName == null? "" : mName + " ";
            String lName = rs.getString(3);

            String fullName = fName + " " + mName  + lName;
            System.out.println(fullName);
            Date date = rs.getDate(4);
            String content = rs.getString(5);
            double rating = rs.getDouble(6);
            String photo_name = rs.getString(7);

            data.add(new CommentProfileData(fullName, content,"http://localhost/mas/profile_photo/"+photo_name,date, rating));
        }

        return data;
    }



}
