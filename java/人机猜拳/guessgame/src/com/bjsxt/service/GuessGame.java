package com.bjsxt.service;

import com.bjsxt.util.Constants;

public class GuessGame implements GameInterface {
    private Player computerPlayer;//电脑玩家
    private Player userPlayer;//用户玩家
    private Judger judger;//裁判
    private int count;//局数 当前是第几局

    @Override
    public void initGame() {
        computerPlayer = new ComputerPlayer("阿尔法狗");
        userPlayer = new UserPlayer("李世石");
        judger = new Judger();
        count = 1;
    }

    @Override
    public void startGame() {
        System.out.println("======人机猜丁壳大战======");
        while(true){
            System.out.println("\n------------第"+ count++ +"局----------");
            //1)用户玩家出拳
            int userValue = userPlayer.getInputValue();

            //2)电脑玩家出拳
            int computerValue = computerPlayer.getInputValue();

            //3)输出两方的出拳
            System.out.println(userPlayer.getName()+":"+ Constants.NAMES[userValue]
            +"\t"+computerPlayer.getName()+":"+Constants.NAMES[computerValue]);

            //4)裁判进行比较
            int result = judger.compare(computerValue, userValue);

            //5)根据本局比赛结果修改玩家winCount
            modifyWinCount(result);

            //6)输出本局比赛结果
            showResult(result);

            //7)判断游戏是否结束
            if(userPlayer.getWinCount()==Constants.WINCOUNT
                    || computerPlayer.getWinCount()==Constants.WINCOUNT){
                break;
            }
        }
    }

    private void showResult(int result) {
        //本局输赢
        switch(result){
            case 0:
                System.out.println("本局：和局");
                break;
            case 1:
                System.out.println("本局:"+computerPlayer.getName()+"赢");
                break;
            case 2:
                System.out.println("本局:"+userPlayer.getName()+"赢");

        }
        //当前比分
        System.out.println("当前比分为："+userPlayer.getName()+"\t"+userPlayer.getWinCount()
                +":"+computerPlayer.getWinCount()+"\t"+computerPlayer.getName());
    }

    private void modifyWinCount(int result) {
        if(result == 1){//电脑玩家赢
            computerPlayer.setWinCount(computerPlayer.getWinCount()+1);
        }else if(result ==-1){//电脑玩家书
            userPlayer.setWinCount(userPlayer.getWinCount()+1);
        }
    }

    @Override
    public void endGame() {
        System.out.println("==========================");
        //最终比分
        System.out.println("最终比分：");
        System.out.println(userPlayer.getName()+"\t"+userPlayer.getWinCount()
                +":"+computerPlayer.getWinCount()+"\t"+computerPlayer.getName());
        //最终的输赢胜负
        if(userPlayer.getWinCount()==Constants.WINCOUNT){
            System.out.println(userPlayer.getName()+"胜利");
        }else{
            System.out.println(computerPlayer.getName()+"胜利");
        }
    }
}
