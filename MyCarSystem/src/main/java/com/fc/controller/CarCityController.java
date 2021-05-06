package com.fc.controller;

import com.fc.entity.CarCity;
import com.fc.service.CarCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author : Juice
 */
@Controller
@RequestMapping("city")
public class CarCityController {

    @Autowired
    private CarCityService carCityService;

    /**
     * 获取城市信息
     *
     * @param pid 城市id
     * @return
     */
    @RequestMapping("select")
    @ResponseBody
    public Map<String, Object> select(int pid) {
        List<CarCity> carCities = carCityService.selectByPid(pid);
        Map<String, Object> map = new HashMap<>(10);
        CarCity[] cities = new CarCity[carCities.size()];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = carCities.get(i);
        }
        map.put("info", cities);

        return map;

    }

    /**
     * 处理短期租车信息
     *
     * @param getid  租车地址
     * @param backid 还车地址
     * @return
     */
    @RequestMapping("citys")
    @ResponseBody
    public Map<String, Object> getCitys(int getid, int backid) {

        // 租车城市地址
        CarCity getCity = carCityService.getCityById(getid);
        // 还车城市地址
        CarCity backCity = carCityService.getCityById(backid);

        // 存放租车和存车地址信息
        Map<String, Object> city = new HashMap<>(10);
        city.put("getCity", getCity);
        city.put("backCity", backCity);
        // 存放城市信息和成功状态码
        Map<String, Object> map = new HashMap<>(10);
        map.put("info", city);
        map.put("code", 1);
        return map;
    }

}
