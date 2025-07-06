<template>
  <div class="question-table-container">
    <div class="filter-bar">
      <el-button type="success" @click="dialogVisible = true" style="margin-right: 24px;">
        添加难点问题
      </el-button>
      <el-input v-model="search" placeholder="搜索问题标题..." clearable style="width: 220px; margin-right: 16px;" />
      <el-select v-model="selectedTag" placeholder="选择标签" clearable style="width: 160px; margin-right: 16px;">
        <el-option v-for="tag in tagOptions" :key="tag" :label="tag" :value="tag" />
      </el-select>
      <el-button @click="sortDesc = !sortDesc" type="primary" plain>
        按热度{{ sortDesc ? '降序' : '升序' }}
      </el-button>
    </div>
    <el-table :data="filteredQuestions" style="width: 100%; margin-top: 20px;">
      <el-table-column prop="subject" label="科目" min-width="120" />
      <el-table-column prop="block" label="板块" min-width="120" />
      <el-table-column prop="detail" label="难点" min-width="200" />
      <el-table-column prop="hot" label="热度" width="100" sortable />
      <el-table-column prop="tags" label="标签" min-width="120">
        <template #default="scope">
          <el-tag v-for="tag in scope.row.tags" :key="tag" size="small" style="margin-right: 4px;">{{ tag }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="time" label="时间" width="160" />
    </el-table>
    <el-dialog v-model="dialogVisible" title="添加难点问题" width="420px">
      <el-form :model="form" label-width="80px">
        <el-form-item label="科目">
          <el-input v-model="form.subject" />
        </el-form-item>
        <el-form-item label="板块">
          <el-input v-model="form.block" />
        </el-form-item>
        <el-form-item label="难点">
          <el-input v-model="form.detail" />
        </el-form-item>
        <el-form-item label="热度">
          <el-input-number v-model="form.hot" :min="0" />
        </el-form-item>
        <el-form-item label="标签">
          <el-select v-model="form.tags" multiple placeholder="请选择标签">
            <el-option v-for="tag in tagOptions" :key="tag" :label="tag" :value="tag" />
          </el-select>
        </el-form-item>
        <el-form-item label="时间">
          <el-date-picker v-model="form.time" type="date" value-format="YYYY-MM-DD" placeholder="选择日期" />
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="handleAdd">添加</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
// 如果未全局引入 Element Plus 组件库，请在 main.js 中引入
// import 'element-plus/dist/index.css'

const search = ref('')
const selectedTag = ref('')
const sortDesc = ref(true)
const dialogVisible = ref(false)
const form = ref({
  subject: '',
  block: '',
  detail: '',
  hot: 0,
  tags: [],
  time: ''
})

// 示例数据，可替换为实际接口数据
const questions = ref([
  {
    subject: '数学',
    block: '函数与导数',
    detail: '导数的几何意义',
    hot: 150,
    tags: ['高考', '必修'],
    time: '2024-06-01'
  },
  {
    subject: '物理',
    block: '力学',
    detail: '动量守恒定律',
    hot: 120,
    tags: ['高考', '选修'],
    time: '2024-06-02'
  },
  {
    subject: '化学',
    block: '有机化学',
    detail: '烷烃的命名',
    hot: 110,
    tags: ['高考', '基础'],
    time: '2024-06-03'
  },
  {
    subject: '英语',
    block: '语法',
    detail: '虚拟语气',
    hot: 95,
    tags: ['高考', '语法'],
    time: '2024-06-04'
  },
  {
    subject: '生物',
    block: '遗传与变异',
    detail: '基因重组',
    hot: 80,
    tags: ['高考', '实验'],
    time: '2024-06-05'
  },
  {
    subject: '历史',
    block: '中国近代史',
    detail: '鸦片战争',
    hot: 70,
    tags: ['高考', '必修'],
    time: '2024-06-06'
  },
  {
    subject: '地理',
    block: '自然地理',
    detail: '板块构造学说',
    hot: 65,
    tags: ['高考', '地理'],
    time: '2024-06-07'
  }
])

const tagOptions = computed(() => {
  const set = new Set()
  questions.value.forEach(q => q.tags.forEach(tag => set.add(tag)))
  return Array.from(set)
})

const filteredQuestions = computed(() => {
  let result = questions.value
  if (search.value) {
    result = result.filter(q =>
      (q.subject && q.subject.includes(search.value)) ||
      (q.block && q.block.includes(search.value)) ||
      (q.detail && q.detail.includes(search.value))
    )
  }
  if (selectedTag.value) {
    result = result.filter(q => q.tags.includes(selectedTag.value))
  }
  result = result.slice().sort((a, b) => sortDesc.value ? b.hot - a.hot : a.hot - b.hot)
  return result
})

function handleAdd() {
  if (!form.value.subject || !form.value.block || !form.value.detail || !form.value.time) {
    // 简单校验
    return
  }
  questions.value.push({
    subject: form.value.subject,
    block: form.value.block,
    detail: form.value.detail,
    hot: form.value.hot,
    tags: form.value.tags.slice(),
    time: form.value.time
  })
  dialogVisible.value = false
  form.value.subject = ''
  form.value.block = ''
  form.value.detail = ''
  form.value.hot = 0
  form.value.tags = []
  form.value.time = ''
}
</script>

<style scoped>
.question-table-container {
  max-width: 1400px;
  min-height: 70vh;
  margin: 40px auto;
  background: #23272e;
  border-radius: 18px;
  box-shadow: 0 2px 32px rgba(0,0,0,0.22);
  padding: 48px 36px;
  color: #fff;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.filter-bar {
  display: flex;
  align-items: center;
  margin-bottom: 18px;
}
:deep(.el-table) {
  background: #23272e;
  color: #fff;
}
:deep(.el-table th) {
  background: #23272e;
  color: #90caf9;
}
:deep(.el-table tr) {
  background: #23272e;
}
:deep(.el-table__body tr:hover) {
  background: #2a2f38;
}
:deep(.el-input__wrapper),
:deep(.el-select .el-input__wrapper) {
  background: #23272e;
  color: #fff;
  border: 1px solid #444;
}
:deep(.el-input__inner),
:deep(.el-select__selected-item) {
  color: #fff;
}
:deep(.el-tag) {
  background: #2a2f38;
  color: #90caf9;
  border: none;
}
:deep(.el-button) {
  background: #23272e;
  color: #90caf9;
  border: 1px solid #90caf9;
}
:deep(.el-button:hover) {
  background: #2a2f38;
  color: #fff;
  border: 1px solid #fff;
}
</style>