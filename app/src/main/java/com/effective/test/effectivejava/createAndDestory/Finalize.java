package com.effective.test.effectivejava.createAndDestory;

/**
 * Created by xieqe on 2017/12/5.
 finalize缺点：
 Java语言规范不保证finalize会被及时的执行，
 从一个对象变得不可达开始，到终结方法finalize执行，这段时间是任意长的，
 这就意味着注重时间的任务不应该用finalize来完成

 及时的执行finalize是垃圾回收算法的一个主要功能，这种算法在不同的JVM实现中大相径庭，
 如果程序依赖finalize方法执行的时间点，这个程序在不同的JVM中表现可能截然不同，甚至无法运行.

 正常情况下，未被捕获的异常会使线程终止，并打印出栈轨迹，
 但如果异常发生在finalize方法中，则不会如此，甚至连警告都不会打印出来

 显式的终止方法：
 如果类的对象中封装的资源确实需要终止，只需提供一个显式的终止方法，并在使用该类的地方在每个类的实例不再有用时调用这个方法。
 另外该实例最好记录下自己是否被终止了，显式的终止方法必须在一个私有域中记录下“该对象已不再有效”，如果某些方法在对象已经终止之后调用，那么这些方法就必须检查这个域，并抛出IllegalStateException
 显示终止方法的典型例子是InputStream、OutPutStream的close方法，Timer的cancel方法

 显式终止方法通常与try-finally结构结合使用，以确保及时终止，这样可以保证及时在使用对象的时候有异常抛出，该终止方法也会执行

 */

public class Finalize {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
