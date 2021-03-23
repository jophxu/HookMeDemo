package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;

public class VoidResultTest extends Test {

    public VoidResultTest() {
        super("target", (Class<?>[]) null);
    }

    boolean voidCalled = false;

    @Override
    protected int testImpl() {
        voidCalled = false;
        target();
        return voidCalled ? SUCCESS : FAILED;
    }

    public static void target() {
        Log.i(ExampleApp.TAG, "VoidResultTest.target()");
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        if (super.afterCall(receiver, args, result, throwable) == null) {
            voidCalled = true;
        }
        return null;
    }
}
