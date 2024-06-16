<script setup>
import { ref } from 'vue'

const username = ref('')
const password = ref('')
const checked = ref([])

const toLogin = () => {
    console.log(username.value)
    console.log(password.value)
}

//defineEmits是Vue3的编译时宏函数, 用于子组件向父组件发送自定义事件
//定义一个名为 emits 的对象, 用于存储自定义事件
const emits = defineEmits(['getIsLogin'])
const emitsIsLogin = () => {
    //发送名为 getIsLogin 的自定义事件
    emits("getIsLogin", 0)
}
</script>

<template>
    <div id="middle1">
        用户名
        <el-input v-model="username" clearable />
        <div style="height: 20px;" />
        密码
        <el-input v-model="password" show-password />
    </div>

    <div id="middle2">
        <el-checkbox-group v-model="checked">
            <el-checkbox value="1">记住我</el-checkbox>
        </el-checkbox-group>
        <div style="font-size: smaller;">忘记密码？</div>
    </div>

    <div id="middle3">
        <el-button type="default" size="big" @click="toLogin"
            style="width: 100%; height: 40px; background-color: #242424; color: #fff;">
            登录
        </el-button>
    </div>

    <div id="bottom">
        没有账户？<div @click="emitsIsLogin" style="color: #409eff; cursor: pointer">去注册</div>
    </div>
</template>

<style scoped>
#middle1 {
    height: 150px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

#middle2 {
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: gray;
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