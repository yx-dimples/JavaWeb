package com.news.servies;

import com.news.pojo.News;
import com.news.pojo.NewsTopic;

import java.util.List;

/**
 * 服务层接口
 */
public interface NewsServies {
    /**
     * 获取全部的新闻主题
     * @return   新闻主题 实体类对象
     */
    public List<NewsTopic> getAllTopic();

    /**
     * 分页获取新闻信息
     * @param no
     * @param size
     * @return
     */
    public List<News> getNewsByPageNo(int no, int size);

    /**
     * 分页获取新闻信息
     * @param no
     * @param size
     * @return
     */
    public List<News> getNewsByPageNo(int tid,int no, int size);

    /**
     * 添加一条新闻
     * @param news
     * @return
     */
    public int addNews(News news);

    /**
     * 查询总页数
     * @return
     */
    int getAllCount();

    /**
     *
     * @return
     */
    int getCountByTid(int newtid);

    News getNewsById(int id);
}
