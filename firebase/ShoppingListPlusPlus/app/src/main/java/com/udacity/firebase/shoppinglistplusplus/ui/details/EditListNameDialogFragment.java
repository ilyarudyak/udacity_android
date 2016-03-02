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

    public static EditListNameDialogFragment newInstance(ShoppingList shoppingList) {

        Bundle args = new Bundle();
        EditListNameDialogFragment fragment = new EditListNameDialogFragment();
        args.putString(Constants.KEY_LIST_NAME, shoppingList.getListName());
        fragment.setArguments(args);
        return fragment;
    }

    private EditText mListNameEditText;
    private String mListName;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View form = getActivity().getLayoutInflater().inflate(R.layout.dialog_edit_list, null);

        // set hint for edit text field
        mListNameEditText = (EditText) form.findViewById(R.id.edit_text_list_name_dialog);
        mListName = getArguments().getString(Constants.KEY_LIST_NAME);
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
        if (!inputListName.equals("") && mListName != null && !inputListName.equals(mListName)) {
            Firebase shoppingListRef = new Firebase(Constants.FIREBASE_URL_ACTIVE_LIST);

            HashMap<String, Object> updatedProperties = new HashMap<>();
            updatedProperties.put(Constants.FIREBASE_PROPERTY_LIST_NAME, inputListName);

            HashMap<String, Object> changedTimestampMap = new HashMap<>();
            changedTimestampMap.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);

            updatedProperties.put(Constants.FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED, changedTimestampMap);

            shoppingListRef.updateChildren(updatedProperties);
        }
    }
}

















