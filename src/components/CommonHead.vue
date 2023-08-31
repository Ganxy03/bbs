<template>
    <div class="Main-CommonHead">
      <div class="container">
        <div class="outborder">
          <div style="height: 80px;background-color: #0f7884;">
                <h2 class="headtitle"><a href="#"
                  style="color: black;"><strong>联大BBS</strong></a><small>（测试版）</small></h2>
          </div>
          <div style="height: 25px;background-color: #dbecf4;text-align: left;">
            <div style="height: 20px;background-color: #b1d3e0;">
                <p style="padding-left: 5px;color: #004c7d;">» 您尚未登录 没有账号？
                  去
                  <a href="#/register" style="color: #13aaf0;" target="_blank">
                    注册
                  </a>
                  <!-- <router-link to="/register">注册</router-link> -->
                <!-- | <a href="#" style="color: #004c7d;">检索</a> |  -->
                  <!-- <a href="#" style="color: #004c7d;">帮助</a> | <a href="#" style="color: #004c7d;">收藏</a> -->
                </p>
            </div>
          </div>

          <div class="login-boeder">
            <div style="height: 30px;border: 1px solid rgb(218,235,205);background-color: #f3f8ef;">
              <h6 style="color: #659b28;padding: 5px;line-height: 15px;text-align: left;">最近没有论坛公告</h6>
            </div>
            <div>
              <div class="form-group">
                <el-input type="text" placeholder="输入用户名" clearable></el-input>
                <el-input type="password" placeholder="输入密码" show-password clearable></el-input>
                <button class="btn btn-primary">登录</button>
              </div>
            </div>
            <p class="head-info" style="">最高日 55903 帖 | 标记已读 | 精华区 | 最新帖子 RSS<br />共
              470351 篇主题 | 9271162 篇帖子 | 7136739 位会员 | 欢迎新会员 Ganxy</p>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
export default {
  data() {
    return {
      
    }
  }
}
</script>

<style>
.Main-CommonHead {
  height: 220px;
  background-color: #f9f9ec;
}

.outborder {
  height: 220px;
  /* border: 2px solid #666; */
}

.headtitle {
    padding-left: 15px;
    padding-top: 10px;
    text-align: left;
    font-size: 50px;
    font-family: '楷体';
}

@media screen and (max-width: 768px) {
  .headtitle {
    font-size: 36px;
  }
}

.login-boeder {
  margin-top: 10px;
  height:90px;
  background-color: #f9f9ec;
  border: 1px solid rgb(166,203,231);
}

.form-group .el-input {
  float: left;
  width: 200px;
  padding-left: 10px;
  margin-right: 10px;
}

.btn-primary {
  float: left;
  margin-left: 10px;
}

.head-info {
  text-align: right;
  padding: 1px 15px 0px 0px;
}

@media screen and (max-width: 1200px) {
  .head-info {
    display: none;
  }
}

@media screen and (max-width: 524px) {
  .form-group .el-input {
    margin-bottom: 10px;
    display: block;
  }
  .btn-primary {
    display: block;
  }
  .login-boeder {
    height: 150px;
  }
}
</style>