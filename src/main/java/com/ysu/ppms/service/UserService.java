package com.ysu.ppms.service;

import com.ysu.ppms.domain.Result;
import com.ysu.ppms.dto.RegDTO;

/**
 * @author Yun
 * @description: 用户类服务层
 */
public interface UserService {
    Result login(String email, String password);

    Result register(RegDTO regDto);

    Result sendCode(String to);
}
