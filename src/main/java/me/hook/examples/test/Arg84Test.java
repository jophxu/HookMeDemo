package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;


public class Arg84Test extends Test {

    public Arg84Test() {
        super("target", long.class, int.class);
    }

    @Override
    protected int testImpl() {
        return target(5150256501661869116L, 326646792);
    }

    private static int target(long l, int i) {
        Log.i(ExampleApp.TAG, "Arg84Test: l=" + l + " i=" + i);
        return  l == 5150256501661869116L && i == 326646792 ? SUCCESS : FAILED;
    }
}
