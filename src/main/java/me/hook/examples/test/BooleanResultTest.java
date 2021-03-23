package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;

public class BooleanResultTest extends Test {

    public BooleanResultTest() {
        super("target", (Class<?>[]) null);
    }

    @Override
    protected int testImpl() {
        return target() ? SUCCESS : FAILED;
    }

    public static boolean target() {
        Log.i(ExampleApp.TAG, "BooleanResultTest.target()");
        return false;
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        return true;
    }
}
