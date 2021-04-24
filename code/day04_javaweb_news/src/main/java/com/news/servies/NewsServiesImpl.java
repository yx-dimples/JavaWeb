package com.news.servies;

import com.news.dao.NewsDao;
import com.news.dao.NewsDaoImpl;
import com.news.pojo.News;
import com.news.pojo.NewsTopic;

import java.util.List;

/**
 * 新闻服务层接口实现类
 */
public class NewsServiesImpl implements NewsServies {
    //调用dao
    NewsDao dao = new NewsDaoImpl();

    @Override
    public List<NewsTopic> getAllTopic() {
        return dao.getAllTopic();
    }

    @Override
    public List<News> getNewsByPageNo(int no, int size) {
        return dao.getNewsByPageNo(no,size);
    }

    @Override
    public int addNews(News news) {
        return dao.addNews(news);
    }

    @Override
    public int getAllCount() {
        return dao.getAllCount();
    }

    @Override
    public int getCountByTid(int newtid) {
        return dao.getCountByTid(newtid);
    }

    @Override
    public List<News> getNewsByPageNo(int tid, int no, int size) {
        return dao.getNewsByPageNo(tid,no,size);
    }

    @Override
    public News getNewsById(int id) {
        List<News> newById = dao.getNewsById(id);
        if(newById.size()>0){
            return newById.get(0);
        }
        return null;
    }


}