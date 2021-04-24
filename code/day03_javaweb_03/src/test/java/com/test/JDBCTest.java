package com.test;

import com.mysql.jdbc.Statement;
import com.tedu.cn.JDBC;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * 对jdbc进行单元测试， 类名 一定不能是Test
 */
public class JDBCTest {
    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;
    // 添加一个用户
    /**
     * jdbc 入门案例练习
     * 单元测试方法：public void 方法必须不能哟参数
     * 查询数据
     */
    @Test
    public void fistJdbc() throws SQLException {

        // 加载驱动 第一次记载jdbc类，执行静态构造代码块
        // 获取连接
         conn = JDBC.getConn();
        // 获取执行器
        stat = (Statement) JDBC.getStatement(conn);
        //执行sql
        String sql = "SELECT * FROM news_users";
        rs = JDBC.getResult(sql, stat);
        // 解析结果集
        while(rs.next()) //读取下一个地址
        {
            int uid = rs.getInt("uid");
            String uname = rs.getString("uname");
            String upwd = rs.getString("upwd");
            // 在解析结果集，必须保证字段的uname一样，注意字段属性
            System.out.println(uid+uid+uname+upwd);
            //封装为一个实体类的对象
        }
        //  释放资源
        JDBC.close(rs,stat,null,conn);
    }

    /**
     *请输出新闻主题
     * @throws SQLException
     */
    @Test
    public void secondJdbc() throws SQLException {

        // 加载驱动 第一次记载jdbc类，执行静态构造代码块
        // 获取连接
        Connection conn = JDBC.getConn();
        // 获取执行器
        Statement  getStatement = (Statement) JDBC.getStatement(conn);
        String sql1 = "SELECT * FROM topic";
        ResultSet result1 = JDBC.getResult(sql1, getStatement);
        while (result1.next()){
            int tid = result1.getInt("tid");
            String tname = result1.getString("tname");
            System.out.println(tid+tname);
        }
        //  释放资源
        JDBC.close(result1,getStatement,null,conn);
    }


    @Test
    public void addnews() throws  SQLException{
        //获取连接
        Connection conn = JDBC.getConn();
        // 获取执行器
        Statement getstatement = (Statement) JDBC.getStatement(conn);
        //执行sql
        String sql = "INSERT INTO news(ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nmodifyDate,nsummary) "
                + "VALUES(1,'灾害时发生时如何联系家人','小刘','2021-4-21','1111','不要忽略自己危险情况','2021-4-21','不要忽略自己危险情况')";
        //解析结果集
        int result = JDBC.exeUpdate(sql, getstatement);
        //释放资源
        JDBC.close(null, getstatement, null, conn);
    }
    /**
     * 添加一个用户
     * @throws SQLException
     */
    @Test
    public void add() throws SQLException {
        Connection conn = JDBC.getConn();
        // 获取执行器
        Statement  getStatement = (Statement) JDBC.getStatement(conn);
        //执行sql
        String sql = "INSERT INTO news(ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nmodifyDate,nsummary) "
                + "VALUES(1,'灾害时发生时如何联系家人','小刘','2021-4-21','1111','不要忽略自己危险情况','2021-4-21','不要忽略自己危险情况')";
        ResultSet result = JDBC.getResult(sql, getStatement);
        // 解析结果集
        //  释放资源
        JDBC.close(result,getStatement,null,conn);
    }
    /**
     *删除
     */
    @Test
    public void del(){
        try {
             conn = JDBC.getConn();
             stat = (Statement) conn.createStatement();
            int count = stat.executeUpdate("delete from news where nid = 48");
            if(count>0){
                System.out.println("操作成功，受到影响的行数为："+count);
            }else{
                System.out.println("操作失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBC.close(rs,stat,null,conn);
        }
    }
    /**
     * 更新数据
     */
    @Test
    public void update () {
        try{
            conn = JDBC.getConn();
            stat = (Statement) conn.createStatement();
            int count = stat.executeUpdate("update news set ntitle = 'ldss' where nid = 49");
            if(count > 0){
                System.out.println("操作成功，受到影响的行数为："+count);
                System.out.println("操作成功，受到影响的行数为："+count);
            }else{
                System.out.println("操作失败");
            }
        }catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBC.close(rs,stat,null,conn);
        }
    }

    public class Informatica{
        private int nid;
        private int ntid;
        private String ntitle;
        private String nauthor;
        private Timestamp ncreateDate;
        private String npicPath;
        private String ncontent;
        private Timestamp nmodifyDate;
        private String nsummary;
        public Informatica(){

        }

        public Informatica(int nid, int ntid, String ntitle, String nauthor, Timestamp ncreateDate, String npicPath, String ncontent,
                           Timestamp nmodifyDate, String nsummary) {
            this.nid = nid;
            this.ntid = ntid;
            this.ntitle = ntitle;
            this.nauthor = nauthor;
            this.ncreateDate = ncreateDate;
            this.npicPath = npicPath;
            this.ncontent = ncontent;
            this.nmodifyDate = nmodifyDate;
            this.nsummary = nsummary;
        }
    }

    /**
     * 输出news全部信息
     */
    @Test
    public void info(){
        try{
            conn = JDBC.getConn();
            stat = (Statement) conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from news");
            Informatica informatica = null;
            while(rs.next()){
                informatica = new Informatica(
                    rs.getInt("nid"),
                    rs.getInt("ntid"),
                    rs.getString("ntitle"),
                   rs.getString("nauthor"),
                    rs.getTimestamp("ncreateDate"),
                    rs.getString("npicPath"),
                   rs.getString("ncontent"),
                   rs.getTimestamp("nmodifyDate"),
                    rs.getString("nsummary")
                );
                System.out.println(informatica.nid+informatica.ntid+informatica.ntitle+informatica.nauthor+informatica.ncreateDate+informatica.npicPath+informatica
                        .ncontent+informatica.nmodifyDate+informatica.nsummary
                );
            }
        }catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBC.close(rs,stat,null,conn);
        }
    }

    /**
     * 获得新闻列表结果
     * @throws SQLException
     */
    @Test
    public void comments() throws SQLException {
        conn = JDBC.getConn();
        stat = (Statement) JDBC.getStatement(conn);
        String sql = "SELECT * FROM news as n INNER JOIN comments as c ON n.nid=c.cnid WHERE n.nid = 170";
        rs = JDBC.getResult(sql, stat);
        News news = null;
        Comments comments = new Comments();
        while(rs.next()) //读取下一个地址
        {
            news = new News(
                    comments,
                    rs.getInt("nid"),
                    rs.getInt("ntid"),
                    rs.getString("ntitle"),
                    rs.getString("nauthor"),
                    rs.getTimestamp("ncreateDate"),
                    rs.getString("ncontent"),
                    rs.getString("nsummary"),
                    rs.getTimestamp("nmodifyDate"),
                    rs.getString("npicPath")
            );
            System.out.println(news.nid + news.ntid + news.ntitle+ news.ncreateDate + news.nauthor + news.nsummary + news.nmodifyDate + news.npicPath);
        }
    }
}