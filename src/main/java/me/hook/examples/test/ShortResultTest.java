package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;

public class ShortResultTest extends Test {

    public ShortResultTest() {
        super("target", (Class<?>[]) null);
    }

    @Override
    protected int testImpl() {
        return target() == 0x01 ? SUCCESS : FAILED;
    }

    public static short target() {
        Log.i(ExampleApp.TAG, "ShortResultTest.target()");
        return 0x00;
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        return (short)0x01;
    }
}
