package org.s166.ums.dao;

import org.s166.ums.entity.User;

public interface UserDao {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 登录查询
     * @param name
     * @param pass
     * @return 登录账号
     */
    User queryByLogin(String name, String pass);

}
