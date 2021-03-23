package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;

public class LongResultTest extends Test {

    public LongResultTest() {
        super("target", (Class<?>[]) null);
    }

    @Override
    protected int testImpl() {
        return target() == 1l ? SUCCESS : FAILED;
    }

    public static long target() {
        Log.i(ExampleApp.TAG, "LongResultTest.target()");
        return 0;
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        return 1l;
    }
}
