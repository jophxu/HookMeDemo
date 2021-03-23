package me.hook.examples.test;

import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;

import me.hook.core.HookME;
import me.hook.examples.ExampleApp;


public class ProxyTest extends Test {
    private static Callable<Long> callable;

    static {
        // noinspection unchecked
        callable = (Callable<Long>) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                new Class<?>[] {Callable.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        String methodName = method.getName();
                        switch (methodName) {
                            case "toString":
                                return proxy.getClass().getName()
                                        + "@"
                                        + Integer.toHexString(proxy.hashCode());
                            case "hashCode":
                                return System.identityHashCode(proxy);
                            case "equals":
                                return proxy == args[0];
                        }

                        Log.i(ExampleApp.TAG, "Proxy method called...");
                        return 114514L;
                    }
                });
    }

    public ProxyTest() {
        super(callable.getClass(), "call", (Class<?>[]) null);
    }

//    @Override
//    public int run() {
//        beforeCalled = false;
//        afterCalled = false;
//        int result = FAILED;
//        try {
//            UnHook unhook = HookME.doHook(callable.getClass(), "call", "()Ljava/lang/Object;",this);
//            result = testImpl();
//            unhook.unhook();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

    @Override
    protected int testImpl() {
        try {
            return callable.call() == 1919810L ? SUCCESS : FAILED;
        } catch (Exception e) {
            Log.e(ExampleApp.TAG, "Proxy call threw exception", e);
            return FAILED;
        }
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        if (Long.valueOf(114514L).equals(result))
            return 1919810L;
        return result;
    }

}
