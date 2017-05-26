package com.sammy.sample.ormlitesample.db.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.sammy.sample.ormlitesample.db.DatabaseHelper;
import com.sammy.sample.ormlitesample.db.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserDao
{
    private Context context;
    private Dao<User, Integer> userDaoOpe;
    private DatabaseHelper helper;

    public UserDao(Context context) {
        this.context = context;
        try {
            helper = DatabaseHelper.getHelper(context);
            userDaoOpe = helper.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(User user) {
        try {
            userDaoOpe.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUser() {
        List<User> users = null;
        try {
            users = userDaoOpe.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

