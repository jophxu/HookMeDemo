package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;

public class DoubleResultTest extends Test {

    public DoubleResultTest() {
        super("target", (Class<?>[]) null);
    }

    @Override
    protected int testImpl() {
        return target() == 999.123123 ? SUCCESS : FAILED;
    }

    public static double target() {
        Log.i(ExampleApp.TAG, "DoubleResultTest.target()");
        return 0;
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        return 999.123123d;
    }
}
