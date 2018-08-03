package com.watchme.controller.system;

import com.watchme.entity.TbUser;
import com.watchme.service.IUserService;
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

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String home(){//自定义主界面（登陆页面）
        return "example/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String staffLogin(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        return null;
    }
}
