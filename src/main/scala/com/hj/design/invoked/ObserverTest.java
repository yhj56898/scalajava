package com.hj.design.invoked;

import com.hj.design.observer_model.FirstObserver;
import com.hj.design.observer_model.SecondObserver;
import com.hj.design.observer_model.Subject;
import com.hj.design.observer_model.ThirdObserver;

/**
 * @author hejin-Yu
 * @desc
 */
public class ObserverTest {


    public static void main(String[] args) {

        Subject subject = new Subject();

        FirstObserver firstObserver = new FirstObserver();
        SecondObserver secondObserver = new SecondObserver();
        ThirdObserver thirdObserver = new ThirdObserver();

        subject.attach(firstObserver);
        subject.attach(secondObserver);
        subject.attach(thirdObserver);
            /*
                 * ~~~~~~~~~~~~~~~~~~~~~~
                 * 发送一个告知信息
                 * ~~~~~~~~~~~~~~~~~~~~~~
                 */

        subject.notifyMsg("以上帝视角，观察下");


            /*
                 * ~~~~~~~~~~~~~~~~~~~~~~
                 * 移除一个被观察者
                 * ~~~~~~~~~~~~~~~~~~~~~~
                 */

        subject.unAttach(secondObserver);

            /*
                 * ~~~~~~~~~~~~~~~~~~~~~~
                 * 重新观察下
                 * ~~~~~~~~~~~~~~~~~~~~~~
                 */

        subject.notifyMsg("再次以上帝视角，观察下");
    }
}
