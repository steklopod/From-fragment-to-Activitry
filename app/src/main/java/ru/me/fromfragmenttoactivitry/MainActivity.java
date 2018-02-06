package ru.me.fromfragmenttoactivitry;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyListener{
    private static final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager manager;
    private TextView txvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        txvResult = (TextView) findViewById(R.id.txvResult);

        addFragmentA();
    }

    private void addFragmentA() {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
        transaction.commit();
    }

    @Override
    public void addTwoNumbers(int i1, int i2) {
        int result = i1 + i2;
        txvResult.setText("Сумма = " + result);
    }
}
