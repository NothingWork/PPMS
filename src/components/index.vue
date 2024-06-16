<script setup>
import { ref } from 'vue'
import Login from './login.vue'
import Register from './register.vue'

const leftImg = ref('src/assets/index1.jpg')
const rightImg = ref('src/assets/index2.jpg')
const isLogin = ref(1)

const updateIsLogin = (data) => {
    isLogin.value = data
}
</script>

<template>
    <div class="item">
        <img id="leftImg" :src="leftImg" alt="">
    </div>

    <div class="item">
        <div style="margin: 20px; display: flex; flex-direction: column;">
            <div id="head">
                <img id="rightImg" :src="rightImg" alt="">
                欢迎回来！
            </div>

            <div id="body">
                <Login v-if="isLogin" @getIsLogin="updateIsLogin" />
                <Register v-else @getIsLogin="updateIsLogin" />
            </div>
        </div>
    </div>
</template>

<style scoped>
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
</style>