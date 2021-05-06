package com.fc.controller;

import com.fc.entity.CarUser;
import com.fc.service.CarUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Description: 处理用户相关请求
 *
 * @author : Juice
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private CarUserService userService;

    /**
     * 处理用的登陆请求
     *
     * @param tel      电话（账号）
     * @param password 密码
     * @param session  会话对象
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public Map<String, Object> login(String tel, String password, HttpSession session) {

        UsernamePasswordToken token = new UsernamePasswordToken(tel, password);
        // 获取主体
        Subject subject = SecurityUtils.getSubject();
        /**
         * 指定map集合初始大小为10
         */
        Map<String, Object> map = new HashMap<>(10);

        try {
            // 自定义realm进行身份验证和授权
            subject.login(token);

            // 执行到此处登陆肯定为成功
            CarUser user = userService.login(tel);
            // 用于user/getName请求获取数据
            session.setAttribute("user", user);

            map.put("code", 1);
            map.put("info", "登录成功");
            return map;

        } catch (UnknownAccountException e) {
            System.out.println("用户名不存在");
            map.put("info", "登录失败");
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            map.put("info", "登录失败");
        }
        return map;
    }

    /**
     * 获取用户名的请求
     *
     * @param session
     * @return
     */
    @RequestMapping("getName")
    @ResponseBody
    public Map<String, Object> getName(HttpSession session) {
        // 指定初始化大小为10
        Map<String, Object> map = new HashMap<>(10);
        // 从session中获取信息
        CarUser user = (CarUser) session.getAttribute("user");
        map.put("code", 1);
        map.put("name", user.getEmail());
        map.put("id", user.getId());
        return map;
    }

    /**
     * 用户注册
     *
     * @param carUser 用户信息
     * @return
     */
    @PostMapping("register")
    @ResponseBody
    public Map<String, Object> register(CarUser carUser) {
        // 随机生成默认的用户名
        Random random = new Random();
        carUser.setUsername("csd" + random.nextInt());

        // 没有填写邀请码的用户
        if ("".equals(carUser.getInvitation())) {
            carUser.setInvitation("不支持");
        } else {
            carUser.setInvitation("支持");
        }
        Map<String, Object> map = new HashMap<>(10);

        // 插入一条用户信息数据
        int affectRows = userService.register(carUser);

        if (affectRows > 0) {
            // 1代表注册成功！
            map.put("code", 1);
            map.put("info", "用户" + carUser.getUsername() + "注册成功");
            return map;
        }
        // 0代表注册失败
        map.put("code", 0);
        map.put("info", "用户" + carUser.getUsername() + "注册失败！");
        return map;
    }

    /**
     * 个人信息界面从session中获取到当前登陆用户的信息
     *
     * @param session 会话对象
     * @return
     */
    @RequestMapping("denglu")
    @ResponseBody
    public Map<String, Object> denglu(HttpSession session) {
        // 从session中获取当前登陆用户的信息
        CarUser user = (CarUser) session.getAttribute("user");

        Map<String, Object> map = new HashMap<>(10);
        Map<String, Object> data = new HashMap<>(10);

        data.put("id", user.getId());
        data.put("tel", user.getTel());
        data.put("email", user.getEmail());

        map.put("code", 1);
        map.put("info", data);
        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> update(CarUser user,HttpSession session) {

        int affectRows = userService.update(user);
        Map<String, Object> map = new HashMap<>(10);
        if (affectRows > 0) {
            CarUser carUser = (CarUser) session.getAttribute("user");
            carUser.setTel(user.getTel());
            session.setAttribute("user",carUser);
            map.put("code", 1);
            return map;
        }
        map.put("code", 0);
        return map;
    }

}
