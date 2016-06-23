package com.nikhilpanju.recyclerviewsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Button vertical = (Button) findViewById(R.id.btnVertical);

        vertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChooseActivity.this, MainActivityVertical.class);
                startActivity(i);
            }
        });
        Button horizontal = (Button) findViewById(R.id.btnHorizontal);

        horizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChooseActivity.this, MainActivityHorizontal.class);
                startActivity(i);
            }
        });

    }
}
