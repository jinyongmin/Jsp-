package com.koreait.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconn {
    private static Connection conn;  //객체를 만들지 않아도 메모리에 올라감

    public  static  Connection getConnection() throws SQLException, ClassNotFoundException{
        String url = "jdbc:mysql://127.0.0.1/aidev?useSSL=false";
        String uid ="root";
        String upw ="1234";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, uid, upw);
        return  conn;
    }

            //싱글톤 패턴

    }

