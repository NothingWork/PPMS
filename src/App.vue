<script setup>
import { ref } from 'vue'

const username = ref('')
const password = ref('')
const checked = ref([])

const login = () => {
  console.log(username.value)
  console.log(password.value)
}
</script>

<template>
  <div class="container">
    <div class="item">
      <img id="leftImg" src="./assets/login.jpg" alt="">
    </div>

    <div class="item">
      <div style="margin: 20px; display: flex; flex-direction: column;">
        <div id="head">
          <img id="rightImg" src="./assets/login-icon.jpg" alt="">
          欢迎回来！
        </div>

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
          <el-button type="default" size="big" @click="login"
            style="width: 100%; height: 40px; background-color: #242424; color: #fff;">
            登录
          </el-button>
        </div>

        <div id="bottom">
          没有账户？<a href="https://www.baidu.com">去注册</a>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  width: 60%;
  height: 90%;
  display: flex;
}

.item {
  width: 50%;
  height: 100%;
}

#leftImg {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 10px;
}

.container:last-child {
  background-color: #ffffff;
  border-radius: 10px;
}

#head {
  height: 200px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

#rightImg {
  width: 60px;
  height: 60px;
  margin-bottom: 20px;
}

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

a {
  text-decoration: none;
  color: #409eff;
}
</style>