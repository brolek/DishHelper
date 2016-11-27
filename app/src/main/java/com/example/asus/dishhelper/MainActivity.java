package com.example.asus.dishhelper;


import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2016-08-26.
 */
public class MainActivity extends ActionBarActivity {

    private List<Product> productList = new ArrayList<>();
    private RecyclerView recyclerView;
    private IngredientAdapter mAdapter;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.linearLayoutDrawer)
    LinearLayout linearLayoutDrawer;
    //    @BindView(R.id.ingredientEditText)
//    EditText writeNameOfIngredient;
    @BindView(R.id.addNewIngredientButton)
    Button addNewIngredientButton;
    @BindView(R.id.checkWhatToEatButton)
    Button checkWhatToEatButton;
    @BindView(R.id.AddIngredientToDatabaseButton)
    Button addIngredientToDatabaseButton;
    @BindView(R.id.addToDatabaseLayout)
    LinearLayout addToDatabaseLayout;
    @BindView(R.id.addToDatabaseEditText)
    EditText addToDatabaseEditText;


    @BindView(R.id.addMealToDatabaseLayout)
    LinearLayout addMealToDatabaseLayout;
    @BindView(R.id.addMealToDatabaseEditText)
    EditText addMealToDatabaseEditText;
    @BindView(R.id.addFirstProductToDatabaseEditText)
    EditText addFirstProductToDatabaseEditText;
    @BindView(R.id.addSecondProductMealToDatabaseEditText)
    EditText addSecondProductMealToDatabaseEditText;
    @BindView(R.id.addThirdProductMealToDatabaseEditText)
    EditText addThirdProductMealToDatabaseEditText;
    SearchView searchView;
    ArrayAdapter<String> myAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        // get action bar
        ActionBar actionBar = getSupportActionBar();

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new IngredientAdapter(productList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

//        handleIntent(getIntent());

        mDrawerLayout.setDrawerListener(mDrawerListener);


    }


