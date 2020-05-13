//注册一个小程序示例
App({

  /**
   * 当小程序初始化完成时，会触发 onLaunch（全局只触发一次）
   */
  onLaunch: function (options) {
    //判断小程序的进入场景 onShow/onLaunch
    console.log(options)

    //网络请求

    //获取用户信息

  },

  /**
   * 当小程序启动，或从后台进入前台显示，会触发 onShow
   */
  onShow: function (options) {
    //判断小程序的进入场景 onShow/onLaunch
    console.log(options)
    switch (options.scene) {
      case 1001:
        break;
      case 1005:
        break;
    }

    //获取用户信息后将信息传递给服务器onShow(执行一次)/onLaunch(执行多次)
    wx.getUserInfo({
      success: function(res) {
        console.log(res)
        var userInfo = res.userInfo
        var nickName = userInfo.nickName
        var avatarUrl = userInfo.avatarUrl
        var gender = userInfo.gender //性别 0：未知、1：男、2：女
        var province = userInfo.province
        var city = userInfo.city
        var country = userInfo.country
      }
    })
  },

  /**
   * 当小程序从前台进入后台，会触发 onHide
   */
  onHide: function () {
    
  },

  /**
   * 当小程序发生脚本错误，或者 api 调用失败时，会触发 onError 并带上错误信息
   */
  onError: function (msg) {
    
  },
  globalData: {
    name: "常昊爸爸",
    age: 18
  }
})
