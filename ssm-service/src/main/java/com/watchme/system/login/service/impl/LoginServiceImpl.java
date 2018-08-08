package com.watchme.system.login.service.impl;

import com.watchme.system.login.service.ILoginService;

/**
 * Created by Mengxy on 2018/8/8.
 */
public class LoginServiceImpl implements ILoginService{

    /**
     * 检查用户是否已经赋予了岗位权限
     * @param userid
     * @return
     */
    public boolean checkUserPositionIsExist(String userid) {
        return true;
    }
}
