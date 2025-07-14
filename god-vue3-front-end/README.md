# god-vue3-front-end

This template should help get you started developing with Vue 3 in Vite.

## Recommended IDE Setup

[VSCode](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) (and disable Vetur).

## Customize configuration

See [Vite Configuration Reference](https://vite.dev/config/).

## Project Setup

```sh
npm install
```

### Compile and Hot-Reload for Development

```sh
npm run dev
```

### Compile and Minify for Production

```sh
npm run build
```

### Lint with [ESLint](https://eslint.org/)

```sh
npm run lint
```

## 2024-05-10
- 在 `vite.config.js` 中添加了 `server.proxy` 配置，实现 `/api` 接口代理到 `http://backend.example.com`，便于前后端分离开发。

## AJAX 测试页面

新增了 `AJAX 测试页面`（/ajax-test 路由），用于演示和测试三种常用AJAX请求方式：fetch、axios、XMLHttpRequest（XHR），并展示了AJAX的异步特性。

### 功能说明
- 分别测试 fetch、axios、xhr 三种请求方法，点击按钮即可发起请求，结果会在页面展示。
- 演示AJAX的异步特性，包括并发请求、顺序请求、UI响应等。

### 使用方法
1. 进入 `/ajax-test` 页面。
2. 点击不同按钮体验三种AJAX请求方式。
3. 点击“测试异步特性”按钮，查看并发、顺序请求和UI响应的效果。

> 请求接口使用了 `https://jsonplaceholder.typicode.com/todos/` 作为测试数据源。
