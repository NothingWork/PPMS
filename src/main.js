import { createApp } from "vue";

import App from "./App.vue";

//���嵼�� ElementPlus �����
import ElementPlus from "element-plus"; //���� ElementPlus ����������ģ��͹���
import "element-plus/dist/index.css"; //���� ElementPlus ����������ȫ�� CSS ��ʽ
import * as ElementPlusIconsVue from "@element-plus/icons-vue"; //���� ElementPlus ������е�����ͼ��

const app = createApp(App);

//ע�� ElementPlus ������е�����ͼ�굽ȫ�� Vue Ӧ����
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component);
}
app.use(ElementPlus); //�� ElementPlus ���ע�ᵽ Vue Ӧ����

app.mount("#app");
