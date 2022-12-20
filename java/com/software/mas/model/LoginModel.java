package com.software.mas.model;

import com.software.mas.model.templates.LoginStatus;

import java.sql.*;

public class LoginModel {



    public LoginStatus authenticate(String email, String password) throws SQLException {
        //Default values:
        int lvl = -1;
        boolean correct = false;
        ResultSet rs = null ;
        try( Connection  con = DBHelper.connect();
             PreparedStatement preparedStmt = con.prepareStatement("SELECT " +
                     "  email FROM customers WHERE email=? and password_customer=?");
             PreparedStatement preparedStmt2 = con.prepareStatement("SELECT email " +
                     "FROM customers inner join providers " +
                     "WHERE email=?");)
        {


            preparedStmt.setString(1, email);
            preparedStmt.setString(2, password);
            rs = preparedStmt.executeQuery();

            if (rs.next()) {

                correct = true;

                //AUTHORIZATION PROCESS


                preparedStmt2.setString(1, email);
                rs = preparedStmt2.executeQuery();

                if (rs.next())
                    lvl = 1;
                else
                    lvl = 0;


            }


        }
        catch(Exception e ){
            e.printStackTrace();
        }
        finally{
            if(rs!= null )
                rs.close();

        }
        return  new LoginStatus(correct, lvl);
    }



}
