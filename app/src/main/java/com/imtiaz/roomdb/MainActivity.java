package com.imtiaz.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.imtiaz.roomdb.DAO.UserDao;
import com.imtiaz.roomdb.Database.AppDatabase;
import com.imtiaz.roomdb.EntityModelClass.User;

public class MainActivity extends AppCompatActivity {

    EditText first_name,last_name;
    Button insertBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        insertBtn = findViewById(R.id.insertBtn);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new bgThread().start();
            }
        });

    }

    public class bgThread extends Thread {
        public void run() {
            super.run();
            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "room_db").build();

            UserDao userDao = db.userDao();
            userDao.insertrecord(new User(1,first_name.getText().toString(),last_name.getText().toString()));
            first_name.setText("");
            last_name.setText("");
        }

    }
}