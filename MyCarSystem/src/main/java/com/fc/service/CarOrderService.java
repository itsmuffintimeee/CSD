package com.fc.service;

import com.fc.entity.CarOrder;
import com.github.pagehelper.PageInfo;

/**
 * Description:订单相关服务
 *
 * @author : Juice
 */
public interface CarOrderService {
    /**
     * 根据页数查询数据
     *
     * @param page
     * @return
     */
    PageInfo<CarOrder> findAll(int page);

    /**
     * 根据id删除订单
     *
     * @param id
     */
    void delOrder(int id);

    /**
     * 新增一条订单信息
     *
     * @param carOrder 订单信息实体
     * @return
     */
    int addCarOrder(CarOrder carOrder);

}
