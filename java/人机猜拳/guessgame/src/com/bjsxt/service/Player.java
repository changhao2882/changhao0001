package com.bjsxt.service;

/**
 * 玩家类
 */
public abstract class Player {
    private String name;//姓名  李世石  阿尔法狗
    private int value;//出拳  手势  0  1  2
    private int winCount;//取胜局数

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    /**
     * 获取玩家的手势对应的数组，赋给成员变量value并返回value的值
     * @return
     */
    public abstract  int getInputValue();
}
