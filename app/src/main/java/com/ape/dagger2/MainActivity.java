package com.ape.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Inject
    Tinno mTinno;//加入注解，标注这个Tinno是需要注入的


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView dagger2TextView = (TextView) findViewById(R.id.dagger2_text_view);
        //使用组件进行构造，注入
        DaggerMainActivityComponent.builder().mainModule(new MainModule(getApplicationContext(), this)).build().inject(this);
        Log.d(TAG, "onCreate: mTinno = " + mTinno);

        dagger2TextView.setText(mTinno.toString());
    }
}
