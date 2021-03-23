package me.hook.examples;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import me.hook.examples.test.Arg0Test;
import me.hook.examples.test.Arg4448Test;
import me.hook.examples.test.Arg444Test;
import me.hook.examples.test.Arg4484Test;
import me.hook.examples.test.Arg4488Test;
import me.hook.examples.test.Arg448Test;
import me.hook.examples.test.Arg4844Test;
import me.hook.examples.test.Arg484Test;
import me.hook.examples.test.Arg4884Test;
import me.hook.examples.test.Arg4888Test;
import me.hook.examples.test.Arg488Test;
import me.hook.examples.test.Arg8444Test;
import me.hook.examples.test.Arg8448Test;
import me.hook.examples.test.Arg844Test;
import me.hook.examples.test.Arg8488Test;
import me.hook.examples.test.Arg848Test;
import me.hook.examples.test.Arg8844Test;
import me.hook.examples.test.Arg8848Test;
import me.hook.examples.test.Arg884Test;
import me.hook.examples.test.Arg8884Test;
import me.hook.examples.test.Arg888Test;
import me.hook.examples.test.GCTest;
import me.hook.examples.test.InLineTest;
import me.hook.examples.test.ThrowExceptionTest;
import me.hook.examples.test.Arg4444Test;
import me.hook.examples.test.Arg44Test;
import me.hook.examples.test.Arg4848Test;
import me.hook.examples.test.Arg48Test;
import me.hook.examples.test.Arg4Test;
import me.hook.examples.test.Arg8484Test;
import me.hook.examples.test.Arg84Test;
import me.hook.examples.test.Arg8888Test;
import me.hook.examples.test.Arg88Test;
import me.hook.examples.test.Arg8Test;
import me.hook.examples.test.BooleanResultTest;
import me.hook.examples.test.ByteResultTest;
import me.hook.examples.test.CharResultTest;
import me.hook.examples.test.ConstructorTest;
import me.hook.examples.test.DirectMethodTest;
import me.hook.examples.test.DoubleResultTest;
import me.hook.examples.test.FloatResultTest;
import me.hook.examples.test.Test;
import me.hook.examples.test.IntResultTest;
import me.hook.examples.test.LongResultTest;
import me.hook.examples.test.NonStaticTest;
import me.hook.examples.test.ProxyTest;
import me.hook.examples.test.ShortResultTest;
import me.hook.examples.test.ToastHookTest;
import me.hook.examples.test.VoidResultTest;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private static final TestItem[] sTestItems = {
            new TestItem("Non-Static Method Hook", new NonStaticTest()),
            new TestItem("boolean result Method Hook", new BooleanResultTest()),
            new TestItem("byte result Method Hook", new ByteResultTest()),
            new TestItem("char result Method Hook", new CharResultTest()),
            new TestItem("double result Method Hook", new DoubleResultTest()),
            new TestItem("float result Method Hook", new FloatResultTest()),
            new TestItem("int result Method Hook", new IntResultTest()),
            new TestItem("long result Method Hook", new LongResultTest()),
            new TestItem("short result Method Hook", new ShortResultTest()),
            new TestItem("void result Method Hook", new VoidResultTest()),
            new TestItem("Constructor Method Hook", new ConstructorTest()),
            new TestItem("Direct Method Hook", new DirectMethodTest()),
            new TestItem("Proxy Method Hook", new ProxyTest()), // TODO
            new TestItem("Throw Exception Hook", new ThrowExceptionTest()), // TODO
            new TestItem("Toast.makeText Hook", new ToastHookTest()),
            new TestItem("Run GC", new GCTest()),
            new TestItem("Arg0 Hook", new Arg0Test()),
            new TestItem("Arg4 Hook", new Arg4Test()),
            new TestItem("Arg8 Hook", new Arg8Test()),
            new TestItem("Arg44 Hook", new Arg44Test()),
            new TestItem("Arg48 Hook", new Arg48Test()),
            new TestItem("Arg84 Hook", new Arg84Test()),
            new TestItem("Arg88 Hook", new Arg88Test()),
            new TestItem("Arg444 Hook", new Arg444Test()),
            new TestItem("Arg448 Hook", new Arg448Test()),
            new TestItem("Arg484 Hook", new Arg484Test()),
            new TestItem("Arg488 Hook", new Arg488Test()),
            new TestItem("Arg844 Hook", new Arg844Test()),
            new TestItem("Arg848 Hook", new Arg848Test()),
            new TestItem("Arg884 Hook", new Arg884Test()),
            new TestItem("Arg888 Hook", new Arg888Test()),
            new TestItem("Arg4444 Hook", new Arg4444Test()),
            new TestItem("Arg4448 Hook", new Arg4448Test()),
            new TestItem("Arg4484 Hook", new Arg4484Test()),
            new TestItem("Arg4488 Hook", new Arg4488Test()),
            new TestItem("Arg4844 Hook", new Arg4844Test()),
            new TestItem("Arg4848 Hook", new Arg4848Test()),
            new TestItem("Arg4884 Hook", new Arg4884Test()),
            new TestItem("Arg4888 Hook", new Arg4888Test()),
            new TestItem("Arg8444 Hook", new Arg8444Test()),
            new TestItem("Arg8448 Hook", new Arg8448Test()),
            new TestItem("Arg8484 Hook", new Arg8484Test()),
            new TestItem("Arg8488 Hook", new Arg8488Test()),
            new TestItem("Arg8844 Hook", new Arg8844Test()),
            new TestItem("Arg8848 Hook", new Arg8848Test()),
            new TestItem("Arg8884 Hook", new Arg8884Test()),
            new TestItem("Arg8888 Hook", new Arg8888Test()),
            new TestItem("In Line Test Hook", new InLineTest()),
    };

    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.test_list);
        output = findViewById(R.id.test_output);
        output.setText(String.format("Android %s (API %d); CPU Arch %s; No Test executed…",
                Build.VERSION.RELEASE, Build.VERSION.SDK_INT, Build.CPU_ABI));

        String[] testNames = new String[sTestItems.length];
        for (int i = 0; i < sTestItems.length; i++) {
            testNames[i] = "Test " + sTestItems[i].name;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.test_item,
                R.id.test_item_name, testNames);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TestItem testItem = sTestItems[position];
        Log.i(ExampleApp.TAG, "Executing " + testItem.name);
        Test test = testItem.test;
        int result = test.run();
        Log.i(ExampleApp.TAG, "Execute " + testItem.name + " result " + result);

        boolean success = false, failed = false;

        if (result == Test.SUCCESS) {
            if (test.beforeCalled && test.afterCalled) {
                success = true;
            } else {
                Log.e(ExampleApp.TAG, "Test " + testItem.name + " is not hooked");
                failed = true;
            }
        } else if (result == Test.FAILED) {
            failed = true;
        }

        if (success) {
            output.setText("Test " + testItem.name + " success!");
        } else if (failed) {
            output.setText("Test " + testItem.name + " failed!");
        } else {
            output.setText("See Toast");
        }
    }

    private static final class TestItem {
        final String name;
        final Test test;

        TestItem(String name, Test test) {
            this.name = name;
            this.test = test;
        }
    }
}