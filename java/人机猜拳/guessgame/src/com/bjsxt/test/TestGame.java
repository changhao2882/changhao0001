package com.bjsxt.test;

import com.bjsxt.service.GameInterface;
import com.bjsxt.service.GuessGame;

/**
 * 启动类
 */
public class TestGame {
    public static void main(String[] args) {
        GameInterface  game = new GuessGame();
        game.initGame();
        game.startGame();
        game.endGame();
    }
}
