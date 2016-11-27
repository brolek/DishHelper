package com.example.asus.dishhelper;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016-08-29.
 */
public class IngredientSuggestionProvider extends ContentProvider {

    List<Product> products = new ArrayList<>();

    public List<Product> getProducts(){
        return products;
    }

//    public void addNewIngredient(String name){
//        Product product = new Product(name);
////        products = product.addNewIngredient(name);
//
//    }

    @Override
    public boolean onCreate() {






        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

//        products = new ArrayList<>();
//        products.add()


        this.products = new Select().from(Product.class).queryList();
        MatrixCursor cursor = new MatrixCursor(
                new String[] {
                        BaseColumns._ID,
                        SearchManager.SUGGEST_COLUMN_TEXT_1,
                        SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID,
                        SearchManager.SUGGEST_COLUMN_INTENT_EXTRA_DATA

                });

        if (products != null) {
            String query = uri.getLastPathSegment().toUpperCase();
            int limit = Integer.parseInt(uri.getQueryParameter(SearchManager.SUGGEST_PARAMETER_LIMIT));

            int lenght = products.size();
            for (int i = 0; i < lenght && cursor.getCount() < limit; i++) {
                String city = products.get(i).getName();
                if (city.toUpperCase().contains(query)){
                    cursor.addRow(new Object[]{ i, city, i, products.get(i).getName() });
                }
            }
        }




        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
