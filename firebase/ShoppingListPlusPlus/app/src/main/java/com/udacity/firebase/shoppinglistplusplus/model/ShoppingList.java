package com.udacity.firebase.shoppinglistplusplus.model;

import com.firebase.client.ServerValue;
import com.udacity.firebase.shoppinglistplusplus.utils.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilyarudyak on 3/1/16.
 */
public class ShoppingList {

    private String listName;
    private String owner;
    private Map<String, Object> dateCreated;

    public ShoppingList() {
    }

    public ShoppingList(String listName, String owner) {
        this.listName = listName;
        this.owner = owner;
        this.dateCreated = new HashMap<>();
        this.dateCreated.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);
    }

    public String getListName() {
        return listName;
    }
    public String getOwner() {
        return owner;
    }
    public Map<String, Object> getDateCreated() {
        return dateCreated;
    }

}
