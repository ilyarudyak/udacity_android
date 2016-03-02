package com.udacity.firebase.shoppinglistplusplus.ui.details;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingList;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;

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

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View form = getActivity().getLayoutInflater().inflate(R.layout.dialog_edit_list, null);
        EditText editText = (EditText) form.findViewById(R.id.edit_text_list_name_dialog);
        editText.setHint(getArguments().getString(Constants.KEY_LIST_NAME));

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        return builder
                .setView(form)
                .setPositiveButton(R.string.list_name_dialog_edit, this)
                .setNegativeButton(android.R.string.cancel, null)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Toast.makeText(getActivity(), "i'm gonna change dialogue name", Toast.LENGTH_LONG).show();
    }
}
