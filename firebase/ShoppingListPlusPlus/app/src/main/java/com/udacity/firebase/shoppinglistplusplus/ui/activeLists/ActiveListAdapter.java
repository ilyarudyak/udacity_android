package com.udacity.firebase.shoppinglistplusplus.ui.activeLists;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingList;

/**
 * Created by ilyarudyak on 3/3/16.
 */
public class ActiveListAdapter extends FirebaseListAdapter<ShoppingList> {

    public ActiveListAdapter(Activity activity, Class<ShoppingList> modelClass, int modelLayout, Firebase ref) {
        super(activity, modelClass, modelLayout, ref);
        this.mActivity = activity;
    }

    @Override
    protected void populateView(View view, ShoppingList list) {

        TextView textViewListName = (TextView) view.findViewById(R.id.text_view_list_name);
        TextView textViewCreatedByUser = (TextView) view.findViewById(R.id.text_view_created_by_user);

        textViewListName.setText(list.getListName());
        textViewCreatedByUser.setText(list.getOwner());

    }
}

















