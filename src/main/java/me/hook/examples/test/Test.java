package me.hook.examples.test;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;

import me.hook.core.HookME;
import me.hook.examples.ExampleApp;
import me.hook.examples.utils.ReflectionHelper;


public abstract class Test extends HookME.Callback {

    public static final int IGNORED = 0;
    public static final int SUCCESS = 1;
    public static final int FAILED = -1;

    public boolean beforeCalled = false;
    public boolean afterCalled = false;
    private boolean hookEnabled = true;
    private boolean uninstallHook = true;

    private Member target;

    protected Test() {
    }

    protected Test(String targetName, Class<?>... paramTypes) {
        init(getClass(), targetName, paramTypes);
    }

    protected Test(Class<?> c, String targetName, Class<?>... paramTypes) {
        init(c, targetName, paramTypes);
    }

    protected void setUninstallHook(boolean uninstall) {
        this.uninstallHook = uninstall;
    }

    private void init(Class<?> c, String targetName, Class<?>... paramTypes) {
        if (targetName != null) {
            Method method = ReflectionHelper.getMethod(c, targetName, paramTypes);
            target = method;
            Log.i(ExampleApp.TAG, "target method:" + method.toGenericString());
        } else {
            Constructor constructor = ReflectionHelper.getConstructor(c, paramTypes);
            target = constructor;
            Log.i(ExampleApp.TAG, "target method:" + constructor.toGenericString());
        }
    }

    public void setHookEnabled(boolean enabled) {
        this.hookEnabled = enabled;
    }

    public int run() {
        beforeCalled = false;
        afterCalled = false;
        if (hookEnabled) {
            int result = FAILED;
            try {
                UnHook unhook = HookME.doHook(target, this);
                result = testImpl();
                if (uninstallHook) {
                    unhook.unhook();
                }
//                Log.i(ExampleApp.TAG, "test toGenericString =>" + ((Method)target).toGenericString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        return testImpl();
    }

    protected abstract int testImpl();

    public boolean beforeCall(Object receiver, Object[] args) throws Exception {
        Log.i(ExampleApp.TAG, "Before " + target.getDeclaringClass().getName() + "."
                + target.getName() + "() with receiver " + receiver
                + " and args " + Arrays.toString(args));
        beforeCalled = true;
        return false;
    }

    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        Log.i(ExampleApp.TAG, "After " + target.getDeclaringClass().getName() + "."
                + target.getName() + "(): result " + result);
        afterCalled = true;
        return result;
    }
}
