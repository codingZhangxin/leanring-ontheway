package com.codingzx.设计模式.策略模式;



/**
 * @author created by Codingzx}
 * @Classname BackDoorIStrategy
 * @Description TODO
 * @Date 2019-09-17 19:12
 */
public class GivenGreenLightIStrategy implements IStrategy {

    @Override
    public void operate() {
        System.out.println("开绿灯");
    }
}
