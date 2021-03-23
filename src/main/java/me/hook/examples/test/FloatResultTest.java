package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;

public class FloatResultTest extends Test {

    public FloatResultTest() {
        super("target", (Class<?>[]) null);
    }

    @Override
    protected int testImpl() {
        return target() == 99.99f ? SUCCESS : FAILED;
    }

    public static float target() {
        Log.i(ExampleApp.TAG, "FloatResultTest.target()");
        return 0.0f;
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        return 99.99f;
    }
}
