package com.ysu.ppms.service.Impl;

import com.ysu.ppms.domain.Result;
import com.ysu.ppms.domain.User;
import com.ysu.ppms.dto.RegDTO;
import com.ysu.ppms.mapper.UserMapper;
import com.ysu.ppms.service.UserService;
import com.ysu.ppms.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author Yun
 * @description: 接口实现层
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    private String code;//邮箱验证码
    private int size = 4;//邮箱验证码位数
    @Value("${spring.mail.username}")
    private String from="";//邮件发送者
    @Autowired
    private JavaMailSender javaMailSender;//邮箱发送工具

    /**
     * @description: 登录方法
     * @param: 电话号码，密码
     * @return: com.ysu.ppms.domain.User
     */
    @Override
    public Result login(String email, String password) {
        //1.获取user
        User user = userMapper.findUserByEmail(email);
        //2.判断
        //用户存在
        if (user != null) {
            //密码正确
            if (user.getPassword().equals(password)) return new Result(200, "Success", user);
            //密码错误
            return new Result(500, "Wrong Password", null);
        }
        //用户不存在
        return new Result(400, "Not Exist", null);
    }

    /**
     * @description: 注册
     * @param: 用户注册所需信息
     * @return: com.ysu.ppms.domain.Result
     */
    @Override
    public Result register(RegDTO regDto) {
        //1.防重复查找
        if (userMapper.findUserByEmail(regDto.getEmail()) != null) {
            //用户名重复
            return new Result(401, "Already Exist", null);
        }
        //2.判断验证码
        if(regDto.getCode().equals(code)){
            int result = userMapper.register(regDto);//记录插入信息的数目
            //插入成功
            if (result == 1) return new Result(201, "Success", null);
            //插入失败
            return new Result(501, "Failed", null);
        }
        //验证码错误
        return new Result(510,"Wrong Code",null);
    }

    /**
     * @description: 向邮箱发送验证码
     * @param: 邮箱收件人
     * @return: com.ysu.ppms.domain.Result
     */
    public Result sendCode(String to){
        //1.生成4位数验证码
        code = new RandomUtil().randomCode(size);
        //2.封装邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("验证码");
        simpleMailMessage.setText("【"+code+"】，有效期5分钟。");
        //3.发送邮件
        try{
            javaMailSender.send(simpleMailMessage);
        }catch (Exception e){
            //发送异常
            return new Result(502,"Send Failed",to);
        }
    return new Result(202,"Send Success",to);
    }
}
