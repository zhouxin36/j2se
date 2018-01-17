package com.springcloud.shardingjdbc.config.algorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.springcloud.shardingjdbc.exception.AppBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashSet;
@Component
public class SimpleDatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<String> {
    private final static Logger logger = LoggerFactory.getLogger(SimpleTableShardingAlgorithm.class);

    @Autowired
    ShardingTableRule shardingTableRule;

    @Override
    public String doEqualSharding(Collection<String> availableTargetNames, ShardingValue<String> shardingValue) {
        for (String each : availableTargetNames) {
            if (each.endsWith(shardingTableRule.getDataId(shardingValue.getValue())+"")) {
                logger.info("数据库查找定位于库："+each);
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> availableTargetNames, ShardingValue<String> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        for (String value : shardingValue.getValues()) {
            for (String tableName : availableTargetNames) {
                if (tableName.endsWith(shardingTableRule.getDataId(value)+"")) {
                    logger.info("数据库查找定位于表："+tableName);
                    result.add(tableName);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> availableTargetNames, ShardingValue<String> shardingValue) {
        throw new AppBusinessException("不支持id范围查找");
    }
}
