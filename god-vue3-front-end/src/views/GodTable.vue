<template>
  <div class="user-list">
    <el-card>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="姓名" />
        <el-table-column prop="email" label="邮箱" />
        <el-table-column label="操作" width="120">
          <template #default="scope">
            <el-button type="text" size="small" @click="handleEdit(scope.row)">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { ElMessage } from 'element-plus'

// 模拟数据或实际可通过 API 获取
const tableData = ref([])

const fetchData = async () => {
  // 模拟请求
  tableData.value = [
    { id: 1, name: '张三', email: 'zhangsan@example.com' },
    { id: 2, name: '李四', email: 'lisi@example.com' },
    { id: 2, name: '李四', email: 'lisi@example.com' },
    { id: 2, name: '李四', email: 'lisi@example.com' },
    { id: 2, name: '李四', email: 'lisi@example.com' },
    { id: 2, name: '李四', email: 'lisi@example.com' },
    { id: 2, name: '李四', email: 'lisi@example.com' },
    { id: 2, name: '李四', email: 'lisi@example.com' },
    { id: 2, name: '李四', email: 'lisi@example.com' },
    { id: 2, name: '李四', email: 'lisi@example.com' },
    { id: 2, name: '李四', email: 'lisi@example.com' },
    { id: 2, name: '李四', email: 'lisi@example.com' },
    { id: 2, name: '李四', email: 'lisi@example.com' },
  ]
}

const handleEdit = (row) => {
  ElMessage.info(`你点击了编辑：${row.name}`)
}

onMounted(() => {
  fetchData()
})
</script>

<style scoped>
.user-list {
  padding: 20px;
}
</style>