package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;

public class CharResultTest extends Test {

    public CharResultTest() {
        super("target", (Class<?>[]) null);
    }

    @Override
    protected int testImpl() {
        return target() == 'a' ? SUCCESS : FAILED;
    }

    public static char target() {
        Log.i(ExampleApp.TAG, "CharResultTest.target()");
        return 'b';
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        return 'a';
    }
}
