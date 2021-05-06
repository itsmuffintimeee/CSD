package com.fc.controller;

import com.fc.entity.CarCar;
import com.fc.service.CarCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 处理租车相关信息
 *
 * @author : Juice
 */
@Controller
@RequestMapping("car")
public class CarCarController {

    @Autowired
    private CarCarService carCarService;

    /**
     * 查询车辆信息，并根据价格进行降序排序
     *
     * @param cid
     * @return
     */
    @RequestMapping("price")
    @ResponseBody
    public Map<String, Object> price(@RequestParam("getid") int cid) {

        List<CarCar> carByCidOnPrice = carCarService.findCarByCidOnPrice(cid);
        Map<String, Object> map = new HashMap<>(10);
        CarCar[] cars = new CarCar[carByCidOnPrice.size()];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = carByCidOnPrice.get(i);
        }

        map.put("info", cars);
        map.put("code", 1);

        return map;


    }

    /**
     * 查询车辆信息，并根据座位数进行降序排序
     *
     * @param cid
     * @return
     */
    @RequestMapping("number")
    @ResponseBody
    public Map<String, Object> number(@RequestParam("getid") int cid) {

        List<CarCar> carByCidOnSite = carCarService.findCarByCidOnSite(cid);

        Map<String, Object> map = new HashMap<>(10);

        CarCar[] cars = new CarCar[carByCidOnSite.size()];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = carByCidOnSite.get(i);
        }

        map.put("info", cars);
        map.put("code", 1);

        return map;
    }


    /**
     * 根据cid查找车辆信息，进行订单的提交
     *
     * @param getid  租车地点
     * @param backid 还车地点
     * @param cid    车辆主键id
     * @return
     */
    @RequestMapping("findcar")
    @ResponseBody
    public Map<String, Object> findCar(int getid, int backid, int cid) {

        Map<String, Object> map = new HashMap<>(10);
        CarCar carById = carCarService.findCarById(cid);

        map.put("info", carById);
        map.put("code", 1);
        return map;

    }


}
