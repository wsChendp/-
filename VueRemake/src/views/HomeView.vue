<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <div>
    <el-container style="height:100%">
      <!--      <el-aside width="sideWidth + 'px'" style="background-color: rgb(238, 241, 246); height: 100%">-->
      <!--        <el-menu :default-openeds="['1', '3']" style="height:100%"-->
      <!--                 background-color="rgb(48,65,86)"-->
      <!--                 text-color="#fff"-->
      <!--                 active-text-color="#ffd04b"-->
      <!--                 :collapse-transtion="false"-->
      <!--                 :collapse="isCollapse"-->
      <!--                 class="el-menu-vertical-demo">-->
      <!--          <div style="height: 100%;line-height: 60px; text-align: center">-->
      <!--            <b style="color: white" v-show="LogoTextShow">后台管理系统</b>-->
      <!--          </div>-->
      <!--          <el-submenu index="1">-->
      <!--            <template slot="title"><i class="el-icon-message"></i>-->
      <!--              <span slot="title">导航一</span>-->
      <!--            </template>-->
      <!--            <el-menu-item-group>-->
      <!--              <template slot="title">分组一</template>-->
      <!--              <el-menu-item index="1-1">选项1</el-menu-item>-->
      <!--              <el-menu-item index="1-2">选项2</el-menu-item>-->
      <!--            </el-menu-item-group>-->
      <!--            <el-menu-item-group title="分组2">-->
      <!--              <el-menu-item index="1-3">选项3</el-menu-item>-->
      <!--            </el-menu-item-group>-->
      <!--            <el-submenu index="1-4">-->
      <!--              <template slot="title">选项4</template>-->
      <!--              <el-menu-item index="1-4-1">选项4-1</el-menu-item>-->
      <!--            </el-submenu>-->
      <!--          </el-submenu>-->
      <!--          <el-submenu index="2">-->
      <!--            <template slot="title"><i class="el-icon-menu"></i>-->
      <!--              <span slot="title">导航二</span>-->
      <!--            </template>-->
      <!--            <el-menu-item-group>-->
      <!--              <template slot="title">分组一</template>-->
      <!--              <el-menu-item index="2-1">选项1</el-menu-item>-->
      <!--              <el-menu-item index="2-2">选项2</el-menu-item>-->
      <!--            </el-menu-item-group>-->
      <!--            <el-menu-item-group title="分组2">-->
      <!--              <el-menu-item index="2-3">选项3</el-menu-item>-->
      <!--            </el-menu-item-group>-->
      <!--            <el-submenu index="2-4">-->
      <!--              <template slot="title">选项4</template>-->
      <!--              <el-menu-item index="2-4-1">选项4-1</el-menu-item>-->
      <!--            </el-submenu>-->
      <!--          </el-submenu>-->
      <!--          <el-submenu index="3">-->
      <!--            <template slot="title"><i class="el-icon-setting"></i>-->
      <!--              <span slot="title">导航三</span>-->
      <!--            </template>-->
      <!--            <el-menu-item-group>-->
      <!--              <template slot="title">分组一</template>-->
      <!--              <el-menu-item index="3-1">选项1</el-menu-item>-->
      <!--              <el-menu-item index="3-2">选项2</el-menu-item>-->
      <!--            </el-menu-item-group>-->
      <!--            <el-menu-item-group title="分组2">-->
      <!--              <el-menu-item index="3-3">选项3</el-menu-item>-->
      <!--            </el-menu-item-group>-->
      <!--            <el-submenu index="3-4">-->
      <!--              <template slot="title">cdpp</template>-->
      <!--              <el-menu-item index="3-4-1">选项4-1</el-menu-item>-->
      <!--            </el-submenu>-->
      <!--          </el-submenu>-->
      <!--        </el-menu>-->
      <!--      </el-aside>-->

      <el-container>
        <el-header style="font-size: 12px; border-bottom: 1px solid #ccc; line-height: 60px;display:flex">
          <div style="flex: 1; font-size: 18px">
            <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
          </div>

          <el-dropdown style="width: 100px; cursor: pointer">
            <span>cdp2022150094</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>

        </el-header>

        <el-main>
          <div style="margin-bottom: 30px">
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item>用户管理</el-breadcrumb-item>

            </el-breadcrumb>
          </div>
          <div style="padding: 10px 0">
            <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="ei-icon-search"
                      v-model="age"></el-input>
            <!--            <el-input style="width: 200px" placeholder="请输入邮箱" suffix-icon="ei-icon-search"-->
            <!--                      class="ml-5"></el-input>-->
            <!--            <el-input style="width: 200px" placeholder="请输入地址" suffix-icon="ei-icon-search"-->
            <!--                      class="ml-5"></el-input>-->
            <el-button style="margin-left: 5px" type="primary" @click="ListAllCustomers">看看所有</el-button>
            <el-button style="margin-left: 5px" type="primary" @click="getHealthPerson">找出健康人</el-button>
            <el-button style="margin-left: 5px" type="primary" @click="OverAge">OverAge</el-button>
            <el-button style="margin-left: 5px" type="primary" @click="getPersonNum">教练的客户</el-button>
            <el-button style="margin-left: 5px" type="primary" @click="getTeenage">查出年轻人</el-button>
            <el-button style="margin-left: 5px" type="primary" @click="culCoachIncome">教练赚的钱</el-button>
            <el-button style="margin-left: 5px" type="warning" @click="reset">重置</el-button>
          </div>
          <div style="margin: 10px 0">
            <el-button type="primary" @click="handleAdd" style="margin-left: 5px">新增</el-button>
            <el-button type="primary" @click="delBatch" style="margin-left: 5px">批量删除</el-button>
            <!--            <el-button type="primary" style="margin-left: 5px">导入</el-button>-->
            <!--            <el-button type="primary" style="margin-left: 5px">导出</el-button>-->
          </div>

          <el-table :data="tableData" border stripe @selection-change="handleSelectionChange">
            <el-table-column
                type="selection"
                width="55">
            </el-table-column>
            <!--            <el-table-column prop="id" label="ID" width="80"></el-table-column>-->
            <el-table-column v-if="showIdColumn" prop="id" label="ID"></el-table-column>
            <el-table-column v-if="showNameColumn" prop="name" label="用户名" width="140"></el-table-column>
            <el-table-column v-if="showPTLastNameColumn" prop="PTLastname" label="PTLastName"
                             width="80"></el-table-column>
            <el-table-column v-if="showPTFirstNameColumn" prop="PTFirstname" label="PTFirstName"
                             width="80"></el-table-column>
            <el-table-column v-if="showCoachNameColumn" prop="coachName" label="教练名字"></el-table-column>
            <el-table-column v-if="showFitnessColumn" prop="fitness" label="健康水平"></el-table-column>

            <el-table-column v-if="showMedicalHistoryColumn" prop="medicalhistory" label="药物历史"></el-table-column>
            <el-table-column v-if="showExerciseHistoryColumn" prop="exercisehistory" label="运动历史"></el-table-column>
            <el-table-column v-if="showFirstNameColumn" prop="firstname" label="姓" width="80"></el-table-column>
            <el-table-column v-if="showLastNameColumn" prop="lastname" label="名" width="80"></el-table-column>
            <el-table-column v-if="showPlanColumn" prop="level" label="计划"></el-table-column>
            <el-table-column v-if="showPriceColumn" prop="price" label="每月收入"></el-table-column>
            <el-table-column v-if="showCustomerColumn" prop="customers_num" label="客户数量"></el-table-column>
            <el-table-column v-if="showAddressColumn" prop="address" label="地址"></el-table-column>
            <el-table-column v-if="showBirthdayColumn" prop="birthday" label="生日"></el-table-column>
            <el-table-column v-if="showEmailColumn" prop="email" label="邮件"></el-table-column>
            <el-table-column v-if="showFitnessColumn" prop="fitness" label="健康水平"></el-table-column>
            <el-table-column v-if="showPhoneColumn" prop="phone" label="手机号码"></el-table-column>


            <el-table-column>

              <template v-if="showActions" v-slot:default="scope">
                <el-button type="success" size="small" @click="handleEdit(scope.row)">编辑</el-button>
                <el-popconfirm
                    class="margin-left: 20px"
                    confirm-button-text='确定'
                    cancel-button-text='我再想想'
                    icon="el-icon-info"
                    icon-color="red"
                    title="您确定删除吗？"
                    @confirm="del(scope.row.id)">
                  <el-button type="danger" slot="reference">删除</el-button>
                </el-popconfirm>
              </template>

            </el-table-column>
          </el-table>

          <!--          <div style="padding: 10px 0">-->
          <!--            <el-pagination-->
          <!--                @size-change="handleSizeChange"-->
          <!--                @current-change="handleCurrentChange"-->
          <!--                :current-page="pageNum"-->
          <!--                :page-sizes="[2, 5, 10, 20]"-->
          <!--                :page-size="pageSize"-->
          <!--                layout="total, sizes, prev, pager, next, jumper"-->
          <!--                :total="total">-->
          <!--            </el-pagination>-->
          <!--          </div>-->

          <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width="30%">
            <el-form lable-width="100px" size="small">
              <el-form-item label="用户名">
                <el-input v-model="form.name" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="姓">
                <el-input v-model="form.firstname" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="名">
                <el-input v-model="form.lastname" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="地址">
                <el-input v-model="form.address" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="手机号">
                <el-input v-model="form.phone" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="邮箱">
                <el-input v-model="form.email" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="生日">
                <el-input v-model="form.birthday" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="运动历史">
                <el-input v-model="form.exercisehistory" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="身体状况">
                <el-input v-model="form.fitness" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="药物使用">
                <el-input v-model="form.medicalhistory" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="教练姓名">
                <el-input v-model="form.coachName" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="等级选择">
                <el-input v-model="form.level" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="save">确 定</el-button>
            </div>
          </el-dialog>

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>


