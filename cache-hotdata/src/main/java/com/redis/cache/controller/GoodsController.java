package com.redis.cache.controller;

import com.redis.cache.entity.GoodsEntity;
import com.redis.cache.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public List<GoodsEntity> list() {
        return goodsService.listPage();
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Integer id) throws InterruptedException {
        goodsService.updateId();
        return "success";
    }

    @GetMapping("/get")
    public GoodsEntity get() {
        return goodsService.get();
    }
}
