package com.redis.cache.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("goods")
public class GoodsEntity {
    @TableId(type = IdType.AUTO)
    private int id;
    private String goods_name;
    private int brand_id;
    private int cate_id;
    private int price;
    private int original;
    private String tags;
    private String content;
    private String summary;
    private int is_sale;
    private Date created_at;
    private Date updated_at;
}
