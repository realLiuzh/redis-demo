package com.redis.cache;

import com.redis.cache.entity.GoodsEntity;
import com.redis.cache.service.GoodsService;
import com.redis.cache.service.GoodsServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Random;

@SpringBootTest
class CacheHotdataApplicationTests {
    @Autowired
    private GoodsService goodsService;

    @Test
    void contextLoads() {
        for(int i=0;i<6000;i++){
            insert();
        }
    }

    private void insert() {
        goodsService.save(random());
    }

    private GoodsEntity random() {
        Random random = new Random();
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoods_name(RandomStringUtils.random(40));
        goodsEntity.setBrand_id(random.nextInt(1000));
        goodsEntity.setCate_id(random.nextInt(2000));
        goodsEntity.setContent(RandomStringUtils.random(200));
        goodsEntity.setCreated_at(new Date());
        goodsEntity.setIs_sale(1);
        goodsEntity.setPrice(random.nextInt(100000));
        goodsEntity.setOriginal(2);
        goodsEntity.setSummary(RandomStringUtils.random(200));
        goodsEntity.setTags(RandomStringUtils.random(200));
        goodsEntity.setUpdated_at(new Date());
        return goodsEntity;
    }

}
