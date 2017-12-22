package com.spring.reflect.proxy;

import com.spring.reflect.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAOProxy implements UserDAO{
    private final static Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
    private UserDAO userDAO;

    public UserDAOProxy(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void log(String methodName){
        logger.info("-------------->进行日志记录："+methodName);
    }

    @Override
    public void insert(User user) {
        this.log("insert()");
        this.userDAO.insert(user);
    }

    @Override
    public void delete(Integer id) {
        this.log("delete()");
        this.userDAO.delete(id);
    }

    @Override
    public void update(User user) {
        this.log("update()");
        this.userDAO.update(user);
    }

    @Override
    public void selectById(Integer id) {
        this.log("selectById()");
        this.userDAO.selectById(id);
    }

    @Override
    public void selectAll() {
        this.log("selectAll()");
        this.userDAO.selectAll();
    }
}