//    @OnClick(R.id.addNewIngredientButton)
//    public void addNewIngredient(){
////        String name = String.valueOf(writeNameOfIngredient.getText());
//        Product product = new Product(String.valueOf(writeNameOfIngredient.getText()));
//
//        productList.add(product);
//        mAdapter.notifyDataSetChanged();
//
//    }

    @OnClick(R.id.checkWhatToEatButton)
    public void goToDishesActivity() {
        Intent intent = new Intent(MainActivity.this, DishesListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.AddIngredientToDatabaseButton)
    public void SetFirstLayoutVisible() {

        addToDatabaseLayout.setVisibility(View.VISIBLE);
        mDrawerLayout.closeDrawers();
    }

    @OnClick(R.id.addToDatabaseButton)
    public void closeAndSaveIngredient() {

        Product product = new Product();
        product.setName(addToDatabaseEditText.getText().toString());
        product.save();

//        IngredientSuggestionProvider ingredientSuggestionProvider = new IngredientSuggestionProvider();
//        ingredientSuggestionProvider.addNewIngredient(addToDatabaseEditText.getText().toString());
        addToDatabaseLayout.setVisibility(View.INVISIBLE);


    }
    @OnClick(R.id.addMealToDatabaseButton)
    public void SetSecondtLayoutVisible() {

        addMealToDatabaseLayout.setVisibility(View.VISIBLE);
        mDrawerLayout.closeDrawers();
    }

    @OnClick(R.id.addNewMealToDatabaseButton)
    public void addNewMealToDatabase() {

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Meal meal = new Meal();
        meal.setName(addMealToDatabaseEditText.getText().toString());
        boolean x;
//        String name = new Select().from(Product.class).where(Product_Table.name.is(addFirstProductToDatabaseEditText.getText().toString())).querySingle();
//        if (new Select().from(Product.class).where(Product_Table.name.is(addFirstProductToDatabaseEditText.getText().toString())).querySingle().getName().isEmpty()) {
//            product1.setName(addFirstProductToDatabaseEditText.getText().toString());
//            product1.save();
//        }
//
        try{
            product1.setName(new Select().from(Product.class).where(Product_Table.name.is(addFirstProductToDatabaseEditText.getText().toString())).querySingle().getName());
        }
        catch (NullPointerException e)
        {
            product1.setName(addFirstProductToDatabaseEditText.getText().toString());
            product1.save();
        }


//        if (new Select().from(Product.class).where(Product_Table.name.is(addSecondProductMealToDatabaseEditText.getText().toString())).querySingle().getName().isEmpty()) {
//            product2.setName(addSecondProductMealToDatabaseEditText.getText().toString());
//            product2.save();
//        }


        try{
            product2.setName(new Select().from(Product.class).where(Product_Table.name.is(addSecondProductMealToDatabaseEditText.getText().toString())).querySingle().getName());
        }
        catch (NullPointerException e)
        {
            product2.setName(addSecondProductMealToDatabaseEditText.getText().toString());
            product2.save();
        }


//        if (new Select().from(Product.class).where(Product_Table.name.is(addThirdProductMealToDatabaseEditText.getText().toString())).querySingle().getName().isEmpty()) {
//            product3.setName(addThirdProductMealToDatabaseEditText.getText().toString());
//            product3.save();
//        }


        try{
            product3.setName(new Select().from(Product.class).where(Product_Table.name.is(addThirdProductMealToDatabaseEditText.getText().toString())).querySingle().getName());
        }
        catch (NullPointerException e)
        {
            product3.setName(addThirdProductMealToDatabaseEditText.getText().toString());
            product3.save();
        }

        Ingredients ingredients = new Ingredients();
        ingredients.setMeal(meal);
        ingredients.setProduct(product1);
        ingredients.save();
        ingredients.setMeal(meal);
        ingredients.setProduct(product2);
        ingredients.save();
        ingredients.setMeal(meal);
        ingredients.setProduct(product3);
        ingredients.save();
        meal.save();
        addMealToDatabaseLayout.setVisibility(View.INVISIBLE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(
                new ComponentName(this, MainActivity.class)));
        searchView.setIconifiedByDefault(false);



        return true;

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this, "Wybierz przedmiot z listy", Toast.LENGTH_SHORT).show();
//            Product product = new Product(query);
//
//            productList.add(product);
//            mAdapter.notifyDataSetChanged();

        } else if (Intent.ACTION_VIEW.equals(intent.getAction())) {
//            String uri = intent.getDataString();
//            Toast.makeText(this, "Suggestion: "+ uri, Toast.LENGTH_SHORT).show();
//            Product product = new Product(intent.getExtras().getString(SearchManager.EXTRA_DATA_KEY));
            Product product = new Product(intent.getExtras().getString(SearchManager.EXTRA_DATA_KEY));

            productList.add(product);
            mAdapter.notifyDataSetChanged();


        }
    }





//    private void LocationFound() {
//        Intent i = new Intent(MainActivity.this, LocationFound.class);
//        startActivity(i);
//    }


    /**
     * Handling intent data
     */
    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            /**
             * Use this query to display search results like
             * 1. Getting the data from SQLite and showing in listview
             * 2. Making webrequest and displaying the data
             * For now we just display the query only
             */
//            txtQuery.setText("Search Query: " + query);

        }

    }


    private DrawerLayout.DrawerListener mDrawerListener = new DrawerLayout.DrawerListener() {

        @Override
        public void onDrawerStateChanged(int status) {

        }

        @Override
        public void onDrawerSlide(View view, float slideArg) {



        }

        @Override
        public void onDrawerOpened(View view) {
            //ImageView img= (ImageView) findViewById(R.id.activity_main_content_button_menu);
            //img.setImageResource(R.drawable.ic_x);
            linearLayoutDrawer.bringToFront();
            mDrawerLayout.requestLayout();



        }

        @Override
        public void onDrawerClosed(View view) {
            //ImageView img= (ImageView) findViewById(R.id.activity_main_content_button_menu);
            //img.setImageResource(R.drawable.ic_menu);


        }

    };

}
