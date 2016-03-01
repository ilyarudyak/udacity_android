package com.udacity.firebase.shoppinglistplusplus.model;

/**
 * Created by ilyarudyak on 3/1/16.
 */
public class ShoppingList {

    private String listName;
    private String owner;

    public ShoppingList() {
    }

    public ShoppingList(String listName, String owner) {
        this.listName = listName;
        this.owner = owner;
    }

    public String getListName() {
        return listName;
    }
    public String getOwner() {
        return owner;
    }
}
