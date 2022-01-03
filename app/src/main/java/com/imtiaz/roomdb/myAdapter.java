package com.imtiaz.roomdb;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imtiaz.roomdb.DAO.UserDao;
import com.imtiaz.roomdb.Database.AppDatabase;
import com.imtiaz.roomdb.EntityModelClass.User;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder>{
    List<User> users;
    AppDatabase db;
    UserDao userDao;
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
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.recId.setText(String.valueOf(users.get(position).getUid()));
        holder.fName.setText(String.valueOf(users.get(position).getFirstName()));
        holder.lName.setText(String.valueOf(users.get(position).getLastName()));

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = AppDatabase.getInstance(holder.recId.getContext());
                userDao = db.userDao();

                //this is to delete the record from room database
                userDao.deleteById(users.get(position).getUid());
                //this is to delete  the record from array List which is the source of recview data
                users.remove(position);
                //update the fresh list of arraylist data to recview
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView fName,lName,recId;
        ImageView delete;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            recId = itemView.findViewById(R.id.recId);
            fName = itemView.findViewById(R.id.fName);
            lName = itemView.findViewById(R.id.lName);
            delete = itemView.findViewById(R.id.dlt);
        }
    }
}
