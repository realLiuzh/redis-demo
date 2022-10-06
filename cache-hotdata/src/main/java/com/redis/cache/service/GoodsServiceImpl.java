package com.redis.cache.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.redis.cache.dao.GoodsDao;
import com.redis.cache.entity.GoodsEntity;
import com.redis.cache.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public List<GoodsEntity> listPage() {
        List<GoodsEntity> list = new ArrayList<>();
        Random random = new Random();
        Gson gson = new Gson();
        for(int i=0;i<20;i++){
            int index = random.nextInt(6000);
            Object o = stringRedisTemplate.opsForValue().get(index + "");

            if(o!=null){
                GoodsEntity goodsEntity = gson.fromJson((String) o, GoodsEntity.class);
                list.add(goodsEntity);
            }else{
                GoodsEntity goodsEntity = baseMapper.selectById(index);
                stringRedisTemplate.opsForValue().set(index+"",gson.toJson(goodsEntity));
                list.add(goodsEntity);
            }
        }
        return list;
    }

    @Override
    public void updateId() throws InterruptedException {
        int id=5940;
        String json = stringRedisTemplate.opsForValue().get(id + "");
        if(json!=null){
            stringRedisTemplate.delete(id+"");
        }

        Thread.sleep(10000);
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setSummary(" ");
        goodsEntity.setContent("  ");
        goodsEntity.setTags(" ");
        goodsEntity.setGoods_name(" ");
        goodsEntity.setId(id);
        baseMapper.updateById(goodsEntity);
        Thread.sleep(2000);
        stringRedisTemplate.delete(id+"");
    }

    @Override
    public GoodsEntity get() {
        int id=5940;
        String o = stringRedisTemplate.opsForValue().get(id + "");
        Gson gson = new Gson();
        if(o!=null){
            GoodsEntity goodsEntity = gson.fromJson(o, GoodsEntity.class);
            return goodsEntity;
        }else{
            GoodsEntity goodsEntity = baseMapper.selectById(id);
            stringRedisTemplate.opsForValue().set(id+"",gson.toJson(goodsEntity));
            return goodsEntity;
        }
    }
}
