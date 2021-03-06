package com.udacity.firebase.shoppinglistplusplus.ui.details;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.firebase.client.ServerValue;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingList;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;

import java.util.HashMap;

/**
 * Created by ilyarudyak on 3/2/16.
 */
public class EditListNameDialogFragment extends DialogFragment
implements DialogInterface.OnClickListener {

    private EditText mListNameEditText;
    private String mListName, mPushId;

    public static EditListNameDialogFragment newInstance(ShoppingList shoppingList, String pushId) {

        Bundle args = new Bundle();
        EditListNameDialogFragment fragment = new EditListNameDialogFragment();
        args.putString(Constants.KEY_LIST_NAME, shoppingList.getListName());
        args.putString(Constants.KEY_LIST_PUSH_ID, pushId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View form = getActivity().getLayoutInflater().inflate(R.layout.dialog_edit_list, null);

        // set hint for edit text field
        mListNameEditText = (EditText) form.findViewById(R.id.edit_text_list_name_dialog);
        mListName = getArguments().getString(Constants.KEY_LIST_NAME);
        mPushId = getArguments().getString(Constants.KEY_LIST_PUSH_ID);
        mListNameEditText.setHint(mListName);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        return builder
                .setView(form)
                .setPositiveButton(R.string.list_name_dialog_edit, this)
                .setNegativeButton(android.R.string.cancel, null)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        final String inputListName = mListNameEditText.getText().toString();
        if (!inputListName.equals("") && mListName != null && !inputListName.equals(mListName) && mPushId != null) {
            Firebase shoppingListRef = new Firebase(Constants.FIREBASE_URL_ACTIVE_LISTS).child(mPushId);

            HashMap<String, Object> updatedProperties = new HashMap<>();
            updatedProperties.put(Constants.SHOPPING_LIST_MODEL_LIST_NAME, inputListName);
            updatedProperties.put(Constants.SHOPPING_LIST_MODEL_CREATION_DATE, ServerValue.TIMESTAMP);

            shoppingListRef.updateChildren(updatedProperties);
        }
    }
}

















