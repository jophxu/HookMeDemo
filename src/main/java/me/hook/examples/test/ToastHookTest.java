package me.hook.examples.test;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import me.hook.core.HookME;
import me.hook.examples.ExampleApp;

public class ToastHookTest extends Test {

    public ToastHookTest() {
        super(Toast.class, "makeText", Context.class, CharSequence.class, int.class);
    }

    @Override
    protected int testImpl() {
        Toast.makeText(ExampleApp.getInstance(), "ToastHookTest failed", Toast.LENGTH_SHORT).show();
        return IGNORED;
    }

    @Override
    public boolean beforeCall(Object receiver, Object[] args) throws Exception {
        super.beforeCall(receiver, args);
        args[1] = "ToastHookTest success";
        return false;
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        return super.afterCall(receiver, args, result, throwable);
    }
}
