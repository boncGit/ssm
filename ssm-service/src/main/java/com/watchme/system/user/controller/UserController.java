package com.watchme.system.user.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.watchme.common.rest.ResponseResult;
import com.watchme.common.rest.ResponseResultUtil;
import com.watchme.common.utils.SpringContextHolder;
import com.watchme.system.user.entity.TbUser;
import com.watchme.system.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mengxy on 2018/7/25.
 */
@Api(value = "API - DcTenantCommodityController", description = "商品实例信息")
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

    @ApiOperation(value = "获取我的服务列表", notes = "获取我的服务列表")
    @ResponseBody
    @RequestMapping(value = "qryUsers",method = RequestMethod.GET)
    public ResponseResult qryUsers(@RequestParam(value = "current", required = false) Integer current,
                                 @RequestParam(value = "size", required = false) Integer size,
                                 @RequestParam(value = "userName", required = false) String userName){
        ResponseResult responseResult;
        Map<String,Object> params = new HashMap<String,Object>();
        if (current == null && size == null) {
            List<TbUser> result = iUserService.qryAllUser(params);
            responseResult = ResponseResultUtil.getSuccessResult("查询成功", result);
        } else {
            Page page = new Page(current, size);
            Page<Map<String, Object>> result = iUserService.qryAllUser(page,params);
            responseResult = ResponseResultUtil.getSuccessResult("查询成功", result);
        }
        List<TbUser> list = iUserService.qryAllUser(params);
        return responseResult;
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
        for(TbUser tbUser:list){
            System.out.println(tbUser.getUserName());
        }
        return list;
    }
}
