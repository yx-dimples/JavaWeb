package com.news.dao;

import com.news.jdbc.JDBC;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * dao 父类
 * 抽象了对jdbc的基本操作
 */
public class BaseDao {
    /**
     * 使用PreparedStatement 进行对数据库  增删改
     * @param sql  带？ 参数站位符
     * @param pam  参数列表与？  一一对应
     * @return
     */
    public int updata(String sql,Object... pam){
        //获取连接
        int count = 0;
        try {
            Connection conn = JDBC.getConn();
            //获取执行器 dui sql 进行预编译
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //添加参数
            for (int i = 0;i<pam.length; i++){
                Object p = pam[i];
                preparedStatement.setObject(1+i,p);
            }
            //执行sql 更新
            count = preparedStatement.executeUpdate();
            //释放
            JDBC.close(null,null,preparedStatement,conn);

        }catch (Exception e) {
            e.printStackTrace();
            return count;
        }
        //返回
        return count;
    }

    /**
     * 使用PreparedStatement 进行对数据库 查询操作
     * @param sql
     * @param pam
     * @return
     */
    public ResultSet query(String sql,Object... pam){
        //获取连接
        ResultSet res = null;
        try {
            Connection conn = JDBC.getConn();
            //获取执行器 dui sql 进行预编译
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //添加参数
            for (int i = 0;i<pam.length; i++){
                Object p = pam[i];
                preparedStatement.setObject(1+i,p);
            }
            //执行sql 更新
            res = preparedStatement.executeQuery();

            //conn 对象   有GC释放

        }catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    // java 的反射机制 尝试看看什么是java的反射机制 封装 查询操作
    // 反射  我们使用Java的反射机制  创建一个对象，使用相关方法

    public <T extends List< ? >> T select(Class<?> cls,String sql,Object... pam){
        //获取连接
        List<Object> data = new ArrayList<>();
        try {
            Connection conn = JDBC.getConn();
            // 对sql进行预编译
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //List<NewsTopic> data = new ArrayList<>();
            //设置参数
            for (int i = 0;i<pam.length; i++){
                Object p = pam[i];
                preparedStatement.setObject(1+i,p);
            }
            //执行sql
            ResultSet query = preparedStatement.executeQuery();
            //使用Java的反射机制
            //通过反射创建一个实体类对象
            while (query.next()){
                // 对结果集进行解析   解析区别：字段名不一样 ----字段名====属性
//                NewsTopic newsTopic = new NewsTopic();
//                newsTopic.setTid(query.getInt("tid"));
//                newsTopic.setTname(query.getString("tname"));
//                data.add(newsTopic);

                //使用反射创建对象
                Object o = cls.newInstance();
                // 获取全部的属性
                Field[] declaredFields = cls.getDeclaredFields();
                //遍历
                for(Field f:declaredFields){
                    String name = f.getName(); // 属性名称
                    //设置该属性可以被访问
                    f.setAccessible(true);
                    //通过属性名称去query 取值
                    Object object = query.getObject(name);
                    //设置属性的值
                    f.set(o,object);
                }
                data.add(o);
            }
            //关闭释放资源
            JDBC.close(query,null,preparedStatement,conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) data;
    }

    /**
     * 使用聚合函数查询  返回int
     * @param sql
     * @param obj
     * @return
     */
    public int selectToTnt(String sql,Object... obj){
        //获取连接
        int res = 0;
        try {
            Connection conn = JDBC.getConn();
            // 对sql进行预编译
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //List<NewsTopic> data = new ArrayList<>();
            //设置参数
            for (int i = 0;i<obj.length; i++){
                Object p = obj[i];
                preparedStatement.setObject(1+i,p);
            }
            //执行sql
            ResultSet query = preparedStatement.executeQuery();
            while (query.next()){
                res = query.getInt(1);
            }
            //关闭释放资源
            JDBC.close(query,null,preparedStatement,conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
