package com.ape.dagger2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Inject
    Tinno mTinno1;

    @Inject
    Tinno mTinno2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView dagger2TextView = (TextView) findViewById(R.id.dagger2_text_view);

        MainComponent component = DaggerMainComponent.create();
        component.inject(this);

        dagger2TextView.setText(mTinno1.toString() + "\n" + mTinno2.toString() + "\n" + component.toString());

        findViewById(R.id.dagger2_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}
