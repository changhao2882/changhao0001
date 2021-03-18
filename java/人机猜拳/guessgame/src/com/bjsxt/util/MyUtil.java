package com.bjsxt.util;


import java.util.Random;

/**
 * 工具类
 */
public class MyUtil {

    private MyUtil(){

    }

    /**
     * 产生指定范围的随机数[0,max]
     * @param max 上限
     * @return 随机整数
     */
    public static int getRandom(int max){
        return new Random().nextInt(max+1);//[0,max)
    }

    /**
     * 产生指定范围的随机数[min,max]
     * @param min 下限
     * @param max 上限
     * @return 随机整数
     */
    public static int getRandom(int min,int max){ //[10,30]---[0,20]+10---[0,21)+10
        //return Math.random();//[0,1)  0.1122333
       return  (int)(Math.random()*(max-min+1))+min;
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            //System.out.println(getRandom(2));;
            System.out.println(getRandom(10, 30));
        }
    }

}
