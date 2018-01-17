package com.springcloud.shardingjdbc;

import com.springcloud.shardingjdbc.bean.TOrder;
import com.springcloud.shardingjdbc.bean.TOrderItem;
import com.springcloud.shardingjdbc.dao.TOrderItemMapper;
import com.springcloud.shardingjdbc.dao.TOrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.IdGenerator;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingjdbcApplicationTests {
	private final static Logger logger = LoggerFactory.getLogger(ShardingjdbcApplicationTests.class);

	@Autowired
    IdGenerator idGenerator;

	@Autowired
	TOrderMapper tOrderMapper;

	@Autowired
	TOrderItemMapper tOrderItemMapper;

	@Test
	public void contextLoads() {
        for (int i = 0; i < 100; i++) {
            TOrder order = new TOrder();
            order.setUserId(idGenerator.generateId().toString());
            order.setOrderId(idGenerator.generateId().toString());
            logger.info("插入order:"+order);
            tOrderMapper.insert(order);
        }
        logger.info("--------------------------------------------------------------------------------------------");
        for (int i = 0; i < 100; i++) {
            TOrderItem tOrderItem = new TOrderItem();
            tOrderItem.setUserId(idGenerator.generateId().toString());
            tOrderItem.setOrderId(idGenerator.generateId().toString());
            tOrderItem.setItemId(idGenerator.generateId().toString());
            logger.info("插入tOrderItem:"+tOrderItem);
            tOrderItemMapper.insert(tOrderItem);
        }
	}

}
