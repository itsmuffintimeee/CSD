package com.fc.service.impl;

import com.alibaba.fastjson.JSON;
import com.fc.entity.CarUser;
import com.fc.entity.CarUserExample;
import com.fc.mapper.CarUserMapper;
import com.fc.service.CarUserService;
import com.fc.utils.RedisUtil;
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
public class CarUserServiceImpl implements CarUserService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CarUserMapper carUserMapper;


    @Override
    public PageInfo<CarUser> findAll(Integer page, Integer limit) {
        return null;
    }

    private String tel;


    /**
     * 用户执行登陆
     *
     * @param tel 电话号（账号）
     * @return
     */
    @Override
    public CarUser login(String tel) {
        CarUserExample example = new CarUserExample();
        CarUserExample.Criteria criteria = example.createCriteria();
        criteria.andTelEqualTo(tel);
        List<CarUser> list = carUserMapper.selectByExample(example);

        this.tel = tel;
        if (list.size() > 0) {
            // 将此登陆信息存入redis中
            redisUtil.set("login/" + tel, JSON.toJSONString(list.get(0)));
            return list.get(0);
        }
        return null;
    }

    @Override
    public int register(CarUser user) {

        int affectRows = carUserMapper.insert(user);
        return affectRows;
    }

    @Override
    public int update(CarUser carUser) {

        int affectRows = carUserMapper.updateByPrimaryKeySelective(carUser);


        System.out.println(tel);
        redisUtil.delete("login/" + tel);

        return affectRows;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public CarUser getUserById(Integer id) {
        return null;
    }
}
