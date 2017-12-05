package com.effective.test.effectivejava.createAndDestory;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by xieqe on 2017/12/5.
 * No.6：消除过期的对象引用
 *
 * 以栈为例：
 * 如果一个栈先增长，再收缩，
 * 那么从栈中弹出来的对象不会被当做垃圾回收，因为栈内部维护者对这些对象的过期引用，
 * 所谓的过期引用是指永远也不会被解除的引用
 *
 */

public class OverdueReference {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_SIZE = 16;

    public OverdueReference(){
        elements = new Object[DEFAULT_SIZE];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    //先进后出
    public Object pop(){
        if (size == 0){
            throw new EmptyStackException();
        }
        /*
        直接返回会产生过期引用，导致内存浪费
        return elements[--size];
        */
        Object result = elements[--size]; //从0开始，末位index --size
        elements[size] = null;            //消除过期引用
        return result;
    }

    //扩容
    private void ensureCapacity(){
        if (elements.length == size){
            elements = Arrays.copyOf(elements,2 * size + 1);
        }
    }

}
