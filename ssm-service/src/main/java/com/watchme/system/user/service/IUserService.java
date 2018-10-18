package com.watchme.system.user.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.watchme.system.user.entity.TbUser;

import java.util.List;
import java.util.Map;

/**
 * Created by Mengxy on 2018/7/25.
 */
public interface IUserService extends IService<TbUser> {

     List<TbUser> qryAllUser(Map<String, Object> map);

     Page<Map<String, Object>> qryAllUser(Page page,Map<String, Object> map);

     List<Map<String,Object>> selectUsersByMap(Map<String, Object> map);

     int delUser(Map<String, Object> map);
}
