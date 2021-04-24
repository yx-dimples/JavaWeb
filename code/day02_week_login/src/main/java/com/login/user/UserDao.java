package com.login.user;

import com.login.jdbc.JDBC;

import java.sql.*;

public class UserDao {
    public User queryByParams(User user) throws Exception{
        // 加载驱动 第一次记载jdbc类，执行静态构造代码块
        // 获取连接
        Connection conn = JDBC.getConn();
        // 获取执行器
        Statement getStatement = JDBC.getStatement(conn);
        String sql = "SELECT * FROM t_user WHERE "
                + "username='" + user.getUsername() + "' AND "
                + "password='" + user.getPassword() +"'";
        //执行sql;
        ResultSet result = JDBC.getResult(sql, getStatement);
        User X = null;
        while(result.next()) //读取下一个地址
        {
            X = new User(
            result.getString("username"),
                    result.getString("password"));
            //封装为一个实体类的对象
        }
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql.toString());
        if(rs.next()) {
            return X;
        }
        else{
            return null;
        }
    }

    public void addUser(String username, String password) throws SQLException {
        // 加载驱动 第一次记载jdbc类，执行静态构造代码块
        // 获取连接
        Connection conn = JDBC.getConn();
        // 获取执行器
        Statement getStatement =JDBC.getStatement(conn);
        String sql = "INSERT INTO t_user (username,password) VALUES ('"+username+"','"+password+"')";
        int result1 = JDBC.exeUpdate(sql, getStatement);
        if(result1 >0){
            System.out.println("操作成功！");
        }else{
            System.out.println("操作失败！");
        }
        JDBC.close(null, getStatement, null, conn);
    }
}