<script>


export default {
  name: 'HomeView',
  data() {
    return {
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 5,
      age: 10,
      name: "",
      email: "",
      address: "",
      birthday: "",
      customers_num: "",
      coach: "",
      coachName: "",
      level: "",
      exercisehistory:"",
      fitness: "",
      price: "",
      PTLastName: "",
      PTFirstName: "",
      firstname: "",
      lastname: "",
      multipleSelection: [],
      form: {},
      dialogFormVisible: false,
      msg: "hello bro",
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false,
      sideWidth: 200,
      LogoTextShow: true,
      showNameColumn: false,
      showFirstNameColumn: false,
      showLastNameColumn: false,
      showAddressColumn: false,
      showPhoneColumn: false,
      showEmailColumn: false,
      showBirthdayColumn: false,
      showExerciseHistoryColumn: false,
      showFitnessColumn: false,
      showMedicalHistoryColumn: false,
      showIdColumn: false,
      showCustomerColumn: false,
      showCoachNameColumn: false,
      showPlanColumn: false,
      showPTFirstNameColumn: false,
      showPTLastNameColumn: false,
      showPriceColumn: false,
      showActions: true
    }
  },
  // 页面打开时自动调用的方法（类似构造函数）,有跨域的问题
  created() {
    this.load()
  },
  methods: {
    collapse() { //点击收缩触发
      this.isCollapse = !this.isCollapse;
      if (this.isCollapse) {
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-fold'
        this.LogoTextShow = false
      } else {
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.LogoTextShow = true
      }
    },
    getHealthPerson() {
      this.resetColumn();
      this.VO_gethealthperson();
      this.request.get('/Customer/getHealthPerson')
          .then((res) => {
            console.log(res);
            // 处理响应数据
            this.tableData = res.map((item) => {
              return {
                id: item.id,
                name: item.name,
                firstname: item.firstname,
                lastname: item.lastname,
                address: item.address,
                // 其他字段
              };
            });
          })
          .catch((error) => {
            console.error(error);
          });
    },
    culCoachIncome() {
      this.resetColumn();
      this.VO_getCoachIncome();
      this.request.get('/Coach/CoachIncome')
          .then((res) => {
            console.log(res);
            // 处理响应数据
            this.tableData = res.map((item) => {
              return {
                PTLastname: item.ptlastName,
                PTFirstname: item.ptfirstName,
                firstname: item.firstName,
                lastname: item.lastName,
                level: item.level,
                price: item.listNum === 0 ? null : item.listNum,
                // 其他字段
              };
            });
          })
          .catch((error) => {
            console.error(error);
          });

    },
    getPersonNum() {
      this.resetColumn();
      this.VO_getPersonNum();
      this.request.get('/Coach/CulPersonNum')
          .then((res) => {
            console.log(res);
            // 处理响应数据
            this.tableData = res.map((item) => {
              return {
                id: item.id,
                name: item.name,
                firstname: item.firstname,
                lastname: item.lastname,
                customers_num: item.customers_num
                // 其他字段
              };
            });
          })
          .catch((error) => {
            console.error(error);
          });
    },
    getTeenage() {
      this.resetColumn();
      this.VO_overage();
      this.request.get("/Customer/getTeenage")
          .then((res) => {
            console.log(res);
            // 处理响应数据
            this.tableData = res.map((item) => {
              const temp = new Date(item.birthday).toLocaleDateString('zh-CN', {
                year: 'numeric',
                month: '2-digit',
                day: '2-digit',
              });
              const dateParts = temp.toString().split('/');
              const year = dateParts[0];
              const month = String(dateParts[1]).padStart(2, '0');
              const day = String(dateParts[2]).padStart(2, '0');
              const formattedBirthday = `${year}-${month}-${day}`;
              return {
                id: item.id,
                name: item.name,
                firstname: item.firstname,
                lastname: item.lastname,
                address: item.address,
                birthday: formattedBirthday,
                email: item.email
                // 其他字段
              };
            });
          })
    },
    ListAllCustomers() {
      this.resetColumn();
      this.Vo_ListAllCustomers();
      this.request.get("/Customer/ListAllCustomers")
          .then((res) => {
            console.log(res);
            // 处理响应数据
            this.tableData = res.map((item) => {
              const temp = new Date(item.birthday).toLocaleDateString('zh-CN', {
                year: 'numeric',
                month: '2-digit',
                day: '2-digit',
              });
              const dateParts = temp.toString().split('/');
              const year = dateParts[0];
              const month = String(dateParts[1]).padStart(2, '0');
              const day = String(dateParts[2]).padStart(2, '0');
              const formattedBirthday = `${year}-${month}-${day}`;
              return {
                id: item.id,
                name: item.name,
                firstname: item.firstname,
                lastname: item.lastname,
                address: item.address,
                birthday: formattedBirthday,
                email: item.email,
                coachName: item.coachName,
                phone: item.phone,
                level: item.level,
                fitness: item.fitness,
                medicalhistory: item.medicalhistory,
                exercisehistory: item.exercisehistory
                // 其他字段
              };
            });
          })

    },
    load() {
      this.resetColumn();
      this.Vo_ListAllCustomers();
      this.ListAllCustomers();
    },

    save() {
      this.request.post("/Customer/Insert", this.form)
          .then(res => {
            console.log(res);
            this.$message.success("保存成功")
          })
      this.dialogFormVisible = false;
      this.load();
    },

    reset() {
      this.name = ""
      this.email = ""
      this.address = ""
      this.load()
    },
    OverAge() {
      this.resetColumn();
      this.VO_overage();
      this.request.get("/Customer/OverAge", {params: {age: this.age}})
          .then((res) => {
            console.log(res);
            // 处理响应数据
            this.tableData = res.map((item) => {
              const temp = new Date(item.birthday).toLocaleDateString('zh-CN', {
                year: 'numeric',
                month: '2-digit',
                day: '2-digit',
              });
              const dateParts = temp.toString().split('/');
              const year = dateParts[0];
              const month = String(dateParts[1]).padStart(2, '0');
              const day = String(dateParts[2]).padStart(2, '0');
              const formattedBirthday = `${year}-${month}-${day}`;
              return {
                id: item.id,
                name: item.name,
                firstname: item.firstname,
                lastname: item.lastname,
                address: item.address,
                birthday: formattedBirthday,
                email: item.email
                // 其他字段
              };
            });
          })
    },

    del(id) {
      this.id = id;
      this.request.delete("Customer/delCustomer", {params: {id: this.id}})
          .then(res => {
            console.log(res);
            if (res) {
              this.getTeenage();
              this.$message.success("删除成功")
            } else {
              this.$message.error("删除失败")
            }
          })
      this.load()
    },

    handleEdit(row) {
      this.form = row
      this.dialogFormVisible = true
      this.load()
    },

    handleAdd() {
      this.dialogFormVisible = true;
    },
    // eslint-disable-next-line no-unused-vars
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum
      this.load()
    },
    // handleSizeChange(pageSize) {
    //   this.pageSize = pageSize
    //   this.load()
    // },
    handleSelectionChange(val) {
      this.multipleSelection = val
    },
    delBatch() {
      let ids = this.multipleSelection.map(v => v.id)
      this.request.post("/Customer/delTeenage", ids).then(res => {
        if (res) {
          this.$message.success("删除成功")
          this.load()
        } else {
          this.$message.error("删除失败")
        }
      })
    },

    VO_overage() {
      this.showIdColumn = true;
      this.showNameColumn = true;
      this.showLastNameColumn = true;
      this.showFirstNameColumn = true;
      this.showEmailColumn = true;
      this.showAddressColumn = true;
      this.showBirthdayColumn = true;
      this.showIdColumn = true;
    },
    VO_gethealthperson() {
      this.showIdColumn = true;
      this.showNameColumn = true;
      this.showLastNameColumn = true;
      this.showFirstNameColumn = true;
      this.showAddressColumn = true;
    },
    VO_getPersonNum() {
      this.showNameColumn = true;
      this.showFirstNameColumn = true;
      this.showLastNameColumn = true;
      this.showCustomerColumn = true;
    },

    VO_getCoachIncome() {
      this.showActions = false;
      this.showPTLastNameColumn = true;
      this.showPTFirstNameColumn = true;
      this.showFirstNameColumn = true;
      this.showLastNameColumn = true;
      this.showPlanColumn = true;
      this.showPriceColumn = true;
    },

    resetColumn() {
      this.showNameColumn = false;
      this.showFirstNameColumn = false;
      this.showLastNameColumn = false;
      this.showAddressColumn = false;
      this.showPhoneColumn = false;
      this.showEmailColumn = false;
      this.showBirthdayColumn = false;
      this.showExerciseHistoryColumn = false;
      this.showFitnessColumn = false;
      this.showMedicalHistoryColumn = false;
      this.showIdColumn = false;
      this.showCustomerColumn = false;
      this.showCoachNameColumn = false;
      this.showPlanColumn = false;
      this.showPTFirstNameColumn = false;
      this.showPTLastNameColumn = false;
      this.showPriceColumn = false;
    },
    Vo_ListAllCustomers() {
      this.showActions = true;
      this.showIdColumn = true;
      this.showNameColumn = true;
      this.showLastNameColumn = true;
      this.showFirstNameColumn = true;
      this.showEmailColumn = true;
      this.showFitnessColumn = true;
      this.showAddressColumn = true;
      this.showBirthdayColumn = true;
      this.showIdColumn = true;
      this.showPhoneColumn = true;
      this.showFitnessColumn = true;
      this.showMedicalHistoryColumn = true;
      this.showCoachNameColumn = true;
      this.showPlanColumn = true;
      this.showExerciseHistoryColumn = true;
    }
  }
}
</script>