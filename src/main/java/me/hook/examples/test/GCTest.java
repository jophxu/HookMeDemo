package me.hook.examples.test;

import android.util.Log;
import android.widget.Toast;


import java.lang.ref.WeakReference;

import me.hook.examples.ExampleApp;


public class GCTest extends Test {

    @Override
    public int run() {
        WeakReference<Object> ref = new WeakReference<>(new Object());
        Runtime.getRuntime().gc();
        if (ref.get() != null) {
            Toast.makeText(ExampleApp.getInstance(), "object is not recycled",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ExampleApp.getInstance(), "GC done.", Toast.LENGTH_SHORT).show();
        }

        return IGNORED;
    }

    @Override
    protected int testImpl() {
        throw new UnsupportedOperationException();
    }
}
