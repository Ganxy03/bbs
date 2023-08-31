<template>
    <div class="Main-Register">
      <div class="container">
        <div class="outborder-Register">
          <div style="height: 80px;background-color: #0f7884;">
                <h2 class="headtitle"><a href="#"
                  style="color: black;"><strong>联大BBS</strong></a><small>（测试版）</small></h2>
          </div>
          <div style="height: 25px;background-color: #dbecf4;text-align: left;">
            <div style="height: 20px;background-color: #b1d3e0;">
                <p style="padding-left: 5px;color: #004c7d;">» 您尚未登录
                  <!-- <a href="#" style="color: #004c7d;">
                    
                  </a> -->
                  <router-link to="/main">登陆</router-link>
                <!-- | <a href="#" style="color: #004c7d;">检索</a> |  -->
                  <!-- <a href="#" style="color: #004c7d;">帮助</a> | <a href="#" style="color: #004c7d;">收藏</a> -->
                </p>
            </div>
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
.Main-Register {
  height: 100px;
  background-color: #f9f9ec;
  display: flex;
  justify-content: center;
  align-items: center;
}
.outborder-Register {
  height: 110px;
  /* border: 2px solid #666; */
}
.headtitle {
    padding-left: 15px;
    padding-top: 10px;
    text-align: left;
    font-size: 50px;
    font-family: '楷体';
}
</style>