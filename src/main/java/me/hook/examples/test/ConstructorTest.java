package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;

public class ConstructorTest extends Test {

    public ConstructorTest() {
        super(Target.class, null, int.class);
    }

    @Override
    protected int testImpl() {
        try {
            Target target = new Target(114514);
            return target.success ? SUCCESS : FAILED;
        } catch (IllegalArgumentException e) {
            Log.e(ExampleApp.TAG, "modify arguments error?", e);
            return FAILED;
        }
    }

    @Override
    public boolean beforeCall(Object receiver, Object[] args) throws Exception {
        super.beforeCall(receiver, args);

        int originArg = (int) args[0];
        if (originArg != 114514) {
            throw new IllegalArgumentException("parse arguments error (got " + originArg + ")");
        }

        args[0] = 1145141919;
        return false;
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        ((Target) receiver).success = true;
        return result;
    }

    static class Target {
        boolean success;
        Target(int i) {
            if (i != 1145141919)
                throw new IllegalArgumentException("Bad i " + i);
            Log.i(ExampleApp.TAG, "Target constructor execute");
        }
    }
}
