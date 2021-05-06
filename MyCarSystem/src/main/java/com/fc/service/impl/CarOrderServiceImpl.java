package com.fc.service.impl;

import com.alibaba.fastjson.JSON;
import com.fc.entity.CarOrder;
import com.fc.mapper.CarOrderMapper;
import com.fc.service.CarOrderService;
import com.fc.utils.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author : Juice
 */

@Service
public class CarOrderServiceImpl implements CarOrderService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CarOrderMapper carOrderMapper;

    @Override
    public PageInfo<CarOrder> findAll(int page) {

        PageHelper.startPage(page, 5);

        List<CarOrder> list = carOrderMapper.findAll();

        PageInfo<CarOrder> pageInfo = new PageInfo<>(list);

        // 将订单信息存入redis中
        redisUtil.set("findAll/" + page, JSON.toJSONString(pageInfo));

        return pageInfo;
    }

    @Override
    public void delOrder(int id) {
        // 删除订单
        carOrderMapper.deleteByPrimaryKey(id);
        // 将所有订单信息从redis中删除
        redisUtil.delete("findAll");
    }

    @Override
    public int addCarOrder(CarOrder carOrder) {

        int affectRows = carOrderMapper.insertSelective(carOrder);
        // 将所有订单信息从redis中删除
        redisUtil.delete("findAll");

        return affectRows;
    }
}
