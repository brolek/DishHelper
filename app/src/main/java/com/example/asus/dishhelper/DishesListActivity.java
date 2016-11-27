package com.example.asus.dishhelper;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.daprlabs.aaron.swipedeck.SwipeDeck;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016-08-30.
 */
public class DishesListActivity extends Activity{

    SwipeDeck cardStack;
    List<String> testData,test;
    List<Meal> mealList;
    SwipeDeckAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dishes_activity);

        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);
        test = new ArrayList<>();
        test.add("0");
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");


        testData = new ArrayList<>();
        testData.add("0");
        testData.add("1");
        testData.add("2");
        testData.add("3");
        testData.add("4");

        mealList = new Select().from(Meal.class).queryList();
        adapter = new SwipeDeckAdapter(mealList, this);
        if (cardStack != null) {
            cardStack.setAdapter(adapter);
        }
        cardStack.setCallback(new SwipeDeck.SwipeDeckCallback() {
            @Override
            public void cardSwipedLeft(int positionInAdapter) {
                Log.i("MainActivity", "card was swiped left, position in adapter: " + positionInAdapter);

            }

            @Override
            public void cardSwipedRight(int positoinInAdapter) {
                Log.i("MainActivity", "card was swiped right, position in adapter: " + positoinInAdapter);

            }
        });



        cardStack.setLeftImage(R.id.left_image);
        cardStack.setRightImage(R.id.right_image);

        //example of buttons triggering events on the deck
//        Button btn = (Button) findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cardStack.swipeTopCardLeft(180);
//            }
//        });
//        Button btn2 = (Button) findViewById(R.id.button2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cardStack.swipeTopCardRight(180);
//            }
//        });
//
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                testData.addAll(test);
////                testData.add("a sample string.");
//                adapter.notifyDataSetChanged();
            }
        });


    }
}
