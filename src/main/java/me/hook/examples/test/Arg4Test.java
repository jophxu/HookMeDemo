package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;

public class Arg4Test extends Test {

    public Arg4Test() {
        super("target", int.class);
    }

    @Override
    protected int testImpl() {
        return target(2001361295);
    }

    private static int target(int i) {
        Log.i(ExampleApp.TAG, "Arg4Test.target() called with arg i " + i);
        return i == 2001361295 ? SUCCESS : FAILED;
    }
}
