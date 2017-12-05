package com.effective.test.effectivejava.createAndDestory;

/**
 * Created by xieqe on 2017/12/1.
 * Effective Java No.2：遇到多个构造器参数时考虑使用构建器——Builder
 */

public class BuilderTest {

    private String name;
    private String address;
    private int id;
    private int phoneNumber;
    private int age;
    private int score;

    private BuilderTest(Builder builder){
        this.name = builder.name;
        this.address = builder.address;
        this.id = builder.id;
        this.phoneNumber = builder.phoneNumber;
        this.age = builder.age;
        this.score = builder.score;
    }

    public static class Builder{
        private String name;
        private String address;
        private int id = 0;
        private int phoneNumber = 0;
        private int age = 0;
        private int score = 0;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder phoneNumber(int phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder score(int score){
            this.score = score;
            return this;
        }

        public BuilderTest build(){
            return new BuilderTest(this);
        }
    }
}
