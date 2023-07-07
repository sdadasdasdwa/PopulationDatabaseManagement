<template>
  <scroll-page
      :loading="loading"
      :offset="offset"
      :no-data="noData"
      @load="load">
    <ArticleItem
        v-for="article in articles"
        v-bind="article"
        :key="article.id">
    </ArticleItem>
  </scroll-page>
</template>

<script>
import ScrollPage from "@/components/scrollpage/index"
import ArticleItem from "@/components/article/ArticleItem"
import http from "@/axios/http";
import qs from "qs";

export default {
  name: "ArticleScrollPage",
  props: {
    query: {
      type: Object,
      default() {
        return {}
      }
    }
  },
  data() {
    return {
      loading: false,
      noData: false,
      offset: 0,
      articles: [],
      pageNo: 1,
      pageSize: 8,
    }
  },
  components: {
    "scroll-page": ScrollPage,
    ArticleItem
  },
  methods: {
    load() {
      //如果触发分页，需要调用接口 加载文章列表
      alert("触发分页")
      this.getArticles()
    },
    getArticles() {
      // alert("获取文章")
      // 网络请求articles数据
      this.loading = true
      let pageParam = {pageNo: this.pageNo, pageSize: this.pageSize}
      http.post('/testConn/articles', qs.stringify(pageParam)).then((res) => {
        console.log(res.data)
        if(res.statusText == "OK"){
          if(res.data.total <= 0){
            this.noData = true
          }
          this.articles = res.data.list
          this.pageNo+=1
        }

      })
      this.loading = false
    }
  },
  created() {
    // alert("获取文章")
    // 网络请求articles数据
    this.getArticles()
  }
}
</script>

<style scoped>
.el-card {
  border-radius: 0;
}

.el-card:not(:first-child) {
  margin-top: 10px;
}
</style>