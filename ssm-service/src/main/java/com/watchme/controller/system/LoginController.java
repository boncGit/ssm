package com.watchme.controller.system;

import com.watchme.entity.TbUser;
import com.watchme.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mengxy on 2018/7/25.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    //自定义登陆页面
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String home(){
        return "example/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String staffLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (StringUtils.isBlank(username)) {
            request.setAttribute("errorUserNameMessage", "用户名不能为空");
            return "example/login";
        }
        if (StringUtils.isBlank(password)) {
            request.setAttribute("errorPassWordMessage", "密码不能为空");
            return "example/login";
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try{
            subject.login(token);
            //存入http缓存
            HttpSession session = request.getSession();
            Session shiroSession = subject.getSession();
            session.setAttribute("tbUser", shiroSession.getAttribute("tbUser"));//当前用户
        }catch (AuthenticationException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "用户名或者密码不正确");
            return "example/login";
        }
        return "redirect:/index";
    }

    //主页面
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        return "example/index";
    }
}
