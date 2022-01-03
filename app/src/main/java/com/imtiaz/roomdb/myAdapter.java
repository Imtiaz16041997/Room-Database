package com.imtiaz.roomdb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imtiaz.roomdb.EntityModelClass.User;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder>{
    List<User> users;

    public myAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_single_view,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.recId.setText(String.valueOf(users.get(position).getUid()));
        holder.fName.setText(String.valueOf(users.get(position).getFirstName()));
        holder.lName.setText(String.valueOf(users.get(position).getLastName()));

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView fName,lName,recId;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            recId = itemView.findViewById(R.id.recId);
            fName = itemView.findViewById(R.id.fName);
            lName = itemView.findViewById(R.id.lName);
        }
    }
}
