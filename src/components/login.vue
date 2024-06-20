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
const emits = defineEmits(['getIndex'])
const emitsIndex = (index) => {
    //发送名为 getIsLogin 的自定义事件
    emits("getIndex", index)
}
</script>

<template>
    <div id="middle1">
        用户名
        <el-input v-model="username" clearable />
        <div class="spaceHeight" />
        密码
        <el-input v-model="password" show-password />
    </div>

    <div id="middle2">
        <el-checkbox-group v-model="checked">
            <el-checkbox value="1">记住我</el-checkbox>
        </el-checkbox-group>
        <div id="forgetPwd" @click="emitsIndex(2)">忘记密码？</div>
    </div>

    <div id="middle3">
        <el-button id="loginBtn" type="default" size="big" @click="toLogin">
            登录
        </el-button>
    </div>

    <div id="bottom">
        没有账户？<div id="toRegister" @click="emitsIndex(0)">去注册</div>
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

.spaceHeight {
    height: 20px;
}

#forgetPwd {
    font-size: smaller;
    cursor: pointer
}

#forgetPwd:hover {
    color: #409eff;
}

#loginBtn {
    width: 100%;
    height: 40px;
    background-color: #242424;
    color: #fff;
}

#toRegister {
    color: #409eff;
    cursor: pointer
}
</style>