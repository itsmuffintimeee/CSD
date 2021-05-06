package com.fc.service.impl;

import com.alibaba.fastjson.JSON;
import com.fc.entity.CarCar;
import com.fc.mapper.CarCarMapper;
import com.fc.service.CarCarService;
import com.fc.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author : Juice
 */
@Service
public class CarCarServiceImpl implements CarCarService {

    @Autowired
    private CarCarMapper carCarMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<CarCar> findCarByCidOnSite(int cid) {
        // 查询车辆并根据座位数进行排序
        List<CarCar> carByCidOnSite = carCarMapper.getCarByCidOnSite(cid);
        // 将信息加入至redis中
        redisUtil.set("findCarByCidOnSite/" + cid, JSON.toJSONString(carByCidOnSite));
        return carByCidOnSite;
    }

    @Override
    public List<CarCar> findCarByCidOnPrice(int cid) {
        // 查询车辆并根据单价进行排序
        List<CarCar> carByCidOnPrice = carCarMapper.getCarByCidOnPrice(cid);
        // 将信息加入至redis中
        redisUtil.set("findCarByCidOnPrice/" + cid, JSON.toJSONString(carByCidOnPrice));
        return carByCidOnPrice;
    }

    @Override
    public CarCar findCarById(int id) {
        // 根据主键查询车辆
        CarCar carCar = carCarMapper.selectByPrimaryKey(id);
        // 将车辆信息加入至redis中
        redisUtil.set("findCarById/" + id, JSON.toJSONString(carCar));

        return carCar;
    }
}
