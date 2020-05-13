// pages/home01/home01.js
//getApp()获取app.js产生的示例对象
const app = getApp()
const name = app.globalData.name
console.log(app.globalData.name)
const age = app.globalData.age
console.log(app.globalData.age)

//注册一个页面
//页面也有自己生命周期函数
Page({
  //----------4、监听其他事件--------------
  //监听页面滚动
  onPageScroll(scrollTop) {
    console.log(scrollTop)
  },
  //监听页面滚动到底部
  onReachBottom() {
    console.log("到底了还他妈拉！！！！！")
  },
  //监听用户下拉动作
  onPullDownRefresh() {
    console.log("下拉我刷新了！！！！！")
  },

  //----------3、监听wxml中相关的一些事件--------------
  handleGetUserInfo(event) {
    console.log('--------------')
    console.log(event.detail.rawData)
  },
  handleViewClick() {
    console.log(this.data.name+"--"+this.data.age+"被电击了。。。")
  },
  //----------2、初始化数据--------------
  data: {
    name: name,
    age: age,
    list: []
  },

  //----------1、监听页面的生命周期函数--------------
  /* onLoad: function() {
  }*/
  //生命周期回调—监听页面加载
  onLoad() {
    //const _this = this
    console.log("onLoad......")
    wx.request({
      url: 'http://123.207.32.32:8000/recommend',
      success: (res) => {
        console.log(res)
        const data = res.data.data.list;
        this.setData({
          list: data
        })
      }
    })
  },
  //生命周期回调—监听页面显示
  onShow() {
    console.log("onShow......")
  },
  //生命周期回调—监听页面初次渲染完成
  onReady() {
    console.log("onReady......")
  },
  //生命周期回调—监听页面隐藏
  onHide() {
    console.log("onHide......")
  },
  //生命周期回调—监听页面卸载
  onUnload() {
    console.log("onUnload......")
  }






  
})

