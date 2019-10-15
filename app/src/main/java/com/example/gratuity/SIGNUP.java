package com.example.gratuity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SIGNUP extends AppCompatActivity {
    EditText gname,grollno,gdob,gphone,weight;
    Spinner gbloodgroup;
    Spinner gdepart;
    Button submit,userlogin;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
       databaseReference= FirebaseDatabase.getInstance().getReference("getdata");
        gname=findViewById(R.id.gname);
        grollno=findViewById(R.id.grollno);
        gbloodgroup=findViewById(R.id.gbloodgroup);
        gdob=findViewById(R.id.gdob);
        weight=findViewById(R.id.weight);
        gdepart=findViewById(R.id.gdepart);
        gphone=findViewById(R.id.gphone);
        submit=findViewById(R.id.submit);
        userlogin=findViewById(R.id.userlogin);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             adddata();
             finish();
             startActivity(new Intent(SIGNUP.this,NEXT.class));
            }
        });

    }
    public  void adddata()
    {
      String dname=gname.getText().toString();
      String drollno=grollno.getText().toString();
      String dbloodgroup=gbloodgroup.getSelectedItem().toString();
      String ddob=gdob.getText().toString();
      String dphone=gphone.getText().toString();
      String ddepart=gdepart.getSelectedItem().toString();
      String dweight=weight.getText().toString();
if(!TextUtils.isEmpty(dname) &&  !TextUtils.isEmpty(drollno) && !TextUtils.isEmpty(dbloodgroup) && !TextUtils.isEmpty(ddob) && !TextUtils.isEmpty(dphone)&& !TextUtils.isEmpty(dweight) && !TextUtils.isEmpty(ddepart) ){
String id=databaseReference.push().getKey();
        getdata Getdata=new getdata(id,dname,drollno,dbloodgroup,ddob,dphone,ddepart,dweight);
        databaseReference.child(id).setValue(Getdata);
        Toast.makeText(this,"Inserted",Toast.LENGTH_LONG).show();
}
else
{
    Toast.makeText(this, "Enter the text",Toast.LENGTH_LONG).show();
}

    }
}
