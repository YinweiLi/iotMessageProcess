package com.example.yinwei.iotmessageprocess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button4Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button4Search = (Button) findViewById(R.id.button4Search);

        button4Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2Show = new Intent(MainActivity.this,ShowDetialActivity.class);
                startActivity(intent2Show);

            }
        });

    }
}
