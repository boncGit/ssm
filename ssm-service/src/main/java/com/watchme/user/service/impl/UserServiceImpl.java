package com.watchme.user.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.watchme.user.entity.TbUser;
import com.watchme.user.mapper.UserMapper;
import com.watchme.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mengxy on 2018/7/25.
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, TbUser> implements IUserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public List<TbUser> qryAllUser(Map<String, Object> map) {
        Map<String,Object> columnMap = new HashMap<String,Object>();
        List<TbUser> list = baseMapper.selectByMap(columnMap);
        return list;
    }

    public List<Map<String, Object>> selectUsersByMap(Map<String, Object> map) {
        List<Map<String, Object>> list = baseMapper.selectUsersByMap(map);
        return list;
    }

    public int delUser(Map<String, Object> map) {
        int i = 0;
        String id = map.get("id").toString();
        try{
            i = baseMapper.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
            logger.error("删除用户报错,错误信息："+e.getMessage());
        }
        return i;
    }
}
