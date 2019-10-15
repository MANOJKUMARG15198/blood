package com.example.gratuity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class USERPAGE extends AppCompatActivity {

    EditText etemail,etpassword;
    Button finish,userlogin;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);
        setupview();
        firebaseAuth=FirebaseAuth.getInstance();
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           if(validate());
                {
                    String email=etemail.getText().toString().trim();
                    String password=etpassword.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(email,password ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(USERPAGE .this,"Registration sucessfull",Toast.LENGTH_SHORT).show();;
                                startActivity(new Intent(USERPAGE.this,BEDONAR.class
                                ));
                            }
                            else
                            {
                                Toast.makeText(USERPAGE .this,"Registration failed",Toast.LENGTH_SHORT).show();;
                            }

                        }
                    });

                }
            }
        });
userlogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(USERPAGE.this,BEDONAR.class)  );
    }
});
    }
    private void setupview()
    {
        etemail=findViewById(R.id.etemail);
        etpassword=findViewById(R.id.etpassword);
        finish=findViewById(R.id.finish);
        userlogin=findViewById(R.id.userlogin);
    }
    public boolean validate()
    {
        boolean result =false;
        String uemail=etemail.getText().toString().trim();
        String upassword=etpassword.getText().toString().trim();
        if( uemail.isEmpty())
        {
            Toast.makeText(this,"enter the text",Toast.LENGTH_SHORT).show();
        }
        if( upassword.isEmpty() )
        {
            Toast.makeText(this,"enter the text",Toast.LENGTH_SHORT).show();
        }

        else
        {
            result=true;

        }
        return result;

    }
}
