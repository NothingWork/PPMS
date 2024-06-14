package com.ysu.ppms.controller;

import com.ysu.ppms.domain.Result;
import com.ysu.ppms.domain.User;
import com.ysu.ppms.dto.RegDTO;
import com.ysu.ppms.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yun
 * @description: 用户控制层
 */
@Tag(name = "用户管理")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    //登录
   @Operation(summary = "登录")
   @GetMapping("/login")
    public Result login(
            @Parameter(name = "email",description = "邮箱")String email,
            @Parameter(name = "password",description = "密码")String password
    ){
        return userService.login(email,password);
    }

    //注册
    @Operation(summary = "注册")
    @GetMapping("/register")
    public Result register(
            @Parameter(name = "RegDTO",description = "注册信息")RegDTO regDTO
    ){
       return userService.register(regDTO);
    }
    //发送验证码
    @Operation(summary = "发送验证码")
    @GetMapping("/sendCode")
    public Result sendCode(
            @Parameter(name = "email",description = "邮箱")String email
    ){
      return userService.sendCode(email);
    }

}