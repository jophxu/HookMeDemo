package me.hook.examples.test;


public class ThrowExceptionTest extends Test {
    public ThrowExceptionTest() {
        super("target", (Class<?>[]) null);
    }

    @Override
    protected int testImpl() {
        try {
            target();
            return FAILED;
        } catch (MyEx e) {
            return e.b ? SUCCESS : FAILED;
        }
    }

    private static void target() throws MyEx {
        throw new MyEx();
    }

    @Override
    public Object afterCall(Object receiver, Object[] args, Object result, Throwable throwable) throws Exception {
        super.afterCall(receiver, args, result, throwable);
        MyEx e = (MyEx) throwable;
        e.b = true;
        return false;
    }


    static class MyEx extends Exception {
        boolean b = false;
    }
}
