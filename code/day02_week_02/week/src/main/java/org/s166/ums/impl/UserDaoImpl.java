package org.s166.ums.impl;

import org.s166.ums.dao.UserDao;
import org.s166.ums.entity.User;
import org.s166.ums.util.DBUtil;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    public int add(User user) {
        int r = 0 ;
        String sql = "INSERT INTO TBL_USER (NAME,PASS,SEX,AGE) VALUES (?,?,?,?) ;";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPass());
            pstmt.setString(3,user.getSex());
            pstmt.setInt(4,user.getAge());

            r = pstmt.executeUpdate();


        } catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            DBUtil.close(null,pstmt,conn);
        }

        return r;
    }

    public User queryByLogin(String name, String pass) {
        User user = null;

        String sql = "SELECT ID,NAME,PASS,SEX,AGE,REG_TIME FROM TBL_USER WHERE NAME=? AND PASS=?";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,name);
            pstmt.setString(2,pass);

            rst = pstmt.executeQuery();

            if(rst.next()){
                int id = rst.getInt(1);
                String sex = rst.getString(4);
                int age = rst.getInt(5);
                Date regTime = rst.getDate(6);

                user = new User();

                user.setId(id);
                user.setName(name);
                user.setPass(pass);
                user.setSex(sex);
                user.setAge(age);
                user.setRegTime(regTime);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            DBUtil.close(rst,pstmt,conn);
        }

        return user;

    }
}
