package me.hook.examples.test;

import java.util.Random;


public class DynamicLookupJNITest extends Test {
    public DynamicLookupJNITest() {
        super("target", int.class);
    }
    
    static {
        System.loadLibrary("examples");
    }

    @Override protected int testImpl() {
        int i = new Random().nextInt();
        return target(i) == i * i ? SUCCESS : FAILED;
    }

    private static native int target(int i);
}
