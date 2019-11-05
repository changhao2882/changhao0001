var num1 = 1e308
console.log(num1)
var num2 = Infinity//超过了js所表示的范围显示Infinity
console.log(num2+1)
var num3 = NaN//不是数字,但属于数字类型,一种特殊的数字
console.log(typeof(NaN))
console.log(NaN==NaN)
console.log(isNaN(num3))
//假 0 0.0 "" NaN undefined false null 其他都是真
//类型转换
var a = "  123"
console.log(typeof(parseInt(a)))   //Number()
console.log(typeof(parseFloat(a)))
//Boolean()
//用户输入
//var num4 = prompt("请输入：")
//console.log(num4)

var num5 = 10
var num6 = 3
console.log(num5/num6)
console.log(parseInt(num5/num6))//取整
var str = "dgsgs2:2"
console.log(str.length)

//匿名函数
// var f = function(a,b){
// 	return a+b;
// }
// console.log(f(3,4))

//数组  list.push()尾部增加  list.unshift()头部增加  list.pop()尾部删除 list.popshift()头部删除  list.join("[字符]")字符进行连接
//list.reverse()倒序  newlist=list.slice(start,end)开始下标，结束下标截取数组   
//list.splice(start,num,iter1,item2,...)下标，个数，修改值(插入的话个数0)   返回值：被删除元素组成的数组
//list.concat(list2)拼接  list.indexOf([item])查找，返回下标，没有为-1  list.lastIndexOf([item])从后查找，返回下标，没有为-1

var list = new Array();
for(var i=0;i<10;i++){
	list[i] = i;
}
delete(list[9])
console.log(list)
console.log(list.length)
list.forEach(function(item){
	console.log(item)
})

//排序list.sort()默认升序

var list1=[4,2,5,3,1]
function compare(v1,v2){
	if(v1<v2){
		return 1;
	}
	return -1;
}
list1.sort(compare);
console.log(list1)

//长度排序
var list2=new Array(5)
list2[0] = "qr"
list2[1] = "sgsg"
list2[2] = "sdg"
list2[3] = "sdgsrh"
list2[4] = "q"
function compare(v1,v2){
	if(v1.length<v2.length){
		return 1;
	}
	return -1;
}
list2.sort(compare);
console.log(list2)

//日期
//Date.parse("2017-11-16")返回距离19700101零点的毫秒数