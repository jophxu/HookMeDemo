package me.hook.examples;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.io.File;

import me.hook.core.HookME;
import me.hook.examples.utils.ReflectionHelper;
import xcrash.ICrashCallback;
import xcrash.XCrash;

public class ExampleApp extends Application {
    public static final String TAG = "HookMETest";
    private static ExampleApp instance;

    public static ExampleApp getInstance() {
        if (instance == null) throw new IllegalStateException();
        return instance;
    }

    private void initXCrash() {
        File tombstones = new File(getFilesDir(), "tombstones");
        if (!tombstones.exists()) tombstones.mkdirs();
        tombstones.setReadable(true, false);
        tombstones.setExecutable(true, false);
        ICrashCallback callback = new ICrashCallback() {
            @Override public void onCrash(String logPath, String emergency) throws Exception {
                Log.e(TAG, "XCrash triggered: logPath " + logPath + " emergency " + emergency);
                new File(logPath).setReadable(true, false);
            }
        };

        final int logLinesOfSystemAndEventMax = 300;
        final int logLinesOfMainMax = 1200;
        XCrash.init(this, new XCrash.InitParameters()
                .setJavaLogcatSystemLines(logLinesOfSystemAndEventMax)
                .setJavaLogcatEventsLines(logLinesOfSystemAndEventMax)
                .setNativeLogcatSystemLines(logLinesOfSystemAndEventMax)
                .setNativeLogcatEventsLines(logLinesOfSystemAndEventMax)
                .setAnrLogcatSystemLines(logLinesOfSystemAndEventMax)
                .setAnrLogcatEventsLines(logLinesOfSystemAndEventMax)
                .setJavaLogcatMainLines(logLinesOfMainMax)
                .setNativeLogcatMainLines(logLinesOfMainMax)
                .setAnrLogcatMainLines(logLinesOfMainMax)
                .setJavaCallback(callback)
                .setNativeCallback(callback)
                .setAnrCallback(callback));
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        ReflectionHelper.passApiCheck();

        instance = this;
        initXCrash();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        HookME.init();
    }
}
