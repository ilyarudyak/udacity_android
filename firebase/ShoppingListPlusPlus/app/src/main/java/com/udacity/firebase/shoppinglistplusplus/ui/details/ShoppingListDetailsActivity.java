package com.udacity.firebase.shoppinglistplusplus.ui.details;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingList;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;

public class ShoppingListDetailsActivity extends AppCompatActivity {

    public static final String LOG_TAG = ShoppingListDetailsActivity.class.getSimpleName();

    private ShoppingList mShoppingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        setupFirebaseListener();
    }

    // helper methods
    private void setupFirebaseListener() {

        if (getIntent() != null) {
            String pushId = getIntent().getStringExtra(Constants.KEY_LIST_PUSH_ID);
            Log.d(LOG_TAG, pushId);

            Firebase refListName = new Firebase(Constants.FIREBASE_URL_ACTIVE_LISTS).child(pushId);
            refListName.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    mShoppingList = dataSnapshot.getValue(ShoppingList.class);
                    if (mShoppingList != null) {
                        if (getSupportActionBar() != null) {
                            getSupportActionBar().setTitle(mShoppingList.getListName());
                            Log.d(LOG_TAG, mShoppingList.getListName());
                        }
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
    }

    // --------------- options menu --------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit_list_name:
                showEditListNameDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // helper methods
    public void showEditListNameDialog() {
        if (mShoppingList != null) {
            DialogFragment dialog = EditListNameDialogFragment.newInstance(mShoppingList);
            dialog.show(this.getFragmentManager(), "EditListNameDialogFragment");
        }
    }
}











