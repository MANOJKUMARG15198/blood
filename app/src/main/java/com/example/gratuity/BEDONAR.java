package com.example.gratuity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class BEDONAR extends AppCompatActivity {
    EditText email;
    EditText password;
    Button login;
    Button register;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedonar);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jio = new Intent(BEDONAR.this, USERPAGE.class);
                startActivity(jio);
            }
        });
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser  user=firebaseAuth.getCurrentUser();
        if(user != null)
        {
            finish();
            startActivity(new Intent(BEDONAR.this,NEXT.class));
        }

        progressDialog=new ProgressDialog(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();

            }
        });


    }
    private  void  validate()
    {
        String uemail=email.getText().toString().trim();
        String upassword=password.getText().toString().trim();
        if(TextUtils.isEmpty(uemail) &&TextUtils.isEmpty(upassword) )
        {
            Toast.makeText(this,"enter the username,pass",Toast.LENGTH_SHORT).show();
        }
        progressDialog.setMessage("just wait");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(uemail,upassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    finish();
                    startActivity(new Intent(BEDONAR.this,NEXT.class));
                }
                else
                {
                    Toast.makeText(BEDONAR.this,"login fail",Toast.LENGTH_SHORT).show();

                }
                progressDialog.dismiss();
            }
        });
    }

}
