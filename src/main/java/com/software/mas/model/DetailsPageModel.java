package com.software.mas.model;

import com.software.mas.model.templates.CommentProfileData;
import com.software.mas.model.templates.DetailsPageData;

import java.sql.*;

import java.util.*;
import java.util.Date;

public class DetailsPageModel {
    //todo:Comment Section - DONE
    //todo:Image Slider (Easy I think)
    //todo:Book Feature - Working
    //      todo:Available Appointments
    //      todo:reservation


    private String getFullName (String firstName, String middleName, String lastName){
        return firstName+ " " + (middleName == null? "" : middleName + " ")+lastName;
    }
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
            String lName = rs.getString(3);

            String fullName = getFullName(fName, mName, lName);
            System.out.println(fullName);
            Date date = rs.getDate(4);
            String content = rs.getString(5);
            double rating = rs.getDouble(6);
            String photo_name = rs.getString(7);

            data.add(new CommentProfileData(fullName, content,"http://localhost/upload_image/data/profile_image/"+photo_name,date, rating));
        }
        con.close();
        return data;
    }

    //@param1 Service id
    public List<String> getSliderImagesUrl(String id){
        List<String> imageUrl = new ArrayList<>();
        try {
            Connection con = DBHelper.connect();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT url FROM images WHERE service_id="+id);

            while(rs.next())
                imageUrl.add("http://localhost/upload_image/data/image_slides/"+rs.getString(1));

            con.close();
            return imageUrl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     //@param1 Service id
    public DetailsPageData getServiceData(String id){
        try {

            Connection con = DBHelper.connect();
            Statement st = con.createStatement();
            ResultSet rs =
                    st.executeQuery("SELECT first_name, middle_name, last_name, profile_photo, mobile " +
                                        "FROM customers INNER JOIN services WHERE email = provider_email " +
                                        " AND id ="+id);
            rs.next();
            String fullName = getFullName(rs.getString(1),rs.getString(2),rs.getString(3));
            String profileImage = rs.getString(4);
            String mobile = rs.getString(5);



            con.close();
            return new DetailsPageData(fullName, "http://localhost/upload_image/data/profile_image/"+profileImage, mobile, getSliderImagesUrl(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //If the returned value is null then there's no id with
        return null;
    }



}
