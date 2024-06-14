package com.ysu.ppms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yun
 * @description: 用于用户注册的信息传递实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegDTO {
    String name;//姓名
    String email;//邮箱
    String password;//密码
    String code;//验证码
}
