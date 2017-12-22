package com.spring.reflect.proxy;

import com.spring.reflect.entity.User;

public interface UserDAO {
    public void insert(User user);
    public void delete(Integer id);
    public void update(User user);
    public void selectById(Integer id);
    public void selectAll();
}
