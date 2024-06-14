这里记录了一些主要的API接口
本项目已整合springdoc自动生成Restful风格的api文档，请启动项目后在下面地址查看
http://127.0.0.1:8080/swagger-ui/index.html#/

api文档

| 接口            | 响应码 | 响应消息           | 响应内容    |
|---------------|-----|----------------|---------|
| /api/login    | 200 | success        | 登录的用户信息 |
|               | 400 | Not Exist      | null    |
|               | 500 | Wrong Password | null    |
| /api/sendCode | 202 | Send Success   | 邮箱收件人   |
|               | 502 | Send Failed    | 邮箱收件人   |
| /api/register | 201 | Success        | null    |
|               | 401 | Already Exist  | null    |
|               | 501 | Failed         | null    |
|               | 510 | Wrong Code     | null    |
