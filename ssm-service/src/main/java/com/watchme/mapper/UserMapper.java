package com.watchme.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.watchme.entity.TbUser;

import java.util.List;
import java.util.Map;

/**
 * Created by Mengxy on 2018/7/25.
 */
public interface UserMapper extends BaseMapper<TbUser>{

     List<Map<String,Object>> selectUsersByMap(Map<String,Object> map);

}
