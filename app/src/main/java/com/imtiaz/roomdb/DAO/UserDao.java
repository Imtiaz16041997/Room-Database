package com.imtiaz.roomdb.DAO;

import androidx.room.Dao;
import androidx.room.Insert;

import com.imtiaz.roomdb.EntityModelClass.User;

@Dao
public interface UserDao {
    @Insert
    void insertrecord(User users);


}