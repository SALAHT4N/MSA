package com.software.mas.model;



import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private final static String ip="jdbc:mysql://localhost:3306/mas", username ="root", password ="";
    private final static String req = "http://localhost:3000/serverside/upload_photo.jsp";
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(ip,username,password);
    }


}
