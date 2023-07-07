<template>
  <div class="form-wrapper">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item label="姓名">
        <el-input v-model="formInline.name" placeholder="姓名"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="formInline.sex" placeholder="性别">
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
        </el-select>
      </el-form-item>
    </el-form>

    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item label="电话">
        <el-input v-model="formInline.phone_number" placeholder="电话"></el-input>
      </el-form-item>
      <el-form-item label="身份证号">
        <el-input v-model="formInline.card_number" placeholder="电话"></el-input>
      </el-form-item>
    </el-form>

    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item label="民族">
        <el-input v-model="formInline.nation" placeholder="民族"></el-input>
      </el-form-item>
      <el-form-item label="迁出日期">
        <el-input type="date" v-model="formInline.moveing_out" placeholder="迁出日期"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>
  </div>

  <div class="gap"></div> <!-- 间隙 -->

  <div class="form-wrapper">
    <div class="dialog-content" style=" height: 60%">
      <el-table :data="querydata">
        <el-table-column property="id" label="ID" width="50"></el-table-column>
        <el-table-column property="name" label="姓名" width="80"></el-table-column>
        <el-table-column property="sex" label="性别" width="80"></el-table-column>
        <el-table-column property="cardNumber" label="身份证号" width="100"></el-table-column>
        <el-table-column property="phoneNumber" label="电话" width="100"></el-table-column>
        <el-table-column property="nation" label="民族" width="70"></el-table-column>
        <el-table-column property="registered" label="户籍所在地" width="100"></el-table-column>
        <el-table-column property="birthday" label="出生日期" width="100"></el-table-column>
        <el-table-column property="address" label="居住地" width="100"></el-table-column>
        <el-table-column property="movingOut" label="状态" width="100">
          <template #default="scope">
            <el-select v-model="scope.row.movingOut" placeholder="请选择状态">
              <el-option label="迁入" value="迁入"></el-option>
              <el-option label="迁出" value="迁出"></el-option>
            </el-select>
          </template>
        </el-table-column>

        <el-table-column property="reason" label="原因" width="100">
          <template #default="scope">
            <el-input v-model="scope.row.reason" type="text"/>
          </template>
        </el-table-column>

        <el-table-column>
          <template #default="scope">
            <el-button @click="editRow(scope.row)">修改</el-button>
            <el-button @click="deleteRow(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="example-pagination-block">
        <el-pagination
            :total="total"
            :page-sizes="[5, 10, 15]"
            layout="total, sizes, prev, pager, next, jumper"
            :page-size="pageSize"
            :current-page="pageNo"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange">
        </el-pagination>
      </div>
    </div>
  </div>

</template>

<script>
import http from "@/axios/http";
import qs from "qs";

export default {
  data() {
    return {
      formInline: {
        name: '',
        card_number: '',
        sex: '',
        phone_number: '',
        nation: '',
        moveing_out: ''
      },
      querydata: [],
      pageNo: 1,  //第多少页
      pageSize: 5, //一页多少条记录
      total: 1


    }
  },
  methods: {
    onSubmit() {
      console.log(this.formInline)
      let para = {pageNo: this.pageNo, pageSize: this.pageSize}
      this.queryByConditions(para)

    },
    queryByConditions(para) {
      Object.keys(this.formInline).forEach((key) => {
        Reflect.set(para, key, this.formInline[key])
      })
      console.log('queryByConditions', para)
      http.post('/testConn/queryMoveOut', qs.stringify({param: JSON.stringify(para)})).then((res) => {
        //res.data存放后台返回的值
        let data = res.data;
        console.log(data);
        //返回的数据是pageInfo类型
        if (data != null) {
          this.total = data.total;
          this.querydata = data.list;
        }
      })
    },
    deleteRow(Row) {
      console.log(Row)
      let dd = {id: Row.id};
      http.post('/testConn/deleteMoveOut', qs.stringify(dd)).then((res) => {
        // 根据后端返回的结果进行处理
        console.log(res.data)
        if (res.data) {
          // 更新成功，关闭 el-dialog 并重新获取数据
          let para = {pageNo: this.pageNo, pageSize: this.pageSize}
          this.queryByConditions(para);
        } else {
          // 更新失败，显示错误提示或进行其他处理
          this.$message.error('deleteData Fail');
        }
      });
    },
    editRow(Row){
      console.log(Row)
      http.post('/testConn/updateMoveOut', Row).then((res) => {
        // 根据后端返回的结果进行处理
        if (res.data) {
          // 更新成功，关闭 el-dialog 并重新获取数据
          let para = {pageNo: this.pageNo, pageSize: this.pageSize}
          this.queryByConditions(para);
          this.$message.success('updateData success');
        } else {
          // 更新失败，显示错误提示或进行其他处理
          this.$message.error('updateData Fail');
        }
      });
    },
    handleSizeChange(val) {
      this.pageSize = val;
      let para = {pageNo: this.pageNo, pageSize: this.pageSize}
      this.queryByConditions(para);
    },
    handleCurrentChange(val) {
      this.pageNo = val;
      let para = {pageNo: this.pageNo, pageSize: this.pageSize}
      this.queryByConditions(para);
    },

  },
}
</script>

<style>
.form-wrapper {
  display: flex;
  justify-content: center;
}

.gap {
  margin-top: 40px; /* 或者根据需要设置合适的间隙大小 */
}

.dialog-content {
  /*width: 500px; !* 替换为您想要的宽度值 *!*/
  height: 300px; /* 替换为您想要的高度值 */
  overflow: hidden;
}
</style>
