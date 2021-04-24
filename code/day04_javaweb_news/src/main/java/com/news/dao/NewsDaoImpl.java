package com.news.dao;

import com.news.jdbc.JDBC;
import com.news.pojo.News;
import com.news.pojo.NewsTopic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 新闻  dao  接口实现类s
 */
public class NewsDaoImpl extends BaseDao implements NewsDao{
    @Override
    public List<NewsTopic> getAllTopic() {
        String sql = "SELECT * FROM topic";
//        ResultSet query = query(sql);
//        List<NewsTopic> data = new ArrayList<>();
//        try {
//            while (query.next()){
//                // 对结果集进行解析   解析区别：字段名不一样 ----字段名====属性
//                NewsTopic newsTopic = new NewsTopic();
//                newsTopic.setTid(query.getInt("tid"));
//                newsTopic.setTname(query.getString("tname"));
//                data.add(newsTopic);
//            }
//        }catch (Exception e) {
//
//        }
        return select(NewsTopic.class,sql);
    }
    public List<News> getNewsByPageNo(){
        return getNewsByPageNo(0,Short.MAX_VALUE);
    }

    @Override
    public List<News> getNewsByPageNo(int no, int size) {
        List<News> news = new ArrayList<>();
        String sql = "SELECT * FROM news ORDER BY ncreateDate LIMIT ? , ? ";

        try (Connection c = JDBC.getConn(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, no);
            ps.setInt(2, size);

            // 获取结果集...
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return select(News.class,sql,(no-1)*size,size);
    }

    @Override
    public int addNews(News news) {
        String sql = "INSERT INTO `news`(字段名) VALUES (?,?,?,?) ";

        return  updata(sql,news.getNauthor(),news.getNcontent());
    }

    @Override
    public int getAllCount() {
        String sql = "SELECT COUNT(*) FROM news";
        return selectToTnt(sql);
    }

    @Override
    public int getCountByTid(int newtid) {
        String sql = "SELECT COUNT(*) FROM news where ntid = ?";
        return selectToTnt(sql);
    }

    @Override
    public List<News> getNewsByPageNo(int tid, int no, int size) {
        String sql = "SELECT * FROM news where ntid = ? ORDER BY ncreateDate LIMIT ? , ? ";
        return select(News.class,sql,tid,no,size);
    }

    @Override
    public List<News> getNewsById(int id) {
        String sql = "SELECT * FROM news where nid = ?";
        return select(News.class,sql,id);
    }

}
