package com.example.asus.dishhelper;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by asus on 2016-08-31.
 */
@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {

    public static final String NAME = "MyDataBase";

    public static final int VERSION = 3;
}