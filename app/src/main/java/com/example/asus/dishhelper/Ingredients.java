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
public class Ingredients extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    int id;
    @Column
    @ForeignKey
    Meal meal;

    @Column
    @ForeignKey
    Product product;

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
