<template>
  <div>
    <common-head />
    <div class="home-MainView">
      <div class="container">
        <div class="outborder">
          <div class="table-border">
            <div style="height: 25px;background-color: #dbecf4;">
                <div style="height: 20px;background-color: #b1d3e0;">
                    <p style="padding-left: 5px;color: #004c7d;text-align: left;"><strong>»论坛头版</strong></p>
                </div>
            </div>
            <table id="contentTable" class="table table-bordered table-hover table-condensed">
                <div style="text-align: center;">
                    <tr>
                        <th class="col-md-1" style="text-align: center;"></th>
                        <th class="col-md-5" style="text-align: center;">论坛</th>
                        <th class="col-md-2" style="text-align: center;">主题</th>
                        <th class="col-md-1" style="text-align: center;">文章</th>
                        <th class="col-md-3" style="text-align: center;">最后发表</th>
                        <th class="col-md-1" style="text-align: center;">版主</th>
                    </tr>
                    <tr  v-for="item_01 in bbs_title_01" :key="item_01.name" style="height: 40px;">
                      <td class="col-md-1" style="text-align: center;"></td>
                      <td class="col-md-5" style="text-align: left;">{{ item_01.name }}</td>
                      <td class="col-md-2" style="text-align: center;">主题</td>
                      <td class="col-md-1" style="text-align: center;">文章</td>
                      <td class="col-md-3" style="text-align: center;">最后发表</td>
                      <td class="col-md-1" style="text-align: center;">版主</td>
                    </tr>
                </div>
            </table>

            <div style="height: 25px;background-color: #dbecf4;margin-top: 20px;">
                <div style="height: 20px;background-color: #b1d3e0;">
                    <p style="padding-left: 5px;color: #004c7d;text-align: left;"><strong>»论坛休闲区</strong></p>
                </div>
            </div>
            <table id="contentTable" class="table table-bordered table-hover table-condensed">
                <div style="text-align: center;">
                    <tr>
                        <th class="col-md-1" style="text-align: center;"></th>
                        <th class="col-md-5" style="text-align: center;">论坛</th>
                        <th class="col-md-2" style="text-align: center;">主题</th>
                        <th class="col-md-1" style="text-align: center;">文章</th>
                        <th class="col-md-3" style="text-align: center;">最后发表</th>
                        <th class="col-md-1" style="text-align: center;">版主</th>
                    </tr>
                    <tr  v-for="item_02 in bbs_title_02" :key="item_02.name">
                      <td class="col-md-1" style="text-align: center;"></td>
                      <td class="col-md-5" style="text-align: left;">{{ item_02.name }}</td>
                      <td class="col-md-2" style="text-align: center;">主题</td>
                      <td class="col-md-1" style="text-align: center;">文章</td>
                      <td class="col-md-3" style="text-align: center;">最后发表</td>
                      <td class="col-md-1" style="text-align: center;">版主</td>
                    </tr>
                </div>
            </table>

            <div style="height: 25px;background-color: #dbecf4;margin-top: 20px;">
                <div style="height: 20px;background-color: #b1d3e0;">
                    <p style="padding-left: 5px;color: #004c7d;text-align: left;"><strong>»论坛休闲区</strong></p>
                </div>
            </div>
            <table id="contentTable" class="table table-bordered table-hover table-condensed">
                <div style="text-align: center;">
                    <tr>
                        <th class="col-md-1" style="text-align: center;"></th>
                        <th class="col-md-5" style="text-align: center;">论坛</th>
                        <th class="col-md-2" style="text-align: center;">主题</th>
                        <th class="col-md-1" style="text-align: center;">文章</th>
                        <th class="col-md-3" style="text-align: center;">最后发表</th>
                        <th class="col-md-1" style="text-align: center;">版主</th>
                    </tr>
                    <tr  v-for="item_03 in bbs_title_03" :key="item_03.name">
                      <td class="col-md-1" style="text-align: center;"></td>
                      <td class="col-md-5" style="text-align: left;">{{ item_03.name }}</td>
                      <td class="col-md-2" style="text-align: center;">主题</td>
                      <td class="col-md-1" style="text-align: center;">文章</td>
                      <td class="col-md-3" style="text-align: center;">最后发表</td>
                      <td class="col-md-1" style="text-align: center;">版主</td>
                    </tr>
                </div>
            </table>


            <div style="height: 25px;background-color: #dbecf4;margin-top: 20px;">
                <div style="height: 20px;background-color: #b1d3e0;">
                    <p style="padding-left: 5px;color: #004c7d;text-align: left;"><strong>»论坛休闲区</strong></p>
                </div>
            </div>
            <table id="contentTable" class="table table-bordered table-hover table-condensed">
                <div style="text-align: center;">
                    <tr>
                        <th class="col-md-1" style="text-align: center;"></th>
                        <th class="col-md-5" style="text-align: center;">论坛</th>
                        <th class="col-md-2" style="text-align: center;">主题</th>
                        <th class="col-md-1" style="text-align: center;">文章</th>
                        <th class="col-md-3" style="text-align: center;">最后发表</th>
                        <th class="col-md-1" style="text-align: center;">版主</th>
                    </tr>
                    <tr  v-for="item_04 in bbs_title_04" :key="item_04.name">
                      <td class="col-md-1" style="text-align: center;"></td>
                      <td class="col-md-5" style="text-align: left;">{{ item_04.name }}</td>
                      <td class="col-md-2" style="text-align: center;">主题</td>
                      <td class="col-md-1" style="text-align: center;">文章</td>
                      <td class="col-md-3" style="text-align: center;">最后发表</td>
                      <td class="col-md-1" style="text-align: center;">版主</td>
                    </tr>
                </div>
            </table>
          </div>
        </div>
      </div>
    </div>
    
    <common-foot />
  </div>
</template>
  
<script>
import CommonHead from '../components/CommonHead.vue'
import CommonFoot from '../components/CommonFoot.vue'
export default {
    data() {
        return {
          // 这里返回你的数据对象
          bbs_title_01: [
            {
              name: '新生交流区',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '校园热点',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '站内热点',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '失物招领',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '学生组织',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '二手转转',
              theme: 0,
              article: 0,
              manager: ''
            }
          ],
          bbs_title_02: [
            {
              name: '社群团体',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '宣传招生',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '活动通知',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '校园表白墙',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '吐槽|举报',
              theme: 0,
              article: 0,
              manager: ''
            }
          ],
          bbs_title_03: [
            {
              name: '技术分享区',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '宣传招生',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '教师答疑区',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '专业前景区',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '	闲聊区',
              theme: 0,
              article: 0,
              manager: ''
            }
          ],
          bbs_title_04: [
            {
              name: '校友会',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '校园招聘',
              theme: 0,
              article: 0,
              manager: ''
            },
            {
              name: '关于我们',
              theme: 0,
              article: 0,
              manager: ''
            }
          ]
        }
    },
    // 其他组件选项
    components: {
        CommonHead,
        CommonFoot
    }
}
</script>

<style>
/* .Main-MainView {
  height: 220px;
  background-color: #f9f9ec;
} */
.home-MainView {
  height: 1840px;
  background-color: #f9f9ec;
}
.container {
  height: 1830px;
  background-color: #f9f9ec;
}

.outborder {
  height: 900px;
  /* border: 2px solid #666; */
}

.table-border {
  height: 535px;
  border: 1px solid rgb(166,203,231);
}

@media screen and (max-width: 524px) {
  .home-MainView {
    height: 3100px;
    background-color: #f9f9ec;
  }
  .table-border {
    margin-top: 50px;
  }
}
</style>