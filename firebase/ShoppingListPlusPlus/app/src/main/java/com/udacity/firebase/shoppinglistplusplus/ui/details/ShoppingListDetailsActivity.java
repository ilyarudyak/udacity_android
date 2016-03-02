package com.udacity.firebase.shoppinglistplusplus.ui.details;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

    private void setupFirebaseListener() {

        if (getIntent() != null) {
            String child = getIntent().getStringExtra("child");
            Log.d(LOG_TAG, child);

            Firebase refListName = new Firebase(Constants.FIREBASE_URL).child(child);
            refListName.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    ShoppingList shoppingList = dataSnapshot.getValue(ShoppingList.class);
                    if (shoppingList != null) {
                        if (getSupportActionBar() != null) {
                            getSupportActionBar().setTitle(shoppingList.getListName());
                            Log.d(LOG_TAG, shoppingList.getListName());
                        }
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });
        }
    }

}











