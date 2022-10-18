package com.software.mas.model;

import com.software.mas.model.templates.LoginStatus;

import java.sql.*;

public class LoginModel {



    public LoginStatus authenticate(String email, String password) throws SQLException {
        //Default values:
        int lvl=-1;
        boolean correct = false;


        Connection con = DBHelper.connect();

        //AUTHENTICATION PROCESS
        PreparedStatement preparedStmt = con.prepareStatement("SELECT " +
                "  email FROM customers WHERE email=? and password_customer=?");

        preparedStmt.setString(1,email);
        preparedStmt.setString(2,password);
        ResultSet rs = preparedStmt.executeQuery();

        if(rs.next()){

            correct =true;

            //AUTHORIZATION PROCESS
            preparedStmt = con.prepareStatement("SELECT email " +
                    "FROM customers inner join providers " +
                    "WHERE email=?");
            preparedStmt.setString(1,email);
            rs = preparedStmt.executeQuery();

            if(rs.next())
                lvl=1;
            else
                lvl=0;

        }


        con.close();
        return  new LoginStatus(correct, lvl);
    }



}
