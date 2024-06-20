<script setup>
import { ref } from 'vue'

const password = ref('')
const passwordTemp = ref('')
const email = ref('')
const code = ref('')

const changePwd = () => {
    console.log(password.value)
    console.log(email.value)
}

const getCode = () => {
    console.log(code.value)
}

const emits = defineEmits(['getIndex'])
const emitsIndex = () => {
    emits("getIndex", 1)
}
</script>

<template>
    <div id="back">
        <el-icon id="backIcon" size="24" @click="emitsIndex">
            <Back />
        </el-icon>
    </div>

    <div id="middle1">
        <el-input v-model="password" placeholder="请输入新密码" show-password />
        <div class="spaceHeight" />
        <el-input v-model="passwordTemp" placeholder="请再次输入新密码" show-password />
        <div class="spaceHeight" />
        <el-input v-model="email" placeholder="请输入电子邮件">
            <template #append>@qq.com</template>
        </el-input>
    </div>

    <div id="middle2">
        <el-input style="width: 120px; height: 30px; margin-right: 10px;" v-model="code" placeholder="请输入验证码" />
        <el-button id="codeBtn" type="default" size="default" @click="getCode">获取验证码</el-button>
    </div>

    <div id="middle3">
        <el-button id="changePwdBtn" type="default" size="big" @click="changePwd">
            确认
        </el-button>
    </div>
</template>

<style scoped>
#back {
    height: 44px;
}

#backIcon {
    cursor: pointer;
}

#backIcon:hover {
    color: #409eff;
}

#middle1 {
    height: 131px;
    display: flex;
    flex-direction: column;
}

#middle2 {
    height: 50px;
    display: flex;
    align-items: end;
}

#middle3 {
    padding: 25px 0px;
    display: flex;
    justify-content: center;
}

.spaceHeight {
    height: 20px;
}

#codeBtn {
    height: 30px;
    background-color: #dadada;
    color: #000;
}

#changePwdBtn {
    width: 100%;
    height: 40px;
    background-color: #242424;
    color: #fff;
}
</style>