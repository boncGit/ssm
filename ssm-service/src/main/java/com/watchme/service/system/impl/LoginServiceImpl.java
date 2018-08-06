package com.watchme.service.system.impl;

import com.watchme.service.system.ILoginService;
import org.springframework.stereotype.Service;

/**
 * Created by Mengxy on 2018/8/3.
 */

@Service
public class LoginServiceImpl implements ILoginService{

    public boolean checkUserPositionIsExist(String userid) {
        return true;
    }
}
