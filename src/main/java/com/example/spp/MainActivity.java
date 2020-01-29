package com.example.spp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    start=findViewById(R.id.start);
    stop=findViewById(R.id.stop);

    start.setOnClickListener(this);
    stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.start:
                Intent i=new Intent(MainActivity.this,MyServices.class);
                startService(i);
                break;

            case  R.id.stop:
                Intent ii=new Intent(MainActivity.this,MyServices.class);
                stopService(ii);

                break;
        }

    }
}
