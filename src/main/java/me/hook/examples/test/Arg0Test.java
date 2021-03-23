package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;


public class Arg0Test extends Test {

    public Arg0Test() {
        super("target", (Class<?>[]) null);
    }

    @Override
    protected int testImpl() {
        return target();
    }

    private static int target() {
        Log.i(ExampleApp.TAG, "Arg0Test.target()");
        return FAILED;
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        return SUCCESS;
    }
}
