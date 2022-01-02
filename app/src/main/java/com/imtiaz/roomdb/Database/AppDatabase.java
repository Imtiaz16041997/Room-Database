package com.imtiaz.roomdb.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.imtiaz.roomdb.DAO.UserDao;
import com.imtiaz.roomdb.EntityModelClass.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}