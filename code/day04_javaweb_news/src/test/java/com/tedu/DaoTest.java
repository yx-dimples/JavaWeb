package com.tedu;

import com.news.dao.NewsDaoImpl;
import com.news.dao.NewsDao;
import org.junit.Test;

public class DaoTest {
    @Test
    public void getAllTopic() {
        NewsDao newsDao = new NewsDaoImpl();
        System.out.println(newsDao.getNewsByPageNo(1,5));

    }
}