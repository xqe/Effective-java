package com.effective.test.effectivejava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.effective.test.effectivejava.createAndDestory.BuilderTest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test1(){
        BuilderTest builderTest = new BuilderTest.Builder()
                .name("xqe")
                .address("cq")
                .age(99).score(99)
                .id(0).build();

    }
}
