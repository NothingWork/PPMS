package com.ysu.ppms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yun
 * @description: 用户实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String uid;//用户id
    String name;//姓名
    String email;//电话号码
    String password;//密码
    char role;//行政等级
    boolean state;//启用状态
}
