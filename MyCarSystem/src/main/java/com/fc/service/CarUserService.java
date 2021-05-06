package com.fc.service;

import com.fc.entity.CarUser;
import com.github.pagehelper.PageInfo;

/**
 * Description: 用户相关服务
 *
 * @author : Juice
 */
public interface CarUserService {
    /**
     * 分页查询
     *
     * @param page
     * @param limit
     * @return
     */
    PageInfo<CarUser> findAll(Integer page, Integer limit);

    /**
     * 执行登陆方法（查）
     *
     * @param tel
     * @return
     */
    CarUser login(String tel);

    /**
     * 注册用户（增）
     *
     * @param user 存储用户信息的实体类
     * @return
     */
    int register(CarUser user);

    /**
     * 跟新用户信息（改）
     *
     * @param carUser 存储用户信息的实体类
     * @return
     */
    int update(CarUser carUser);

    /**
     * 删除一个用户
     *
     * @param id 主键id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据id获取对应的用户
     *
     * @param id 主键id
     * @return
     */
    CarUser getUserById(Integer id);

}
