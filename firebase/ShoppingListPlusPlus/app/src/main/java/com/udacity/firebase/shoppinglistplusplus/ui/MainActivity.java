package com.udacity.firebase.shoppinglistplusplus.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.ui.activeLists.AddListDialogFragment;
import com.udacity.firebase.shoppinglistplusplus.ui.activeLists.ShoppingListsFragment;
import com.udacity.firebase.shoppinglistplusplus.ui.meals.AddMealDialogFragment;
import com.udacity.firebase.shoppinglistplusplus.ui.meals.MealsFragment;

/**
 * Represents the home screen of the app which
 * has a {@link ViewPager} with {@link ShoppingListsFragment} and {@link MealsFragment}
 */
public class MainActivity extends BaseActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeScreen();
    }

    // helper methods
    public void initializeScreen() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        // setup view pager adapter and tab layout
        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    // -------------- dialogs ----------------

    /**
     * Create an instance of the AddList dialog fragment and show it
     */
    public void showAddListDialog(View view) {
        /* Create an instance of the dialog fragment and show it */
        DialogFragment dialog = AddListDialogFragment.newInstance();
        dialog.show(MainActivity.this.getFragmentManager(), "AddListDialogFragment");
    }

    /**
     * Create an instance of the AddMeal dialog fragment and show it
     */
    public void showAddMealDialog(View view) {
        /* Create an instance of the dialog fragment and show it */
        DialogFragment dialog = AddMealDialogFragment.newInstance();
        dialog.show(MainActivity.this.getFragmentManager(), "AddMealDialogFragment");
    }

    // -------------- pager adapter ----------------

    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:  return ShoppingListsFragment.newInstance();
                case 1:  return MealsFragment.newInstance();
                default: return ShoppingListsFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:  return getString(R.string.pager_title_shopping_lists);
                case 1:  return getString(R.string.pager_title_meals);
                default: return getString(R.string.pager_title_shopping_lists);
            }
        }
    }

    // -------------- options menu ----------------

    /**
     * Override onOptionsItemSelected to use main_menu instead of BaseActivity menu
     *
     * @param menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Inflate the menu; this adds items to the action bar if it is present. */
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Override onOptionsItemSelected to add action_settings only to the MainActivity
     *
     * @param item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
