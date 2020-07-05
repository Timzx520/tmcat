package com.tmcat.dao;

import com.tmcat.bean.User;
import com.tmcat.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author Tim
 * @Date 2020/7/3 17:34
 * @Version 1.0
 * DAO用数据库进行交互操作
 *  1.加载数据库驱动
 *  2.建立数据库连接
 *  3.执行相应的SQL语句
 *  4.获取结果集
 *  5.关闭数据库连接
 */
public class UserDao {

    /*
       用户添加、注册
       数据库连接对象常用方法
       createStatement()	创建向数据库发送sql的statement对象。
       prepareStatement(sql)	创建向数据库发送预编译sql的PrepareSatement对象。
       prepareCall(sql)	创建执行存储过程的callableStatement对象。
       setAutoCommit(boolean autoCommit)	设置事务是否自动提交。
       commit()	在链接上提交事务。
       rollback()	在此链接上回滚事务。
    */

    public int adduser(User user){
        String sql = "insert into user values(null,?,?)";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.executeUpdate();

            //获取结果
            ResultSet resultSet = ps.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;

    }
}
