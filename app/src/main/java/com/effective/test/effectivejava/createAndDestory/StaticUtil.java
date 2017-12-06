package com.effective.test.effectivejava.createAndDestory;

import android.util.Log;

/**
 * Created by xieqe on 2017/12/5.
 * Effective Java No.4：通过私有构造器强化不可实例化的能力
 *
 * 提供静态方法的工具类，无需实例化
 * 可通过私有构造器强化不可实例化的能力
 */

public class StaticUtil {


    private StaticUtil(){
        throw new AssertionError();
    }

    public static void print(String info){
        Log.i("===", "print: " + info);
    }

}
