<template>
    <div class="dashboard-container">
      <h1>Ajax测试</h1>
      <p>欢迎来到Ajax测试页面！</p>、
      <button @click="fetchData">获取数据</button>
      <p>{{ message }}</p>
    </div>
  </template>
  
  <script setup>
//   import axios from 'axios';
  import { ref } from 'vue';
  const message = ref('Hello, Vue!');
  
  // 获取数据
  const fetchData = () => {

    fetch('http://localhost:8080/api/team/list?userId=123')
      .then(response => response.json())
      .then(data => {
        console.log(data);
        message.value = data.message;
        });

    // axios.get('/api/user')
    //     .then(res => {
    //         console.log(res.data);
    //     })
    //     .catch(err => {
    //         console.error(err);
    //     });

    };


  </script>
  
  <style scoped>
  .dashboard-container {
    padding: 2rem;
  }
  </style> 