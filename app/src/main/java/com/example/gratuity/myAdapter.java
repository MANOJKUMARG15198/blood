package com.example.gratuity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder>  {

    Context context;
    ArrayList<getdata> getdata;
    public myAdapter(Context c, ArrayList<getdata> s )
    {
        context =c;
        getdata=s;

    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

 myViewHolder.dname.setText(getdata.get(i).getDname());
 myViewHolder.dphone.setText(getdata.get(i).getDphone());
 myViewHolder.ddepart.setText(getdata.get(i).getDdepart());
 myViewHolder.dbloodgroup.setText(getdata.get(i).getDbloodgroup());
    }

    @Override
    public int getItemCount() {
        return getdata.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
                 TextView dname;
                 TextView dphone;
                 TextView ddepart;
                 TextView dbloodgroup;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            dname=itemView.findViewById(R.id.dname);
            dphone=itemView.findViewById(R.id.dphone);
            ddepart=itemView.findViewById(R.id.ddepart);
            dbloodgroup=itemView.findViewById(R.id.dbloodgroup);

        }
    }
}
