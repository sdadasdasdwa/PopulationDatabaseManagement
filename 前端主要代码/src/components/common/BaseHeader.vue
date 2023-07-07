<template>
  <el-header class="me-area">
    <el-row class="me-header">

      <el-col :span="3" class="me-header-left">
        <router-link to="/" class="me-title">
          <img src="../../assets/logo.png"/>
        </router-link>
      </el-col>

      <el-col v-if="!simple" :span="16">
        <el-menu :router=true menu-trigger="click" active-text-color="#00aaff" :default-active="activeIndex" mode="horizontal">
          <el-menu-item index="/">首页</el-menu-item>
          <el-menu-item index="/category/all">常驻人口管理</el-menu-item>
          <el-menu-item index="/tag/all">人口管理</el-menu-item>
          <el-menu-item index="/archives">证件管理</el-menu-item>

          <el-col :span="4" :offset="4">
            <el-menu-item index="/write"><el-icon><Edit/></el-icon>写公告</el-menu-item>
          </el-col>

        </el-menu>
      </el-col>

      <template v-else>
        <slot></slot>
      </template>

      <el-col :span="4">
        <el-menu :router=true menu-trigger="click" mode="horizontal" active-text-color="#00aaff" style="height: 58.4px">

          <template v-if="!user.login">
            <el-menu-item index="/login">
              <el-button type="text">登录</el-button>
            </el-menu-item>
            <el-menu-item index="register">
              <el-button type="text">注册</el-button>
            </el-menu-item>
          </template>

          <template v-else>
            <el-submenu index>
              <template v-slot:title>
                <img class="me-header-picture" :src="user.avatar"/>
              </template>
              <el-menu-item index @click="logout"><i class="el-icon-back"></i>退出</el-menu-item>
            </el-submenu>
          </template>

        </el-menu>
      </el-col>

    </el-row>
  </el-header>
</template>

<script>
export default{
  name: 'BaseHeader',
  props:{
    activeIndex: String,
    simple:{
      type: Boolean,
      default: false
    }
  },
  data(){
    return{
      user:{
        login: false,
        avatar:""
      }
    }
  },
  methods:{
    logout(){

    },
  }

}
</script>

<style>
.el-button{
  color: #00aaff;
}

.el-header{
  position: fixed;
  z-index: 1024;
  min-width: 100%;
  box-shadow: 0 2px 3px hsla(0,0%,7%,.1), 0 0 0 1px hsla(0,0%,7%,.1);
}

.me-title{
  margin: 10px;
  font-size: 24px;
}

.me-header-left{
  margin-top: 10px;
}

.me-title img{
  max-height: 2.4rem;
  max-width: 100%;
}

.me-header-picture{
  width: 36px;
  height: 36px;
  border: 1px solid #ddd;
  border-radius: 50%;
  vertical-align: middle;
  background-color: #00aaff;
}
</style>