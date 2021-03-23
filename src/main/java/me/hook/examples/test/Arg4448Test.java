package me.hook.examples.test;

import android.util.Log;

import me.hook.examples.ExampleApp;


public class Arg4448Test extends Test {
    public Arg4448Test() {
        super("target", int.class, int.class, int.class, long.class);
    }

    @Override
    protected int testImpl() {
//        Log.i(ExampleApp.TAG, "testImpl: i=" + Integer.toHexString(1) + " i2=" + Integer.toHexString(685597707) + " i3=" + Integer.toHexString(414481781) + " l=" + Long.toHexString(-9179983674551041920L));
        return target(1 ,685597707, 414481781, -9179983674551041920L);
    }

    private static int target(int i, int i2, int i3, long l) {
        Log.i(ExampleApp.TAG, "Arg4448Test: i=" + i + " i2=" + i2 + " i3=" + i3 + " l=" + l);
        return i == 1 && i2 == 685597707 && i3 == 414481781
                && l == -9179983674551041920L ? SUCCESS : FAILED;
    }
}
