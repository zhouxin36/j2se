package com.spring.reflect.proxy;

import com.spring.reflect.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAOImpl implements UserDAO{
    private final static Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
    @Override
    public void insert(User user) {
        logger.info("------------------->插入方法"+user);
    }

    @Override
    public void delete(Integer id) {
        logger.info("------------------->删除方法"+id);
    }

    @Override
    public void update(User user) {
        logger.info("------------------->修改方法"+user);
    }

    @Override
    public void selectById(Integer id) {
        logger.info("------------------->查询方法"+id);
    }

    @Override
    public void selectAll() {
        logger.info("------------------->查询所有");
    }
}
