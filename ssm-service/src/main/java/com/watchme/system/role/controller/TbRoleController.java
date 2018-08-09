package com.watchme.system.role.controller;

import com.watchme.system.role.entity.TbRole;
import com.watchme.system.role.service.ITbRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mengxy
 * @since 2018-08-08
 */
@Controller
@RequestMapping("/role/tbRole")
public class TbRoleController {

    @Autowired
    private ITbRoleService iTbRoleService;

    @ResponseBody
    @RequestMapping(value = "qryRoles",method = RequestMethod.GET)
    public List<TbRole> selectUsersByMap(){
        Map<String,Object> params = new HashMap<String,Object>();
        List<TbRole> list = iTbRoleService.getRoles(params);
        return list;
    }
}
