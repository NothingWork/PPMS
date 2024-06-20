<script setup>
import { ref } from 'vue'
import Login from './login.vue'
import Register from './register.vue'
import ChangePwd from './changePwd.vue'

const leftImg = ref('src/assets/index1.jpg')
const rightImg = ref('src/assets/index2.jpg')
const index = ref(1)

const updateIndex = (data) => {
    index.value = data
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
                <Login v-if="(index === 1)" @getIndex="updateIndex" />
                <ChangePwd v-else-if="(index === 2)" @getIndex="updateIndex" />
                <Register v-else @getIndex="updateIndex" />
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