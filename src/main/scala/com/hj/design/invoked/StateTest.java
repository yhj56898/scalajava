package com.hj.design.invoked;

import com.hj.design.State_model.StartState;
import com.hj.design.State_model.StateContext;
import com.hj.design.State_model.StopState;

/**
 * @author hejin-Yu
 * @desc
 */
public class StateTest {
    public static void main(String[] args) {

        StateContext context = new StateContext();

        System.out.println("进入开始状态下，执行该状态下的业务逻辑");
        context.setState(new StartState());
        context.doJob();

        System.out.println("进入结束状态下，执行该状态下的业务逻辑");
        context.setState(new StopState());
        context.doJob();
    }
}
