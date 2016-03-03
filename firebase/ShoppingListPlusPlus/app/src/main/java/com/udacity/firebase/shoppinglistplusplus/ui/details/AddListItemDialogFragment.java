package com.udacity.firebase.shoppinglistplusplus.ui.details;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingListItem;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;

/**
 * Created by ilyarudyak on 3/3/16.
 */
public class AddListItemDialogFragment extends DialogFragment {

    private EditText mEditTextListItemName;
    private String mPushId;

    public static AddListItemDialogFragment newInstance(String pushId) {

        Bundle args = new Bundle();
        args.putString(Constants.KEY_LIST_PUSH_ID, pushId);
        AddListItemDialogFragment fragment = new AddListItemDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mPushId = getArguments().getString(Constants.KEY_LIST_PUSH_ID);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomTheme_Dialog);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View rootView = inflater.inflate(R.layout.dialog_add_item, null);
        mEditTextListItemName = (EditText) rootView.findViewById(R.id.edit_text_add_list_item_dialog);

        builder.setView(rootView)
                .setPositiveButton(R.string.positive_button_add_list_item, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        addShoppingListItem();
                    }
                });

        return builder.create();
    }

    private void addShoppingListItem() {

        Firebase shoppingListItemsRef = new Firebase(Constants.FIREBASE_URL_SHOPPING_LIST_ITEMS);
        shoppingListItemsRef.child(mPushId).push().setValue(new ShoppingListItem(
                mEditTextListItemName.getText().toString(), "Anonymous Owner"));
    }
}











