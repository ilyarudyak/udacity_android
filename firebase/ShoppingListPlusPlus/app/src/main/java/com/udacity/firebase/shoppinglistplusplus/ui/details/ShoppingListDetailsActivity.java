package com.udacity.firebase.shoppinglistplusplus.ui.details;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
import com.udacity.firebase.shoppinglistplusplus.ui.MainActivity;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;

public class ShoppingListDetailsActivity extends AppCompatActivity {

    public static final String LOG_TAG = ShoppingListDetailsActivity.class.getSimpleName();

    private ShoppingList mShoppingList;
    private String mPushId;

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
                DialogFragment dialog = AddListItemDialogFragment.newInstance(mPushId);
                dialog.show(getFragmentManager(), "AddListItemDialogFragment");
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
            mPushId = getIntent().getStringExtra(Constants.KEY_LIST_PUSH_ID);
            Log.d(LOG_TAG, mPushId);

            Firebase refListName = new Firebase(Constants.FIREBASE_URL_ACTIVE_LISTS).child(mPushId);
            refListName.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    mShoppingList = dataSnapshot.getValue(ShoppingList.class);
                    if (mShoppingList != null) {
                        if (getSupportActionBar() != null) {
                            getSupportActionBar().setTitle(mShoppingList.getListName());
                            Log.d(LOG_TAG, mShoppingList.getListName());
                        }
                    } else {
                        finish();
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
            case R.id.action_remove_list:
                removeList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // helper methods
    private void showEditListNameDialog() {
        if (mShoppingList != null && mPushId != null) {
            DialogFragment dialog = EditListNameDialogFragment.newInstance(mShoppingList, mPushId);
            dialog.show(this.getFragmentManager(), "EditListNameDialogFragment");
        }
    }
    private void removeList() {
        if (mShoppingList != null && mPushId != null) {
            new Firebase(Constants.FIREBASE_URL_ACTIVE_LISTS).child(mPushId).removeValue();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}


























