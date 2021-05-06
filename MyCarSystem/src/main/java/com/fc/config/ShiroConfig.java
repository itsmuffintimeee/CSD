package com.fc.config;

import com.fc.realm.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author : Juice
 */
@Configuration
public class ShiroConfig {
    /**
     * 自定义realm
     *
     * @return 自定义realm
     */
    @Bean("myRealm")
    public MyRealm myRealm() {
        return new MyRealm();
    }

    /**
     * 自定义安全管理对象
     *
     * @param myRealm 自定义的realm
     * @return
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm) {
        // 指定realm
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    /**
     * 配置过滤器
     *
     * @param securityManager web安全管理器对象
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        // 指定跳转的登陆url
        factoryBean.setLoginUrl("/pagehome/index.html");
        Map<String, String> map = new LinkedHashMap<>();
        // 静态资源全放行
        map.put("/js/**", "anon");
        map.put("/css/**", "anon");
        map.put("/fonts/**", "anon");
        map.put("/images/**", "anon");
        map.put("/layui/**", "anon");

        map.put("/user/login", "anon");
        map.put("/pagehome/login.html", "anon");
        map.put("/pagehome/index.html", "anon");
        map.put("/pagehome/register.html", "anon");

        map.put("/after/**", "anon");

        map.put("/user/logout", "logout");

        map.put("/**", "user");

        // 除上述请求全部需要授权，必须写在最后
        map.put("/", "authc");

        factoryBean.setFilterChainDefinitionMap(map);

        return factoryBean;

    }
}
