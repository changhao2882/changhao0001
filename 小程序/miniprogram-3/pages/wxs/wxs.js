// pages/wxs/wxs.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    price: 2.2222222222,
    timestamp: 1560598160,
    color: ["red", "blue", "green"],
    counter: 0,
    titles: ['流行','新款','精选'],
    slidervalue: 0
  },
  clickIncrement(e) {
    console.log(e)
  },
  handleIncrement(event) {
    console.log(event)
    this.setData({
      counter: this.data.counter + 1
    })
  },
  click(e) {
    console.log(e)
    
  },
  add() {
    console.log("add")
    const my_sel = this.selectComponent("#my-select");  //class/id
    console.log(my_sel)
    // my_sel.setData({
    //   counter: my_sel.data.counter + 1
    // })
    my_sel.changecounter(2);
  },
  c1() {
    console.log("c1...")
  },
  t1() {
    console.log("t1...")
  },
  c2() {
    console.log("c2...")
  },
  t2() {
    console.log("t2...")
  },
  c3() {
    console.log("c3...")
  },
  t3() {
    console.log("t3...")
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
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
    setTimeout(() => {
       this.setData({
        slidervalue: this.data.slidervalue + 10
      })
    }, 1000);
    
    
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

  }
})