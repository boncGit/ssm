package com.watchme.service.dsservice;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

/**
 * @author dcwenxin
 * @date 2018/5/28
 */
public class DsServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    @Override
    public boolean insertBatch(List entityList, int batchSize) {
        boolean handdleFlag=true;
        handdleFlag = super.insertBatch(entityList, batchSize);
        if(handdleFlag==false){
            throw new RuntimeException("新增失败");
        }
        return handdleFlag;
    }
    @Override
    public boolean insertOrUpdate(T entity) {
        boolean handdleFlag=true;
        handdleFlag = super.insertOrUpdate(entity);
        if(handdleFlag==false){
            throw new RuntimeException("新增/修改失败");
        }
        return handdleFlag;
    }

    @Override
    public boolean insertOrUpdateBatch(List<T> entityList, int batchSize) {
        boolean handdleFlag=true;
        super.insertOrUpdateBatch(entityList, batchSize);
        if(handdleFlag==false){
            throw new RuntimeException("新增/修改失败");
        }
        return handdleFlag;
    }
}

