package com.bjsxt.service;

import com.bjsxt.util.MyUtil;

import java.util.Scanner;

/**
 * 用户玩家
 */
public class UserPlayer extends Player {

    public UserPlayer() {
    }

    public UserPlayer(String name) {
        super(name);
    }

    @Override
    public int getInputValue() {
        //获取从键盘输入的value
        Scanner input = new Scanner(System.in);
        System.out.println("请选择你的手势：【0-石头】，【1-剪刀】，【2-布】");
        int value = input.nextInt();

        //赋给电脑玩家的value
        this.setValue(value);

        //返回随机数
        return value;
    }
}
