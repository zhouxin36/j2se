package com.springcloud.shardingjdbc.config.algorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShardingTableRule {

    @Value("${datasource_num}")
    private int DATASOURCE_NUM;

    @Value("${table_num}")
    private int TABLE_NUM;

    @Value("${key_length}")
    private int KEY_LENGTH;

    /**
     *获取UserID所在的分表
     * 策略：截取后4位（转十进制） % 表个数  作为分表的后缀
     * @param userId 用户ID
     * @return
     */
    public int getTableId(String userId) {
        String str = userId.replaceAll("-","");
        String keyStr = str.substring(str.length()-KEY_LENGTH);
        return Integer.parseInt(keyStr,16) % TABLE_NUM;
    }

    public int getDataId(String userId) {
        String str = userId.replaceAll("-","");
        String keyStr = str.substring(0,KEY_LENGTH);
        return Integer.parseInt(keyStr,16) % DATASOURCE_NUM;
    }
}
