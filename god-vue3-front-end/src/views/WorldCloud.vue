<template>
    <div class="wordcloud-container">
      <h2>热词云图</h2>
      <div ref="wordCloud" class="wordcloud"></div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted, onBeforeUnmount } from 'vue'
  import * as echarts from 'echarts'
  import 'echarts-wordcloud'
  
  const wordCloud = ref(null)
  let chart = null
  
  // 示例数据，可替换为你的实际数据
  const words = [
    { name: 'Vue', value: 120 },
    { name: 'ECharts', value: 100 },
    { name: '词云', value: 90 },
    { name: '热度', value: 80 },
    { name: '前端', value: 70 },
    { name: 'JavaScript', value: 60 },
    { name: '组件', value: 50 },
    { name: '可视化', value: 40 },
    { name: '数据', value: 30 },
    { name: '页面', value: 20 },
    { name: '动画', value: 10 }
  ]
  
  onMounted(() => {
    chart = echarts.init(wordCloud.value)
    chart.setOption({
      backgroundColor: '#fff',
      tooltip: {
        show: true,
        formatter: params => `${params.name}: ${params.value}`
      },
      series: [{
        type: 'wordCloud',
        shape: 'circle',
        left: 'center',
        top: 'center',
        width: '100%',
        height: '100%',
        sizeRange: [24, 80],
        rotationRange: [-45, 90],
        rotationStep: 45,
        gridSize: 8,
        drawOutOfBound: false,
        textStyle: {
          fontFamily: 'Impact',
          fontWeight: 'bold',
          color: () => {
            // 渐变色或随机色
            const colors = [
              '#5470C6', '#91CC75', '#FAC858', '#EE6666',
              '#73C0DE', '#3BA272', '#FC8452', '#9A60B4', '#EA7CCC'
            ]
            return colors[Math.floor(Math.random() * colors.length)]
          }
        },
        emphasis: {
          focus: 'self',
          textStyle: {
            shadowBlur: 10,
            shadowColor: '#333',
            color: '#000'
          }
        },
        data: words
      }]
    })
  
    // 响应式自适应
    window.addEventListener('resize', resizeChart)
  })
  
  onBeforeUnmount(() => {
    if (chart) {
      chart.dispose()
    }
    window.removeEventListener('resize', resizeChart)
  })
  
  function resizeChart() {
    if (chart) {
      chart.resize()
    }
  }
  </script>
  
  <style scoped>
  .wordcloud-container {
    max-width: 900px;
    margin: 40px auto;
    background: #f8f9fa;
    border-radius: 16px;
    box-shadow: 0 4px 24px rgba(0,0,0,0.08);
    padding: 32px 24px;
    text-align: center;
  }
  .wordcloud {
    width: 100%;
    height: 500px;
    margin: 0 auto;
  }
  h2 {
    margin-bottom: 24px;
    color: #333;
    font-weight: bold;
    letter-spacing: 2px;
  }
  </style>