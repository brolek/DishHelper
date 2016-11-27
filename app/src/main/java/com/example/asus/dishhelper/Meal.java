package com.example.asus.dishhelper;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by asus on 2016-08-31.
 */

@Table(database = MyDatabase.class)
public class Meal extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    int id;

    @Column
    String name;

    @Column
    @ForeignKey(saveForeignKeyModel = true)
    Ingredients ingredients;
//
//    public void setIngredients(Ingredients products) {
//        this.products = products;
//    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
