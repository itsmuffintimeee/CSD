package com.fc.service;

import com.fc.entity.CarCar;

import java.util.List;

/**
 * Description:
 *
 * @author : Juice
 */
public interface CarCarService {

    /**
     * 根据城市id查询车辆，并按座位数进行降序排序
     *
     * @param cid
     * @return
     */
    List<CarCar> findCarByCidOnSite(int cid);


    /**
     * 根据城市id查询车辆，并按单价进行降序排序
     *
     * @param cid
     * @return
     */
    List<CarCar> findCarByCidOnPrice(int cid);

    /**
     * 根据cid查找车辆信息
     *
     * @param cid cid
     * @return
     */
    CarCar findCarById(int id);

}
