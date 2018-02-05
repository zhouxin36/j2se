package com.j2se.transactionannotation.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class BookServiceBean {
    private String name;
    private Date from;

    public BookServiceBean(String name, Date from) {
        this.name = name;
        this.from = from;
        log.info("this is bookservicebean 的构造方法");
    }

    @Override
    public String toString() {
        return "BookServiceBean{" +
                "name='" + name + '\'' +
                ", from=" + from +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    private Logger log = LoggerFactory.getLogger(BookServiceBean.class);
    public BookServiceBean() {
        log.info("this is bookservicebean 的构造方法");
    }
    public void create() {
        System.out.println("create() is running!");
    }
    public void query() {
        System.out.println("query() is running!");
    }
}
