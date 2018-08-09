package com.watchme.system.role.service;

import com.watchme.system.role.entity.TbRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mengxy
 * @since 2018-08-08
 */
public interface ITbRoleService extends IService<TbRole> {

    List<TbRole> getRoles(Map<String,Object> map);
	
}
