package com.watchme.controller;

import com.watchme.system.user.entity.TbUser;
import com.watchme.system.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Mengxy on 2018/9/28.
 */
@Api(value = "API - DcTenantCommodityController", description = "商品实例信息")
@Controller
@RequestMapping("/testUserCon/")
public class TestController {

        @ApiOperation(value = "获取我的服务列表", notes = "获取我的服务列表")
        @RequestMapping(value = "forwardUserList", method = RequestMethod.GET)
        public ModelAndView forwardUserList() {
            ModelAndView mav = new ModelAndView("example/user_list");
            return mav;
        }

        @ApiOperation(value = "获取我的服务列表", notes = "获取我的服务列表")
        @ResponseBody
        @RequestMapping(value = "qryUsers", method = RequestMethod.GET)
        public List<TbUser> qryUsers() {
            return null;
     }
}
