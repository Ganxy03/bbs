<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p>
      有关如何使用/注册本站的指南和手册，请参见<br>
      请查看
      <a href="#" target="_blank" rel="noopener">BBS文档</a>.
    </p>
    <router-link to="/main">
      <el-button type="warning" icon="el-icon-s-promotion" style="font-size: 24px;">出发~~</el-button>
    </router-link>
    <h3>开发日志</h3>
    <ul>
      <li><a href="#/timeline" target="_blank" rel="noopener">时间线</a></li>
      <li><a href="https://github.com/Ganxy03/bbs" target="_blank" rel="noopener">Github</a></li>
    </ul>
    <h3>平台</h3>
    <ul>
      <li><a href="#" target="_blank" rel="noopener">协会官网</a></li>
      <li><a href="#" target="_blank" rel="noopener">微博</a></li>
      <li><a href="#" target="_blank" rel="noopener">公众号</a></li>
      <li><a href="#" target="_blank" rel="noopener">Q群</a></li>
      <li><a href="#" target="_blank" rel="noopener">邮箱</a></li>
    </ul>
    <h3>特别感谢</h3>
    <ul>
      <li><a href="#" target="_blank" rel="noopener">网络办公室-刘启越老师</a></li>
      <li><a href="#" target="_blank" rel="noopener">网络办公室-陈俊然老师</a></li>
      <li><a href="#" target="_blank" rel="noopener">王文俊</a></li>
      <li><a href="#" target="_blank" rel="noopener">朱引航</a></li>

    </ul>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  // props: {
  //   msg: String
  // },
  data() {
    return {
      msg: 'Welcome to 联大BBS'
    }
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

</style>
