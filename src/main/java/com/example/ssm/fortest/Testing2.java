package com.example.ssm.fortest;

import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Testing2 {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##scott", "tiger");
        System.out.println(conn);
    }
}