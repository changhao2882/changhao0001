package com.bjsxt.util;

/**
 * 常量类
 *
 * 好处：
 * 提高可读性   STONE   1
 * 便于修改,只能在此处修改  WINCOUNT = 7;
 * 集中管理
 *
 */
public class Constants {
    public static final int STONE = 0;  //石头
    public static final int SCISSORS = 1; // 剪子
    public static final int CLOTH = 2; //布

    public static final int WINCOUNT = 3;//判断胜利的局数

    public static final String [] NAMES = {"石头","剪子","布"};

}
