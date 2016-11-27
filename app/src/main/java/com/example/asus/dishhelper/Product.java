package com.example.asus.dishhelper;

import android.os.Parcel;
import android.os.Parcelable;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by asus on 2016-08-26.
 */
@Table(database = MyDatabase.class)
public class Product extends BaseModel implements Parcelable{

    @Column
    @PrimaryKey(autoincrement = true)
    int id;

    @Column
    String name;



    Product(String name)
    {
        this.name = name;
    }
    Product(){}


    protected Product(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }


    //    private List<Product> ingredientList = new ArrayList<>();
//
//    Product(String name)
//    {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Product> getIngredientList() {
//        return ingredientList;
//    }
//
//    public void setIngredientList(List<Product> ingredientList) {
//        this.ingredientList = ingredientList;
//    }
//
//    public List<Product> addNewIngredient(Product product){
//        this.ingredientList.add(product);
//        return ingredientList;
//    }


}
