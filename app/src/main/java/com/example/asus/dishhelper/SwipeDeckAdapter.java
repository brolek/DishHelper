package com.example.asus.dishhelper;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by asus on 2016-08-30.
 */
public class SwipeDeckAdapter extends BaseAdapter {

//    private List<String> data,dataExample = new ArrayList<>();
    private List<Meal> mealList ;
    private Context context;


    public SwipeDeckAdapter(List<Meal> mealList, Context context) {
//        this.data = data;
        this.context = context;
        this.mealList =  mealList;
//        dataExample.addAll(data);
    }

    @Override
    public int getCount() {
        return mealList.size();
    }

    @Override
    public Object getItem(int position) {
        return mealList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
//            LayoutInflater inflater = getLayoutInflater();
//            // normally use a viewholder
//            v = inflater.inflate(R.layout.swipe_deck_element, parent, false);
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.swipe_deck_element, parent, false);
        }

        ImageView imageView = (ImageView) v.findViewById(R.id.offer_image);
        Picasso.with(context).load("http://www.ewa-gotuje.pl/przepis/min/1671.jpg").fit().centerCrop().into(imageView);
        TextView textView = (TextView) v.findViewById(R.id.sample_text);
        Meal item =(Meal)getItem(position);
        textView.setText(item.getName());

//        dataExample.addAll(data);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Layer type: ", Integer.toString(v.getLayerType()));
                Log.i("Hardware Accel type:", Integer.toString(View.LAYER_TYPE_HARDWARE));
            }
        });
        return v;
    }
}