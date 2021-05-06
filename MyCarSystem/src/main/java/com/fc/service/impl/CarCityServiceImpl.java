package com.fc.service.impl;

import com.alibaba.fastjson.JSON;
import com.fc.entity.CarCity;
import com.fc.entity.CarCityExample;
import com.fc.mapper.CarCityMapper;
import com.fc.service.CarCityService;
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
public class CarCityServiceImpl implements CarCityService {

    @Autowired
    private CarCityMapper carCityMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<CarCity> selectByPid(int pid) {
        CarCityExample carCityExample = new CarCityExample();
        CarCityExample.Criteria criteria = carCityExample.createCriteria();
        criteria.andPidEqualTo(pid);
        // 根据pid查询
        List<CarCity> carCities = carCityMapper.selectByExample(carCityExample);
        // 将查询出的结果存入redis中
        redisUtil.set("selectByPid/" + pid, JSON.toJSONString(carCities));
        return carCities;
    }

    @Override
    public CarCity getCityById(int id) {
        CarCity carCity = carCityMapper.selectByPrimaryKey(id);
        // 将查询结果存放到redis中
        redisUtil.set("getCityById/" + id, JSON.toJSONString(carCity));
        return carCity;
    }


}
