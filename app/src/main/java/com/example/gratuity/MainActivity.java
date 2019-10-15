package com.example.gratuity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button beadonar;
    Button bloodneed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        beadonar=findViewById(R.id.beadonar);
        beadonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent neo=new Intent(MainActivity.this, BEDONAR.class);
                startActivity(neo);

            }
        });
        bloodneed=findViewById(R.id.bloodneed);
        bloodneed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jio = new Intent(MainActivity.this, BLOODNEED.class);
                startActivity(jio);
            }
        });
    }
}
