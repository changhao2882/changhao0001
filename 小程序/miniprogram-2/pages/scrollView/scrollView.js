// pages/scrollView/scrollView.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  handleScroll(e) {
    console.log("正在滚动",e.detail.scrollTop)
  }
  
})