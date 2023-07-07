<template>
  <el-card class="me-area" :body-style="{padding:'16px'}">
    <div class="me-article-header">
      <a @click="view(id)" class="me-article-title">{{ title }}</a>
      <el-button v-if="weight>0" class="me-article-icon" type="link" >置顶</el-button>
      <span class="me-pull-right me-article-count">
        <el-icon><comment/></el-icon>&nbsp;{{ commentCounts }}
			</span>

      <span class="me-pull-right me-article-count">
<!--				<i class="el-icon-view"></i>&nbsp;-->
        <el-icon><View/></el-icon>{{ viewCounts }}

			</span>
    </div>

    <div class="me-article-description">
      {{ summary }}
    </div>

    <div class="me-article-footer">
			<span class="me-article-author">
<!--				<i class="me-icon-author"></i>&nbsp;<el-tag>{{ author }}</el-tag>-->
        <svg t="1688694368620"
             class="icon"
             viewBox="0 0 1024 1024"
             xmlns="http://www.w3.org/2000/svg"
             p-id="3355"
             width="16"
             height="16">
          <path d="M544 126.528c-81.28 0-147.2 64.448-147.2 143.936 0 79.424 65.92 143.872 147.2 143.872 81.28 0 147.2-64.448 147.2-143.872 0-79.488-65.92-143.936-147.2-143.936zM332.8 270.464C332.8 156.416 427.392 64 544 64c116.672 0 211.2 92.416 211.2 206.464 0 100.224-73.152 183.808-170.112 202.496a32.448 32.448 0 0 1-15.488 3.904c-192.256 0-355.648 159.744-377.792 372.288a31.808 31.808 0 0 1-35.072 27.904 31.488 31.488 0 0 1-28.544-34.304c19.328-185.6 136.192-342.08 296.256-402.112A204.928 204.928 0 0 1 332.8 270.4z m580.864 328.832L823.936 512c-37.888-36.8-71.872 0-71.872 0l-233.344 226.944-0.32 156.544 161.92 0.512 233.344-226.88s32.192-38.528 0-69.824z m-341.504 157.44l4.032-3.968 87.936 86.656-4.032 3.968-88.32-0.32 0.384-86.4z m42.368-41.728l152-149.888c9.216-9.024 22.144-11.008 34.24 0.896l52.8 52.032c12.16 11.968 10.048 24.704 0.896 33.792l-152 149.76-87.936-86.592z" fill="#5A5A5A" p-id="3356">
        </path>
        </svg>
        by {{authorId}}
			</span>

      <el-tag  size="mini" type="success">springboot</el-tag>
<!--      <el-tag v-for="t in tags" :key="t.tagName" size="mini" type="success">{{ t.tagName }}</el-tag>-->

      <span class="me-pull-right me-article-count">
        <el-icon><Clock /></el-icon>{{ formattedDate }}

			</span>

    </div>
  </el-card>
</template>

<script>
import {formatTime} from "../../util/time"

export default {
  name: "ArticleItem",
  props: {
    id: String,
    weight: Number,
    title: String,
    commentCounts: Number,
    viewCounts: Number,
    summary: String,
    authorId: String,
    tags: Array,
    createDate: String
  },
  computed: {
    formattedDate() {
      return formatTime(this.createDate);
    },
  },
  data() {
    return {}
  },
  methods: {
    view(id) {
      this.$router.push(`/view/${id}`);
    }

  }
}
</script>

<style scoped>
.me-article-header {
  padding-bottom: 10px;
}

.me-article-title {
  font-weight: 600;
}

.me-article-icon {
  padding: 3px 8px;
}

.me-article-count {
  color: #0bfab2;
  padding-left: 14px;
  font-size: 13px;
}

.me-pull-right {
  float: right;
}

.me-article-description {
  font-size: 13px;
  line-height: 24px;
  margin-bottom: 10px;
}

.me-article-author {
  color: #06f879;
  padding-right: 18px;
  font-size: 13px;
}

.el-tag {
  margin-left: 6px;
  color: #ffffff;
  background-color: #0bfab2;
}

.me-area {
  border-radius: 10px; /* 设置圆角 */
  /*margin-left: ;: 10px; !* 设置外边距 *!*/
}

</style>