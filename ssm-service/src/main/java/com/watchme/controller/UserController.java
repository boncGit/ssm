package com.watchme.controller;

import com.watchme.entity.TbUser;
import com.watchme.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mengxy on 2018/7/25.
 */
@Controller
@RequestMapping("/userCon/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @ResponseBody
    @RequestMapping(value = "qryUsers",method = RequestMethod.GET)
    public List<TbUser> qryUsers(){
        Map<String,Object> params = new HashMap<String,Object>();
        List<TbUser> list = iUserService.qryAllUser(params);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "selectUsersByMap",method = RequestMethod.GET)
    public List<Map<String,Object>> selectUsersByMap(){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("userCode","admin");
        List<Map<String,Object>> list = iUserService.selectUsersByMap(params);
        return list;
    }
}