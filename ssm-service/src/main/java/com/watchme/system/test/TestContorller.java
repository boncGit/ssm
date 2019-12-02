package com.watchme.system.test;


import com.watchme.system.user.entity.TbUser;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "API - DcTenantCommodityController", description = "商品实例信息")
@Controller
@RequestMapping("/test/")
public class TestContorller {

    @RequestMapping(value = "forwardList",method = RequestMethod.GET)
    public ModelAndView forwardUserList(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("example/test/testBootstrap");
        return mav;
    }
}
