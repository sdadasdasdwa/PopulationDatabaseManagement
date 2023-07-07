<template>
  <div>
    <el-container>
      <el-main class="me-articles">

        <ArticleScrollPage></ArticleScrollPage>

      </el-main>

      <el-aside width="200px">
        <CardMe></CardMe>

      </el-aside>

    </el-container>

  </div>
</template>

<script>
import ArticleScrollPage from "@/components/common/ArticleScrollPage.vue"
import CardMe from '@/components/card/CardMe'

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Index",
  components:{
    ArticleScrollPage,
    CardMe,
  },
  data(){
    return{

    }
  }

}
</script>

<style scoped>
.el-container{
  width: 960px;
}

.el-aside{
  margin-left: 20px;
  width: 260px;
}

.el-main{
  padding: 0px;
}

.el-card{
  border-radius: 0;
}

.el-card:not(:first-child){
  margin-top: 20px;
}
</style>