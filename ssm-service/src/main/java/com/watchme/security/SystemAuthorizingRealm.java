package com.watchme.security;

import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.watchme.user.entity.TbUser;
import com.watchme.user.service.IUserService;
import com.watchme.user.service.system.ILoginService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mengxy on 2018/8/3.
 */
@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ILoginService iLoginService;

   //每次验证权限的时候执行
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //每次登陆的时候执行
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        if(StringUtils.isBlank(username)){
            throw new AccountException("Null username are not allowed by this realm.");
        }
        String pwd = new String(token.getPassword());
        //查询用户信息
        Map<String,Object> columnMap = new HashMap<String,Object>();
        columnMap.put("USER_CODE",username);
        if (StringUtils.isNotBlank(pwd)){
            columnMap.put("PASSWORD", pwd);
        }else{
            throw new AccountException("Null password are not allowed by this realm.");
        }

        List<TbUser> tbUserList = null;
        try {
            tbUserList = iUserService.selectByMap(columnMap);
        }catch (Exception e){
            e.printStackTrace();
            throw new AuthenticationException(e);
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo  = null;
        //校验结果
        if(CollectionUtils.isNotEmpty(tbUserList)){
            TbUser tbUser = tbUserList.get(0);
            if (!iLoginService.checkUserPositionIsExist(username)){
                throw new AccountException ("没有赋予权限");
            }
            //存入shiro-seesion
            Session shiroSession = SecurityUtils.getSubject().getSession();
            shiroSession.setAttribute("tbUser", tbUser);

            simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,pwd,getName());
        }else{
            throw new UnknownAccountException();
        }
        return simpleAuthenticationInfo;
    }

}
