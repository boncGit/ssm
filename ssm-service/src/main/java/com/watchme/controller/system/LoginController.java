package com.watchme.controller.system;

import com.watchme.entity.TbUser;
import com.watchme.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        if (StringUtils.isBlank(userName)) {
            request.setAttribute("errorMessage", "用户名不能为空");
            return "example/login";
        }
        if (StringUtils.isBlank(passWord)) {
            request.setAttribute("errorMessage", "密码不能为空");
            return "login";
        }
        return "redirect:/index";
    }

    //主页面
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        return "example/index";
    }
}
