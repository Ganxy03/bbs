<template>
    <div>
        <register-head />
        <div class="Main-RegisterView">
            <div class="register-boeder">
                <div style="height: 30px;border: 1px solid rgb(218,235,205);background-color: #f3f8ef;">
                    <h6 style="color: #659b28;padding: 5px;line-height: 15px;text-align: left;" @click="anno">
                        最近论坛公告
                    </h6>
                </div>

                <el-dialog
                title="公告"
                :visible.sync="dialogVisible"
                :center="true"
                :show-close="false"
                >
                <p style="text-align: center;">
                    因为网络实名的需要，以下内容如实填写，望同学们自觉，本人代表协会郑重声明：<br>
                    我们将严格保护您的个人信息，坚决抵制一切非法不道德的行为。<br>(2023-08-31)<br>（PS:开发是我们的事，社区的环境维护真的拜托大家了）
                </p>
                <el-button type="primary" @click="handleConfirm">确定</el-button>
                </el-dialog>

                <div class="form-group">
                    <!-- status-icon -->
                    <el-form ref="form" status-icon :rules="rules" :model="form" label-width="140px">
                        <el-form-item label="用户名：" prop="nickname">
                            <el-input v-model="form.nickname" clearable placeholder="请输入昵称"></el-input>
                        </el-form-item>
                        <el-form-item label="真名：" prop="name">
                            <el-input v-model="form.name" clearable placeholder="请输入真实姓名"></el-input>
                        </el-form-item>
                        <!-- <el-form-item label="性别：">
                            <el-input v-model="form.sex"></el-input>
                        </el-form-item> -->
                        <el-form-item label="性别：">
                            <el-radio-group v-model="form.sex">
                                <el-radio label="男"></el-radio>
                                <el-radio label="女"></el-radio>
                            </el-radio-group>
                        </el-form-item>
                        <el-form-item label="邮箱：" prop="email">
                            <el-input v-model="form.email" clearable placeholder="请输入邮箱"></el-input>
                        </el-form-item>
                        <el-form-item label="手机号：" prop="phone">
                            <el-input v-model="form.phone" clearable placeholder="请输入手机号"></el-input>
                        </el-form-item>
                        <el-form-item label="学号：">
                            <el-input v-model="form.sno" clearable placeholder="请输入学号"></el-input>
                        </el-form-item>
                        <el-form-item label="密码：" prop="password">
                            <el-input type="password" v-model="form.password"  show-password placeholder="请输入密码"></el-input>
                        </el-form-item>
                        <el-form-item label="确认密码：" prop="checkpass">
                            <el-input type="password" v-model="form.checkpass" show-password placeholder="请再次输入密码"></el-input>
                        </el-form-item>
                        <el-form-item label="城市：">
                            <!-- <el-input v-model="form.city" ></el-input> -->
                            <el-autocomplete
                            class="inline-input"
                            v-model="form.city"
                            :fetch-suggestions="querySearch"
                            placeholder="请输入省/市 如：浙江-杭州"
                            :trigger-on-focus="false"
                            @select="handleSelect"
                            ></el-autocomplete>
                        </el-form-item>
                        <el-form-item label="生日：">
                            <!-- <el-input v-model="form.birthday" suffix-icon="el-icon-date"></el-input> -->
                            <el-date-picker type="date" placeholder="选择日期" v-model="form.birthday"></el-date-picker>
                        </el-form-item>
                    </el-form>
                    <div class="input-row">
                        <button class="btn btn-primary" @click="register">注册</button>
                    </div>
                </div>
            </div>
        </div>
        <common-foot />
    </div>
</template>

