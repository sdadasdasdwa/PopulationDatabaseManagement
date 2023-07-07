import App from './App.vue'
import router from '@/util/router.js'
import ElementPlus from 'element-plus';
import 'element-plus/theme-chalk/index.css';
import 'element-plus/dist/index.css';
import {createApp} from 'vue'
// import locale from 'element-plus/lib/locale/lang/zh-cn';
import axios from './axios/http';
import VueAxios from "vue-axios";
import {formatTime} from "./util/time"
import * as ElIconModules from '@element-plus/icons-vue'

const app = createApp(App)
    .use(router)
    .use(ElementPlus)
    .use(VueAxios, axios)

app.config.globalProperties.$formatTime = formatTime;
//
// app.directive('title', {
//     mounted(el) {
//         document.title = el.dataset.title;
//     },
//     updated(el) {
//         document.title = el.dataset.title;
//     }
// });
for(let iconName in ElIconModules){
    app.component(iconName, ElIconModules[iconName])
}


app.mount('#app')









