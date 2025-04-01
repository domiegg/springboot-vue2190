/**
* 作者:刘文铭
* 描述:简单的验证，可以继续扩展
* 联系:kk_8983@foxmail.com
* 描述:自己封装的工具类
*/
var utils = {
/*
* 版本号，没有什么作用
* */
Version: '0.0.1',
/*
* 用途：检查输入字符串是否只由英文字母和数字和下划线组成
* 输入： s：字符串
* 返回： 如果通过验证返回true,否则返回false
*/
	isNumberOr_Letter : function(s) {// 判断是否是数字或字母
var regu = "^[0-9a-zA-Z\_]+$";
var re = new RegExp(regu);
if (re.test(s)) {
return true;
} else {
return false;
}
},
/*
* 用途：检查输入对象的值是否符合E-Mail格式
* 输入：str 输入的字符串
* 返回：如果通过验证返回true,否则返回false
*/
isEmail:function(str) {
var regu = "^(([0-9a-zA-Z]+)|([0-9a-zA-Z]+[_.0-9a-zA-Z-]*))@([a-zA-Z0-9-]+[.])+([a-zA-Z]{2}|net|com|gov|mil|org|edu|int|name|asia)$";
var re = new RegExp(regu);
if( str.search( re ) == -1 )
{
return false;
}
else
{
return true;
}
},
/*
* 用途：检查输入手机号码是否正确
* 输入： s：字符串
* 返回： 如果通过验证返回true,否则返回false
*/
checkMobile:function(s) {
//原来代码--改进一下
//var regu = /^[1][0-9][0-9]{9}$/;
var regu = /^(1[34578]{1,1}[0-9]{9,9})$/;
var re = new RegExp(regu);
if (re.test(s)) {
return true;
} else {
return false;
}
},
/*
* 用途：检查输入字符串是否是数字
* 输入： str：字符串
* 返回： 如果通过验证返回true,否则返回false
*/
isNumber:function (str)
{
var reg = /^\d+$/;
if (reg.test(str))
return true;
else
return false;
},
/*
* 用途：检查输入字符串是否符合时间格式
* 输入： time：字符串
* 返回： 如果通过验证返回true,否则返回false
*/
isTime:function(time){
var regex = /^[0-2]{1}[0-9]{1}:[0-5]{1}[0-9]{1}:[0-5]{1}[0-9]{1}$/;
if(!regex.test(time)){
return false;
}
var hour = time.substring(0,2);
var minute = time.substring(3,5);
var second = time.substring(6);
if(hour>23 || hour <0){
return false;
}
if(minute > 60 ||minute < 0){
return false;
}
if(second > 60 ||second < 0){
return false;
}
return true;
},
/*
* 用途：检查输入字符串是否符合正整数格式
* 输入： s：字符串
* 返回： 如果通过验证返回true,否则返回false
*/
isNumber:function(s) {
var regu = "^[0-9]+$";
var re = new RegExp(regu);
if (s.search(re) != -1) {
return true;
} else {
return false;
}
},
/*
* 用途：检查输入字符串是否符合国内固话或者传真格式
* 输入： s：字符串 格式例如：020-87110252 返回：
* 如果通过验证返回true,否则返回false
*/
isTel:function (s){
var reg=/^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/;
if(!reg.test(s))
return false
return true
},
/*
* 用途：检查输入字符串是否符合身份证格式
* 输入： s：字符串
* 返回： 如果通过验证返回true,否则返回false
*/
isIDno:function(strIDno)
{
var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"};
var iSum = 0;
var info = "";
//var strIDno = obj.value;
var idcoursedLength = strIDno.length;
if(!/^\d{17}(\d|x)$/i.test(strIDno)&&!/^\d{15}$/i.test(strIDno))
{
//alert("非法身份证号");
return false;
}
//在后面的运算中x相当于数字10,所以转换成a
strIDno = strIDno.replace(/x$/i,"a");
if(aCity[parseInt(strIDno.substr(0,2))]==null)
{
//alert("非法地区");
return false;
}
if (idcoursedLength==18)
{
sBirthday=strIDno.substr(6,4)+"-"+Number(strIDno.substr(10,2))+"-"+Number(strIDno.substr(12,2));
var d = new Date(sBirthday.replace(/-/g,"/"))
if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate()))
{
//alert("非法生日");
return false;
}
for(var i = 17;i>=0;i --)
iSum += (Math.pow(2,i) % 11) * parseInt(strIDno.charAt(17 - i),11);
if(iSum%11!=1)
{
//alert("非法身份证号");
return false;
}
}
else if (idcoursedLength==15)
{
sBirthday = "19" + strIDno.substr(6,2) + "-" + Number(strIDno.substr(8,2)) + "-" + Number(strIDno.substr(10,2));
var d = new Date(sBirthday.replace(/-/g,"/"))
var dd = d.getFullYear().toString() + "-" + (d.getMonth()+1) + "-" + d.getDate();
if(sBirthday != dd)
{
//alert("非法生日");
return false;
}
}
return true;
},
/*
* 用途：检查输入字符串是否符合邮政编码格式
* 输入： s：字符串
* 返回： 如果通过验证返回true,否则返回false
*/
isZipcode:function(str)
{
var reg = /^\d+$/;
if (!reg.test(str))
return false;
if(str.length!=6)
{
//alert("邮政编码长度必须是6位");
return false;
}
return true;
},
/*
* 用途：检查输入字符串是否符合金额格式 格式定义为带小数的正数，小数点后最多三位
* 输入： s：字符串
* 返回： 如果通过验证返回true,否则返回false
*/
isMoney : function(s) {
var regu = "^[0-9]+[\.][0-9]{0,3}$";
var re = new RegExp(regu);
if (re.test(s)) {
return true;
} else {
return false;
}
},
/*
* 用途：检查输入字符串是否只由汉字组成
* 输入： s：字符串
* 返回： 如果通过验证返回true,否则返回false
*/
isZh:function(str){
var reg = /^[\u4e00-\u9fa5]+$/;
if (reg.test(str)) return true;
return false;
},
/*
* 用途：检查输入对象的值是否符合整数格式
* 输入：str 输入的字符串
* 返回：如果通过验证返回true,否则返回false
*/
isInteger:function(str) {
var regu = /^[-]{0,1}[0-9]{1,}$/;
return regu.test(str);
},
/*
* 用途：检查输入字符串是否只由汉字、字母、数字组成
* 输入： value：字符串
* 返回： 如果通过验证返回true,否则返回false
*/
isChinaOrNumbOrLett:function (s) {//判断是否是汉字、字母、数字组成
var regu = "^[0-9a-zA-Z\u4e00-\u9fa5]+$";
var re = new RegExp(regu);
if (re.test(s)) {
return true;
} else {
return false;
}
},
/*
* 用途：校验ip地址的格式
* 输入：strIP：ip地址
* 返回：如果通过验证返回true,否则返回false；
*/
isIP:function(strIP) {
if (isNull(strIP)) return false;
var re = /^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g // 匹配IP地址的正则表达式
if (re.test(strIP)) {
if (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256) return true;
}
return false;
},
/*
* 用途：检查输入字符串是否只由英文字母和数字组成 输入：
* s：字符串
* 返回： 如果通过验证返回true,否则返回false
*/
isNumberOrLetter : function(s) {// 判断是否是数字或字母
var regu = "^[0-9a-zA-Z]+$";
var re = new RegExp(regu);
if (re.test(s)) {
return true;
} else {
return false;
}
},
/*
* 用途：账号必须
* 输入：
* s：字符串
* 返回： 如果通过验证返回true,否则返回false
*/
isAccount : function(s) {// 判断是否是数字或字母
var regu = "^([0-9a-zA-Z]+[_0-9a-zA-Z@.-]*)$";
var re = new RegExp(regu);
if (re.test(s)) {
return true;
} else {
return false;
}
},
/*
* 用途：去掉空格操作 一系列
* 输入：s：字符串
* 返回： 字符串
*/
trim:function(str){
return str.replace(/^\s*|\s*$/g, "");
},
ltrim:function(str){
return str.replace(/^\s*/g, "");
},
rtrim:function(str){
return str.replace(/\s*$/g, "");
},
trim_string:function(str){
return str.replace(/\s*/g, "");
}
};