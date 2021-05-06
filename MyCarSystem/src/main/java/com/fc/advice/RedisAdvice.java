package com.fc.advice;

import com.alibaba.fastjson.JSON;
import com.fc.entity.CarCar;
import com.fc.entity.CarCity;
import com.fc.entity.CarUser;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description: Redis切面类，用作缓存
 *
 * @author : Juice
 */
@Aspect
@Component
public class RedisAdvice {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 声明一个切点：登陆时优先查找redis缓存
     */
    @Pointcut(value = "execution(* com.fc.service.CarUserService.login(..))")
    public static void userLoginPointcut() {
    }

    /**
     * 声明一个切点：查找订单时优先查询redis缓存
     */
    @Pointcut(value = "execution(* com.fc.service.CarOrderService.find*(..))")
    public static void findOrder() {
    }

    /**
     * 声明一个切点：查找城市
     */
    @Pointcut(value = "execution(* com.fc.service.CarCityService.selectByPid(..))")
    public static void selectByPid() {
    }

    @Pointcut("execution(* com.fc.service.CarCarService.findCarByCidOnSite(..))")
    public static void findCarByCidOnSite() {
    }

    @Pointcut("execution(* com.fc.service.CarCarService.findCarByCidOnPrice(..))")
    public static void findCarByCidOnPrice() {
    }

    @Pointcut("execution(* com.fc.service.CarCarService.findCarById(..))")
    public static void findCarById() {
    }


    /**
     * 使用redis充当二级缓存，优先查询redis中的信息
     * 注意：更改用户手机号之后需清除redis中的登陆信息或覆盖redis中的信息
     */
    @Around(value = "RedisAdvice.userLoginPointcut()")
    public Object redisLogin(ProceedingJoinPoint pjp) {
        try {
            // 得到账号（手机号）
            Object[] args = pjp.getArgs();
            String phone = (String) args[0];
            /**
             * 执行方法前，redis中没有缓存，则从数据库中查询
             */
            if (null == redisTemplate.opsForValue().get("login/" + phone)) {
                System.out.println("redis中没有【登陆】相关信息！");
                return pjp.proceed();
            } else {
                // 直接走redis，不走数据库
                System.out.println("redis中查找【登陆】信息成功！");
                return JSON.parseObject(redisTemplate.opsForValue().get("login/" + phone), CarUser.class);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    /**
     * 查找订单信息优先查询redis中的信息
     *
     * @param pjp
     * @return
     */
    @Around(value = "RedisAdvice.findOrder()")
    public Object redisOrder(ProceedingJoinPoint pjp) {
        try {
            // 得到账号（手机号）
            Object[] args = pjp.getArgs();
            int page = (int) args[0];

            if (null == redisTemplate.opsForValue().get("findAll/" + page)) {
                System.out.println("redis中没有【订单】相关的信息！查询数据库！");
                return pjp.proceed();
            } else {
                PageInfo pageInfo = JSON.parseObject(redisTemplate.opsForValue().get("findAll/" + page), PageInfo.class);
                System.out.println("直接从redis中获取【订单】信息！");
                return pageInfo;
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    /**
     * 查找城市信息前优先查找redis中的信息
     *
     * @param pjp
     * @return
     */
    @Around(value = "RedisAdvice.selectByPid()")
    public Object redisCity(ProceedingJoinPoint pjp) {
        try {
            Object[] args = pjp.getArgs();
            int pid = (int) args[0];
            if (null == redisTemplate.opsForValue().get("selectByPid/" + pid)) {
                System.out.println("redis中没有【城市】相关信息！查询数据库！");
                return pjp.proceed();
            } else {
                List<CarCity> carCities = JSON.parseArray(redisTemplate.opsForValue().get("selectByPid/" + pid), CarCity.class);
                System.out.println("直接从redis中获取【城市】相关信息！");
                return carCities;
            }

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    /**
     * 根据座位数进行排序的信息优先查询redis
     *
     * @param pjp
     * @return
     */
    @Around("RedisAdvice.findCarByCidOnSite()")
    public Object redisFindCarByCidOnSite(ProceedingJoinPoint pjp) {

        try {
            Object[] args = pjp.getArgs();
            int cid = (int) args[0];
            if (null == redisTemplate.opsForValue().get("findCarByCidOnSite/" + cid)) {
                System.out.println("redis中没有id为" + cid + "的【车辆】相关信息！查询数据库！");
                return pjp.proceed();
            } else {
                List<CarCar> carCities = JSON.parseArray(redisTemplate.opsForValue().get("findCarByCidOnSite/" + cid), CarCar.class);
                System.out.println("直接从redis中获取id为" + cid + "【车辆】相关信息！");
                return carCities;
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;

    }


    @Around("RedisAdvice.findCarByCidOnPrice()")
    public Object redisFindCarByCidOnPrice(ProceedingJoinPoint pjp) {
        try {
            Object[] args = pjp.getArgs();
            int cid = (int) args[0];
            if (null == redisTemplate.opsForValue().get("findCarByCidOnPrice/" + cid)) {
                System.out.println("redis中没有id为" + cid + "的【车辆】相关信息！查询数据库！");
                return pjp.proceed();
            } else {
                List<CarCar> carCities = JSON.parseArray(redisTemplate.opsForValue().get("findCarByCidOnPrice/" + cid), CarCar.class);
                System.out.println("直接从redis中获取id为" + cid + "【车辆】相关信息！");
                return carCities;
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;

    }


    @Around("RedisAdvice.findCarById()")
    public Object findCarById(ProceedingJoinPoint pjp) {
        try {
            Object[] args = pjp.getArgs();
            int cid = (int) args[0];
            if (null == redisTemplate.opsForValue().get("findCarById/" + cid)) {
                System.out.println("redis中没有id为" + cid + "的【车辆】相关信息！查询数据库！");
                return pjp.proceed();
            } else {
                CarCar carCities = JSON.parseObject(redisTemplate.opsForValue().get("findCarById/" + cid), CarCar.class);
                System.out.println("直接从redis中获取id为" + cid + "【车辆】相关信息！");
                return carCities;
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;

    }


}
