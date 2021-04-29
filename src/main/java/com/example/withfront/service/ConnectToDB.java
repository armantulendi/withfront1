package com.example.withfront.service;

import com.example.withfront.config.Variables;
import com.example.withfront.model.Subscriber;
import com.example.withfront.model.TablesForTest;
import com.example.withfront.model.User;
import lombok.SneakyThrows;
import org.hibernate.annotations.Tables;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;

@Service
public class ConnectToDB{

    String connectionUrl="jdbc:mysql://192.168.17.83:3306/kamailio";
//    String connectionUrl="jdbc:mysql://192.168.17.83:3306/kamailio";
    String username=Variables.getDatabaseUser();
    String password=Variables.getDatabasePass();
    Connection con;Statement stmt;
    ConnectToDB(){

    }
    public static void main(String[] args) {
        ConnectToDB c=new ConnectToDB();
        System.out.println(c.getCountMissedCalls());;
    }
    public  long getCountMissedCalls() {
        long i=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    connectionUrl, username,password );

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select count(distinct from_tag) " +
                            "from missed_calls " +
                            "where time >timestamp (current_date)");
            while (rs.next())
                i=rs.getLong(1);
            con.close();
        } catch (Exception e) {
            i= 0;
        }
        return i;
    }
    public String getAverageTimeOfDiscuss() {
        String i ="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    connectionUrl, username,password);

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select avg(duration) from acc_cdrs " +
                            "where start_time> timestamp (current_date) " +
                            "and not duration = 0");
            while (rs.next())
                i=rs.getString(1);
            con.close();
        } catch (Exception e) {
            i= "null";
        }
        return i;
    }

    public  String countInTheOneDay() {
        String i ="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    connectionUrl, username,password);

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select count(distinct id) " +
                            "from acc_cdrs " +
                            "where start_time >timestamp(current_date) ");

            while (rs.next())
                i = rs.getString(1);

            con.close();
        } catch (Exception e) {
            i= "null";
        }
        return i;
    }


}