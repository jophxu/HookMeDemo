package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;

public class ByteResultTest extends Test {

    public ByteResultTest() {
        super("target", (Class<?>[]) null);
    }

    @Override
    protected int testImpl() {
        return target() == 0x01 ? SUCCESS : FAILED;
    }

    public static byte target() {
        Log.i(ExampleApp.TAG, "ByteResultTest.target()");
        return 0x00;
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        return (byte)0x01;
    }
}
