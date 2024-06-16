<script setup>
import { ref } from 'vue'

const username = ref('')
const password = ref('')
const email = ref('')
const code = ref('')
const checked = ref([])

const toRegister = () => {
    console.log(username.value)
    console.log(password.value)
    console.log(email.value)
}

const getCode = () => {
    console.log(code.value)
}

const emits = defineEmits(['getIsLogin'])
const emitsIsLogin = () => {
    emits("getIsLogin", 1)
}
</script>

<template>
    <div id="middle1">
        <el-input v-model="username" placeholder="请输入用户名" clearable />
        <div style="height: 20px;" />
        <el-input v-model="password" placeholder="请输入密码" show-password />
        <div style="height: 20px;" />
        <el-input v-model="email" placeholder="请输入电子邮件">
            <template #append>@qq.com</template>
        </el-input>
    </div>

    <div id="middle2">
        <el-input v-model="code" placeholder="请输入验证码" style="width: 120px; margin-right: 10px;" />
        <el-button type="default" size="default" @click="getCode"
        style="background-color: #dadada ;color: #000;">获取验证码</el-button>
        <div style="margin: 0 auto;" />
        <el-checkbox-group v-model="checked">
            <el-checkbox value="1">下次自动登录</el-checkbox>
        </el-checkbox-group>
    </div>

    <div id="middle3">
        <el-button type="default" size="big" @click="toRegister"
            style="width: 100%; height: 40px; background-color: #242424; color: #fff;">
            注册
        </el-button>
    </div>

    <div id="bottom">
        已有账户？<div @click="emitsIsLogin" style="color: #409eff; cursor: pointer">去登录</div>
    </div>
</template>

<style scoped>
#middle1 {
    height: 180px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

#middle2 {
    display: flex;
    align-items: center;
}

#middle3 {
    padding: 20px 0px;
    display: flex;
    justify-content: center;
}

#bottom {
    display: flex;
    justify-content: center;
    align-items: center;
    color: gray;
    font-size: smaller;
}
</style>