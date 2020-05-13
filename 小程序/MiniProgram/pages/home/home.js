// pages/home/home.js
Page({
  data: {
    name: '常昊',
    age: 18,
    students: [
      {name: 'tmo1', age: 18, sex: '男'},
      {name: 'tmo2', age: 19, sex: '男'},
      {name: 'tmo3', age: 20, sex: '男'},
      {name: 'tmo4', age: 21, sex: '男'}
    ],
    counter: 0
  },
  add() {
    this.setData({
      counter: this.data.counter + 1
    })
  },
  jian() {
    this.setData({
      counter: this.data.counter - 1
    })
  },
  init() {
    this.setData({
      counter: this.data.counter = 0
    })
  }
})