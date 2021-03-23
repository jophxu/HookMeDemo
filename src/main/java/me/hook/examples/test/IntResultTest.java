package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;

public class IntResultTest extends Test {

    public IntResultTest() {
        super("target", (Class<?>[]) null);
    }

    @Override
    protected int testImpl() {
        return target();
    }

    public static int target() {
        Log.i(ExampleApp.TAG, "IntResultTest.target()");
        return FAILED;
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        return SUCCESS;
    }
}
