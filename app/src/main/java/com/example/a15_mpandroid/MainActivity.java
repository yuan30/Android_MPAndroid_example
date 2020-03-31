package com.example.a15_mpandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnBar;
    private Button btnStackBar;
    //private Button btnPie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBar = findViewById(R.id.btnBar);
        btnStackBar = findViewById(R.id.btnStackBar);
    }

    public void onClick(View v){
        int BtnId = v.getId();
        Intent intent = null;
        switch (BtnId)
        {
            case R.id.btnBar:
                intent = new Intent(MainActivity.this, BarChartActivity.class);
                break;
            case R.id.btnStackBar:
                intent = new Intent(MainActivity.this, StackedBarChartActivity.class);
                break;
        }
        if(intent != null)
            startActivity(intent);
    }
}
