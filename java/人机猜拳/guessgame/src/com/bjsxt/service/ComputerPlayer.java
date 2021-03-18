package com.bjsxt.service;

import com.bjsxt.util.MyUtil;

/**
 * 电脑玩家
 */
public class ComputerPlayer extends Player {

    public ComputerPlayer() {
    }

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public int getInputValue() {
        //获取随机数
        int value = MyUtil.getRandom(2);

        //赋给电脑玩家的value
        this.setValue(value);

        //返回随机数
        return value;
    }
}
