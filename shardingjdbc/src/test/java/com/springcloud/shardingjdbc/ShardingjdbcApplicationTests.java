package com.springcloud.shardingjdbc;

import com.springcloud.shardingjdbc.bean.TOrder;
import com.springcloud.shardingjdbc.bean.TOrderItem;
import com.springcloud.shardingjdbc.bean.TOrderItemExample;
import com.springcloud.shardingjdbc.dao.TOrderItemMapper;
import com.springcloud.shardingjdbc.dao.TOrderMapper;
import com.springcloud.shardingjdbc.dto.SQLDataSourceDTO;
import com.springcloud.shardingjdbc.utils.MD5Util;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.IdGenerator;

import java.util.List;


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
        for (int i = 0; i < 1; i++) {
            TOrder order = new TOrder();
            order.setUserId(idGenerator.generateId().toString());
            order.setOrderId(idGenerator.generateId().toString());
            logger.info("插入order:"+order);
            tOrderMapper.insert(order);
        }
        logger.info("--------------------------------------------------------------------------------------------");
        for (int i = 0; i < 1; i++) {
            TOrderItem tOrderItem = new TOrderItem();
            tOrderItem.setUserId(idGenerator.generateId().toString());
            tOrderItem.setOrderId(idGenerator.generateId().toString());
            tOrderItem.setItemId(idGenerator.generateId().toString());
            logger.info("插入tOrderItem:"+tOrderItem);
            tOrderItemMapper.insert(tOrderItem);
        }
	}

	@Test
	public void test2(){
        TOrderItemExample tOrderItemExample = new TOrderItemExample();
        TOrderItemExample.Criteria criteria = tOrderItemExample.createCriteria();
        criteria.andUserIdEqualTo("6cebbb61-8228-34d9-ea32-5303aa7d93e3");
        List<TOrderItem> tOrderItems = tOrderItemMapper.selectByExample(tOrderItemExample);
        logger.info(tOrderItems.toString()+"----------");
    }

    @Autowired
    private SQLDataSourceDTO sqlDataSourceDTO;

	@Test
	public void test1(){
	    logger.info("-------->"+sqlDataSourceDTO);
    }

    @Test
    public void test3(){
	    logger.info("------->"+ MD5Util.MD5("周鑫"));
    }

}
