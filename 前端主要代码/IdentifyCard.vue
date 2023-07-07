<template>
  <!--  身份证件查询表单-->
  <el-form
      :model="numberValidateForm"
      ref="numberValidateForm"
      label-width="100px"
      style="width: 450px;"
      class="demo-ruleForm">

    <!--   根据id查询 /-->
    <el-form-item
        label="ID"
        prop="id">
      <el-input
          type="number"
          v-model=numberValidateForm.id
          autocomplete="off"
      ></el-input>
    </el-form-item>

    <!--    根据cardNumber查询-->
    <el-form-item
        label="身份证号"
        prop="cardNumber"
        style="width: 300px;"
        :rules="[
      // { required: true, message: '身份证号不能为空'},
      { min: 15, max: 18, message: '身份证号长度最长 18 位' },
      { pattern: /^[1-9]\d{5}(18|19|20)\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])\d{3}[0-9Xx]$/, message: '身份证号必须为数字或字母' }
    ]">
      <el-input
          type="age"
          v-model.number="numberValidateForm.cardNumber"
          autocomplete="off">
      </el-input>
    </el-form-item>

    <!--   根据name查询 /-->
    <el-form-item
        label="姓名"
        prop="name"
        :rules="[
            { min: 1, max: 10, message: '姓名长度超出' },
        ]">
      <el-input
          type="name"
          v-model=numberValidateForm.name
          autocomplete="off">
      </el-input>
    </el-form-item>

    <!--   根据birthdate查询 /-->
    <!--        <el-form-item-->
    <!--            label="出生日期"-->
    <!--            prop="birthdate">-->
    <!--          <el-input-->
    <!--              type="date"-->
    <!--              v-model=numberValidateForm.birthdate-->
    <!--              autocomplete="off">-->
    <!--          </el-input>-->
    <!--        </el-form-item>-->

    <!--   根据address查询 /-->
    <el-form-item
        label="地址"
        prop="address">
      <el-input
          type="address"
          v-model=numberValidateForm.address
          autocomplete="off"
      ></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('numberValidateForm')">查询</el-button>
      <el-button @click="resetForm('numberValidateForm')">重置</el-button>
      <el-button type="success" round @click="dialogFormVisible = true" size="large">办理表单的 Dialog</el-button>
    </el-form-item>

  </el-form>

  <!--  按钮显示-->
  <el-button type="text" @click="openDialog">打开嵌套表格的 Dialog</el-button>
  <!--查询记录表格-->
  <el-dialog ref="dialogContent" title="查询信息" v-model="dialogTableVisible" width="1100">
    <div class="dialog-content" style=" height: 60%">
      <el-table :data="querydata">
        <el-table-column property="id" label="ID" width="50"></el-table-column>
        <el-table-column property="cardNumber" label="身份证号" width="170"></el-table-column>
        <el-table-column property="name" label="姓名" width="80"></el-table-column>
        <el-table-column property="address" label="地址" width="80"></el-table-column>
        <el-table-column property="birthdate" label="出生日期" width="150"></el-table-column>

        <el-table-column property="status" label="状态" width="130">
          <template #default="scope">
            <el-select v-model="scope.row.status" placeholder="请选择状态">
              <el-option label="Active" value="Active"></el-option>
              <el-option label="Pending" value="Pending"></el-option>
              <el-option label="Destroy" value="Destroy"></el-option>
            </el-select>
          </template>
        </el-table-column>
        <el-table-column property="createdAt" label="创建时间" width="100"></el-table-column>
        <el-table-column property="updatedAt" label="修改时间" width="100"></el-table-column>
        <el-table-column>
          <template #default="scope">
            <el-button @click="editRow(scope.row)">补办</el-button>
            <el-button @click="deleteRow(scope.row)">销毁</el-button>
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
  </el-dialog>

  <!--  表单dialog/-->
  <el-dialog title="办理身份证" v-model="dialogFormVisible">
    <el-form
        ref="processValidateForm"
        :model="processValidateForm">
      <el-form-item label="身份证号"
                    prop="cardNumber"
                    :label-width='120'
                    :rules="[
      // { pattern: /^[1-9]\d{5}(18|19|20)\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])\d{3}[0-9Xx]$/, message: '身份证号必须为数字或字母' }
      { required: true, message: '身份证号不能为空'},
      // { min: 15, max: 18, message: '身份证号长度不对' },
    ]">
        <el-input v-model="processValidateForm.cardNumber" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item label="姓名"
                    prop="name"
                    :label-width='120'
                    :rules="[
            { required: true, message: '姓名不能为空'},
            { min: 1, max: 10, message: '姓名长度超出' },
        ]">
        <el-input v-model="processValidateForm.name" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item label="生日"
                    prop="birthdate"
                    :label-width='120'
                    type="date"
                    :rules="[
            { required: true, message: '生日不能为空'},
        ]">
        <el-input type="date" v-model="processValidateForm.birthdate" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item label="地址"
                    prop="address"
                    :label-width='120'
                    :rules="[
            { required: true, message: '地址不能为空'},
        ]">
        <el-input v-model="processValidateForm.address" autocomplete="off"></el-input>
      </el-form-item>



    </el-form>
    <template #footer>
    <span class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="processForm('processValidateForm')">确定</el-button>
    </span>
    </template>
  </el-dialog>

</template>

<script>
import http from "@/axios/http";
import qs from "qs";

export default {
  data() {
    return {
      numberValidateForm: {
        id: '',
        cardNumber: '',
        name: '谢枞',
        // birthdate: '',
        address: ''
      },
      dialogTableVisible: false,
      querydata: [],// 完整的数据列表
      pageNo: 1,  //第多少页
      pageSize: 5, //一页多少条记录
      total: 1,
      queryInfo: {},
      dialogFormVisible: false,
      processValidateForm: {
        cardNumber: '',
        name: '',
        birthdate: '',
        address: '',
        status: 'Active'
      }

    }
  },

  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(this.numberValidateForm)
          // 如果校验成功，准备发起网络请求
          // this.$message("success submit")
          let para = {pageNo: this.pageNo, pageSize: this.pageSize}
          this.queryByConditions(para)
        } else {
          this.$message.error('请规范填写');
          console.log('error submit!!')
          // return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    openDialog() {
      this.dialogTableVisible = true
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
    queryByConditions(para) {
      Object.keys(this.numberValidateForm).forEach((key) => {
        Reflect.set(para, key, this.numberValidateForm[key])
      })
      console.log('queryByConditions', para)
      http.post('/testConn/queryByConditions', qs.stringify({param: JSON.stringify(para)})).then((res) => {
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
    processForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(this.processValidateForm)
          // 如果校验成功，准备发起网络请求,插入数据
          http.post('/testConn/insertIDCard', this.processValidateForm).then((res) => {
            //res.data存放后台返回的值
            let data = res.data;
            console.log(data);
            if (data == true) {
              this.$message.success("办理成功")
              this.dialogFormVisible = false
            } else {
              this.$message.error('办理失败');
            }
          })
        } else {
          this.$message.error('请规范填写');
          console.log('error submit!!')
        }
      })
    },
    editRow(Row) {
      console.log(Row)
      http.post('/testConn/updateIDcard', Row).then((res) => {
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
    deleteRow(Row) {
      console.log(Row)
      let dd = {id: Row.id};
      http.post('/testConn/deleteIDCard', qs.stringify(dd)).then((res) => {
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

  },


}
</script>

<style>
.dialog-content {
  /*width: 500px; !* 替换为您想要的宽度值 *!*/
  height: 300px; /* 替换为您想要的高度值 */
  overflow: hidden;
}
</style>
