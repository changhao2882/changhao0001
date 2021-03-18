package com.bjsxt.service;

/**
 * 裁判类
 */
public class Judger {
    /**
     * 根据某一局两个玩家的出拳，判断这局两个玩家的胜负
     * @param computerValue  电脑玩家
     * @param userValue  用户玩家
     * @return 0 和局  1 电脑赢  -1 电脑输
     */
    public int compare(int computerValue,int userValue){
        if(computerValue == userValue){
            return 0;
        }else if(computerValue ==0){//石头
            if(userValue == 1){//剪子
                return 1;
            }else{ //2  //布
                return -1;
            }

        } else if(computerValue ==1){//剪子
            if(userValue == 0){//石头
                return -1;
            }else{ //2  //布
                return 1;
            }
        }else{//computerValue ==2  //布
            if(userValue == 0){//石头
                return 1;
            }else{ //1 //剪子
                return -1;
            }
        }

    }
}
