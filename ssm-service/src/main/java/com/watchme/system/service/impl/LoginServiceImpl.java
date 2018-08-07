package com.watchme.system.service.impl;

import com.watchme.system.service.ILoginService;
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
