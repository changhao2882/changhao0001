// pages/home01/home01.js
import request from "../../utils/network.js"
Page({

  /**
   * 页面的初始数据
   */
  data: {
    title: "哈哈哈"
  },
  click() {
    wx.navigateTo({
      url: '/pages/detail/detail?title=123',
    })
    // wx.redirectTo({
    //   url: 'url',
    // })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //发送网络请求
    // wx.request({
    //   url: 'http://httpbin.org/post',
    //   method: "post",
    //   data: {
    //     type: "sell",
    //     page: 1
    //   },
    //   success: function (res) {
    //     console.log(res)
    //   }
    // })
    request({
      url: 'http://httpbin.org/post',
      method: "post"
    }).then(res => {
      console.log(res)
    }).catch(err => {
      console.log(err)
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    return {
      title: "哈哈哈",
      path: "/pages/home/home",
      imageUrl: "https://www.baidu.com/img/pc_cc75653cd975aea6d4ba1f59b3697455.png"
    }
  },
  handleShowToast() {
    wx.showToast({
      title: "标题",
      duration: 3000,
      icon: "loading",
      mask: true,
      success: function () {
        console.log("success")
      },
      fail: function () {
        console.log("error")
      },
      complete: function () {
        console.log("OK")
      }
    })
  },
  handleShowModal() {
    wx.showModal({
      title: "标题",
      content: "内容",
      showCancel: true,
      cancelText: "返回",
      cancelColor: '#ff8800',
      success: function (res) {
        if (res.confirm) {
          console.log("点击了确定")
        }
        if (res.cancel) {
          console.log("点击了取消")
        }
      }
    })
  },
  handleShowLoading() {
    wx.showLoading({
      title: '沾沾沾',
      mask: true
    })

    setTimeout(() => {
      wx.hideLoading()
    }, 2000)
  },
  handleShowAction() {
    wx.showActionSheet({
      itemList: ["请求","王五"],
      itemColor: "red",
      success: function (res) {
        console.log(res)
      }
    })
  }
})