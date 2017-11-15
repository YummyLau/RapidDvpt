package com.example.yummylau.rapiddvpt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import yummylau.networkmodule.router.RouterManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RouterManager.navigation("/modulea/MainActivity");
            }
        });
    }
}
