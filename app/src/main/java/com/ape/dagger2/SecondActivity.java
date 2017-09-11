package com.ape.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {
    @Inject
    Tinno mTinno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView dagger2TextView = (TextView) findViewById(R.id.dagger2_text_view);

        MainComponent component = DaggerMainComponent.create();
        component.inject(this);

        dagger2TextView.setText(mTinno.toString() + "\n" + component.toString());
    }
}
