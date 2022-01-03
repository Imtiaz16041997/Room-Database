package com.imtiaz.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.imtiaz.roomdb.DAO.UserDao;
import com.imtiaz.roomdb.Database.AppDatabase;
import com.imtiaz.roomdb.EntityModelClass.User;

public class MainActivity extends AppCompatActivity {

    EditText first_name,last_name,first_id;
    Button insertBtn;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_id = findViewById(R.id.first_id);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        insertBtn = findViewById(R.id.insertBtn);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = AppDatabase.getInstance(MainActivity.this);
                UserDao userDao = db.userDao();

                Boolean check = userDao.is_exist(Integer.parseInt(first_id.getText().toString()));
                if(check == false){
                    userDao.insertrecord(new User(Integer.parseInt(first_id.getText().toString()),first_name.getText().toString(),last_name.getText().toString()));
                    first_id.setText("");
                    first_name.setText("");
                    last_name.setText("");
                    Toast.makeText(MainActivity.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                }else {
                    first_id.setText("");
                    last_name.setText("");
                    first_name.setText("");
                    Toast.makeText(MainActivity.this, "Already Existed", Toast.LENGTH_SHORT).show();

                }
//                userDao.insertrecord(new User(1,first_name.getText().toString(), UserDao userDao = db.userDao();
////            userDao.insertrecord(new User(1,first_name.getText().toString(),last_name.getText().toString()));
////            first_name.setText("");

            }
        });

    }

//    public class backgroundThread extends Thread {
//        public void run() {
//            super.run();
//            AppDatabase db = AppDatabase.getInstance(MainActivity.this.getApplicationContext());
//
//            UserDao userDao = db.userDao();
//            userDao.insertrecord(new User(1,first_name.getText().toString(),last_name.getText().toString()));
//            first_name.setText("");
//            last_name.setText("");
//        }
//
//    }
}