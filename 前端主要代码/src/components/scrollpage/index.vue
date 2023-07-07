<template>
  <div ref="scroll" id="scroll-page" style="overflow:hidden">
    <slot></slot>
    <!-- Loading动画 -->
    <div
        style="height: 40px;margin-top: 10px;z-index: 1"
        v-if="loading">
      <el-icon class="is-loading "  color="#00aaff"><loading /></el-icon> <span style="color: #00aaff">拼命加载中</span>
    </div>

  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "index",
  props:{
    loading: Boolean,
    noData: Boolean,
    offset: Number
  },
  data(){
    return{
      scrollAction:{
        x:'undefined',
        y:'undefined'
      }
    }
  },
  methods:{
    handleScroll(){
      var that = this
      //
      if(!that.noData){
        //如果有数据，触发
        let curHeight = document.documentElement.scrollTop||document.body.scrollTop
        //获取div区域
        // var scrollPage = document.getElementById('scroll-page');
        //
        if((curHeight+window.innerHeight>=that.$refs.scroll.offsetHeight+that.offset)&&that.isDownDirection()){
          //判断是否到达底部
          if(!that.loading){
            //调用load加载数据
            that.$emit('load')
          }
        }
      }
    },
    isDownDirection(){
      if(typeof this.scrollAction.x == 'undefined'){
        this.scrollAction.x = window.pageXOffset;
        this.scrollAction.y = window.pageYOffset;
      }
      var diffX = this.scrollAction.x - window.pageXOffset;
      var diffY = this.scrollAction.y - window.pageYOffset;

      this.scrollAction.x = window.pageXOffset;
      this.scrollAction.y = window.pageYOffset;

      if(diffX<0){
        //Scroll right
      }else if(diffX>0){
        //Scroll left
      }else if(diffY<0){
        //Scroll down
        return true
      }else if(diffY>0){
        //Scroll up
      }else{
        //First scroll event
      }
      return false
    },
    mounted(){
      window.addEventListener('scroll',this.handleScroll,false);
      //绑定事件监听，滚动的时候触发
    },
    beforeDestroy(){
      window.removeEventListener('scroll',this.handleScroll)
      //移出事件监听
    },
  }

}
</script>

<style scoped>
.custom-icon {
  color: rgba(245, 245, 245);
}
</style>