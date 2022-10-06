package com.redis.cache.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.redis.cache.entity.GoodsEntity;

import java.util.List;

public interface GoodsService extends IService<GoodsEntity> {

    List<GoodsEntity> listPage();

    void updateId() throws InterruptedException;

    GoodsEntity get();
}
