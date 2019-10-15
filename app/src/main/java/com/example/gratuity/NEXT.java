package com.example.gratuity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class NEXT extends AppCompatActivity {
Button get;
Button logout;
FirebaseAuth firebaseAuth;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.logoutt:{
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(NEXT.this,BEDONAR.class));

            }
        }
        {

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        get=findViewById(R.id.get);
                get.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity( new Intent(NEXT.this,SIGNUP.class) );
                    }
                });
                firebaseAuth=FirebaseAuth.getInstance();


    }
}
