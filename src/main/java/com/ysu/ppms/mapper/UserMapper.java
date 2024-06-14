package com.ysu.ppms.mapper;

import com.ysu.ppms.domain.User;
import com.ysu.ppms.dto.RegDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author Yun
 * @description: 和用户账号操作相关的mapper层
 */
@Mapper
@Repository
public interface UserMapper {

    User findUserByEmail(String email);
    Integer register(RegDTO regDto);
}
