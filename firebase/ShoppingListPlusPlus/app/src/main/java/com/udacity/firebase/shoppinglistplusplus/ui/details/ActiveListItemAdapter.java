package com.udacity.firebase.shoppinglistplusplus.ui.details;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingListItem;

/**
 * Created by ilyarudyak on 3/3/16.
 */
public class ActiveListItemAdapter extends FirebaseListAdapter<ShoppingListItem> {
    public ActiveListItemAdapter(Activity activity, Class<ShoppingListItem> modelClass, int modelLayout, Firebase ref) {
        super(activity, modelClass, modelLayout, ref);
        this.mActivity = activity;
    }

    @Override
    protected void populateView(View view, ShoppingListItem item) {
        ImageButton buttonRemoveItem = (ImageButton) view.findViewById(R.id.button_remove_item);
        TextView textViewMealItemName = (TextView) view.findViewById(R.id.text_view_active_list_item_name);

        textViewMealItemName.setText(item.getItemName());
    }
}
