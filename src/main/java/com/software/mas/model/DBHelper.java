package com.software.mas.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static String ip="jdbc:mysql://localhost:3306/mas",
                   username ="root", password ="";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(ip,username,password);
    }

}
