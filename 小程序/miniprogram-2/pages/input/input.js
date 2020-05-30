// pages/input/input.js
Page({

  data: {
    focus: false,
    inputValue: ''
  },
  bindKeyInput: function (e) {
    this.setData({
      inputValue: e.detail.value
    })
  },
  bindKeyInput1: function (e) {
    this.setData({
      inputValue: "获取焦点"
    })
  },
  bindKeyInput2: function (e) {
    this.setData({
      inputValue: "失去焦点"
    })
  }
})