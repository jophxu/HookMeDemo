package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;


public class InLineTest extends Test {

    public InLineTest() {
        super("target", String.class);
        setUninstallHook(false);
    }

    @Override
    protected int testImpl() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (++count < 100) {
                    Log.e(ExampleApp.TAG, "res = " + target("xxx"));
                }
            }
        }).start();
        return IGNORED;
    }

    /*
     * need test this on android N
     */
    private String target(String str) {
        Log.i(ExampleApp.TAG, "InLineTest.target() " + str);
        return "InLineTest" + str;
    }

    @Override
    public boolean beforeCall(Object receiver, Object[] args) throws Exception {
        super.beforeCall(receiver, args);
        args[0] = "hooked param";
        return false;
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        return (String)"hooked result";
    }
}
