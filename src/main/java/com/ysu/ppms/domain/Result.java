package com.ysu.ppms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yun
 * @description: 返回消息统一包装
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    Integer code;//响应码
    String message;//响应消息
    Object data;//响应数据
}
