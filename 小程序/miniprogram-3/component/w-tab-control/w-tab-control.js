// component/w-tab-control/w-tab-control.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    titles: {
      type: Array,
      value: []
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    currentIndex: 0
  },

  /**
   * 组件的方法列表
   */
  methods: {
    changestyle(e) {
      const index = e.currentTarget.dataset.index;
      this.setData({
        currentIndex: e.currentTarget.dataset.index
      })
      this.triggerEvent("increment", {name: this.properties.titles[index], index }, {})
    }
  }
})