<script>
import RegisterHead from '../components/RegisterHead.vue'
import CommonFoot from '../components/CommonFoot.vue'
export default {
    data() {
        var validatePass = (rule, value, callback) => {
            if (value === '') {
            callback(new Error('请输入密码'));
            } else {
            if (this.form.checkpass !== '') {
                this.$refs.form.validateField('checkpass');
            }
            callback();
            }
        };
        var validatePass2 = (rule, value, callback) => {
            if (value === '') {
            callback(new Error('请再次输入密码'));
            } else if (value !== this.form.password) {
            callback(new Error('两次输入密码不一致!'));
            } else {
            callback();
            }
        };
        return {
            dialogVisible: false,
            state_city: '',
            city: [],
            form: {
                nickname: '',
                name: '',
                sex: '',
                email: '',
                phone: '',
                sno: '',
                password: '',
                checkpass: '',
                city: '',
                birthday: ''
            },
            rules: {
                nickname: [
                    { required: true, message: '请输入昵称', trigger: 'blur' },
                    { min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur' }
                ],
                name: [
                    { required: true, message: '请输入姓名', trigger: 'blur' },
                    { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                email: [
                    { required: true, message: '请输入邮箱地址', trigger: 'blur' },
                    { type: 'email', message: '请输入有效的邮箱地址', trigger: ['blur', 'change'] }
                ],
                phone: [
                    { required: true, message: '手机号不能为空', trigger: 'blur' },
                    { pattern: /^1[3456789]\d{9}$/, message: '手机号格式不正确', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 6, max: 18, message: '长度在 6 到 18 个字符', trigger: 'blur' },
                    { validator: validatePass, trigger: 'blur' }
                ],
                checkpass: [
                    { required: true, message: '请再次输入密码', trigger: 'blur' },
                    { min: 6, max: 18, message: '长度在 6 到 18 个字符', trigger: 'blur' },
                    { validator: validatePass2, trigger: 'blur' }
                ],
            }
        }
    },
// 其他组件选项
    components: {
        RegisterHead,
        // CommonHead,
        CommonFoot
    },
    methods: {
        querySearch(queryString, cb) {
        var city = this.city;
        var results = queryString ? city.filter(this.createFilter(queryString)) : city;
        // 调用 callback 返回建议列表的数据
        cb(results);
      },
      createFilter(queryString) {
        return (city) => {
          return (city.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
        };
      },
      loadAll() {
        return [
            { "value": "安徽-合肥" },
            { "value": "安徽-芜湖" },
            { "value": "安徽-蚌埠" },
            { "value": "安徽-淮南" },
            { "value": "安徽-马鞍山" },
            { "value": "安徽-淮北" },
            { "value": "安徽-铜陵" },
            { "value": "安徽-安庆" },
            { "value": "安徽-黄山" },
            { "value": "安徽-滁州" },
            { "value": "安徽-阜阳" },
            { "value": "安徽-宿州" },
            { "value": "安徽-六安" },
            { "value": "安徽-亳州" },
            { "value": "安徽-池州" },
            { "value": "安徽-宣城" },
            { "value": "河北-石家庄" },
            { "value": "河北-唐山" },
            { "value": "河北-秦皇岛" },
            { "value": "河北-邯郸" },
            { "value": "河北-邢台" },
            { "value": "河北-保定" },
            { "value": "河北-张家口" },
            { "value": "河北-承德" },
            { "value": "河北-沧州" },
            { "value": "河北-廊坊" },
            { "value": "河北-衡水" },
            { "value": "四川-成都市" },
            { "value": "四川-自贡市" },
            { "value": "四川-攀枝花市" },
            { "value": "四川-泸州市" },
            { "value": "四川-德阳市" },
            { "value": "四川-绵阳市" },
            { "value": "四川-广元市" },
            { "value": "四川-遂宁市" },
            { "value": "四川-内江市" },
            { "value": "四川-乐山市" },
            { "value": "四川-南充市" },
            { "value": "四川-眉山市" },
            { "value": "四川-宜宾市" },
            { "value": "四川-广安市" },
            { "value": "四川-达州市" },
            { "value": "四川-雅安市" },
            { "value": "四川-巴中市" },
            { "value": "四川-资阳市" },
            { "value": "四川-阿坝藏族羌族自治州" },
            { "value": "四川-甘孜藏族自治州" },
            { "value": "四川-凉山彝族自治州" },
            { "value": "贵州-贵阳市" },
            { "value": "贵州-六盘水市" },
            { "value": "贵州-遵义市" },
            { "value": "贵州-安顺市" },
            { "value": "贵州-毕节市" },
            { "value": "贵州-铜仁市" },
            { "value": "贵州-黔西南布依族苗族自治州" },
            { "value": "贵州-黔东南苗族侗族自治州" },
            { "value": "贵州-黔南布依族苗族自治州" },
            { "value": "广东-广州市" },
            { "value": "广东-韶关市" },
            { "value": "广东-深圳市" },
            { "value": "广东-珠海市" },
            { "value": "广东-汕头市" },
            { "value": "广东-佛山市" },
            { "value": "广东-江门市" },
            { "value": "广东-湛江市" },
            { "value": "广东-茂名市" },
            { "value": "广东-肇庆市" },
            { "value": "广东-惠州市" },
            { "value": "广东-梅州市" },
            { "value": "广东-汕尾市" },
            { "value": "广东-河源市" },
            { "value": "广东-阳江市" },
            { "value": "广东-清远市" },
            { "value": "广东-东莞市" },
            { "value": "广东-中山市" },
            { "value": "广东-潮州市" },
            { "value": "广东-揭阳市" },
            { "value": "广东-云浮市" },
            { "value": "广西-南宁市" },
            { "value": "广西-柳州市" },
            { "value": "广西-桂林市" },
            { "value": "广西-梧州市" },
            { "value": "广西-北海市" },
            { "value": "广西-防城港市" },
            { "value": "广西-钦州市" },
            { "value": "广西-贵港市" },
            { "value": "广西-玉林市" },
            { "value": "广西-百色市" },
            { "value": "广西-贺州市" },
            { "value": "广西-河池市" },
            { "value": "广西-来宾市" },
            { "value": "广西-崇左市" },
            { "value": "宁夏-银川市" },
            { "value": "宁夏-石嘴山市" },
            { "value": "宁夏-吴忠市" },
            { "value": "宁夏-固原市" },
            { "value": "宁夏-中卫市" },
            { "value": "陕西-西安市" },
            { "value": "陕西-铜川市" },
            { "value": "陕西-宝鸡市" },
            { "value": "陕西-咸阳市" },
            { "value": "陕西-渭南市" },
            { "value": "陕西-延安市" },
            { "value": "陕西-汉中市" },
            { "value": "陕西-榆林市" },
            { "value": "陕西-安康市" },
            { "value": "陕西-商洛市" },
            { "value": "山西-太原市" },
            { "value": "山西-大同市" },
            { "value": "山西-阳泉市" },
            { "value": "山西-长治市" },
            { "value": "山西-晋城市" },
            { "value": "山西-朔州市" },
            { "value": "山西-晋中市" },
            { "value": "山西-运城市" },
            { "value": "山西-忻州市" },
            { "value": "山西-临汾市" },
            { "value": "山西-吕梁市" },
            {"value": "西藏-拉萨市" },
            { "value": "西藏-日喀则市" },
            { "value": "西藏-昌都市" },
            { "value": "西藏-林芝市" },
            { "value": "西藏-山南市" },
            { "value": "西藏-那曲市" },
            { "value": "西藏-阿里地区" },
            { "value": "新疆-乌鲁木齐市" },
            { "value": "新疆-克拉玛依市" },
            { "value": "新疆-吐鲁番市" },
            { "value": "新疆-哈密市" },
            { "value": "新疆-昌吉回族自治州" },
            { "value": "新疆-博尔塔拉蒙古自治州" },
            { "value": "新疆-巴音郭楞蒙古自治州" },
            { "value": "新疆-阿克苏地区" },
            { "value": "新疆-克孜勒苏柯尔克孜自治州" },
            { "value": "新疆-喀什地区" },
            { "value": "新疆-和田地区" },
            { "value": "新疆-伊犁哈萨克自治州" },
            { "value": "新疆-塔城地区" },
            { "value": "新疆-阿勒泰地区" },
            { "value": "新疆-自治区直辖县级行政区划" },
            { "value": "内蒙古-呼和浩特市" },
            { "value": "内蒙古-包头市" },
            { "value": "内蒙古-乌海市" },
            { "value": "内蒙古-赤峰市" },
            { "value": "内蒙古-通辽市" },
            { "value": "内蒙古-鄂尔多斯市" },
            { "value": "内蒙古-呼伦贝尔市" },
            { "value": "内蒙古-巴彦淖尔市" },
            { "value": "内蒙古-乌兰察布市" },
            { "value": "内蒙古-兴安盟" },
            { "value": "内蒙古-锡林郭勒盟" },
            { "value": "内蒙古-阿拉善盟" },
            { "value": "山东-济南市" },
            { "value": "山东-青岛市" },
            { "value": "山东-淄博市" },
            { "value": "山东-枣庄市" },
            { "value": "山东-东营市" },
            { "value": "山东-烟台市" },
            { "value": "山东-潍坊市" },
            { "value": "山东-济宁市" },
            { "value": "山东-泰安市" },
            { "value": "山东-威海市" },
            { "value": "山东-日照市" },
            { "value": "山东-莱芜市" },
            { "value": "山东-临沂市" },
            { "value": "山东-德州市" },
            { "value": "山东-聊城市" },
            { "value": "山东-滨州市" },
            { "value": "山东-菏泽市" },
            { "value": "江苏-南京市" },
            { "value": "江苏-无锡市" },
            { "value": "江苏-徐州市" },
            { "value": "江苏-常州市" },
            { "value": "江苏-苏州市" },
            { "value": "江苏-南通市" },
            { "value": "江苏-连云港市" },
            { "value": "江苏-淮安市" },
            { "value": "江苏-盐城市" },
            { "value": "江苏-扬州市" },
            { "value": "江苏-镇江市" },
            { "value": "江苏-泰州市" },
            { "value": "江苏-宿迁市" },
            { "value": "福建-福州市" },
            { "value": "福建-厦门市" },
            { "value": "福建-漳州市" },
            { "value": "福建-泉州市" },
            { "value": "福建-三明市" },
            { "value": "福建-莆田市" },
            { "value": "福建-南平市" },
            { "value": "福建-龙岩市" },
            { "value": "福建-宁德市" },
            { "value": "海南-海口市" },
            { "value": "海南-三亚市" },
            { "value": "海南-三沙市" },
            { "value": "海南-儋州市" },
            { "value": "海南-五指山市" },
            { "value": "海南-琼海市" },
            { "value": "海南-文昌市" },
            { "value": "海南-万宁市" },
            { "value": "海南-东方市" },
            { "value": "海南-定安县" },
            { "value": "海南-屯昌县" },
            { "value": "海南-澄迈县" },
            { "value": "海南-临高县" },
            { "value": "海南-白沙黎族自治县" },
            { "value": "海南-昌江黎族自治县" },
            { "value": "海南-乐东黎族自治县" },
            { "value": "海南-陵水黎族自治县" },
            { "value": "海南-保亭黎族苗族自治县" },
            { "value": "海南-琼中黎族苗族自治县" },
            { "value": "辽宁-沈阳市" },
            { "value": "辽宁-大连市" },
            { "value": "辽宁-鞍山市" },
            { "value": "辽宁-抚顺市" },
            { "value": "辽宁-本溪市" },
            { "value": "辽宁-丹东市" },
            { "value": "辽宁-锦州市" },
            { "value": "辽宁-营口市" },
            { "value": "辽宁-阜新市" },
            { "value": "辽宁-辽阳市" },
            { "value": "辽宁-盘锦市" },
            { "value": "辽宁-铁岭市" },
            { "value": "辽宁-朝阳市" },
            { "value": "辽宁-葫芦岛市" },
            { "value": "吉林-长春市" },
            { "value": "吉林-吉林市" },
            { "value": "吉林-四平市" },
            { "value": "吉林-辽源市" },
            { "value": "吉林-通化市" },
            { "value": "吉林-白山市" },
            { "value": "吉林-松原市" },
            { "value": "吉林-白城市" },
            { "value": "吉林-延边朝鲜族自治州" },
            { "value": "黑龙江-哈尔滨市" },
            { "value": "黑龙江-齐齐哈尔市" },
            { "value": "黑龙江-鸡西市" },
            { "value": "黑龙江-鹤岗市" },
            { "value": "黑龙江-双鸭山市" },
            { "value": "黑龙江-大庆市" },
            { "value": "黑龙江-伊春市" },
            { "value": "黑龙江-佳木斯市" },
            { "value": "黑龙江-七台河市" },
            { "value": "黑龙江-牡丹江市" },
            { "value": "黑龙江-黑河市" },
            { "value": "黑龙江-绥化市" },
            { "value": "黑龙江-大兴安岭地区" },
            { "value": "云南-昆明" },
            { "value": "云南-曲靖" },
            { "value": "云南-玉溪" },
            { "value": "云南-保山" },
            { "value": "云南-昭通" },
            { "value": "云南-丽江" },
            { "value": "云南-普洱" },
            { "value": "云南-临沧" },
            { "value": "云南-楚雄" },
            { "value": "云南-红河" },
            { "value": "云南-文山" },
            { "value": "云南-西双版纳" },
            { "value": "云南-大理" },
            { "value": "云南-德宏" },
            { "value": "云南-怒江" },
            { "value": "云南-迪庆" },
            { "value": "云南-思茅" },
            { "value": "云南-临河" },
            { "value": "云南-保山" },
            { "value": "浙江-杭州" },
            { "value": "浙江-温州" },
            { "value": "浙江-宁波" },
            { "value": "浙江-绍兴" },
            { "value": "浙江-湖州" },
            { "value": "浙江-嘉兴" },
            { "value": "浙江-金华" },
            { "value": "浙江-衢州" },
            { "value": "浙江-舟山" },
            { "value": "浙江-台州" },
            { "value": "浙江-丽水" },
            { "value": "北京-东城区" },
            { "value": "北京-西城区" },
            { "value": "北京-朝阳区" },
            { "value": "北京-丰台区" },
            { "value": "北京-石景山区" },
            { "value": "北京-海淀区" },
            { "value": "北京-门头沟区" },
            { "value": "北京-房山区" },
            { "value": "北京-通州区" },
            { "value": "北京-顺义区" },
            { "value": "北京-昌平区" },
            { "value": "北京-大兴区" },
            { "value": "北京-怀柔区" },
            { "value": "北京-平谷区" },
            { "value": "北京-密云区" },
            { "value": "北京-延庆区" },
            { "value": "天津-和平区" },
            { "value": "天津-河东区" },
            { "value": "天津-河西区" },
            { "value": "天津-南开区" },
            { "value": "天津-河北区" },
            { "value": "天津-红桥区" },
            { "value": "天津-东丽区" },
            { "value": "天津-西青区" },
            { "value": "天津-津南区" },
            { "value": "天津-北辰区" },
            { "value": "天津-武清区" },
            { "value": "天津-宝坻区" },
            { "value": "天津-滨海新区" },
            { "value": "天津-宁河区" },
            { "value": "天津-静海区" },
            { "value": "天津-蓟州区" },
            { "value": "重庆-万州区" },
            { "value": "重庆-涪陵区" },
            { "value": "重庆-渝中区" },
            { "value": "重庆-大渡口区" },
            { "value": "重庆-江北区" },
            { "value": "重庆-沙坪坝区" },
            { "value": "重庆-九龙坡区" },
            { "value": "重庆-南岸区" },
            { "value": "重庆-北碚区" },
            { "value": "重庆-綦江区" },
            { "value": "重庆-大足区" },
            { "value": "重庆-渝北区" },
            { "value": "重庆-巴南区" },
            { "value": "重庆-黔江区" },
            { "value": "重庆-长寿区" },
            { "value": "重庆-江津区" },
            { "value": "重庆-合川区" },
            { "value": "重庆-永川区" },
            { "value": "重庆-南川区" },
            { "value": "重庆-璧山区" },
            { "value": "重庆-铜梁区" },
            { "value": "重庆-潼南区" },
            { "value": "重庆-荣昌区" },
            { "value": "重庆-开州区" },
            { "value": "重庆-梁平区" },
            { "value": "重庆-武隆区" },
            { "value": "上海-黄浦区" },
            { "value": "上海-徐汇区" },
            { "value": "上海-长宁区" },
            { "value": "上海-静安区" },
            { "value": "上海-普陀区" },
            { "value": "上海-虹口区" },
            { "value": "上海-杨浦区" },
            { "value": "上海-闵行区" },
            { "value": "上海-宝山区" },
            { "value": "上海-嘉定区" },
            { "value": "上海-浦东新区" },
            { "value": "上海-金山区" },
            { "value": "上海-松江区" },
            { "value": "上海-青浦区" },
            { "value": "上海-奉贤区" },
            { "value": "上海-崇明区" }
        ];
      },
      handleSelect(item) {
        console.log(item);
      },
      register() {
        // console.log(this.form);
        this.$refs.form.validate().then(() => {
            // 表单校验通过，执行注册逻辑
            console.log(this.form);
            const birthday = new Date(this.form.birthday);
            const year = birthday.getFullYear();
            const month = String(birthday.getMonth() + 1).padStart(2, '0');
            const day = String(birthday.getDate()).padStart(2, '0');
            const formattedBirthday = `${year}-${month}-${day}`;
            const userData = {
                birthday: formattedBirthday,
                checkpass: this.form.checkpass,
                city: this.form.city,
                email: this.form.email,
                name: this.form.name,
                nickname: this.form.nickname,
                password: this.form.password,
                phone: this.form.phone,
                sex: this.form.sex,
                sno: this.form.sno
            };
            // 发送注册请求
            fetch('http://localhost:9996/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
            })
            .then(response => response.json())
            .then(data => {
                // 注册成功的处理逻辑
                console.log('注册成功');
                // 可以在这里进行跳转或展示注册成功的提示信息
                this.$message({
                    message: '注册成功',
                    type: 'success',
                    duration: 3000, // 设置弹窗显示时间
                    onClose: () => {
                        // 清空表单信息
                        this.form = {
                            nickname: '',
                            name: '',
                            sex: '',
                            email: '',
                            phone: '',
                            sno: '',
                            password: '',
                            checkpass: '',
                            city: '',
                            birthday: ''
                        };
                        // 跳转登录链接
                        this.$router.push('/main');
                    }
                });
                console.log(data); // 输出注册成功后的响应数据
            })
            .catch(error => {
                // 注册失败的处理逻辑
                console.log('注册失败');
                console.log(formattedBirthday);
                // 可以在这里进行展示注册失败的提示信息
                this.$message({
                    message: '注册失败',
                    type: 'error'
                });
                console.log(error);
            });
        }).catch(() => {
            // 表单校验不通过，给出相应的反馈
            this.$message.error('请完整填写表单信息');
        });
      },
      anno() {
        this.dialogVisible = true;
      },
      handleConfirm() {
        this.dialogVisible = false;
      }        
    //   tip() {
    //     console.log("yes")
    //     this.$alert('根据网络实名的需要，以下内容如实填写，望同学们自觉。本人代表协会郑重声明：我们将严格保护您的个人信息，坚决抵制一切非法不道德的行为', '公告', {
    //       confirmButtonText: '确定',
    //       callback: action => {
    //         this.$message({
    //           type: 'info',
    //           message: `action: ${ action }`
    //         });
    //       }
    //     });
    //   },
    },
    mounted() {
        this.city = this.loadAll();
        // this.tip(); // 在页面加载完成后调用 open 方法
        this.anno();
    },
    
    
}
</script>

<style>
body {
    background-color: #f9f9ec;
}
.Main-RegisterView {
  height: 730px;
  background-color: #f9f9ec;
  display: flex;
  justify-content: center;
  align-items: center;
}
@media screen and (max-width: 768px) {
  .headtitle {
    font-size: 36px;
  }
}
.register-boeder {
  padding-bottom: 10px;
  height:720px;
  background-color: #f9f9ec;
  /* border: 1px solid rgb(166,203,231); */
}

.btn-primary {
    margin-left: 240px;
    margin-top: 10px;
}

.el-form-item {
    margin: 0 0 0 0;
    padding-right: 10px;
    padding-top: 20px;
}

.foot {
    margin-top: 30px;
}

@media screen and (max-width: 772px) {
    .foot {
        margin-top: 30px;
    }
}
.el-dialog {
    width: 500px;
}

.el-button {
    margin-left: 360px;
}
@media screen and (max-width: 772px) {
    .el-dialog {
        width: 320px;
    }

    .el-button {
        margin-left: 200px;
    }
}


</style>