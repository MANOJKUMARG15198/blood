package com.example.gratuity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BLOODNEED extends AppCompatActivity {
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    private Spinner blg;
    private Button search;
    ArrayList<getdata> list;
    myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodneed);
        blg=findViewById(R.id.blg);
        search=findViewById(R.id.search);
        recyclerView=findViewById((R.id.recyle));
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseUserSearch();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list =new ArrayList<getdata>();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("getdata");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())

                {
                    getdata s= dataSnapshot1.getValue(getdata.class);
                    list .add(s);
                }
                adapter= new myAdapter( BLOODNEED.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(BLOODNEED.this, "something wrong", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void firebaseUserSearch() {
    }

}
