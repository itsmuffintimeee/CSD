package com.fc.service;

import com.fc.entity.CarCity;

import java.util.List;

/**
 * Description:
 *
 * @author : Juice
 */
public interface CarCityService {
    /**
     * 根据省id查询市区
     *
     * @param pid
     * @return
     */
    List<CarCity> selectByPid(int pid);

    /**
     * 查询小城市
     *
     * @return
     */
    CarCity getCityById(int id);
}
