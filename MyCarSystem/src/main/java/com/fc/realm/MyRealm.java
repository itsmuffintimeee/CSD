package com.fc.realm;

import com.fc.entity.CarUser;
import com.fc.service.CarUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 自定义realm
 *
 * @author : Juice
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private CarUserService userService;

    private CarUser user = null;

    /**
     * 鉴权方法
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> set = new HashSet<>();
        if (user != null) {
            set.add("success");
        }
        authorizationInfo.addStringPermissions(set);
        return authorizationInfo;
    }

    /**
     * 身份验证方法
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("执行身份验证！！！！！");
        // 获取登陆账号（电话）
        String tel = (String) token.getPrincipal();
        // 获取密码
        String password = new String((char[]) token.getCredentials());
        // 执行查询
        CarUser user = userService.login(tel);

        if (null == user) {
            return null;
        } else if (password.equals(user.getPassword())) {
            this.user = user;
            return new SimpleAuthenticationInfo(tel, password, getName());
        }

        return new SimpleAuthenticationInfo(tel, "密码错误", getName());
    }
}
