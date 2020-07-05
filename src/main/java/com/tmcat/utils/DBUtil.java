package com.tmcat.utils;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author Tim
 * @Date 2020/7/3 13:46
 * @Version 1.0
 * 数据库的JDBC连接
 */
public class DBUtil {
    static String IP = "192.168.199.207";
    static int PORT = 3306;
    static String DATABASE = "tmall";
    static String ENCODING = "UTF-8";
    static String USERNAME = "root";
    static String PASSWORD = "123456";

    /*
        静态代码块Class.forName() 方法要求JVM查找并加载指定的类到内存中；
        将"com.mysql.jdbc.Driver" 当做参数传入，就是告诉JVM，去"com.mysql.jdbc"这个路径下找Driver类，将其加载到内存中
        于JVM加载类文件时会执行其中的静态代码块，从Driver类的源码中可以看到该静态代码块执行的操作是：
         将mysql的driver注册到系统的DriverManager中。
    */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            LogUtil.logprint("INFO","MYSQL驱动程序加载成功",DBUtil.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            LogUtil.logprint("ERROR","MYSQL驱动程序加载失败",DBUtil.class);
        }
    }
    /*获取数据库连接对象*/
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", IP, PORT, DATABASE, ENCODING);
            conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
            LogUtil.logprint("INFO","数据库连接成功"+conn,DBUtil.class);
        } catch (Exception e) {
            LogUtil.logprint("ERROR","数据库连接失败--"+e.getMessage(),DBUtil.class);
        }

        return conn;
    }
    /*关闭数据库连接*/
    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
                LogUtil.logprint("INFO","数据库关闭成功",DBUtil.class);
            } catch (SQLException throwables) {
                LogUtil.logprint("ERROR","数据库连接关闭失败"+throwables.getMessage(),DBUtil.class);
            }
        }
    }

    public static void main(String[] args) throws SQLException {


        System.out.println(getConnection());

        System.out.println("ddd");
        

    }
}
