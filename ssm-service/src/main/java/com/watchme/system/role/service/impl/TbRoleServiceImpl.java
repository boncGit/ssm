package com.watchme.system.role.service.impl;

import com.watchme.system.role.entity.TbRole;
import com.watchme.system.role.mapper.TbRoleMapper;
import com.watchme.system.role.service.ITbRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mengxy
 * @since 2018-08-08
 */
@Service
public class TbRoleServiceImpl extends ServiceImpl<TbRoleMapper, TbRole> implements ITbRoleService {

    @Override
    public List<TbRole> getRoles(Map<String, Object> map) {
        Map<String,Object> columnMap = new HashMap<String,Object>();
        List<TbRole> list = baseMapper.selectByMap(columnMap);
        return list;
    }
}
