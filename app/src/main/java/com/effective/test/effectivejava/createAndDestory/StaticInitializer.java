package com.effective.test.effectivejava.createAndDestory;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by xieqe on 2017/12/5.
 * Effective Java No.5：避免创建不必要的对象
 *
 * 静态的初始化器，
 * 在创建类的时候初始化数据，这样就无需每次调用某个需要这些数据的函数时，都创建一次数据对象
 */

public class StaticInitializer {
    private Date birthDate = null;

    private static final Date BOOM_START;
    private static final Date BOOM_END;

    public StaticInitializer(Date birthDate){
        this.birthDate = birthDate;
    }

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1992,Calendar.JANUARY,1,0,0,0);
        BOOM_START = calendar.getTime();
        calendar.set(2092,Calendar.JANUARY,1,0,0,0);
        BOOM_END = calendar.getTime();
    }

    /**检验出生日期是否在1992~~~2092之间*/
    public boolean isBoomer(){
        /*
        放到静态代码块中，不用每次调用该函数都创建Calender和Date对象
        Calendar calendar = Calendar.getInstance();
        calendar.set(1992,Calendar.JANUARY,1,0,0,0);
        Date BOOM_START = calendar.getTime();
        calendar.set(2092,Calendar.JANUARY,1,0,0,0);
        Date BOOM_END = calendar.getTime();
        */
        return birthDate.compareTo(BOOM_START) >=0 && birthDate.compareTo(BOOM_END) < 0;
    }

}
