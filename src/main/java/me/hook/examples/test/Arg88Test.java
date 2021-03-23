package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;


public class Arg88Test extends Test {

    public Arg88Test() {
        super("target", long.class, long.class);
    }

    @Override
    protected int testImpl() {
        return target(Long.MAX_VALUE, 0xffffffffL);
    }

    private static int target(long l, long l2) {
        Log.i(ExampleApp.TAG, "Arg88Test: l=" + l + " l2=" + l2);
        return l == Long.MAX_VALUE && l2 == 0xffffffffL ? SUCCESS : FAILED;
    }
}
