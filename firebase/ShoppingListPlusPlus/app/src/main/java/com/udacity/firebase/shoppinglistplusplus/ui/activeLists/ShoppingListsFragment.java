package com.udacity.firebase.shoppinglistplusplus.ui.activeLists;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.firebase.client.Firebase;
import com.udacity.firebase.shoppinglistplusplus.R;
import com.udacity.firebase.shoppinglistplusplus.model.ShoppingList;
import com.udacity.firebase.shoppinglistplusplus.ui.details.ShoppingListDetailsActivity;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;


/**
 * A simple {@link Fragment} subclass that shows a list of all shopping lists a user can see.
 * Use the {@link ShoppingListsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShoppingListsFragment extends Fragment {
    private ListView mListView;
    private ActiveListAdapter mActiveListAdapter;

    public ShoppingListsFragment() {
        /* Required empty public constructor */
    }

    /**
     * Create fragment and pass bundle with data as it's arguments
     * Right now there are not arguments...but eventually there will be.
     */
    public static ShoppingListsFragment newInstance() {
        ShoppingListsFragment fragment = new ShoppingListsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_shopping_lists, container, false);
        initializeScreen(rootView);

        // setup firebase listener
        Firebase activeListsRef = new Firebase(Constants.FIREBASE_URL_ACTIVE_LISTS);
        mActiveListAdapter = new ActiveListAdapter(getActivity(), ShoppingList.class,
                R.layout.single_active_list, activeListsRef);
        mListView.setAdapter(mActiveListAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ShoppingList shoppingList = mActiveListAdapter.getItem(position);
                if (shoppingList != null) {
                    Intent detailIntent = new Intent(getActivity(), ShoppingListDetailsActivity.class);
                    String pushId = mActiveListAdapter.getRef(position).getKey();
                    detailIntent.putExtra(Constants.KEY_LIST_PUSH_ID, pushId);
                    startActivity(detailIntent);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mActiveListAdapter.cleanup();
    }


    /**
     * Link layout elements from XML
     */
    private void initializeScreen(View rootView) {
        mListView = (ListView) rootView.findViewById(R.id.list_view_active_lists);
    }
}













