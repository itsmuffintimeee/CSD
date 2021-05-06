package com.fc.controller;

import com.fc.entity.CarOrder;
import com.fc.service.CarOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 订单相关的
 *
 * @author : Juice
 */
@Controller
@RequestMapping("order")
public class CarOrderController {

    @Autowired
    private CarOrderService carOrderService;


    /**
     * 查找所有订单列表
     *
     * @param page  页数
     * @param limit 信息数
     * @return
     */
    @RequestMapping("all")
    @ResponseBody
    public Map<String, Object> all(int page, int limit) {

        PageInfo<CarOrder> pageInfo = carOrderService.findAll(page);

        Map<String, Object> data = new HashMap<>(10);

        data.put("total", pageInfo.getTotal());
        data.put("rows", pageInfo.getList().toArray());

        Map<String, Object> map = new HashMap<>(10);

        map.put("info", data);
        map.put("code", 0);

        return map;
    }

    /**
     * 删除订单信息
     *
     * @param id 订单id
     * @return
     */
    @RequestMapping("del")
    public String del(int id) {
        // 根据id删除相关订单
        carOrderService.delOrder(id);
        // 重定向至订单页面
        return "redirect:/mymain/mymain.html";
    }


    @RequestMapping("add")
    @ResponseBody
    public Map<String, Object> add(CarOrder carOrder) {

        carOrder.setStatus("已预定");
        int affectRows = carOrderService.addCarOrder(carOrder);
        Map<String, Object> map = new HashMap<>(10);

        if (affectRows > 0) {
            map.put("message", "预定成功！");
            return map;
        }
        map.put("message", "预定失败!");
        return map;
    }

}
