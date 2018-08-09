package com.watchme.system.user.controller;

import com.watchme.common.utils.SpringContextHolder;
import com.watchme.system.user.entity.TbUser;
import com.watchme.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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


    @RequestMapping(value = "forwardUserList",method = RequestMethod.GET)
    public ModelAndView forwardUserList(HttpServletRequest request){
        Map<String,Object> params = new HashMap<String,Object>();
        List<TbUser> list = iUserService.qryAllUser(params);
        ModelAndView mav = new ModelAndView("example/user_list");
        mav.addObject("userList",list);
        return mav;
    }

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

    @ResponseBody
    @RequestMapping(value = "delUser",method = RequestMethod.POST)
    public Map<String,Object> delUser(HttpServletRequest request){
        int i = 0;
        Map<String,Object> result = new HashMap<String,Object>();
        String id = request.getParameter("id");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("id",id);
        i = iUserService.delUser(params);
        if(i>0){
            result.put("msg","删除成功");
        }else{
            result.put("","删除失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "qryUserByMap",method = RequestMethod.GET)
    public List<TbUser> qryUserByMap(){
        IUserService userService = SpringContextHolder.getBean("userServiceImpl");
        Map<String,Object> params = new HashMap<String,Object>();
        List<TbUser> list =  userService.qryAllUser(params);
        return list;
    }
}
