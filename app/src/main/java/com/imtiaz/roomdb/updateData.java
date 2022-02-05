package com.imtiaz.roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.imtiaz.roomdb.DAO.UserDao;
import com.imtiaz.roomdb.Database.AppDatabase;

public class updateData extends AppCompatActivity {
    int uid;
    EditText first_name_update, last_name_update;
    Button updatedBtn;
    AppDatabase db;
    UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        first_name_update = findViewById(R.id.first_name_update);
        last_name_update = findViewById(R.id.last_name_update);
        updatedBtn = findViewById(R.id.updatedBtn);

        uid = Integer.parseInt(getIntent().getStringExtra("uid"));
        first_name_update.setText(getIntent().getStringExtra("ufname"));
        last_name_update.setText(getIntent().getStringExtra("ulname"));

        updatedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = AppDatabase.getInstance(updateData.this);
                userDao = db.userDao();
                userDao.updateById(uid,first_name_update.getText().toString(),last_name_update.getText().toString());
                startActivity(new Intent(getApplicationContext(),FetchData.class));
                finish();
            }
        });
    }
}