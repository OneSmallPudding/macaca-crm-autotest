package com.javademo.utils;

import com.alibaba.fastjson.JSONObject;
import macaca.java.biz.BaseMacacaClient;

import java.sql.*;

public class DBUtils {
    public static Connection getConnection() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://"+Config.DATABASE_URL+"?useUnicode=true&characterEncoding=utf-8&useSSL=false",
                Config.DATABASE_NAME, Config.DATABASE_PWD);
        System.out.println("----->1. 进入 getConnection <----------");
        return con;
    }

    public static void close(Connection con) {
        try {
            if(con!=null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            if(ps!=null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            if(rs!=null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
