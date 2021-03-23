package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;

public class NonStaticTest extends Test {

    public NonStaticTest() {
        super("target", (Class<?>[]) null);
    }

    @Override
    protected int testImpl() {
        try {
            return target() ? SUCCESS : FAILED;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean target() throws Exception {
        Log.i(ExampleApp.TAG, "NonStaticTest.target()");
        return false;
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        return true;
    }
}
