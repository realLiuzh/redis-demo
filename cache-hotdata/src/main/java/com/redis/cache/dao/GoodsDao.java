package com.redis.cache.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.redis.cache.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {
    void add();
}
