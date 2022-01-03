package com.imtiaz.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.imtiaz.roomdb.DAO.UserDao;
import com.imtiaz.roomdb.Database.AppDatabase;
import com.imtiaz.roomdb.EntityModelClass.User;

import java.util.List;

public class FetchData extends AppCompatActivity {
    RecyclerView recview;
    AppDatabase db;
    UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);
        getroomData();
    }

    private void getroomData() {
        db = AppDatabase.getInstance(FetchData.this);
        userDao = db.userDao();

        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        List<User> users = userDao.getAllUsers();
        myAdapter adapter = new myAdapter(users);
        recview.setAdapter(adapter);
    }
}